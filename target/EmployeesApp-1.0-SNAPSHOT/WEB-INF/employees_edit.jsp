<%-- 
    Document   : employees_edit
    Created on : 14 oct. 2020, 22:05:24
    Author     : dario
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.employeesapp.utils.Conversor"%>
<%@page import="com.mycompany.employeesapp.domain.Employee"%>
<%@page import="com.mycompany.employeesapp.domain.Location"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="header">
            <%@ include file="/WEB-INF/layout/menu.jspf" %>
        </div>
        <% Employee e = (Employee)mySession.getAttribute("employee"); 
        List<Location> locations = (List<Location>)mySession.getAttribute("locations"); %>
        <h1>Edit the employee info: </h1>
        <form action="/EmployeesApp/editEmployee" method="post">
            <label for="brand">New Name: </label>
            <input type="text" id="name" name="name">
            <label for="brand">  Old Name: <%= e.getName() %> </label>
            <br>
            <label for="model">New Location: </label>
            <select id="location" name="location">
                <% for(Location loc : locations )
                    { %>
                        <option value="<%=loc.getName() %>"> <%= loc.getName() %> </option>
                 <% } %>    
            </select>
            <label for="brand">  Old Location: <%= e.getLocation() %> </label>
            <br>
            <label for="model">New Salary: </label>
            <input type="text" id="salary" name="salary">
            <label for="brand">  Old Salary: <%= e.getSalary() %> </label>
            <br>
            <input type="submit" value="EDIT"> 
        </form>
    </body>
</html>
