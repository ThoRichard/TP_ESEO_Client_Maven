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

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class CalculDistance
 */
@WebServlet("/CalculDistance")
public class CalculDistance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculDistance() {
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
		String ville2 = request.getParameter("ville2");
		session.setAttribute("ville1", ville1);
		session.setAttribute("ville2", ville2);

		float latitude1 = 0;
		float longitude1 = 0;
		float latitude2 = 0;
		float longitude2 = 0;

		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(ville1)) {
				latitude1 = ville.getLatitude();
				longitude1 = ville.getLongitude();
			}
			if (ville.getNomCommune().equals(ville2)) {
				latitude2 = ville.getLatitude();
				longitude2 = ville.getLongitude();
			}
		}

		if (latitude1 == 0 & longitude1 == 0) {
			session.setAttribute("erreurRecuperation1", "Coordonnées de la première ville non récupérées");
		}

		if (latitude2 == 0 & longitude2 == 0) {
			session.setAttribute("erreurRecuperation1", "Coordonnées de la deuxième ville non récupérées");
		}

		HttpResponse<JsonNode> httpResponse;
		String url2 = "http://api.openweathermap.org/data/2.5/weather?lat="+ latitude2 + "&lon=" + longitude2 + "&appid=e7981aedc88a1188690110ee718393bf";
		try {
			DecimalFormat df = new DecimalFormat("###.##");
			httpResponse = Unirest.get(url2).asJson();
			JsonElement jArray2 = JsonParser.parseString(httpResponse.getBody().toString());
			JsonObject rootObject2 = jArray2.getAsJsonObject();
			String tempFVille2 = rootObject2.getAsJsonObject("main").get("temp").toString();
			double tempCVille2 = this.fahrenheitToCelcius(Double.parseDouble(tempFVille2));
			session.setAttribute("tempsVille2", df.format(tempCVille2));

		} catch (UnirestException e) {
			e.printStackTrace();
		}
		session.setAttribute("villes", villes);
		
		DecimalFormat df = new DecimalFormat("###.##");
		double distance = this.calculDistance(latitude1, longitude1, latitude2, longitude2);
		session.setAttribute("distance", df.format(distance));
		RequestDispatcher req = request.getRequestDispatcher("AffichageDistance.jsp");
		req.forward(request, response);

	}

	public double calculDistance(float latitude1, float longitude1, float latitude2, float longitude2) {

		return Math.acos(Math.sin(Math.toRadians(latitude1)) * Math.sin(Math.toRadians(latitude2))
				+ Math.cos(Math.toRadians(latitude1)) * Math.cos(Math.toRadians(latitude2))
						* Math.cos(Math.toRadians(longitude1 - longitude2)))
				* 6371;
	}

	public double fahrenheitToCelcius(double temp) {
		return temp - 273.15;
	}

}
