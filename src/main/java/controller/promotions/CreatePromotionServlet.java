package controller.promotions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ErrorDatosException;
import services.AttractionService;
import services.PromotionService;

@WebServlet("/promocion/new.do")
public class CreatePromotionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7812151349602346751L;
	private AttractionService attractionService;
	private PromotionService promotionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		this.promotionService = new PromotionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("atraccionesLista", this.attractionService.map().values());

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/promocionalta.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String tipoPromocion = req.getParameter("tipo-promocion");
		req.getParameterValues("atracciones");

		// FALTA mandar mensajes error via flash?!
		if (tipoPromocion.equals("PORCENTUAL")) {
			try {
				this.promotionService.createPromoPorcentual(req.getParameter("id"), req.getParameter("nombre"),
						tipoPromocion, req.getParameter("tipo"), Double.parseDouble(req.getParameter("descuento")),
						req.getParameterValues("atracciones"));
			} catch (ErrorDatosException e) {
				e.printStackTrace();
			}
		}
		if (tipoPromocion.equals("ABSOLUTA")) {
			try {
				System.out.println(req.getParameter("costo"));
				this.promotionService.createPromoAbsoluta(req.getParameter("id"), req.getParameter("nombre"),
						tipoPromocion, req.getParameter("tipo"), Double.parseDouble(req.getParameter("costo")),
						req.getParameterValues("atracciones"));
			} catch (ErrorDatosException e) {
				e.printStackTrace();
			}

		}
		// req.setAttribute("flash", "Promocion agregada correctamente");
		resp.sendRedirect("/TP003-LPC/admin.do");
		// RequestDispatcher dispatcher =
		// getServletContext().getRequestDispatcher("/admin.do");
		// dispatcher.forward(req, resp);
		// } else {
		// RequestDispatcher dispatcher =
		// getServletContext().getRequestDispatcher("/views/admin/promocionalta.jsp");
//			req.setAttribute("errorTipoPromo", "Debe seleccionar un tipo de promocion.");
//			dispatcher.include(req, resp);
		// }
	}

}
