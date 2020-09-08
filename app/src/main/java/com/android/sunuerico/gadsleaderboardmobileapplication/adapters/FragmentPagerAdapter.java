package com.android.sunuerico.gadsleaderboardmobileapplication.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.sunuerico.gadsleaderboardmobileapplication.fragments.LearningLeadersFragment;
import com.android.sunuerico.gadsleaderboardmobileapplication.fragments.SkillIQFragment;

public class FragmentPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {

	private String tabTitles[] = new String[]{"Learning Leaders", "Skill IQ Leaders"};
	private Context mContext;


	public FragmentPagerAdapter(@NonNull FragmentManager fm, Context context) {
		super(fm);
		this.mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
			case 0:
				return new LearningLeadersFragment();
			case 1:
				return new SkillIQFragment();
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return 2;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// Generate title based on item position
		return tabTitles[position];
	}
}
