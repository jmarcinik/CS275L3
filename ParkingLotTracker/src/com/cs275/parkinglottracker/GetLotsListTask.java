package com.cs275.parkinglottracker;

import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetInputSet;
import com.temboo.Library.CloudMine.ObjectStorage.ObjectGet.ObjectGetResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

import android.os.AsyncTask;

public class GetLotsListTask extends AsyncTask<Void, Void, String[]>
{
	
	public static final String TEMBOO_APP_NAME = "myFirstApp";
	public static final String TEMBOO_APP_KEY = "346446bab5fb4feab4ef381c19e964ac";
	public static final String APP_NAME = "LotTracker";
	public static final String APP_ID = "b31cc8b24fa54a3b85fc4f93d177d24f";
	public static final String API_KEY = "FF563FA5CC844220A8AD7992C20243C1";

	@Override
	protected String[] doInBackground(Void... params)
	{
		TembooSession session;
		try 
		{
			session = new TembooSession("jmarcinikcs275", TEMBOO_APP_NAME, TEMBOO_APP_KEY);
			ObjectGet getter = new ObjectGet(session);
						
			ObjectGetInputSet inputs = getter.newInputSet();
						
			inputs.set_APIKey(API_KEY);
			inputs.set_ApplicationIdentifier(APP_ID);						
			
			ObjectGetResultSet result = getter.execute(inputs);
			String[] resultArray = (String[])(result.getOutputs().keySet().toArray());
			
			return resultArray;
		} 
		catch (TembooException e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}

}
