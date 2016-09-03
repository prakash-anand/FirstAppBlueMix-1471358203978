package com.bluemix.helper;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;


public class Utilities {
	
	  public Map loadStaticBluemixProperties(Properties properties)
		      throws IOException, IllegalArgumentException, JSONException {

		    // Get read the vcap services from environment
		    String envServices = System.getenv("VCAP_SERVICES");
		    JSONObject  services;

		    if (envServices != null) {
		    	//services=envServices;

		    } 

		    
		    return properties;
		  }

}
