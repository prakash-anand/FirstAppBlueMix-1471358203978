package com.bluemix.helper;

import java.net.URI;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

public class WeatherCompanyHelper {

	public String getWeatherPostCode(String postCode) {
		String weatherPostcode="";

		try {
			String baseURL = "https://twcservice.stage1.mybluemix.net/api/weather/v1/location/30339%3A4%3AUS/almanac/daily.json?start=0112";
			String weatherUsername = "c929253b-2767-4dbb-af1b-88b0da43e938";
			String weatherPassword = "oM6upqP1UV";

			URI weatherURI = new URI(baseURL).normalize();
			Request weatherRequest = Request.Post(weatherURI)
					.addHeader("Accept", "application/json")
					.addHeader("Content-Language", "en");

			Executor executor = Executor.newInstance().auth(weatherUsername,
					weatherPassword);
			Response responsefromAPI = executor.execute(weatherRequest);

			weatherPostcode = responsefromAPI.returnContent().asString();
		
		} catch (Exception e) {
			System.out.println("Exception in getWeatherPostCode: " + e);
		}
		return weatherPostcode;
	}
}