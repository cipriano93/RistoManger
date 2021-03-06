package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CameriereManager;

/**
 * Servlet implementation class RimozioneCameriere
 */
@WebServlet("/RimozioneCameriere")
public class RimozioneCameriere extends HttpServlet {
private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("usr");
		CameriereManager cm = new CameriereManager();
			
		boolean result = cm.rimozioneCameriere(username);
	
		if(result) {
			request.setAttribute("message_rimozione", true);
			request.getRequestDispatcher("GetCamerieri").forward(request, response);
		} else {
			request.setAttribute("message_rimozione", false);
			request.getRequestDispatcher("gestioneCameriere.jsp").forward(request, response);	
		}
	}	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
