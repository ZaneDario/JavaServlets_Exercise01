package com.mycompany.employeesapp.utils;

import com.mycompany.employeesapp.domain.Location;
import com.mycompany.employeesapp.service.UserService;
import java.util.List;

public class Conversor {
    
    public static String parseIntToString(int id)
    {
        UserService service= new UserService();
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
        UserService service= new UserService();
        List<Location> locations = service.getLocations();
        for(Location loc : locations)
        {
            if(loc.getName().equals(location))
                return loc.getId();
        }
        
        return 0;
    }
}
