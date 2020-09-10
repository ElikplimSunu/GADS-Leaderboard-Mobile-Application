package com.android.sunuerico.gadsleaderboardmobileapplication.classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.android.sunuerico.gadsleaderboardmobileapplication.BuildConfig;
import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.modules.UserClient;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class PromptDialogue extends AppCompatDialogFragment {


	final Activity activity = getActivity();

	private OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();


	private Retrofit.Builder builder = new Retrofit.Builder()
			.baseUrl("https://docs.google.com/forms/d/e/")
			.addConverterFactory(GsonConverterFactory.create())
			.client(okHttpClient.build());

	private ImageView cancel;
	private Button yesBtn;
	//	private PromptDialogueListener promptDialogueListener;
	private Retrofit retrofit = builder.build();

	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.custom_popup, null);

		builder.setView(view);


		cancel = view.findViewById(R.id.cancel_button);
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				dismiss();
			}
		});


		yesBtn = view.findViewById(R.id.yes_btn);
		yesBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {


				SharedPreferences preferences = Objects.requireNonNull(getContext()).getSharedPreferences("Dialogue", MODE_PRIVATE);
				String fname = preferences.getString("first name", "");
				String lname = preferences.getString("last name", "");
				String email = preferences.getString("email", "");
				String githubLink = preferences.getString("github link", "");

				executeSubmission(
						fname,
						lname,
						email,
						githubLink

				);

			}
		});


		return builder.create();
	}

	public void dialogueResponse(boolean isSuccessful) {
		ResponseDialoge dialogFragment = new ResponseDialoge();
		Bundle bundle = new Bundle();
		bundle.putBoolean("responseType", isSuccessful);
		dialogFragment.setArguments(bundle);
	}


	public void openDialogue() {
		ResponseDialoge responseDialogue = new ResponseDialoge();
		assert getFragmentManager() != null;
		responseDialogue.show(getFragmentManager(), "Response Dialogue");
	}

	public void executeSubmission(String firstName, String lastName, String email, String githubLink) {


		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BODY);
		if (BuildConfig.DEBUG) {
			okHttpClient.addInterceptor(logging);
		}


		UserClient userClient = retrofit.create(UserClient.class);

		Call<ResponseBody> call = userClient.submitProject(
				firstName,
				lastName,
				email,
				githubLink
		);


		call.enqueue(new Callback<ResponseBody>() {
			@Override
			public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {

				dialogueResponse(true);
				openDialogue();
				dismiss();
				SharedPreferences dialogue = Objects.requireNonNull(getContext()).getSharedPreferences("Pop-up", MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = dialogue.edit();
				prefEditor.putBoolean("responseType", true);
				prefEditor.apply();
			}

			@Override
			public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {

				dialogueResponse(false);
				openDialogue();
				dismiss();
				SharedPreferences dialogue = Objects.requireNonNull(getContext()).getSharedPreferences("Pop-up", MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = dialogue.edit();
				prefEditor.putBoolean("responseType", false);
				prefEditor.apply();
			}
		});
	}
}
