package controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Usuario;
import services.AttractionService;
import services.PromotionService;
import services.UserService;

@WebServlet("/admin.do")
public class AdminServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3679279743547995532L;
	private AttractionService attractionService;
	private PromotionService promotionService;
	private UserService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		this.promotionService = new PromotionService();
		this.usuarioService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Atraccion> atracciones = this.attractionService.list();
		req.setAttribute("atracciones", atracciones);

		List<Promocion> promociones = this.promotionService.listAll(this.attractionService.mapAll());
		req.setAttribute("promociones", promociones);
		
		List<Usuario> usuarios = usuarioService.list();
		req.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/dashboard.jsp");
		dispatcher.forward(req, resp);
	}
}
