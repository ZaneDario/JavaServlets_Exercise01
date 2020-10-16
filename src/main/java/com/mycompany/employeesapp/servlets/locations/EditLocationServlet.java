
package com.mycompany.employeesapp.servlets.locations;

import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.LocationService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditLocationServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession mySession = request.getSession(true);
        LocationService service = new LocationService();
        String name = request.getParameter("name");
        
        int id = (Integer)mySession.getAttribute("locationId");
        service.editLocation(id, name);

        response.sendRedirect("http://localhost:8080/EmployeesApp/listLocations");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        LocationService service = new LocationService();
        HttpSession mySession = req.getSession(true);
        
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        mySession.setAttribute("locationId", id);
        
        Location location = service.getLocation(id);
        
        mySession.setAttribute("location", location);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/locations_edit.jsp");
        rd.forward(req, resp);
    }
}
