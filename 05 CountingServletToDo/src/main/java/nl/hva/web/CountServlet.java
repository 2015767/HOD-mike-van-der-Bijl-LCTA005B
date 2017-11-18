package nl.hva.web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Peter
 */
@WebServlet(name = "CountServlet", urlPatterns = {"/CountServlet"})
public class CountServlet extends HttpServlet {

    private static int count;

    @Override
    public void init(ServletConfig config) throws ServletException {

        count = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            writer.println("Incrementing the count: Count = "+count);
            writer.println("<br><BR><form method='POST'><input type='submit' name='cookieclicker' value='cookieclicker'> </form>");
    }
   @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        count++;
        String site = new String("http://localhost:8080/05%20CountingServletToDo/CountServlet");
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site);  
    }
}
