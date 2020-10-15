package com.mycompany.employeesapp.utils;

import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.LocationService;
import java.util.List;

public class Conversor {
    
    public static String parseIntToString(int id)
    {
        LocationService service= new LocationService();
        List<Location> locations = service.getLocations();
        for(Location loc : locations)
        {
            if(loc.getId() == id)
                return loc.getName();
        }
        
        return "";
    }
    
    public static int parseStringToInt(String location)
    {
        LocationService service= new LocationService();
        List<Location> locations = service.getLocations();
        for(Location loc : locations)
        {
            if(loc.getName().equals(location))
                return loc.getId();
        }
        
        return 0;
    }
}
