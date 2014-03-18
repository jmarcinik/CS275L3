package com.cs275.parkinglottracker;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class EditLotActivity extends Activity 
{
	private boolean loaded;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		loaded = false;
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_lot);
	
		try
		{
			Spinner spin = (Spinner) this.findViewById(R.id.spinner1);
			
			GetLotsListTask task = new GetLotsListTask();
			task.execute(spin);			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.out);
		}
		
		loaded = true;
		
		Button updateButton = (Button)this.findViewById(R.id.button1);
		updateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) 
			{
				Spinner spin = (Spinner) ((Activity) arg0.getContext()).findViewById(R.id.spinner1);
				
				EditText et2 = (EditText) ((Activity) arg0.getContext()).findViewById(R.id.editText2);
				EditText et3 = (EditText) ((Activity) arg0.getContext()).findViewById(R.id.editText3);
				
				String name = spin.getSelectedItem().toString(); //et1.getText().toString();
				String price = et2.getText().toString();
				String hours = et3.getText().toString();
				
				LotInfo info = new LotInfo(name, hours, price, true);
				
				SaveLotDataTask saveTask = new SaveLotDataTask();
				saveTask.execute(info);
			}			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_lot, menu);
		return true;
	}

}
