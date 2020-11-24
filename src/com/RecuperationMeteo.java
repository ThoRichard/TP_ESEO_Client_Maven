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

		float latitude1 = 0;
		float longitude1 = 0;

		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(ville1)) {
				latitude1 = ville.getLatitude();
				longitude1 = ville.getLongitude();
			}

		}

		HttpResponse<JsonNode> reponse1;

		String url1 = "http://api.openweathermap.org/data/2.5/weather?APPID=2129170164288096a566a7b4580ed806&lat="
				+ latitude1 + "&lon=" + longitude1 + "";
		try {
			DecimalFormat df = new DecimalFormat("###.##");
			reponse1 = Unirest.get(url1).asJson();
			JsonElement jArray1 = JsonParser.parseString(reponse1.getBody().toString());
			JsonObject rootObject1 = jArray1.getAsJsonObject();
			String tempFVille1 = rootObject1.getAsJsonObject("main").get("temp").toString();
			double tempCVille1 = this.fahrenheitToCelcius(Double.parseDouble(tempFVille1));
			session.setAttribute("tempsVille1", df.format(tempCVille1));

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
