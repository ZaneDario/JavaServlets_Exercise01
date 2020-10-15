/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    int id;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LocationService service = new LocationService();
        String name = request.getParameter("name");
        service.editLocation(id, name);

        response.sendRedirect("http://localhost:8080/EmployeesApp/listLocations");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        LocationService service = new LocationService();
        String idString = req.getParameter("id");
        id = Integer.parseInt(idString);
        Location location = null;
        for(Location loc : service.getLocations())
        {
            if(loc.getId() == id)
                location = loc;
        }
        HttpSession mySession = req.getSession(true);
        mySession.setAttribute("location", location);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/locations_edit.jsp");
        rd.forward(req, resp);
    }
}
