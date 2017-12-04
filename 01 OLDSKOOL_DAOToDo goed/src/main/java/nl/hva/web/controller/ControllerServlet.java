package nl.hva.web.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nl.hva.web.dao.UserDAO;
import nl.hva.web.model.User;

/**
 *
 * @author P.Odenhoven
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/ControllerServlet",
    "/ListAllUser", "/CreateUser", "/UpdateUser", "/DeleteUser", "/ReadUser",
    "/ReadUserByID", "/SearchUserLastName", "/SearchUserId", "/InsertUser",
    "/SearchUserIdToUpdate", "/SearchUserIdToDelete",
    "/ReadUserToUpdate", "/ReadUserToDelete"})
public class ControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        UserDAO userDAO = new UserDAO();
        List<User> userlist = new LinkedList<User>();
        User user = new User();

        String uri = request.getRequestURI();

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String dispatchUrl = "index.jsp";

        if (action.equals("ListAllUser")) 
        {
            userlist = userDAO.findAll();
            request.setAttribute("userlist", userlist);
            dispatchUrl = "ListAllUser.jsp";
        } 
        else if (action.equals("CreateUser")) 
        {
            dispatchUrl = "CreateUser.jsp";
        } 
        else if (action.equals("UpdateUser")) 
        {
            String userIdStr = request.getParameter("userId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String eMail = request.getParameter("eMail");
            int userId = Integer.parseInt(userIdStr);
            user.setUserId(userId);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.seteMail(eMail);
            userDAO.update(user);
            userlist = userDAO.findAll();
            request.setAttribute("userlist", userlist);
            dispatchUrl = "ListAllUser.jsp";
        } 
        else if (action.equals("InsertUser")) 
        {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String eMail = request.getParameter("eMail");
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.seteMail(eMail);
            userDAO.insert(user);
            System.out.println(firstName);
            System.out.println(lastName);
            System.out.println(eMail);
            userlist = userDAO.findAll();
            request.setAttribute("userlist", userlist);
            dispatchUrl = "ListAllUser.jsp";

        } 
        else if (action.equals("DeleteUser")) 
        {
            String userIdStr = request.getParameter("userId");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String eMail = request.getParameter("eMail");
            int userId = Integer.parseInt(userIdStr);
            user.setUserId(userId);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.seteMail(eMail);
            userDAO.remove(user);
            userlist = userDAO.findAll();
            request.setAttribute("userlist", userlist);            
            dispatchUrl = "ListAllUser.jsp";
        } 
        else if ((action.equals("SearchUserId")) || (action.equals("SearchUserIdToUpdate"))|| (action.equals("SearchUserIdToDelete")))
        {
            String userIdStr = request.getParameter("userId");
            int userId = Integer.parseInt(userIdStr);
            user = userDAO.findById(userId);
            request.setAttribute("userdata", user);
            if (action.equals("SearchUserId")) 
            {
                dispatchUrl = "ListUser.jsp";
            }
            if (action.equals("SearchUserIdToUpdate")) 
            {
                dispatchUrl = "UpdateUser.jsp";
            }
            if (action.equals("SearchUserIdToDelete")) 
            {
                dispatchUrl = "DeleteUser.jsp";
            }
        } 
        else if (action.equals("ReadUser")) 
        {
            dispatchUrl = "ReadUserByName.jsp";
        } 
        else if (action.equals("ReadUserByID")) 
        {
            dispatchUrl = "ReadUserByID.jsp";
        } 
        else if (action.equals("ReadUserToUpdate")) 
        {
            dispatchUrl = "ReadUserToUpdate.jsp";
        } 
        else if (action.equals("ReadUserToDelete")) 
        {
            dispatchUrl = "ReadUserToDelete.jsp";
        } 
        else if (action.equals("SearchUserLastName")) 
        {
            String lastName = request.getParameter("lastName");

            userlist = userDAO.findByLastName(lastName);
            request.setAttribute("userlist", userlist);
            dispatchUrl = "ListAllUser.jsp";
        }

        if (dispatchUrl != null) 
        {
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
