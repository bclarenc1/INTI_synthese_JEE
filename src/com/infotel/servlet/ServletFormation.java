package com.infotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Formation;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/ServletFormation")
public class ServletFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();   
	
    public ServletFormation() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom;

		if (request.getParameter("nom") != null) {
			Formation f = new Formation();
			nom = request.getParameter("nom");
			f.setNomFormation(nom);
			service.ajouterFormation(f);
		}
		
		request.setAttribute("formations", service.findAllFormations());
		request.getRequestDispatcher("formation.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
