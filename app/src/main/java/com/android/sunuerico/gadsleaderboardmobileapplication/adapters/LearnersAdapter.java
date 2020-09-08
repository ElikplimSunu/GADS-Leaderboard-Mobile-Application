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
import com.android.sunuerico.gadsleaderboardmobileapplication.classes.LearnersItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class LearnersAdapter extends RecyclerView.Adapter<LearnersAdapter.LeaderboardViewHolder> {
	private Context mContext;
	private ArrayList<LearnersItem> mLeaderboardList;

	public LearnersAdapter(Context context, ArrayList<LearnersItem> leaderboardList) {
		mContext = context;
		mLeaderboardList = leaderboardList;
	}

	@NonNull
	@Override
	public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(mContext).inflate(R.layout.learner_list_item, parent, false);
		return new LeaderboardViewHolder(v);
	}

	@Override
	public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
		LearnersItem currentItem = mLeaderboardList.get(position);

		String learnerName = currentItem.getmName();
		int learningHours = currentItem.getmLearningHours();
		String courty = currentItem.getmCountry();
		String imageUrl = currentItem.getmImageUrl();


		holder.mTextViewName.setText(learnerName);
		holder.mTextViewLearningHours.setText(learningHours + mContext.getString(R.string.learning_hours_text));
		holder.mTextViewCountry.setText(courty);
		Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);


	}

	@Override
	public int getItemCount() {
		return mLeaderboardList.size();
	}

	public class LeaderboardViewHolder extends RecyclerView.ViewHolder {
		public TextView mTextViewName;
		public TextView mTextViewLearningHours;
		public TextView mTextViewCountry;
		public ImageView mImageView;


		public LeaderboardViewHolder(@NonNull View itemView) {
			super(itemView);

			mTextViewName = itemView.findViewById(R.id.learner_name);
			mTextViewLearningHours = itemView.findViewById(R.id.learning_hours);
			mTextViewCountry = itemView.findViewById(R.id.country);
			mImageView = itemView.findViewById(R.id.badge);

		}
	}
}
