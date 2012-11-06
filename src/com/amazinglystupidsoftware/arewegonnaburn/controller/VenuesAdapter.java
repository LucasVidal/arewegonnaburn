package com.amazinglystupidsoftware.arewegonnaburn.controller;

import java.util.Comparator;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amazinglystupidsoftware.arewegonnaburn.R;
import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;

public class VenuesAdapter extends ArrayAdapter<Venue>{

	private List<Venue> venueList;
	private Context context;

	public VenuesAdapter(Context context, 
			List<Venue> venues) {
		super(context, 0, venues);
		this.context=context;
		this.venueList = venues;
	}
	
	public void sort()
	{
		super.sort(new Comparator<Venue>() {
			@Override
			public int compare(Venue lhs, Venue rhs) {
				return lhs.compareTo(rhs);
			}
		});
	}
	
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		View rowView; 
		
		if (convertView ==null)
		{
			LayoutInflater inflater = LayoutInflater.from(context);
			rowView = inflater.inflate(R.layout.venue_row, parent, false);
		}
		else rowView = convertView;
		
		TextView nameTextView = (TextView) rowView.findViewById(R.id.nameTextView);
		TextView locationTextView = (TextView) rowView.findViewById(R.id.locationTextView);
		Venue v = this.venueList.get(position);
		nameTextView.setText(v.getName());
		locationTextView.setText(""+v.getLocation());
		return rowView;
    }
}
