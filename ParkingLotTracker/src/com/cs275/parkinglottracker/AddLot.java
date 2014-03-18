package com.cs275.parkinglottracker;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class AddLot extends Activity {

	EditText editTextName;
	EditText editTextPrice;
	EditText editTextHour;
	EditText editTextLocation;
	Button buttonSave;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_lot);
		// Show the Up button in the action bar.
		setupActionBar();
		
		editTextName = (EditText) findViewById(R.id.editText1);
		editTextPrice = (EditText) findViewById(R.id.editText2);
		editTextHour = (EditText) findViewById(R.id.editText3);
		editTextLocation = (EditText) findViewById(R.id.editText4);
		addListenerOnButtonSave();
	}

	private void addListenerOnButtonSave() {
		// TODO Auto-generated method stub

		// "Save" button
		buttonSave = (Button) findViewById(R.id.button1);

		buttonSave.setOnClickListener(new OnClickListener() { 
			@Override
			public void onClick(View arg0) {
				Log.i("TEST", "Save button clicked.");

				LotInfo lotInfo = null;

				if(editTextLocation.getText().toString().trim().length() > 0)
					lotInfo = new LotInfo(editTextName.getText().toString()
							, editTextHour.getText().toString()
							, editTextPrice.getText().toString()
							, editTextLocation.getText().toString());
				else
					lotInfo = new LotInfo(editTextName.getText().toString()
							, editTextHour.getText().toString()
							, editTextPrice.getText().toString());
				
				AsyncTask<LotInfo, Void, Void> asyncTask = new SaveLotDataTask().execute(lotInfo);
				
				try
				{
					asyncTask.get();
				}
				catch(Exception e){
					Log.e("asyncTask.get()", e.toString());
				}
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
		getMenuInflater().inflate(R.menu.add_lot, menu);
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
