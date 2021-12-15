package controller;

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
import services.ProductService;
import services.UserService;

@WebServlet("/adminLists.do")
public class AdminServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 3679279743547995532L;
	private ProductService productService;
	private UserService usuarioService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productService = new ProductService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Promocion> promociones = productService.promotionslist();
		req.setAttribute("promociones", promociones);

		List<Atraccion> atracciones = productService.attractionslist();
		req.setAttribute("atracciones", atracciones);

		List<Usuario> usuarios = usuarioService.list();
		req.setAttribute("usuarios", usuarios);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/dashboard.jsp");
		dispatcher.forward(req, resp);
	}
}
