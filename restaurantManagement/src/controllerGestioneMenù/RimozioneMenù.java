package controllerGestioneMenù;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelGestioneMenù.MenùManager;


/**
 * Servlet implementation class RimozioneMenù
 */

@WebServlet("/rimuovimenu")
public class RimozioneMenù extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idmenu"));
		MenùManager mm = new MenùManager();
		boolean result = mm.rimozione(id);
		if (result) {
			request.setAttribute("message_success", "menù rimosso con successo.");
			request.getRequestDispatcher("getmenus").forward(request, response);
		} else {
			request.setAttribute("message_danger", "impossibile rimuovere il menù");
			request.getRequestDispatcher("gestioneMenù.jsp").forward(request, response);
		}
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
