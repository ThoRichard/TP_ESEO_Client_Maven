package com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * Servlet implementation class EffectuerModification
 */
@WebServlet("/EffectuerModification")
public class EffectuerModification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EffectuerModification() {
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
		String codeCommune = (String) request.getParameter("codeCommune");
		String nomCommune = (String) request.getParameter("nomCommune");
		String codePostal = (String) request.getParameter("codePostal");
		String libelleAcheminement = (String) request.getParameter("libelleAcheminement");
		String ligne = (String) request.getParameter("ligne");
		String longitude = (String) request.getParameter("longitude");
		String latitude = (String) request.getParameter("latitude");
		
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		if (ligne == null) {
			ville.setLigne("");
		} else {
			ville.setLigne(ligne);
		}
		ville.setLongitude(Float.parseFloat(longitude));
		ville.setLatitude(Float.parseFloat(latitude));

		Gson gson = new Gson();
		String villeJSon = gson.toJson(ville);

		try {
			HttpResponse<String> reponse = Unirest.put("http://localhost:8181/ville/" + codeCommune)
					.header("Content-type", "application/json").body(villeJSon).asString();
			System.out.println(reponse);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		String message = "La ville " + nomCommune + " a bien été modifiée!";
		session.setAttribute("message", message);
		RequestDispatcher req = request.getRequestDispatcher("ModificationVilleEffectuee.jsp");
		req.forward(request, response);
	}

}
