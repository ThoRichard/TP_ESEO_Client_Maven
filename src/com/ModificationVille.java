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

/**
 * Servlet implementation class ModificationVille
 */
@WebServlet("/ModificationVille")
public class ModificationVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificationVille() {
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
		/**
		 * Code commune INSEE unique
		 */
		String villeModif = request.getParameter("ville");
		

		String codeCommune = ""; 
		String codePostal = "";
		String libelleAcheminement = ""; 
		String ligne = "";
		float latitude = 0; 
		float longitude = 0; 
		
		for (Ville ville : villes) {
			if (ville.getNomCommune().equals(villeModif)) {
				codeCommune = ville.getCodeCommune();
				codePostal = ville.getCodePostal();
				libelleAcheminement = ville.getLibelleAcheminement();
				ligne = ville.getLigne();
				latitude = ville.getLatitude();
				longitude = ville.getLongitude();
			}
		}
		
		session.setAttribute("codeCommune", codeCommune);
		session.setAttribute("nomCommune", villeModif);
		session.setAttribute("codePostal", codePostal);
		session.setAttribute("libelleAcheminement", libelleAcheminement);
		session.setAttribute("ligne", ligne);
		session.setAttribute("latitude", latitude);
		session.setAttribute("longitude", longitude);
		session.setAttribute("villes", villes);
		RequestDispatcher req = request.getRequestDispatcher("ModificationVille.jsp");
		req.forward(request, response);
	}

}
