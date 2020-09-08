package com.android.sunuerico.gadsleaderboardmobileapplication.classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;

import java.util.Objects;

public class ResponseDialoge extends AppCompatDialogFragment {


	@NonNull
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


		LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
		View view = inflater.inflate(R.layout.custom_popup2, null);

		builder.setView(view);

		SharedPreferences preferences = ((Activity) Objects.requireNonNull(getContext())).getSharedPreferences("Pop-up", Context.MODE_PRIVATE);
		boolean mResponse = preferences.getBoolean("responseType", true);


		ImageView responseImage = view.findViewById(R.id.response_image);
		responseImage.setImageResource(mResponse ? R.drawable.ic_baseline_check_circle_24 : R.drawable.ic_baseline_error_24);

		TextView responseText = view.findViewById(R.id.response_text);
		responseText.setText(mResponse ? getString(R.string.submission_successful_text) : getString(R.string.submission_unsuccessful_text));


		return builder.create();
	}


}
