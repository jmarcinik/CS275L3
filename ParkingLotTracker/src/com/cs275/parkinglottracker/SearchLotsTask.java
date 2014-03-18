package com.cs275.parkinglottracker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSearch;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSearch.ObjectSearchInputSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSearch.ObjectSearchResultSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet.ObjectSetInputSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

import android.os.AsyncTask;

public class SearchLotsTask extends AsyncTask<Void, Void, String[]>
{
	public static final String TEMBOO_APP_NAME = "myFirstApp";
	public static final String TEMBOO_APP_KEY = "346446bab5fb4feab4ef381c19e964ac";
	public static final String APP_NAME = "LotTracker";
	public static final String APP_ID = "b31cc8b24fa54a3b85fc4f93d177d24f";
	public static final String API_KEY = "FF563FA5CC844220A8AD7992C20243C1";
	

	@Override
	protected String[] doInBackground(Void... arg0)
	{		
		String lat = "", lon = "";
		
		String object = "";
		
		// get latitude and longitude
		try
		{
			URL requestURL = new URL("http://freegeoip.net/json/");
			
			HttpURLConnection req = (HttpURLConnection) requestURL.openConnection();
			req.connect();
			
			InputStreamReader reader = new InputStreamReader((InputStream)req.getContent());
						
			JsonParser parser = new JsonParser();
			JsonElement head = parser.parse(reader);
			
			if(head.isJsonObject())
			{
				JsonObject obj = (JsonObject) head;
				
				JsonElement latElement = obj.get("latitude");
				JsonElement longElement = obj.get("longitude");
				
				lat = latElement.getAsString();
				lon =  longElement.getAsString();
			}
			
			req.disconnect();
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.out);
		}
		
		TembooSession session;
		try 
		{
			session = new TembooSession("jmarcinikcs275", TEMBOO_APP_NAME, TEMBOO_APP_KEY);
			ObjectSearch searcher = new ObjectSearch(session);
			
			
			ObjectSearchInputSet inputs = searcher.newInputSet();
			
			String query = "[location near (" + lon + ", " + lat + "), 1km]";
			
			inputs.set_Query(query);
			inputs.set_APIKey(API_KEY);
			inputs.set_ApplicationIdentifier(APP_ID);
						
			//searcher.execute(inputs);
			
			
			ObjectSearchResultSet results = searcher.execute(inputs);
			String[] array = (String[])results.getOutputs().keySet().toArray();
			
			return array;
		} 
		catch (TembooException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

}
