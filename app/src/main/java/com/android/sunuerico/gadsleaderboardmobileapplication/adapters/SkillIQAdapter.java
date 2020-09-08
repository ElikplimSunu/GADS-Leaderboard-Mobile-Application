package com.android.sunuerico.gadsleaderboardmobileapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.classes.SkillIQItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkillIQAdapter extends RecyclerView.Adapter<SkillIQAdapter.SkillIQViewHolder> {
	private Context mContext;
	private ArrayList<SkillIQItem> mSkillIQList;

	public SkillIQAdapter(Context context, ArrayList<SkillIQItem> skillIQList) {
		mContext = context;
		mSkillIQList = skillIQList;
	}

	@NonNull
	@Override
	public SkillIQAdapter.SkillIQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(mContext).inflate(R.layout.skill_iq_list_item, parent, false);
		return new SkillIQAdapter.SkillIQViewHolder(v);
	}

	@Override
	public void onBindViewHolder(@NonNull SkillIQAdapter.SkillIQViewHolder holder, int position) {
		SkillIQItem currentItem = mSkillIQList.get(position);

		String learnerName = currentItem.getmName();
		int skillIqScore = currentItem.getmSkillIqScore();
		String country = currentItem.getmCountry();
		String imageUrl = currentItem.getmImageUrl();


		holder.mTextViewName.setText(learnerName);
		holder.mTextViewLearningHours.setText(skillIqScore + mContext.getString(R.string.skilliq_text));
		holder.mTextViewCountry.setText(country);
		Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);


	}

	@Override
	public int getItemCount() {
		return mSkillIQList.size();
	}

	public class SkillIQViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextViewName;
		public TextView mTextViewLearningHours;
		public TextView mTextViewCountry;
		public ImageView mImageView;


		public SkillIQViewHolder(@NonNull View itemView) {
			super(itemView);

			mTextViewName = itemView.findViewById(R.id.learner_name);
			mTextViewLearningHours = itemView.findViewById(R.id.skill_iq_score);
			mTextViewCountry = itemView.findViewById(R.id.country);
			mImageView = itemView.findViewById(R.id.badge);

		}
	}
}
