package controller;

import java.io.IOException;
import java.util.List;

import dao.DAOFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Producto;
import model.Usuario;
import services.ProductService;

@WebServlet("/listProducts.do")
public class ListProductsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 6726512261455231345L;
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productService = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
//		Usuario usuario = DAOFactory.getUsuarioDAO().findUsuarioByNombre(req.getParameter("nombre"));
		
		List<Producto> productos = productService.list(usuario);
		req.setAttribute("productos", productos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
}
