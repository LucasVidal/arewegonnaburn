package com.amazinglystupidsoftware.arewegonnaburn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;

public class MainActivity extends FragmentActivity {

	protected DetailFragment detailFrag;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


	}
	
	public void showDetailForVenue(Venue v)
	{
		detailFrag = ((DetailFragment) MainActivity.this.getSupportFragmentManager()
				.findFragmentById(R.id.detail_fragment));
				
		if (detailFrag == null) {
			Intent intent = new Intent(MainActivity.this, DetailActivity.class);
			intent.putExtra(Venue.VENUE_ID, v.getId());
			startActivity(intent);
		} else {
			detailFrag.showDetailsForId(v.getId());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
