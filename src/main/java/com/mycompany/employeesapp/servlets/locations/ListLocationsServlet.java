/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.servlets.locations;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.LocationService;
import com.mycompany.employeesapp.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dario
 */
public class ListLocationsServlet extends HttpServlet{
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        LocationService service = new LocationService();
        List<Location> locations = service.getLocations();
        
        HttpSession mySession = req.getSession(true);
        mySession.setAttribute("locations", locations);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/locations_list.jsp");
        rd.forward(req, resp);
    }
}