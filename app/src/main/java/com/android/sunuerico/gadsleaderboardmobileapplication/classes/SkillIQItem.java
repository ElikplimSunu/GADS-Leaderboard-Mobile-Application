package com.android.sunuerico.gadsleaderboardmobileapplication.classes;

public class SkillIQItem {
	private String mName;
	private int mSkillIqScore;
	private String mCountry;
	private String mImageUrl;

	public SkillIQItem() {
	}


	public SkillIQItem(String name, int skillIqScore, String country, String imageUrl) {
		mName = name;
		mSkillIqScore = skillIqScore;
		mCountry = country;
		mImageUrl = imageUrl;

	}

	public String getmName() {
		return mName;
	}

	public int getmSkillIqScore() {
		return mSkillIqScore;
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

	public void setmSkillIqScore(int mLearningHours) {
		this.mSkillIqScore = mLearningHours;
	}

	public void setmCountry(String mCountry) {
		this.mCountry = mCountry;
	}

	public void setmImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
	}

}
