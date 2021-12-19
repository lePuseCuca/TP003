package controller.promotions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;

@WebServlet("/promocion/new.do")
public class CreatePromotionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7812151349602346751L;
	private AttractionService attractionService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("atraccionesLista", this.attractionService.map().values());
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/promocionalta.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("include", "OK");
		String tipoPromocion = req.getParameter("tipo-promocion");
		
		
		if (!tipoPromocion.equals("default")) {
			System.out.println("ENTRE");
		}else {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/promocionalta.jsp");
			System.out.println(tipoPromocion);
			dispatcher.include(req, resp);
		}
	}
	
	

}
