package com.cs275.parkinglottracker;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map.Entry;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetInputSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetResultSet;
import com.temboo.core.TembooSession;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class GetLotsListTask extends AsyncTask<Spinner, Void, Void>
{
	
	public static final String TEMBOO_APP_NAME = "myFirstApp";
	public static final String TEMBOO_APP_KEY = "346446bab5fb4feab4ef381c19e964ac";
	public static final String APP_NAME = "LotTracker";
	public static final String APP_ID = "b31cc8b24fa54a3b85fc4f93d177d24f";
	public static final String API_KEY = "FF563FA5CC844220A8AD7992C20243C1";

	Spinner spin;
	String[] res;
	
	@Override
	protected Void doInBackground(Spinner... params)
	{
				
		TembooSession session;
		try 
		{
			spin = params[0];
			
			session = new TembooSession("jmarcinikcs275", TEMBOO_APP_NAME, TEMBOO_APP_KEY);
			ObjectGet getter = new ObjectGet(session);
						
			ObjectGetInputSet inputs = getter.newInputSet();
						
			inputs.set_APIKey(API_KEY);
			inputs.set_ApplicationIdentifier(APP_ID);						
			
			ObjectGetResultSet result = getter.execute(inputs);
						
			String resultStr = result.get_Response();
			
			StringReader reader = new StringReader(resultStr);
			
			ArrayList<String> resultArray = new ArrayList<String>();
			
			JsonParser parser = new JsonParser();
			JsonElement head = parser.parse(reader);
			
			if(head.isJsonObject())
			{
				JsonObject results = head.getAsJsonObject();
				JsonElement r2 = results.get("success");
				
				for(Entry<String, JsonElement> entry: r2.getAsJsonObject().entrySet())
				{
					resultArray.add(entry.getKey());
				}
			}
			
			String[] resultArray2 = new String[resultArray.size()];
			int i = 0;			
			for(String s: resultArray)
			{
				resultArray2[i] = s;
				i++;
			}
			
			System.out.println("String array complete");
			
			res = resultArray2;
			
			return null;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	protected void onPostExecute(Void param)
	{
		try
		{
			ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(spin.getContext(), android.R.layout.simple_spinner_item, res);
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
			spin.setAdapter(adapter);
		}
		catch(Exception ex)
		{
			ex.printStackTrace(System.out);
		}
	}

}
