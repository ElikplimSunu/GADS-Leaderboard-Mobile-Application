package com.android.sunuerico.gadsleaderboardmobileapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;

public class SplashActivity extends AppCompatActivity {
	private static int SPLASH_TIME_OUT = 2500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		getSupportActionBar().hide();
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent homeIntent = new Intent(SplashActivity.this, HomeActivity.class);
				startActivity(homeIntent);
				finish();
			}
		}, SPLASH_TIME_OUT);
	}
}