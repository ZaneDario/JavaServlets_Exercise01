
package com.mycompany.employeesapp.servlets.locations;

import com.mycompany.employeesapp.service.LocationService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteLocationServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocationService service = new LocationService();
        
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        
        service.removeLocation(id);
        
        resp.sendRedirect("http://localhost:8080/EmployeesApp/listLocations");
    }
}
