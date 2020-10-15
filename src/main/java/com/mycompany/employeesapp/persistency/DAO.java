
package com.mycompany.employeesapp.persistency;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    Connection conn;

    public DAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        conn = DatabaseConnector.getConnection(userName, password, serverName, portNumber, database);
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing connection: " + e.toString());
        }
    }
}
