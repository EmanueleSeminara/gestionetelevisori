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

@WebServlet("/PrepareEditServlet")
public class PrepareEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDelTelevisoreDaEliminare = request.getParameter("idDaInviareComeParametro");

		try {
			Televisore televisoreDaModificare = MyServiceFactory.getTelevisoreServiceInstance()
					.cercaPerId(NumberUtility.isLong(parametroIdDelTelevisoreDaEliminare));
			request.setAttribute("televisoreDaModificare", televisoreDaModificare);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("edit.jsp").forward(request, response);
	}

}
