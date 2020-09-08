package com.android.sunuerico.gadsleaderboardmobileapplication.classes;

public class LearnersItem {
	private String mName;
	private int mLearningHours;
	private String mCountry;
	private String mImageUrl;

	public LearnersItem() {
	}


	public LearnersItem(String name, int learningHours, String country, String imageUrl) {
		mName = name;
		mLearningHours = learningHours;
		mCountry = country;
		mImageUrl = imageUrl;

	}

	public String getmName() {
		return mName;
	}

	public int getmLearningHours() {
		return mLearningHours;
	}

	public String getmCountry() {
		return mCountry;
	}

	public String getmImageUrl() {
		return mImageUrl;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public void setmLearningHours(int mLearningHours) {
		this.mLearningHours = mLearningHours;
	}

	public void setmCountry(String mCountry) {
		this.mCountry = mCountry;
	}

	public void setmImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
	}

}
