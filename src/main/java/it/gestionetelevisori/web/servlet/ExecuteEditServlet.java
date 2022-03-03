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

@WebServlet("/ExecuteEditServlet")
public class ExecuteEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDelTelevisoreDaEliminare = request.getParameter("idTelevisore");
		String marcaDaPagina = request.getParameter("marcaInput");
		String modelloaDaPagina = request.getParameter("modelloInput");
		String prezzoDaPagina = request.getParameter("prezzoInput");
		String numeroPolliciDaPagina = request.getParameter("numeroPolliciInput");
		String codiceDaPagina = request.getParameter("codiceInput");

		if (NumberUtility.isLong(parametroIdDelTelevisoreDaEliminare) == null || marcaDaPagina.isBlank()
				|| modelloaDaPagina.isBlank() || NumberUtility.isInteger(prezzoDaPagina) == 0
				|| NumberUtility.isInteger(numeroPolliciDaPagina) == 0 || codiceDaPagina.isBlank()) {
			String messaggioDaInviareAPagina = "Attenzione! Valorizzare per bene i campi.";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			try {
				request.setAttribute("televisoreDaModificare", MyServiceFactory.getTelevisoreServiceInstance()
						.cercaPerId(NumberUtility.isLong(parametroIdDelTelevisoreDaEliminare)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}

		try {

			Televisore televisoreDaModificare = new Televisore(
					NumberUtility.isLong(parametroIdDelTelevisoreDaEliminare), marcaDaPagina, modelloaDaPagina,
					NumberUtility.isInteger(prezzoDaPagina), NumberUtility.isInteger(numeroPolliciDaPagina),
					codiceDaPagina);

			MyServiceFactory.getTelevisoreServiceInstance().aggiorna(televisoreDaModificare);
			request.setAttribute("risultatoRicerca",
					MyServiceFactory.getTelevisoreServiceInstance().elencoTelevisori());
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("results.jsp").forward(request, response);
	}

}
