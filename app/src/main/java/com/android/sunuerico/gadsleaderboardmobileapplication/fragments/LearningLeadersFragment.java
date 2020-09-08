package com.android.sunuerico.gadsleaderboardmobileapplication.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.sunuerico.gadsleaderboardmobileapplication.R;
import com.android.sunuerico.gadsleaderboardmobileapplication.adapters.LearnersAdapter;
import com.android.sunuerico.gadsleaderboardmobileapplication.classes.LearnersItem;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class LearningLeadersFragment extends Fragment {

	private RecyclerView mRecyclerView;
	private LearnersAdapter mLearnersAdapter;
	private ArrayList<LearnersItem> mLeaderboardList;
	private RequestQueue mRequestQueue;
	private static String JSON_URL = "https://gadsapi.herokuapp.com/api/hours";


	public LearningLeadersFragment() {
		// Required empty public constructor
	}

	public void parseJSON() {
		mRequestQueue = Volley.newRequestQueue(Objects.requireNonNull(getActivity()));
		JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
			@Override
			public void onResponse(JSONArray response) {
				for (int i = 0; i < response.length(); i++) {
					try {
						JSONObject learnerObject = response.getJSONObject(i);

						LearnersItem learner = new LearnersItem();
						learner.setmName(learnerObject.getString("name"));
						learner.setmLearningHours(learnerObject.getInt("hours"));
						learner.setmCountry(learnerObject.getString("country"));
						learner.setmImageUrl(learnerObject.getString("badgeUrl"));

						mLeaderboardList.add(learner);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

				mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

				mLearnersAdapter = new LearnersAdapter(getActivity(), mLeaderboardList);
				mRecyclerView.setAdapter(mLearnersAdapter);
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.d("tag", "onErrorResponse: " + error.getMessage());
			}
		});

		mRequestQueue.add(jsonArrayRequest);
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.activity_learning_leaders, container, false);

		mRecyclerView = rootView.findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);

		mLeaderboardList = new ArrayList<>();

		parseJSON();

		return rootView;

	}
}