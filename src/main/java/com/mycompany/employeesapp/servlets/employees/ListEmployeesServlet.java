
package com.mycompany.employeesapp.servlets.employees;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.service.EmployeeService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListEmployeesServlet extends HttpServlet{
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmployeeService service = new EmployeeService();
        List<Employee> employees = service.getEmployees();
        
        HttpSession mySession = req.getSession(true);
        mySession.setAttribute("employees", employees);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_list.jsp");
        rd.forward(req, resp);
    }
}
