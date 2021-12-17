package controller.itineraries;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Itinerario;
import model.Usuario;
import services.AttractionService;
import services.ItineraryService;
import services.ProductService;
import services.PromotionService;

@WebServlet("/itinerario.do")
public class ItineraryServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 862533293373363088L;
	private ItineraryService itineraryService;
	private ProductService productService;
	private AttractionService atractionService;
	private PromotionService promotionService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.atractionService = new AttractionService();
		this.promotionService = new PromotionService();
		this.productService = new ProductService();
		this.itineraryService = new ItineraryService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
		Itinerario it = null;		
		
		this.productService.setProductos(this.atractionService.map(), promotionService.list(this.atractionService.map()));
		this.itineraryService.setProductos(this.productService.getProductos());
		
		if (usuario.isAdmin()) {
			it = this.itineraryService.getItinerario((String) req.getParameter("usuarioId"));
		} else {
			it = this.itineraryService.getItinerario(usuario.getNombre());
		}
		
		if (it != null) {
			req.getSession().setAttribute("itinerario", it);
			resp.sendRedirect("/TP003-LPC/views/usuario/itinerario.jsp");
		}
			
		
	}
	
}
