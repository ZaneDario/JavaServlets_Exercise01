/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.service;
import com.mycompany.employeesapp.domain.User;
import com.mycompany.employeesapp.persistency.UserDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService{
   
    UserDAO dao;
    
    public UserService()
    {
        try {
            dao = new UserDAO("root", "admin", "localhost", "3306", "employees_web_service");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User loginUser(String username, String password)
    {
        return dao.loginUser(username, password);
    }
}
