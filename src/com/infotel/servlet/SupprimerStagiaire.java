package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/SupprimerStagiaire")
public class SupprimerStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();   
	
    public SupprimerStagiaire() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cetteid = Integer.parseInt(request.getParameter("idStagiaire"));
		service.supprimerStagiaire(cetteid);
		
		request.setAttribute("stagiaires", service.findAllStagiaires());
		request.getRequestDispatcher("stagiaire.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
