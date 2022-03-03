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

@WebServlet("/PrepareDeleteServlet")
public class PrepareDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellTelevisoreDaEliminare = request.getParameter("idDaInviareComeParametro");
		if (NumberUtility.isLong(parametroIdDellTelevisoreDaEliminare) == null) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		try {
			Televisore televisoreDaEliminare = MyServiceFactory.getTelevisoreServiceInstance()
					.cercaPerId(NumberUtility.isLong(parametroIdDellTelevisoreDaEliminare));
			request.setAttribute("televisoreDaEliminare", televisoreDaEliminare);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("delete.jsp").forward(request, response);
	}

}
