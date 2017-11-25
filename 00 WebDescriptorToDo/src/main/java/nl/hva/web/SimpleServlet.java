package nl.hva.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {

    private static final long serialVersionUID = 8946L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head></head>"
                + "<body>Simple Servlet</body></html");
        writer.println("<html><head></head>"
                + "<body> <p>\n"
                + "            <a href=\"welcome\">Go back to WelcomeServlet</a>\n <Br>"
                + "            <a href=\"third\">Go back to ThirdServlet</a>\n"
                + "        </p></body></html>");

    }
}
