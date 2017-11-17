package nl.hva.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Peter
 */
public class CookieServlet extends HttpServlet {

    private String randomID() {
        int num = (int) (Math.random() * 10000000.0);
        return ("id:" + num);
    }
    private final String NO_VALUE = "<I>No Value</I>";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String oldID = CookieUtilities.getCookieValue(request, "userID", NO_VALUE);
        if (oldID.equals(NO_VALUE)) {
            // add some code here
            Random rand = new Random();
            int randomNum = 1 + rand.nextInt((9999 - 1) + 1);
            Cookie myCookie = new Cookie("userID", String.valueOf(randomNum));
            response.addCookie(myCookie);
        }
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CookieServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("You need to add some code");
            // add some code here
            out.println("The Cookie example<br>This page was accessed at the Current time:");
            out.println("");
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            out.println(dateFormat.format(date)); //2016/11/16 12:08:43
            out.println("<br>The userid was userid:");
            out.println(oldID);
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
