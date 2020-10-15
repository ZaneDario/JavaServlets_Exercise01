/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.employeesapp.persistency;

import com.mycompany.employeesapp.domain.Employee;
import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    Connection conn;

    public DAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        conn = DatabaseConnector.getConnection(userName, password, serverName, portNumber, database);
    }
    
    public User loginUser(String username, String password)
    {
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM users";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                if(rs.getString("username").equals(username) 
                        && rs.getString("password").equals(password))
                {
                    return new User(username, password, rs.getString("rol"));
                }      
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
    
    public List<Location> getLocations()
    {
        List<Location> locations = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM locations";
            ResultSet rs = statement.executeQuery(query);

                while (rs.next()) 
                {
                    locations.add(new Location(rs.getInt("id"), rs.getString("name")));
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
        return locations;
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.toString());
        }
    }
}
