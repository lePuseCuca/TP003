package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ErrorDatosException;
import model.Tipo;
import services.UserService;

@WebServlet("/usuario/new.do")
public class CreateUserServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 4435322907119480523L;
	private UserService userService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/usuarioalta.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double monedas = Double.parseDouble(req.getParameter("monedas"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Tipo tipoPreferido = Tipo.valueOf(req.getParameter("tipo-preferido"));
		String clave = req.getParameter("clave");
		Boolean isAdmin = Boolean.getBoolean(req.getParameter("is-admin"));
		
		String error = null;
		
		try {
			if (this.userService.create(nombre, monedas, tiempo, tipoPreferido, clave, isAdmin) == 0) {
				
				error = "Los datos ingresados no son correctos.";
				req.setAttribute("error", error);

				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/usuarioalta.jsp");
				dispatcher.forward(req, resp);
				
			} else {
				resp.sendRedirect("/TP003-LPC/admin.do");
			}
		} catch (ErrorDatosException e) {
			e.printStackTrace();
		}
	}

}
