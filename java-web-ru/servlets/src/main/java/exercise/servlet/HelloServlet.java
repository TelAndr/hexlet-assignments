package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
		resp.setContentType("text/plain");
		String outMessage = "empty_string";
		if (userName == null) {
			outMessage = "Hello, Guest!";
		} else {
			outMessage = String.format("Hello, %s!", userName);
		}
		req.setAttribute("message", outMessage);
		req.getRequestDispatcher("WEB-INF/hello.jsp").forward(req, resp);
		//if (userName == null && userName.isEmpty()) {
		//	resp.getWriter().write("Hello, Guest!");
		//} else {
		//	resp.getWriter().write("Hello, " + userName + "!");
		//}
    }
    // END
}
