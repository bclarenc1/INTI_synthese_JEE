package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/SupprimerFormation")
public class SupprimerFormation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();   

    public SupprimerFormation() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cetteid = Integer.parseInt(request.getParameter("idFormation"));
		service.supprimerFormation(cetteid);
		
		request.setAttribute("formations", service.findAllFormations());
		request.getRequestDispatcher("formation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
