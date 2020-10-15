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

public class EmployeeDAO extends DAO {

    public EmployeeDAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        super(userName, password, serverName, portNumber, database);
    }

    public void addEmployee(Employee e) {
        String query = "INSERT INTO employees (name, location, salary) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setInt(2, e.getLocationId());
            preparedStatement.setFloat(3, e.getSalary());
            preparedStatement.execute();
        } catch (SQLException exc) {
            System.out.println("ERROR: " + exc.toString());
        }
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM employees";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                employees.add(new Employee(rs.getInt("id"), rs.getString("name"), rs.getInt("location"), rs.getFloat("salary")));
            }
        } catch (SQLException e) {
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

    public List<Employee> filterEmployees(String type, String value) {
        List<Employee> filteredEmployees = new ArrayList<>();

        for (Employee e : getEmployees()) {
            String employeeParameter = "";

            switch (type) 
            {
                case "id": employeeParameter = String.valueOf(e.getId()); break;
                case "name": employeeParameter = e.getName(); break;
                case "location": employeeParameter = e.getLocation(); break;
                case "salary": employeeParameter = String.valueOf(e.getSalary()); break;
                default:  break;
            }
            if(employeeParameter.toLowerCase().equals(value.toLowerCase()))
                filteredEmployees.add(e);
        }

        return filteredEmployees;
    }

    public void removeEmployee(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }

}
