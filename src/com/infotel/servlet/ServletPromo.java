package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Promo;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletPromo")
public class ServletPromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	public ServletPromo() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom;
		int effectif;

		if (request.getParameter("nom") != null) {
			Promo p = new Promo();
			nom = request.getParameter("nom");
			effectif = Integer.parseInt(request.getParameter("eff"));

			p.setNomPromo(nom);
			p.setEffectif(effectif);

			service.ajouterPromo(p);
		}
		
		request.setAttribute("promos", service.findAllPromos());
		request.getRequestDispatcher("promo.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
