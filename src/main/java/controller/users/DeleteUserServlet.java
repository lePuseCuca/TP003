package controller.users;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UserService;

@WebServlet("/usuario/delete.do")
public class DeleteUserServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -3151095156670168961L;
	private UserService userService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.userService = new UserService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (this.userService.delete(req.getParameter("usuarioId")) == 0 ) {
			String error = "No se logró eliminar el usuario.";
			req.setAttribute("error", error);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/views/admin/dashboard.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("/TP003-LPC/admin.do?flash=El usuario se borró correctamente");
		}
	}

}
