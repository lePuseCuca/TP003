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
import services.ItineraryService;
import services.ProductService;

@WebServlet("/itinerary.do")
public class ItineraryServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7696899312128181650L;
	private ItineraryService itineraryService;
	private ProductService productService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		this.itineraryService = new ItineraryService();
//		this.productService = new ProductService();
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
//		//Necesito el mapa de producto para poder pedir el it al dao. refactorizar para que st sea servicio!
//		
//		if (usuario.isAdmin()) {
//			Itinerario it = this.itineraryService.getItinerario((String) req.getParameter("usuarioId"));
//		} else {
//			Itinerario it = this.itineraryService.getItinerario(usuario.getNombre());
//		}
//		
//	}
	
}
