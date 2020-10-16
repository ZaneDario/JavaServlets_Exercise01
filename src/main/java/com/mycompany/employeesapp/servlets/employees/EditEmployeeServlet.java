
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

public class EditEmployeeServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession mySession = request.getSession(true);
        EmployeeService service = new EmployeeService();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");
        try
        {
            float fSalary = Float.parseFloat(salary);
            int id = (Integer)mySession.getAttribute("employeeId");
            service.editEmployee(id, name, Conversor.parseStringToInt(location), fSalary);
            response.sendRedirect("http://localhost:8080/EmployeesApp/listEmployees");
        }
        catch (Exception e)
        {
            response.sendRedirect("http://localhost:8080/EmployeesApp/editEmployee?id="+(Integer)mySession.getAttribute("employeeId"));
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmployeeService service = new EmployeeService();
        LocationService locService = new LocationService();
        HttpSession mySession = req.getSession(true);
        
        String idString = req.getParameter("id");
        mySession.setAttribute("employeeId", Integer.parseInt(idString));
        
        Employee employee = service.getEmployee((Integer)mySession.getAttribute("employeeId"));

        mySession.setAttribute("employee", employee);
 
        List<Location> locations = locService.getLocations();
        mySession.setAttribute("locations", locations);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_edit.jsp");
        rd.forward(req, resp);
    }
}
