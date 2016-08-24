package wasdev.sample.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bluemix.helper.PersonalityInsightHelper;
import com.bluemix.helper.WeatherCompanyHelper;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("Inside Servlet doGet");
		String weather = "";

		request.setAttribute("weather", weather);
		request.getRequestDispatcher("/jsp/Response.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Servlet doPost");

		/**
		 * Get Personality Insight - Watson
		 */
		try {
			PersonalityInsightHelper personalityHelper = new PersonalityInsightHelper();
			String personalityInsight = personalityHelper
					.personalityInsightFluent(request.getParameter("remarks"));
			
			if (personalityInsight.equalsIgnoreCase(""))
				personalityInsight="Exception in calling Personality API";
			
			System.out.println("Remarks: "+ request.getParameter("remarks"));
			System.out.println("personality: " + personalityInsight);
			request.setAttribute("personality", personalityInsight);

			/**
			 * Get Weather Company Data
			 */
			WeatherCompanyHelper weatherHelper = new WeatherCompanyHelper();
			String weatherPostcode = weatherHelper.getWeatherPostCode(request.getParameter("postcode"));
			
			if (weatherPostcode.equalsIgnoreCase(""))
				weatherPostcode="Exception in calling Personality API";
			
			System.out.println("Postcode: "+ request.getParameter("postcode"));
			System.out.println("Weather Postcode: " + weatherPostcode);
			request.setAttribute("weatherPostcode", weatherPostcode);
		} catch (Exception e) {
			System.out.println("Service error: " + e.getMessage());
		}

		request.getRequestDispatcher("/jsp/Response.jsp").forward(request,
				response);
	}

}
