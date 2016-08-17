package wasdev.sample.servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.stream.JsonReader;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Content;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.ProfileOptions.Language;
import com.ibm.watson.developer_cloud.util.GsonSingleton;



/**
 * Servlet implementation class JsonServlet
 */
@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Inside Servlet doGet");
		//PersonalityInsights personalityInsight=new PersonalityInsights();
		
		response.setContentType("text/html");
	  //  PrintWriter out =response.getWriter();
	    BufferedReader reader = null;


		String weather="";
		String urlString="https://2c435666-86e9-4041-8c17-46c807cf59fc:7lnNFiTeLZ@twcservice.mybluemix.net:443/api/weather/v2/location/point?postalKey=30339%3AUS&language=en-US";
		//urlString="http://ip.jsontest.com/?callback=showMyIP";
		try {
			
	        URL url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("username", "fcb61d2d-3a6d-4c39-9b75-70172d3df53d");
			//conn.setRequestProperty("password", "vlX9X7iVGd");
			conn.setRequestProperty("Accept", "application/json");
	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
			weather=buffer.toString()+"::"+buffer;
			
			//GET https://<username>:<password>@twcservice.mybluemix.net:443/api/weather/v1/location/97229%3A4%3AUS/forecast/hourly/48hour.json?units=m&language=en-US
			//weather=jsonReader.getWeather("https://6a86e761-fbad-41f9-b3e0-882b54f542f7:3Icqlwztco@twcservice.stage1.mybluemix.net/api/weather/v1/location/30339%3A4%3AUS/almanac/daily.json?start=0112");
			//weather=jsonReader.getWeather("http://echo.jsontest.com/insert-key-here/insert-value-here/key/value");
			System.out.println("Weather: "+ weather);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		request.setAttribute("weather", weather);
	    request.getRequestDispatcher("/jsp/Response.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Servlet doPost");
		
		 String baseURL = "<url>";
		 String username = "<username>";
		String password = "<password>";
		String text="Ashok Malik, Journalist "
+" Perhaps he knew it all along. On Independence Day, Prime Minister Narendra Modi delivered a 100-minute long speech, but the resultant coverage and debate has centred on his reference to troubled regions that are in Pakistani control but disputed internationally, or part of Pakistan but with a contested sovereignty domestically. There were three proper nouns Modi used and it is important to understand the context of each."
+" First, he spoke of Pakistan-Occupied Kashmir, a part of Kashmir in Pakistani control since 1947. Following the accession of the kingdom of Jammu and Kashmir in October 1947, it belongs to India. Indian maps show it as such. Since 1965, successive Indian governments have been willing to write off Pakistan-Occupied Kashmir and convert the line dividing it and the Kashmir Valley (the Line of Control) into an international border - whether a hard border or, as has been suggested over the past 10-15 years, a soft border permitting trade and movement of peoples."
+" Second, Modi referred to Gilgit or, to be more correct, Gilgit-Baltistan, also known as the Northern Areas. Modi was both right and wrong in distinguishing Gilgit-Baltistan from Pakistan-Occupied Kashmir. He was right because this is ethnically and geographically not part of the Kashmir region. Given its strategic import and proximity to Central Asia, the Pakistan government has spun off Gilgit-Baltistan into a separate territory, distinct from Pakistan-occupied Kashmir or the so-called Azad Kashmir."
+" Yet, Modi was also wrong. While not part of the cultural and social expanse of Kashmir and so not part of Pakistan-Occupied Kashmir in that narrow reckoning, the Northern Areas were a part of Hari Singh's kingdom and legally acceded to India in 1947. As such, Gilgit-Baltistan is a segment of Pakistan-occupied portions of the former kingdom (or the current Indian state) of Jammu and Kashmir."
+" Third, Balochistan is in a class by itself. In 1947, it existed as a frontier region comprising a clutch of kingdoms and some territory under the suzerainty of Oman, an Arab kingdom that was an ally of the British Raj. The biggest Baloch kingdom was the Khanate of Kalat. While it acceded to Pakistan, allegedly following promises by Mohammad Ali Jinnah that were never kept, Kalat had never quite been part of British India. Its position vis-à-vis the Raj was not very different from that of Nepal. As such, if Nepal is not part of India, there is logic to suggest that Kalat should not be part of Pakistan." 
+" Certainly the former royal family of Kalat, members of which live in London, still fancy their claims. Another princely state was Las Bela, with its capital city, Bela, famous for not having had a European visitor between Alexander the Great and the British in the 19th century. Alexander visited Balochistan on his way home from India and is believed to have boarded a ship from the Makran Coast, near today's Gwadar. ";
		
		
		
		try {

			   URI profileURI = new URI(baseURL + "/v2/profile").normalize();
			   Request profileRequest = Request.Post(profileURI)
			      .addHeader("Accept", "application/json")
			      .addHeader("Content-Language", "en")
			      .bodyString(text, ContentType.TEXT_PLAIN);

			   Executor executor = Executor.newInstance().auth(username, password);
			   Response responsefromAPI = executor.execute(profileRequest);
			   HttpResponse httpResponse = responsefromAPI.returnResponse();
			   response.setStatus(httpResponse.getStatusLine().getStatusCode());
/*
			   ServletOutputStream servletOutputStream = response.getOutputStream();
			   httpResponse.getEntity().writeTo(servletOutputStream);
			   servletOutputStream.flush();
			   servletOutputStream.close();*/
			   String jsonResponse= responsefromAPI.returnResponse().toString();
			   request.setAttribute("weather", jsonResponse);
			   
			} catch (Exception e) {
			   System.out.println("Service error: " + e.getMessage());
			  // resp.setStatus(HttpStatus.SC_BAD_GATEWAY);
			}
		
	    
	    request.getRequestDispatcher("/jsp/Response.jsp").forward(request, response); 
		/*
		try {

			PersonalityInsights personitlyInsight=new PersonalityInsights();
			personitlyInsight.setUsernameAndPassword("2c435666-86e9-4041-8c17-46c807cf59fc", "7lnNFiTeLZ");
			personitlyInsight.setEndPoint("twcservice.mybluemix.net:443/api/weather/v2/location/point");

			/*try {
			  JsonReader jReader = new JsonReader(new FileReader("profile.json"));
			  Content content = GsonSingleton.getGson().fromJson(jReader, Content.class);
			  ProfileOptions options = new ProfileOptions().contentItems(content.getContentItems());
			  Profile profile = personitlyInsight.getProfile(options);
			  System.out.println(profile);
			} catch (Exception e) {
			  e.printStackTrace();
			}
			
			  URI profileURI = new URI(baseURL + "/v2/profile").normalize();
			   HttpClient httpClient= HttpClientBuilder.create().build();
			   HttpPost postRequest = new HttpPost(baseURL);
			   postRequest.addHeader("Accept", "application/json");
			   postRequest.addHeader("Content-Language", "en" );
			   postRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");
			   
			   List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			   
			   
			//   ProfileOptions options = new ProfileOptions().text(text);
			//   Profile profile = personitlyInsight.getProfile(options);
			   
			   formParams.add(new BasicNameValuePair("text", text));
			   postRequest.setEntity(new UrlEncodedFormEntity(formParams));
			   
			   HttpResponse responseFromApi = httpClient.execute(postRequest);

			    String jsonString = EntityUtils.toString(responseFromApi.getEntity());
			    
			    Request profileRequest = Request.Post(profileURI);
			   
			    request.setAttribute("weather", jsonString);
			    request.getRequestDispatcher("/jsp/Response.jsp").forward(request, response);   


			/*
			 * 
			 * 
			 *    CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    HttpPost postRequest = new HttpPost(postUrl);
    postRequest.addHeader("accept", "application/json");
    postRequest.addHeader("Content-Type", "application/x-www-form-urlencoded");

			
			   URI profileURI = new URI(baseURL + "/v2/profile").normalize();
			   Request profileRequest = Request.Post(profileURI)
			      .addHeader("Accept", "application/json")
			      .addHeader("Content-Language", language)
			      .bodyString(text, ContentType.TEXT_PLAIN);

			   Executor executor = Executor.newInstance().auth(username, password);
			   Response response = executor.execute(profileRequest);
			   HttpResponse httpResponse = response.returnResponse();
			   resp.setStatus(httpResponse.getStatusLine().getStatusCode());

			   ServletOutputStream servletOutputStream = resp.getOutputStream();
			   httpResponse.getEntity().writeTo(servletOutputStream);
			   servletOutputStream.flush();
			   servletOutputStream.close();

			} catch (Exception e) {
			   System.out.println( e.getMessage().toString());
			   //resp.setStatus(HttpStatus.SC_BAD_GATEWAY);
			}*/
		
	}

}
