package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class ArtikelToevoegen
 */
@WebServlet("/artikels/toevoegen.htm")
public class ArtikelToevoegen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/artikels/toevoegen.jsp";
	private static final String REDIRECT_URL = "%s/artikels/zoekenopnummer.htm?id=%d";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<String> fouten = new ArrayList<String>();		
		ArtikelService artService = new ArtikelService();
		
		String naam = request.getParameter("naam");
		BigDecimal aankoopprijs = new BigDecimal(request.getParameter("aankoopprijs"));
		BigDecimal verkoopprijs = new BigDecimal(request.getParameter("verkoopprijs"));
		try {
		Artikel art = new Artikel(naam, aankoopprijs, verkoopprijs);		
		artService.voegArtikelToe(art);
		
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath(), art.getId()));
		
		}catch(IllegalArgumentException ex){
			
			fouten.add(ex.toString());
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
		
		
		
		
		
	}

}
