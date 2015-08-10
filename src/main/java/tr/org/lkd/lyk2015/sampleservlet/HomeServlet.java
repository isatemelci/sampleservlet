package tr.org.lkd.lyk2015.sampleservlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Todo t1 = new Todo("test todo 1", "test lorem ipsum", Calendar.getInstance());

		Todo t2 = new Todo("test todo 2", "test lorem ipsum", Calendar.getInstance());

		Todo t3 = new Todo("test todo 3", "test lorem ipsum", Calendar.getInstance());
		t3.setDone(true);

		Todo t4 = new Todo("test todo 4", "test lorem ipsum", Calendar.getInstance());

		Storage.add(t1);
		Storage.add(t2);
		Storage.add(t3);
		Storage.add(t4);

		System.out.println("in hello servlet");

		Boolean unsafe = new Boolean(req.getParameter("unsafe"));

		if (unsafe) {
			req.setAttribute("message", "this is unsafe page");
			req.getRequestDispatcher("unsafe.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "this is my message");
			req.getRequestDispatcher("WEB-INF/home.jsp").forward(req, resp);
		}
	}

}
