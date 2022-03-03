package it.gestionetelevisori.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisori.model.Televisore;
import it.gestionetelevisori.service.MyServiceFactory;
import it.gestionetelevisori.utility.NumberUtility;

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idDaPagina = request.getParameter("idTelevisore");
		if (NumberUtility.isLong(idDaPagina) == null) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		try {
			MyServiceFactory.getTelevisoreServiceInstance().elimina(NumberUtility.isLong(idDaPagina));
			List<Televisore> listaTelevisori = MyServiceFactory.getTelevisoreServiceInstance().elencoTelevisori();
			request.setAttribute("risultatoRicerca", listaTelevisori);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
