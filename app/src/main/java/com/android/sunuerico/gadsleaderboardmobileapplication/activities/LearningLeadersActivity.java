package com.android.sunuerico.gadsleaderboardmobileapplication.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.fragments.LearningLeadersFragment;

public class LearningLeadersActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container, new LearningLeadersFragment())
				.commit();


	}


}