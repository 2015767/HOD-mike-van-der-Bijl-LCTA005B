package nl.hva.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.hva.web.model.Employee;
import javax.servlet.ServletConfig;

/**
 *
 * @author Peter
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    List<Employee> empList = new ArrayList<Employee>();

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setName("Pankaj");
        emp1.setRole("Developer");
        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setName("Meghna");
        emp2.setRole("Manager");
        empList.add(emp1);
        empList.add(emp2);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        request.setAttribute("employee", empList);
        RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }

}
