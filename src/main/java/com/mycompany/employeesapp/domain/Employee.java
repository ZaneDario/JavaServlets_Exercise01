
package com.mycompany.employeesapp.domain;

import com.mycompany.employeesapp.utils.Conversor;

public class Employee {
    private int id;
    private String name;
    private String location;
    private int locationId;
    private float salary;

    public Employee(int id, String name, int locationId, float salary) {
        this.id = id;
        this.name = name;
        this.locationId = locationId;
        this.salary = salary;
        
        this.location = Conversor.parseIntToString(locationId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    
    
}
