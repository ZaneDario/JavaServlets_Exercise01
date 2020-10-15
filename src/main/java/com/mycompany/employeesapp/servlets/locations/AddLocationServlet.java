package com.mycompany.employeesapp.servlets.locations;

import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.LocationService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddLocationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        LocationService service = new LocationService();
        String name = request.getParameter("name");
        service.addLocation(new Location(name));
        response.sendRedirect("http://localhost:8080/EmployeesApp/listLocations");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/locations_add.jsp");
        rd.forward(req, resp);
    }
}
