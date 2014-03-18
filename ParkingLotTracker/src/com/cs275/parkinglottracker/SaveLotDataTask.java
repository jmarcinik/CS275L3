package com.cs275.parkinglottracker;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectSet.ObjectSetInputSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

import android.os.AsyncTask;

public class SaveLotDataTask extends AsyncTask<LotInfo, Void, Void>
{
	public static final String TEMBOO_APP_NAME = "myFirstApp";
	public static final String TEMBOO_APP_KEY = "346446bab5fb4feab4ef381c19e964ac";
	public static final String APP_NAME = "LotTracker";
	public static final String APP_ID = "b31cc8b24fa54a3b85fc4f93d177d24f";
	public static final String API_KEY = "FF563FA5CC844220A8AD7992C20243C1";

	@Override
	protected Void doInBackground(LotInfo... arg0) 
	{
		if(arg0.length > 0)
		{
			LotInfo info = arg0[0];
			
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
				
				object = "\"" + info.getName() + "\": {\"LotName\": \"" + info.getName() + "\", \"openHours\": \"" + info.getHours() +
		  		         "\", \"pricePerHour\": \"" + info.getPrice() + "\"";
				
				if(!info.isUpdate())
					object += ", \"location\": {\"__type__\": \"geopoint\", \"longitude\": " + lon +
				              ", \"latitude\": " + lat + " 	}}";
				else
					object += "}";
			}
			catch(Exception ex)
			{
				ex.printStackTrace(System.out);
			}
			
			TembooSession session;
			try 
			{
				session = new TembooSession("jmarcinikcs275", TEMBOO_APP_NAME, TEMBOO_APP_KEY);
				ObjectSet setter = new ObjectSet(session);
				
				
				ObjectSetInputSet inputs = setter.newInputSet();
				
				inputs.set_Data(object);
				inputs.set_APIKey(API_KEY);
				inputs.set_ApplicationIdentifier(APP_ID);
				
				
				setter.execute(inputs);
			} 
			catch (TembooException e)
			{
				e.printStackTrace();
			}
			
			
			
		}
		
		return null;
	}

}
