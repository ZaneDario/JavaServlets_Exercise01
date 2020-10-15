
package com.mycompany.employeesapp.servlets;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteEmployeeServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService service = new UserService();
        
        String idString = req.getParameter("id");
        int id = Integer.parseInt(idString);
        
        service.removeEmployee(id);
        
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/employees_list.jsp");
        rd.forward(req, resp);
    }
}
