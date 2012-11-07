package com.amazinglystupidsoftware.arewegonnaburn;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.amazinglystupidsoftware.arewegonnaburn.controller.VenuesAdapter;
import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;
import com.amazinglystupidsoftware.arewegonnaburn.model.VenueDAO;

public class ListFragment extends Fragment {

	private ListView venuesList;
	private MainActivity mActivity;
	protected DetailFragment detailFrag;
	
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		mActivity= (MainActivity) activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.list_fragment, container);

		this.venuesList = (ListView) v.findViewById(R.id.venuesListView);

		VenuesAdapter adapter = new VenuesAdapter(mActivity, VenueDAO.getInstance()
				.getAll());
		adapter.sort();
		venuesList.setAdapter(adapter);

		venuesList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {


				Venue v = (Venue) parent.getAdapter().getItem(position);
				mActivity.showDetailForVenue(v);
			}
		});
		
		return v;
	}
}
