package controller.users;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Producto;
import model.Usuario;
import services.AttractionService;
import services.ItineraryService;
import services.ProductService;
import services.PromotionService;
import services.UserService;

@WebServlet("/producto/buy.do")
public class BuyProductServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 5454644238614794948L;
	private AttractionService attractionService;
	private PromotionService promotionService;
	private ProductService productService;
	private UserService userService;
	private ItineraryService itineraryService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
		this.promotionService = new PromotionService();
		this.productService = new ProductService();
		this.userService = new UserService();
		this.itineraryService = new ItineraryService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String productoId = (String) req.getParameter("id");
		Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");

		this.productService.setProductos(this.attractionService.map(),
				this.promotionService.list(this.attractionService.map()));
		this.itineraryService.setProductos(this.productService.getProductos());
		
		
		Map<String, String> errores = this.productService.buy(usuario, productoId);

		if (errores.isEmpty()) {
			
			Producto producto = this.productService.getProductos().get(productoId);
			
			this.itineraryService.addProduct(producto, usuario.getNombre());
			this.userService.update(usuario);
			
			Usuario usuarioActualizado = userService.find(usuario.getNombre());
			req.getSession().setAttribute("usuario", usuarioActualizado);

			if (producto.esPromocion()) {
				for (Atraccion atraccion : producto.getAtracciones()) {
					//chequear error de update
					this.attractionService.update(atraccion);
				}
			} else {
				//chequear error de update
				this.attractionService.update((Atraccion) producto);
			}

			// req.setAttribute("flash", "¡Gracias por comprar!");
			resp.sendRedirect("/TP003-LPC/listProducts.do?flash=¡Gracias por comprar!");
		
		} else {
			req.setAttribute("errors", errores);
			req.setAttribute("flash", "No ha podido realizarse la compra");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listProducts.do");
			dispatcher.forward(req, resp);
		}

	}

}
