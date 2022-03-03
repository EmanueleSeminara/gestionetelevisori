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

@WebServlet("/SeeDetailsServlet")
public class SeeDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		if (NumberUtility.isLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio) == null) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		try {
			Televisore dettagliTelevisore = MyServiceFactory.getTelevisoreServiceInstance()
					.cercaPerId(NumberUtility.isLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
			request.setAttribute("dettagliTelevisore", dettagliTelevisore);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

}
