package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Stagiaire;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletStagiaire")
public class ServletStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Iservice service = new ServiceImpl();

	public ServletStagiaire() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom;
		String prenom;
		int age;
		int fpromo;

		if (request.getParameter("nom") != null) {
			Stagiaire s = new Stagiaire();
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			age = Integer.parseInt(request.getParameter("age"));
			fpromo = Integer.parseInt(request.getParameter("fpromo"));

			s.setNom(nom);
			s.setPrenom(prenom);
			s.setAge(age);
			s.setFpromo(fpromo);

			service.ajouterStagiaire(s);
		}
		
		request.setAttribute("stagiaires", service.findAllStagiaires());
		request.getRequestDispatcher("stagiaire.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
