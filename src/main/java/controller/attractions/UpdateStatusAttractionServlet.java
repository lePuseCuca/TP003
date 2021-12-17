package controller.attractions;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AttractionService;

@WebServlet("/attractions/updatestatus.do")
public class UpdateStatusAttractionServlet extends HttpServlet {

	private static final long serialVersionUID = 1537949074766873118L;
	private AttractionService attractionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.attractionService = new AttractionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		attractionService.updateStatus(id);
		

		resp.sendRedirect("/TP003-LPC/admin.do");
	}


}
