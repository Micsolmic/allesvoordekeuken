package be.vdab.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Artikel;
import be.vdab.repositories.ArtikelRepository;

/**
 * Servlet implementation class ZoekenOpNummer
 */
@WebServlet("/artikels/zoekenopnummer.htm")
public class ZoekenOpNummer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW ="/WEB-INF/JSP/artikels/zoekenopnummer.jsp";   
    private static final ArtikelRepository artRepo = new ArtikelRepository();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getQueryString()!=null) {
			
			try {				
				Optional<Artikel> optArt = artRepo.read(Integer.valueOf(request.getParameter("id")));
				optArt.ifPresent(art -> request.setAttribute("artikel", art));
				
			}catch(NumberFormatException ex) {
				
				request.setAttribute("fouten", Collections.singletonMap("id", "tik een getal"));
			}
		}
		
		request.getRequestDispatcher(VIEW).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
