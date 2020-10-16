package com.mycompany.employeesapp.servlets.employees;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.service.EmployeeService;
import com.mycompany.employeesapp.service.LocationService;
import com.mycompany.employeesapp.utils.Conversor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddEmployeeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService service = new EmployeeService();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");

        try {
            float fSalary = Float.parseFloat(salary);
            service.addEmployee(new Employee(name, Conversor.parseStringToInt(location), fSalary));
            response.sendRedirect("http://localhost:8080/EmployeesApp/listEmployees");
        } catch (Exception e) {
            response.sendRedirect("http://localhost:8080/EmployeesApp/addEmployee");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession mySession = req.getSession(true);
        if (mySession.getAttribute("locations") == null) {
            LocationService service = new LocationService();
            mySession.setAttribute("locations", service.getLocations());
        }

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_add.jsp");
        rd.forward(req, resp);
    }
}
