package com.mycompany.employeesapp.persistency;

import com.mycompany.employeesapp.domain.Location;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationDAO extends DAO{
    
    public LocationDAO(String userName, String password,
            String serverName, String portNumber, String database) throws ClassNotFoundException {
        super(userName, password, serverName, portNumber, database);
    }
    
    public void addLocation(Location loc) {
        String query = "INSERT INTO locations (name) values (?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, loc.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("ERROR: " + e.toString());
        }
        closeConnection();
    }
    
    public Location getLocation(int id) {
        Location location = null;
        Statement statement = null;
        try {
            statement = conn.createStatement();
            String query = "SELECT * FROM locations WHERE id = "+ id;
            ResultSet rs = statement.executeQuery(query);

                if (rs.next()) 
                {
                    location = new Location(rs.getInt("id"), rs.getString("name"));
                }
                statement.close();
            }
         catch (SQLException e) {
            e.printStackTrace();
        }
        return location;
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
    
    public void editLocation(int id, String name) {
        String query = "UPDATE locations SET name = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void removeLocation(int id)
    {
        String query = "DELETE FROM locations WHERE id = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {

        }
    }


}
