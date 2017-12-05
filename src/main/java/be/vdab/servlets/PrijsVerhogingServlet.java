package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class PrijsVerhogingServlet
 */
@WebServlet("/artikels/prijsverhoging.htm")
public class PrijsVerhogingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/artikels/prijsverhoging.jsp";
 
    private final transient ArtikelService artService = new ArtikelService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("percentage")!=null) {
			
			BigDecimal percentage = new BigDecimal(request.getParameter("percentage"));
			int regelsGewijzigd = artService.prijsverhoging(percentage);
			request.setAttribute("aantalRegelsGewijzigd", regelsGewijzigd);
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

}
