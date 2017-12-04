package be.vdab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.repositories.ArtikelRepository;

/**
 * Servlet implementation class ZoekenOpDeelnaam
 */
@WebServlet("/artikels/zoekenopnaam.htm")
public class ZoekenOpDeelnaam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/zoekopdeelnaam.jsp";
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArtikelRepository artRepo = new ArtikelRepository();
		if(request.getQueryString()!= null) {
			String deelnaam = request.getParameter("deelnaam");
			List<Artikel> list = artRepo.zoekOpDeelnaam(deelnaam);
			request.setAttribute("lijstRecords", list);
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}


}
