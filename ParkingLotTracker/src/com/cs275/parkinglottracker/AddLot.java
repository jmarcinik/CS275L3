package com.cs275.parkinglottracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.NavUtils;

public class AddLot extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_lot);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Button button = (Button)this.findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener() 
		{
			@Override
			public void onClick(View arg0)
			{				
				EditText et1 = (EditText) ((Activity) arg0.getContext()).findViewById(R.id.editText1);
				EditText et2 = (EditText) ((Activity) arg0.getContext()).findViewById(R.id.editText2);
				EditText et3 = (EditText) ((Activity) arg0.getContext()).findViewById(R.id.editText3);
				
				String name = et1.getText().toString();
				String price = et2.getText().toString();
				String hours = et3.getText().toString();
				
				LotInfo info = new LotInfo(name, hours, price, false);
				
				SaveLotDataTask saveTask = new SaveLotDataTask();
				saveTask.execute(info);
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
