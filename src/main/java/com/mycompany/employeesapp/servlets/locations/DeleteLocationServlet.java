/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.servlets.locations;

import com.mycompany.employeesapp.service.UserService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dario
 */
public class DeleteLocationServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserService();
        
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        
        //service.removeLocation(id);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/locations_list.jsp");
        rd.forward(req, resp);
    }
}
