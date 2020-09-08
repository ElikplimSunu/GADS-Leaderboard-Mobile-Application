package com.android.sunuerico.gadsleaderboardmobileapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.adapters.FragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		getSupportActionBar().hide();


		Button leaderboardSubmit = findViewById(R.id.leaderboard_submit);
		leaderboardSubmit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(HomeActivity.this, SubmissionActivity.class);
				startActivity(intent);
			}
		});


		// Get the ViewPager and set it's PagerAdapter so that it can display items
		ViewPager viewPager = findViewById(R.id.viewpager);
		viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),
				HomeActivity.this));

		// Give the TabLayout the ViewPager
		TabLayout tabLayout = findViewById(R.id.sliding_tabs);
		tabLayout.setupWithViewPager(viewPager);

	}
}