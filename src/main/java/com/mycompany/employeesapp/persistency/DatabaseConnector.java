
package com.mycompany.employeesapp.persistency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    
    
    
    public static Connection getConnection(String userName, String password,
                                           String serverName, String portNumber, String database) throws ClassNotFoundException{
        try
        {
            Connection conn = null;
            Properties connectionProps = new Properties();
            connectionProps.put("user", userName);
            connectionProps.put("password", password);

            if(conn == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql" + "://" + serverName +
                    ":" + portNumber + "/" + database + "?useLegacyDatetimeCode=false&serverTimezone=Europe/Madrid", connectionProps);
            }
            
            System.out.println("Connected to database");
            return conn;
        } catch (SQLException e)
        {
            System.out.println("ERROR: "+ e.toString());
        }
        return null;
    }
}

