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

@WebServlet("/ExecuteInsertServlet")
public class ExecuteInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloaDaPagina = request.getParameter("modelloInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciInput");
		String codiceDaPagina = request.getParameter("codiceInput");

		if (marcaDaPagina.isBlank() || modelloaDaPagina.isBlank() || NumberUtility.isInteger(prezzoDaPagina) == null
				|| NumberUtility.isInteger(numeroPolliciDaPagina) == null || codiceDaPagina.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare tutti i campi.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			request.getRequestDispatcher("insert.jsp").forward(request, response);
		}

		Televisore televisoreDaAggiungere = new Televisore(marcaDaPagina, modelloaDaPagina,
				NumberUtility.isInteger(prezzoDaPagina), NumberUtility.isInteger(numeroPolliciDaPagina),
				codiceDaPagina);

		try {
			MyServiceFactory.getTelevisoreServiceInstance().aggiungiNuovo(televisoreDaAggiungere);
			request.setAttribute("risultatoRicerca",
					MyServiceFactory.getTelevisoreServiceInstance().elencoTelevisori());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
