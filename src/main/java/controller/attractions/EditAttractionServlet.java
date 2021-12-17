package controller.attractions;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.ErrorDatosException;
import model.Tipo;
import services.AttractionService;

@WebServlet("/attractions/edit.do")
public class EditAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Atraccion atraccion = this.attractionService.find(req.getParameter("id"));
		
		req.setAttribute("atraccion", atraccion);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/atraccionmodificar.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String nombre = req.getParameter("nombre");
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Double costo = Double.parseDouble(req.getParameter("costo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		Tipo tipo = Tipo.valueOf(req.getParameter("tipo"));
		Boolean disponible = true;

		//Atraccion atraccion = attractionService.update(id, nombre, tiempo, costo, cupo, tipo, disponible);

		//resp.sendRedirect("/TP003-LPC/admin.do");
		//String error = null;

		try {
			attractionService.update(id, nombre, tiempo, costo, cupo, tipo, disponible);
				resp.sendRedirect("/TP003-LPC/admin.do");
			//System.out.println(attractionService.create(id, nombre, tiempo, costo, cupo, tipo, disponible));
		} catch (ErrorDatosException e) {

			req.setAttribute("error", "Los datos ingresados no son correctos.");

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/atraccionmodificar.jsp");
			dispatcher.forward(req, resp);
		}
	}



}
