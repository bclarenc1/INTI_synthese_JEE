package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;

@WebServlet("/SupprimerPromo")
public class SupprimerPromo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Iservice service = new ServiceImpl();   

    public SupprimerPromo() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cetteid = Integer.parseInt(request.getParameter("idPromo"));
		service.supprimerPromo(cetteid);
		
		request.setAttribute("promos", service.findAllPromos());
		request.getRequestDispatcher("promo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
