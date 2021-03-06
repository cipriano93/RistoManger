package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CameriereManager;

/**
 * Servlet implementation class ModificaCameriere
 */
@WebServlet("/ModificaCameriere")
public class ModificaCameriere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("usr");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("pwd");
		String confirmPassword = request.getParameter("pwd_confirm");
		
		//prima della creazione controllo sulla chiave
		/*String regexName = "^[A-Za-z\\s]{3,}$";
		String regexSurname ="^[A-Za-z\\s]{3,}$";
		String regexPassword = "^(?=.*[0-9])(?=.*[A-Z]).{5,}$";*/
		
		//questo è un controllo più accurato, se l'email non rispetta il pattern, esce direttamente
		if(password.equals(confirmPassword)/* && password.matches(regexPassword) && name.matches(regexName) && surname.matches(regexSurname)*/) {
			//Creazione cameriere manager
			CameriereManager cm = new CameriereManager();
		
			boolean result = cm.modificaCameriere(username, password, name, surname, "cameriere");
			
			if(result) {
				request.setAttribute("message", "Cameriere modificato correttamente.");
				request.getRequestDispatcher("GetCamerieri").forward(request, response);
			} else {
				request.setAttribute("message", false);
				request.getRequestDispatcher("modificaCameriere.jsp").forward(request, response);	
			}
		} else
			response.sendRedirect("modificaCameriere.jsp");	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
