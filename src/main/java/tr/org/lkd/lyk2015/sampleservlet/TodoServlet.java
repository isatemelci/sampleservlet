package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/todo")
public class TodoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/todo.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String desc = req.getParameter("desc");
		String dueDate = req.getParameter("dueDate");

		// TODO parse date as calendar
		SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {

			Date date = curFormater.parse(dueDate);
			cal.setTime(date);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Todo todo = new Todo(name, desc, cal);

		Storage.add(todo);

		// FIXME redirect to /list

		resp.sendRedirect("list");

		// req.setAttribute("todos", Storage.getAll());
		// req.getRequestDispatcher("WEB-INF/list.jsp").forward(req, resp);
	}
}
