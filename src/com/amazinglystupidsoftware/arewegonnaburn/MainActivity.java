package com.amazinglystupidsoftware.arewegonnaburn;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.amazinglystupidsoftware.arewegonnaburn.controller.VenuesAdapter;
import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;
import com.amazinglystupidsoftware.arewegonnaburn.model.VenueDAO;

public class MainActivity extends Activity {

    private ListView venuesList;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.venuesList = (ListView) findViewById(R.id.venuesListView);
        
        VenuesAdapter adapter = new VenuesAdapter(this, VenueDAO.getInstance().getAll());
        adapter.sort();
        venuesList.setAdapter(adapter);
        
        venuesList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				Venue v = (Venue) parent.getAdapter().getItem(position);
				Intent i = new Intent(MainActivity.this, DetailActivity.class);
				i.putExtra(Venue.VENUE_ID, v.getId());
				startActivity(i);
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
