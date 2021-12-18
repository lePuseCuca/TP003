package controller.users;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ComparadorProducto;
import model.Itinerario;
import model.Producto;
import model.Usuario;
import services.AttractionService;
import services.ComparatorService;
import services.ItineraryService;
import services.ProductService;
import services.PromotionService;

@WebServlet("/listProducts.do")
public class ListProductsServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 9141888296655762932L;
	private ProductService productService;
	private AttractionService attractionService;
	private PromotionService promotionService;
	private ItineraryService itineraryService;
	private ComparatorService comparatorService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		this.promotionService = new PromotionService();
		this.productService = new ProductService(
				this.attractionService.map(), 
				this.promotionService.list(this.attractionService.map()));
		this.itineraryService = new ItineraryService(this.productService.getProductos());		
		this.comparatorService = new ComparatorService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.destroy();
		this.init();
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		
		Itinerario it = this.itineraryService.getItinerario(usuario.getNombre());
		ComparadorProducto comparador = this.comparatorService.generarComparadorProducto(usuario.getTipoPreferido()); 
		
		List<Producto> productos = productService.listForUser(usuario, it, comparador);
		req.setAttribute("productos", productos);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/usuario/index.jsp");
		dispatcher.forward(req, resp);
	}

}
