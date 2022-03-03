package it.gestionetelevisori.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionetelevisori.model.Televisore;
import it.gestionetelevisori.service.MyServiceFactory;
import it.gestionetelevisori.utility.NumberUtility;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloaDaPagina = request.getParameter("modelloInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciInput");
		String codiceDaPagina = request.getParameter("codiceInput");

		Televisore televisorePerRicerca = new Televisore(marcaDaPagina, modelloaDaPagina,
				NumberUtility.isInteger(prezzoDaPagina), NumberUtility.isInteger(numeroPolliciDaPagina),
				codiceDaPagina);

		try {
			request.setAttribute("risultatoRicerca",
					MyServiceFactory.getTelevisoreServiceInstance().ricercaTelevisori(televisorePerRicerca));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
