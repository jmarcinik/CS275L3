package com.cs275.parkinglottracker;

import java.util.List;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class EditLotInfo extends Activity {

	ListView listView;
	Button buttonClose;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_lot_info);
		// Show the Up button in the action bar.
		setupActionBar();
		
		prepareData();
		addListenerOnButtonClose();
	}
	
	private void prepareData() {
		AsyncTask<Void, Void, List<LotInfo> > asyncTask = new GetLotDataTask().execute();

		try
		{
			List<LotInfo> lotInfos = asyncTask.get();
			
			for(int i=0; i<lotInfos.size(); i++) {
				Log.d("TEST", lotInfos.get(i).getName());
			}

		}
		catch(Exception e){
			Log.e("asyncTask.get()", e.toString());
		}
	}

	// Click Listener for "Save" button
	private void addListenerOnButtonClose() {
		// TODO Auto-generated method stub

		// "Save" button
		buttonClose = (Button) findViewById(R.id.buttonClose);
		buttonClose.setOnClickListener(new OnClickListener() { 
			@Override
			public void onClick(View arg0) {
				Log.i("TEST", "Close button clicked.");
				finish();
			}
		});		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_lot_info, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}