package nl.hva.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 27126L;

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html><head></head>"
                + "<body>Welcome Servlet</body></html>");

        writer.println("<html><head></head>"
                + "<body> <p>\n"
                + "            <a href=\"simple\">Go to SimpleServlet</a>\n <Br>"
                + "            <a href=\"third\">Go back to ThirdServlet</a>\n"
                + "        </p></body></html>");

    }
}
