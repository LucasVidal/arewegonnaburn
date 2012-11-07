package com.amazinglystupidsoftware.arewegonnaburn;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;
import com.amazinglystupidsoftware.arewegonnaburn.model.VenueDAO;

public class DetailFragment extends Fragment {
	
    private TextView venueNameTextView;
    private TextView capacityTextView;
    private TextView locationTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			   Bundle savedInstanceState) 
	{
		View v = inflater.inflate(R.layout.detail_fragment, container, false);
    	venueNameTextView = (TextView) v.findViewById(R.id.venueNameTextView);
        capacityTextView = (TextView) v.findViewById(R.id.capacityTextView);
        locationTextView = (TextView) v.findViewById(R.id.locationTextView);
        return v;
	}
	public void showDetailsForId(String venueId)
	{
		
        Venue v = VenueDAO.getInstance().getVenueWithId(venueId);
        venueNameTextView.setText(v.getName());
        capacityTextView.setText(""+v.getCapacity());
        locationTextView.setText(v.getLocation());
	}

}
