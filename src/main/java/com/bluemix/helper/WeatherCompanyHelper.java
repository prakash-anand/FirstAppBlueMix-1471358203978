package com.bluemix.helper;

import java.net.URI;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class WeatherCompanyHelper {

	public String getWeatherPostCode(String postCode) {
		String weatherPostcode="";

		try {
			String baseURL = "http://twcservice.stage1.mybluemix.net/api/weather/v1/location/30339%3A4%3AUS/almanac/daily.json?start=0112";
			String weatherUsername = "fcb61d2d-3a6d-4c39-9b75-70172d3df53d";
			String weatherPassword = "vlX9X7iVGd";

			URI profileURI = new URI(baseURL).normalize();
			Request profileRequest = Request.Post(profileURI)
					.addHeader("Accept", "application/json")
					.addHeader("Content-Language", "en");

			Executor executor = Executor.newInstance().auth(weatherUsername,
					weatherPassword);
			Response responsefromAPI = executor.execute(profileRequest);

			weatherPostcode = responsefromAPI.returnContent().asString();
		
		} catch (Exception e) {
			System.out.println("Exception in getWeatherPostCode: " + e);
		}
		return weatherPostcode;
	}
}