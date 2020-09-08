package com.android.sunuerico.gadsleaderboardmobileapplication.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.classes.PromptDialogue;

public class SubmissionActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submission);
		getSupportActionBar().hide();


		Button promptPopupBtn;

		EditText editTextFirstName;
		EditText editTextLastName;
		EditText editTextEmail;
		EditText editTextGithub;

		editTextFirstName = findViewById(R.id.firstname_edittext);
		editTextLastName = findViewById(R.id.lastname_edittext);
		editTextEmail = findViewById(R.id.email_edittext);
		editTextGithub = findViewById(R.id.github_link_edittext);


		promptPopupBtn = findViewById(R.id.submission_btn);
		promptPopupBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				String firstname = editTextFirstName.getText().toString();
				String lastname = editTextLastName.getText().toString();
				String email = editTextEmail.getText().toString();
				String link = editTextGithub.getText().toString();

				SharedPreferences dialogue = getSharedPreferences("Dialogue", MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = dialogue.edit();
				prefEditor.putString("first name", firstname);
				prefEditor.putString("last name", lastname);
				prefEditor.putString("email", email);
				prefEditor.putString("github link", link);
				prefEditor.apply();


				if (firstname.isEmpty()) {
					Toast.makeText(SubmissionActivity.this, "First name cannot be empty!", Toast.LENGTH_LONG).show();
				} else if (lastname.isEmpty()) {
					Toast.makeText(SubmissionActivity.this, "Last name cannot be empty!", Toast.LENGTH_LONG).show();
				} else if (email.isEmpty()) {
					Toast.makeText(SubmissionActivity.this, "Email cannot be empty!", Toast.LENGTH_LONG).show();
				} else if (link.isEmpty()) {
					Toast.makeText(SubmissionActivity.this, "Github link cannot be empty!", Toast.LENGTH_LONG).show();
				} else {
					openDialogue();
				}

			}
		});

		ImageView backBtn = findViewById(R.id.back_btn);
		backBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				onBackPressed();
			}
		});


	}


	public void openDialogue() {
		PromptDialogue promptDialogue = new PromptDialogue();
		promptDialogue.show(getSupportFragmentManager(), "Prompt Dialogue");
	}


}