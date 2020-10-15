/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.service;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.persistency.EmployeeDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeService {
    
    EmployeeDAO dao;
    
    public EmployeeService()
    {
        try {
            dao = new EmployeeDAO("root", "admin", "localhost", "3306", "employees_web_service");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addEmployee(Employee employee)
    {
        dao.addEmployee(employee);
    }
    
     public List<Employee> getEmployees()
    {
        return dao.getEmployees();
    }
    
    public void editEmployee(int id, String name, int location, float salary)
    {
        dao.editEmployee(id, name, location, salary);
    }
    public List<Employee> filterEmployees(String filter, String value)
    {
        return dao.filterEmployees(filter, value);
    }
    public void removeEmployee(int id)
    {
        dao.removeEmployee(id);
    }
}
