package com.amazinglystupidsoftware.arewegonnaburn;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.amazinglystupidsoftware.arewegonnaburn.model.Venue;

public class DetailActivity extends FragmentActivity{

	
    
	private DetailFragment detailFrag;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailFrag = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
        
        detailFrag.showDetailsForId(getIntent().getStringExtra(Venue.VENUE_ID));
    }
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail, menu);
        return true;
    }
	
}
