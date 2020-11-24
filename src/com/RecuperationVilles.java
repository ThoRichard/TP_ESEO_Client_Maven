package com;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class RecuperationVilles
 */
@WebServlet("/RecuperationVilles")
public class RecuperationVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RecuperationVilles() {
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		HttpResponse<JsonNode> reponse;
		ArrayList<Ville> villes = null;
		try {
			reponse = Unirest.get("http://localhost:8181/ville").asJson();
			JsonArray jArray = JsonParser.parseString(reponse.getBody().toString()).getAsJsonArray();
			villes = this.tabToVille(jArray);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		session.setAttribute("villes", villes);
		RequestDispatcher req = request.getRequestDispatcher("RecuperationVilles.jsp");
		req.forward(request, response);
	}

	private ArrayList<Ville> tabToVille(JsonArray tab) {
		final Gson gson = new GsonBuilder().create();
		ArrayList<Ville> villes = new ArrayList<>();

		// Itération autour du tableau de données
		for (JsonElement element : tab) {
			villes.add(gson.fromJson(element, Ville.class));
		}
		return villes;
	}

}
