package com.mycompany.employeesapp.persistency;

import com.mycompany.employeesapp.domain.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO extends DAO{
   
    public UserDAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        super(userName, password, serverName, portNumber, database);
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
}
