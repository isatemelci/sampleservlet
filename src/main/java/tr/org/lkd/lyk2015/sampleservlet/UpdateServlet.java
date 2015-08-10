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

@WebServlet(urlPatterns = "/update")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String a = req.getParameter("id");

		Todo t = Storage.getById(Long.valueOf(a));

		if (t == null) {
			req.setAttribute("message", "No Todo with this id!!!");
			req.setAttribute("idRen", "hidden");
			req.setAttribute("idRenName", "hidden");
			req.setAttribute("idRenDate", "hidden");
			req.setAttribute("idRenBtn", "none");
			req.setAttribute("idRenText", "none");
			// req.setAttribute("renderVal", "true");
		} else {
			req.setAttribute("todo", t);

			SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println(t.getDueDate().getTime());
			// Ouput "Wed Sep 26 14:23:28 EST 2012"

			String formatted = format1.format(t.getDueDate().getTime());
			System.out.println(formatted);
			// Output "2012-09-26"

			// req.setAttribute("renderVal", "false");
			req.setAttribute("idRen", "text");
			req.setAttribute("idRenName", "text");
			req.setAttribute("idRenDate", "date");
			req.setAttribute("dueDate", formatted);
			req.setAttribute("date", formatted);

		}

		req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String dueDate = req.getParameter("dueDate");
		String desc = req.getParameter("desc");

		SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {

			Date date = curFormater.parse(dueDate);
			cal.setTime(date);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Todo t = Storage.getById(Long.valueOf(id));

		t.setId(Long.valueOf(id));
		t.setName(name);
		t.setDesc(desc);
		t.setDueDate(cal);

		req.setAttribute("message", "Update successful.");
		req.getRequestDispatcher("WEB-INF/update.jsp").forward(req, resp);

	}
}
