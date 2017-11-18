package nl.hva.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 *
 * @author Peter
 */
@WebServlet(urlPatterns = {"/form"})
public class Formulier extends HttpServlet {

    private static final long serialVersionUID = -20L;
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException,
            IOException {
        String uri = request.getRequestURI();
        String uri2 = request.getRequestURI();
        if (uri.endsWith("/form")) {
            PrintWriter writer = response.getWriter();
            writer.println("<h2>Order Form</h2><br><form method='POST'><table><tr><Td>"
                    + "Name:</td><Td> <input type='text' name='name'></td></tr><Tr><Td>"
                    + "Address:</td><td><textarea name='address'></textarea></td></tr><Tr><Td>"
                    + "Country:</td><Td><select name='country'><option selected='selected' disabled='disabled'>Select country</option><option value='United States'>United States</option><option value='Mexico'>Mexico</option><option value='Nederland'>Nederland</option><option value='Italie'>Italie</option></select></td></tr><Tr><Td>"
                    + "Delivery methode: </td><Td><input type='radio' name='methode' value='First Class'>First class <input type='radio' value='Second Class' name='methode'>Second class </td></tr><Tr><Td>"
                    + "Shipping instructions:</td><Td><textarea name='instructions'></textarea></td></tr><Tr><Td>"
                    + "please send me the latest product catalog:</td><Td><input type='checkbox' value='Yes' name='latest'></td></tr><Tr><Td>"
                    + "</td><td><input type='submit' value='terugzetten' name='terugzetten'><input type='submit' value='verzenden' name='verzenden'></td></tr></table></form>");
        } 
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        String terug = null;
        String verzenden = null;
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        terug = request.getParameter("terugzetten");
        verzenden = request.getParameter("verzenden");
        if(terug != null)
        {
            String site = new String("http://localhost:8080/excellentie_1eopdracht/form");
            response.setStatus(response.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", site);  
        }
        if(verzenden != null)
        {
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String country = request.getParameter("country");
            String methode = request.getParameter("methode");
            String instructions = request.getParameter("instructions");
            String latest = request.getParameter("latest");
            if(latest == null){latest = "No";}
            writer.println("<h2>Order Form</h2><br><form method='POST'><table><tr><Td>"
                    + "Name:</td><Td> "+name+"</td></tr><Tr><Td>"
                    + "Address:</td><td>"+address+"</td></tr><Tr><Td>"
                    + "Country:</td><Td>"+country+"</td></tr><Tr><Td>"
                    + "Delivery methode: </td><Td>"+methode+" </td></tr><Tr><Td>"
                    + "Shipping instructions:</td><Td>"+instructions+"</td></tr><Tr><Td>"
                    + "please send me the latest product catalog:</td><Td>"+latest+"</td></tr><Tr><Td>");
        }
    }
    
    
    
    
}
