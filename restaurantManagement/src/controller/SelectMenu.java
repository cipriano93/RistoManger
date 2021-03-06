package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MenùBean;
import model.MenùManager;
import model.PortataBean;


/**
 * Servlet implementation class SelectMenu
 */
@WebServlet("/SelectMenu")
public class SelectMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String menu = request.getParameter("menu");
		String tipo = request.getParameter("tipo");
		String result = null;
		//per aggiungere le virgolette
		String quote = "\""; 
		
		MenùManager mm = new MenùManager();
		
		int id = mm.getIdMenuByNome(menu);
		
		if(tipo != null) {
			ArrayList<PortataBean> portateByTipo = mm.getPortateByMenuTipo(id, tipo);
			PortataBean pb = new PortataBean();
			for(int i = 0; i < portateByTipo.size(); i++) {
				pb = portateByTipo.get(i);
				result += "<option value=" + quote + pb.getNome()+ quote +">" + pb.getNome()+ "</option>";
			}
		} else {
			ArrayList<PortataBean> portateByMenù = mm.getPortate(id);
			PortataBean pb = new PortataBean();
			result ="<thead> <tr> <th>Portata</th> <th>Prezzo</th></tr></thead> <tbody>";
			for(int i = 0; i < portateByMenù.size(); i++) {
				pb = portateByMenù.get(i);		
				result += "<tr> <td>"+pb.getNome() + "</td>"+ "<td>"+pb.getPrezzo() + "</td> </tr>"; 
			}
			result +="</tbody>";	
		}
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
