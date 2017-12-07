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
import be.vdab.services.ArtikelService;

/**
 * Servlet implementation class KortingenServlet
 */
@WebServlet("/artikels/kortingen.htm")
public class KortingenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/artikels/kortingen.jsp";  
    private final transient ArtikelService artService = new ArtikelService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		if(request.getParameter("artId")!=null) {
			long id = Long.valueOf(request.getParameter("artId"));
			request.setAttribute("detailartikel", artService.read(id).get());
			
		}
		
		
			List<Artikel> artikels = artService.zoekAlle();
			request.setAttribute("artikels", artikels);
			request.getRequestDispatcher(VIEW).forward(request, response);		
	}

	
	

}
