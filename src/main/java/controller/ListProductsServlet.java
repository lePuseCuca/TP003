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
import model.Producto;
import model.Usuario;
import services.ProductService;

@WebServlet("usuario/index.do"/*Definir la ruta (Gonza)*/)
public class ListProductsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 7256385346721236583L;
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.productService = new ProductService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		List<Producto> productos = productService.list(usuario);
		req.setAttribute("productos", productos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/index.do"/*¿?*/);
		dispatcher.forward(req, resp);
		
	}
	
}
