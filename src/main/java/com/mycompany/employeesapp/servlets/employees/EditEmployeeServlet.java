
package com.mycompany.employeesapp.servlets.employees;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.EmployeeService;
import com.mycompany.employeesapp.service.LocationService;
import com.mycompany.employeesapp.service.UserService;
import com.mycompany.employeesapp.utils.Conversor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditEmployeeServlet extends HttpServlet{
    int id;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EmployeeService service = new EmployeeService();
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String salary = request.getParameter("salary");
        service.editEmployee(id, name, Conversor.parseStringToInt(location), Float.parseFloat(salary));

        response.sendRedirect("http://localhost:8080/EmployeesApp/listEmployees");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmployeeService service = new EmployeeService();
        LocationService locService = new LocationService();
        String idString = req.getParameter("id");
        id = Integer.parseInt(idString);
        Employee employee = null;
        for(Employee e : service.getEmployees())
        {
            if(e.getId() == id)
                employee = e;
        }
        HttpSession mySession = req.getSession(true);
        mySession.setAttribute("employee", employee);
 
        List<Location> locations = locService.getLocations();
        mySession.setAttribute("locations", locations);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_edit.jsp");
        rd.forward(req, resp);
    }
}
