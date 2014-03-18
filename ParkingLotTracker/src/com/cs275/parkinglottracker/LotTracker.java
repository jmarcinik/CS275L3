package com.cs275.parkinglottracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LotTracker extends Activity
{
	public static final String APP_NAME = "LotTracker";
	public static final String APP_KEY = "b31cc8b24fa54a3b85fc4f93d177d24f";
	
	Button addLotButton;
	Button editLotButton;
	Button findLotButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lot_tracker);
		
		addLotButton = (Button)this.findViewById(R.id.buttonAddLot);
		addLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent showAddLot = new Intent(v.getContext(), AddLot.class);
				startActivity(showAddLot);
			}			
		});
		
		editLotButton = (Button)this.findViewById(R.id.buttonEditLotInfo);
		editLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
				Intent showEditLotInfo = new Intent(v.getContext(), EditLotInfo.class);
				Log.d("TEST", "editLotButton clicked2.");
				startActivity(showEditLotInfo);
			}			
		});
		
		findLotButton = (Button)this.findViewById(R.id.buttonFindLot);
		findLotButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v)
			{
//				Intent showFindLot = new Intent(v.getContext(), FindLot.class);
//				startActivity(showFindLot);
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
