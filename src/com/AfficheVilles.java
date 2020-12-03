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
 * Servlet implementation class AfficheVilles
 */
@WebServlet("/AfficheVilles")
public class AfficheVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficheVilles() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int numeroPage = 0;
		int nombreTotalVille = 0;
		int nombreParPage = 50;
		int indexDebut = 0;
		int nombrePage = 0;

		HttpSession session = request.getSession();
		HttpResponse<JsonNode> reponse;
		ArrayList<Ville> villesRecup = new ArrayList<Ville>();
		
			try {
				reponse = Unirest.get("http://localhost:8181/ville").asJson();
				JsonArray jArray = JsonParser.parseString(reponse.getBody().toString()).getAsJsonArray();
				villesRecup = this.convertJSONToArray(jArray);
			} catch (UnirestException e) {
				e.printStackTrace();
			}
		
		
		session.setAttribute("villes", villesRecup);
		
		String sNumeroDePage = request.getParameter("pageno");
		numeroPage = Integer.parseInt(sNumeroDePage);
		indexDebut = (numeroPage * nombreParPage) - nombreParPage + 1;
		nombreTotalVille = villesRecup.size();
		
		nombrePage = nombreTotalVille / nombreParPage;

		if (nombreTotalVille > nombrePage * nombreParPage) {
			nombrePage++;
		}
		
		request.setAttribute("numeroPage", numeroPage);
		request.setAttribute("indexDebut", indexDebut-1);
		request.setAttribute("nombrePage", nombrePage);
		request.setAttribute("villes", villesRecup);
		RequestDispatcher req = request.getRequestDispatcher("AfficheVilles.jsp");
		req.forward(request, response);
	}
	
	private ArrayList<Ville> convertJSONToArray(JsonArray tab) {
		final Gson gson = new GsonBuilder().create();
		ArrayList<Ville> villes = new ArrayList<>();

		// Itération autour du tableau de données
		for (JsonElement element : tab) {
			villes.add(gson.fromJson(element, Ville.class));
		}
		return villes;
	}

}
