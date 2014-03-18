package com.cs275.parkinglottracker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetInputSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetResultSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet.ObjectSetInputSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

public class GetLotDataTask extends AsyncTask<Void, Void, List<LotInfo> >
{
	public static final String TEMBOO_APP_NAME = "myFirstApp";
	public static final String TEMBOO_APP_KEY = "346446bab5fb4feab4ef381c19e964ac";
	public static final String APP_NAME = "LotTracker";
	public static final String APP_ID = "b31cc8b24fa54a3b85fc4f93d177d24f";
	public static final String API_KEY = "FF563FA5CC844220A8AD7992C20243C1";

	@Override
	protected List<LotInfo> doInBackground(Void... arg0) {
		// TODO Auto-generated method stub
		TembooSession session;
		try 
		{
			session = new TembooSession("jmarcinikcs275", TEMBOO_APP_NAME, TEMBOO_APP_KEY);
			
			ObjectGet objectGetChoreo = new ObjectGet(session);

			// Get an InputSet object for the choreo
			ObjectGetInputSet objectGetInputs = objectGetChoreo.newInputSet();

			// Set inputs
			objectGetInputs.set_APIKey(API_KEY);
			objectGetInputs.set_ApplicationIdentifier(APP_ID);

			// Execute Choreo
			ObjectGetResultSet objectGetResults = objectGetChoreo.execute(objectGetInputs);
			
			Log.d("TEST", objectGetResults.get_Response());
		} 
		catch (TembooException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}}
