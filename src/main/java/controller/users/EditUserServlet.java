package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import model.Usuario;
import services.UserService;

@WebServlet("/usuario/edit.do")
public class EditUserServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1622840271676183113L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = this.userService.find(req.getParameter("usuarioId"));
		
		req.setAttribute("usuario", usuario);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/usuariomodificar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = (Usuario) req.getAttribute("usuario");
		
		String nombre = req.getParameter("nombre");
		Double monedas = Double.parseDouble(req.getParameter("monedas"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Tipo tipoPreferido = Tipo.valueOf(req.getParameter("tipo-preferido"));
		String clave = req.getParameter("clave");
		Boolean isAdmin = Boolean.getBoolean(req.getParameter("is-admin"));

		String error = null;

		if (this.userService.edit(usuario, nombre, monedas, tiempo, tipoPreferido, clave, isAdmin) == 0) {

			error = "El usuario no pudo ser editado.";
			req.setAttribute("error", error);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/usuariomodificar.jsp");
			dispatcher.forward(req, resp);

		} else {
			resp.sendRedirect("/TP003-LPC/admin.do?flash=El usuario se editó correctamente.");
		}
	}
}
