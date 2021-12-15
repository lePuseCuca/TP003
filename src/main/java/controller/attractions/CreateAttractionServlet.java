package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.ErrorDatosException;
import model.Tipo;
import services.AttractionService;

//PONER VIEWS/ADMIN/ATRACCIONALTA.DO
@WebServlet("/atraccion/new.do")
public class CreateAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = -2211779761371322145L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/atraccionalta.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// El ID SE AUTOGENERA?? COMO SE HACE CON ESO??
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		// COMO CONFIGURO EL ENUM?? ESTA OK??
		Tipo tipo = Tipo.valueOf(req.getParameter("tipo"));
		// Boolean disponible = Boolean.parseBoolean(req.getParameter("disponible"));
		Boolean disponible = true;

		Atraccion atraccion = null;
		try {
			atraccion = attractionService.create(id, nombre, tiempo, costo, cupo, tipo, disponible);
		} catch (ErrorDatosException e) {

			e.printStackTrace();
		}

		// if (attraction.isValid()) {
		if (atraccion != null) {
			resp.sendRedirect("/TP003-LPC/adminListProducts.do");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/atraccionalta.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
