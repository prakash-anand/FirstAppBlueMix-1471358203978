package wasdev.sample.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class JsonServlet
 */
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
		
		response.setContentType("text/html");
	  //  PrintWriter out =response.getWriter();
	    BufferedReader reader = null;
		
		String weather="";
		String urlString="https://fcb61d2d-3a6d-4c39-9b75-70172d3df53d:vlX9X7iVGd@twcservice.stage1.mybluemix.net/api/weather/v1/location/30339%3A4%3AUS/almanac/daily.json?start=0112";
		try {
			
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 
			weather=reader.toString();
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
	}

}
