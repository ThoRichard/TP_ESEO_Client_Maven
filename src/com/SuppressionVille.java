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

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class SuppressionVille
 */
@WebServlet("/SuppressionVille")
public class SuppressionVille extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuppressionVille() {
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
		String villeModif = request.getParameter("ville");

		String codeCommune = "";

		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(villeModif)) {
				codeCommune = ville.getCodeCommune();
			}
		}

		try {
			Unirest.delete("http://localhost:8181/ville/" + codeCommune).asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		session.setAttribute("villes", villes);
		String message = "La ville " + villeModif + " a bien été supprimée!";
		session.setAttribute("message", message);
		RequestDispatcher req = request.getRequestDispatcher("ModificationVilleEffectuee.jsp");
		req.forward(request, response);
	}

}
