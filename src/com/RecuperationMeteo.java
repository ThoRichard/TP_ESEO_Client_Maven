package com;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class RecuperationMeteo
 */
@WebServlet("/RecuperationMeteo")
public class RecuperationMeteo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecuperationMeteo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		ArrayList<Ville> villes = (ArrayList<Ville>) session.getAttribute("villes");
		String ville1 = request.getParameter("ville1");
		session.setAttribute("ville1", ville1);

		float latitude = 0;
		float longitude = 0;

		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(ville1)) {
				latitude = ville.getLatitude();
				longitude = ville.getLongitude();
			}

		}

		HttpResponse<JsonNode> httpReponse;
		String url = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude
				+ "&appid=e7981aedc88a1188690110ee718393bf&lang=fr";
		try {
			httpReponse = Unirest.get(url).asJson();
			JsonElement jsonArray = JsonParser.parseString(httpReponse.getBody().toString());
			JsonObject jsonObject = jsonArray.getAsJsonObject();
			String temperatureFahrenheitVille = jsonObject.getAsJsonObject("main").get("temp").toString();
			/**
			 * TODO Afficher l'ic�ne et les conditions climatiques
			 */
			JsonArray weather = jsonObject.getAsJsonArray("weather");
			String iconMeteo = (weather.get(0).getAsJsonObject()).get("icon").getAsString().trim();
			String descriptionWeather = (weather.get(0).getAsJsonObject()).get("description").getAsString().trim();
			double temperatureCelsiusVille = this.fahrenheitToCelcius(Double.parseDouble(temperatureFahrenheitVille));

			DecimalFormat decimalFormat = new DecimalFormat("###.##");
			session.setAttribute("tempsVille1", decimalFormat.format(temperatureCelsiusVille));
			session.setAttribute("iconMeteo", "http://openweathermap.org/img/w/" + iconMeteo + ".png");
			session.setAttribute("descriptionWeather", descriptionWeather);

		} catch (UnirestException e) {
			e.printStackTrace();
		}
		session.setAttribute("villes", villes);

		RequestDispatcher req = request.getRequestDispatcher("AffichageMeteo.jsp");
		req.forward(request, response);

	}

	public double fahrenheitToCelcius(double temp) {
		return temp - 273.15;
	}

}
