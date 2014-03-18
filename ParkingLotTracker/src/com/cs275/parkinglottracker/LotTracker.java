package com.cs275.parkinglottracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LotTracker extends Activity
{
	public static final String APP_NAME = "LotTracker";
	public static final String APP_KEY = "b31cc8b24fa54a3b85fc4f93d177d24f";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lot_tracker);
		
		Button addLotButton = (Button)this.findViewById(R.id.button1);
		addLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent showAddLot = new Intent(v.getContext(), AddLot.class);
				startActivity(showAddLot);
			}			
		});
		
		Button editLotButton = (Button)this.findViewById(R.id.button2);
		editLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent showEditLot = new Intent(v.getContext(), EditLotActivity.class);
				startActivity(showEditLot);
			}			
		});
		
		Button searchLotButton = (Button)this.findViewById(R.id.button3);
		searchLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent showSearchLot = new Intent(v.getContext(), SearchLotActivity.class);
				startActivity(showSearchLot);
			}			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lot_tracker, menu);
		return true;
	}

}
