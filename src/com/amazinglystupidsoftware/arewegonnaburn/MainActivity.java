package com.amazinglystupidsoftware.arewegonnaburn;

import com.amazinglystupidsoftware.arewegonnaburn.controller.VenuesAdapter;
import com.amazinglystupidsoftware.arewegonnaburn.model.VenueDAO;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {

    private ListView venuesList;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.venuesList = (ListView) findViewById(R.id.venuesListView);
        
        VenuesAdapter adapter = new VenuesAdapter(this, VenueDAO.getInstance().getAll());
        venuesList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
