
package com.mycompany.employeesapp.servlets.employees;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.service.EmployeeService;
import com.mycompany.employeesapp.utils.Conversor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        EmployeeService service = new EmployeeService();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");
        service.addEmployee(new Employee(name, Conversor.parseStringToInt(location), Float.parseFloat(salary)));
        response.sendRedirect("http://localhost:8080/EmployeesApp/listEmployees");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_add.jsp");
        rd.forward(req, resp);
    }
}
