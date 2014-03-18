package com.cs275.parkinglottracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchLotActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_lot);
		
		try
		{
			ListView lv = (ListView)this.findViewById(R.id.listView1);
			
			SearchLotsTask task = new SearchLotsTask();
			task.execute(lv);
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.out);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_lot, menu);
		return true;
	}

}
