package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("todos", Storage.getAll());
		req.getRequestDispatcher("WEB-INF/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String a = req.getParameter("idD");
		Todo t = Storage.getById(Long.valueOf(a));

		if (t.isDone()) {
			t.setDone(false);
		} else {
			t.setDone(true);
		}
		resp.sendRedirect("list");

	}

}