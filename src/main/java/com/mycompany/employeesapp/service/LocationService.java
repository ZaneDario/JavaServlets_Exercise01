package com.mycompany.employeesapp.service;

import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.persistency.LocationDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LocationService{
        
    LocationDAO dao;
    
    public LocationService()
    {
        try {
            dao = new LocationDAO("root", "admin", "localhost", "3306", "employees_web_service");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Location> getLocations()
    {
       return dao.getLocations();
    }

    public void editLocation(int id, String name) {
        dao.editLocation(id, name);
    }
    
    public void removeLocation(int id)
    {
        dao.removeLocation(id);
    }

    public void addLocation(Location location) {
        dao.addLocation(location.getName());
    }
}
