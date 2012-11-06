package com.amazinglystupidsoftware.arewegonnaburn;

import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class DetailActivity extends Activity {

    private TextView venueIdTextView;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        venueIdTextView = (TextView) findViewById(R.id.venue_id);
        
        venueIdTextView.setText(getIntent().getStringExtra(Venue.VENUE_ID));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail, menu);
        return true;
    }
}
