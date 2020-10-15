
package com.mycompany.employeesapp.servlets.employees;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.EmployeeService;
import com.mycompany.employeesapp.service.LocationService;
import com.mycompany.employeesapp.utils.Conversor;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FilterEmployeesServlet extends HttpServlet{
    int id;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService service = new EmployeeService();
        String filter = req.getParameter("filter");
        String value = req.getParameter("value");
        List<Employee> employees = service.filterEmployees(filter, value);

        HttpSession mySession = req.getSession(true);
        mySession.setAttribute("employees", employees);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_list.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
