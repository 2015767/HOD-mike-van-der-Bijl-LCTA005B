/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mike
 */
@WebServlet(name = "thridServlet", urlPatterns = {"/thridServlet"})
public class thridServlet extends HttpServlet {

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
                + "            <a href=\"welcome\">Go back to WelcomeServlet</a> <BR> \n"
                + "            <a href=\"simple\">Go to SimpleServlet</a>\n"
                + "        </p></body></html>");

    }
}
