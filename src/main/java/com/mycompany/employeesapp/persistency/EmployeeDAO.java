/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.persistency;

import com.mycompany.employeesapp.domain.Employee;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO extends DAO{
    
    public EmployeeDAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        super(userName, password, serverName, portNumber, database);
    }
    
    public List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM employees";
            ResultSet rs = statement.executeQuery(query);

                while (rs.next()) 
                {
                    employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("location"), rs.getFloat("salary")));
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    public void editEmployee(int id, String name, int location, float salary) {
        String query = "UPDATE employees SET name = ? , location = ? , salary = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, location);
            preparedStatement.setFloat(3, salary);
            preparedStatement.setInt(4, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removeEmployee(int id)
    {
        String query = "DELETE FROM employees WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }
 
}
