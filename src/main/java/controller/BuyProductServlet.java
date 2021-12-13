package controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.ProductService;
import services.UserService;

@WebServlet("/producto/buy.do")
public class BuyProductServlet extends HttpServlet implements Servlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1822919876888031816L;
	private ProductService productService;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.productService = new ProductService();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productoId = (String) req.getParameter("id");
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		Map<String, String> errores = productService.buy(usuario, productoId);

		Usuario usuarioActualizado = userService.find(usuario.getNombre());
		req.getSession().setAttribute("usuario", usuarioActualizado);

		if (errores.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errores);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/attractions/index.do");
		dispatcher.forward(req, resp);

	}

}
