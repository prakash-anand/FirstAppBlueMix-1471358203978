package com.bluemix.helper;

import java.net.URI;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

public class PersonalityInsightHelper {

	public String personalityInsightFluent(String inputText){
		
		 String baseURL = "https://gateway-s.watsonplatform.net/personality-insights/api";
		 String username = "3d7bfcdc-2af9-4c39-9ace-1488364993d9";
		String password = "bz2Vwau0HFID";
		String personalityInsight="";

		try{
			   URI profileURI = new URI(baseURL + "/v2/profile").normalize();
			 
			   Request profileRequest = Request.Post(profileURI)
			      .addHeader("Accept", "application/json")
			      .addHeader("Content-Language", "en")
			      .bodyString(inputText, ContentType.TEXT_PLAIN);

			   Executor executor = Executor.newInstance().auth(username, password);
			   Response responsefromAPI = executor.execute(profileRequest);

			   personalityInsight= responsefromAPI.returnContent().asString();

		}catch(Exception e){
			System.out.println("Exception while calling Personality Insight API: "+ e);	
		}
		
		return personalityInsight;
	}
	
	
	public String PersonalityInsightWatsonApi(String inputText){
		
		/*
		 checkApiStatus=true;
		PersonalityInsights personitlyInsight=new PersonalityInsights();
		personitlyInsight.setUsernameAndPassword(username, password);

		System.out.println("personalityInsight: "+personitlyInsight.getEndPoint());

		
		//  JsonReader jReader = new JsonReader(new FileReader("profile.json"));
		//  Content content = GsonSingleton.getGson().fromJson(jReader, Content.class);
		//  ProfileOptions options = new ProfileOptions().contentItems(content.getContentItems());
		//  ProfileOptions options = new ProfileOptions()
		//  .text(text)
		//  .language(Language.ENGLISH);
		 // Profile profile =  personitlyInsight.getProfile(options);
		
		
		  Profile profile = personitlyInsight.getProfile(text);
	
		  System.out.println(profile);
	*/
		return "";
	}
}
