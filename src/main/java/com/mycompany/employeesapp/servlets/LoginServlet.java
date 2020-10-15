/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.servlets;

import com.mycompany.employeesapp.domain.User;
import com.mycompany.employeesapp.service.UserService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = service.loginUser(username, password);
        
        if(user != null)
        {
            HttpSession mySession = request.getSession(true);
            mySession.setAttribute("user", user);
            response.sendRedirect("http://localhost:8080/EmployeesApp/listEmployees");
        }
        else
            response.sendRedirect("http://localhost:8080/EmployeesApp/login");
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/employees_list.jsp");
        //rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/index.html");
        rd.forward(req, resp);
    }
}
