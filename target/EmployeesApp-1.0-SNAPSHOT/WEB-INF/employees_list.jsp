<%-- 
    Document   : employees_list
    Created on : 14 oct. 2020, 13:37:55
    Author     : dario
--%>

<%@page import="com.mycompany.employeesapp.utils.Conversor"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.employeesapp.domain.Employee"%>
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
        <text><a href="http://localhost:8080/EmployeesApp/listLocations"> Locations List   </a></text>
        <% if (user.getRol().equals("admin")) { %>
        <text><a href="http://localhost:8080/EmployeesApp/addEmployee"> Add Employee </a></text>
        <% } %>
        <% List<Employee> employees = (List<Employee>) mySession.getAttribute("employees"); %>

        <h1>List of Employees in the Company:</h1>

        <table style="width:100%">
            <tr>
                <td>ID</td>
                <th>Name</th>
                <th>Location ID</th>
                <th>Salary</th>
                    <% if (user != null && user.getRol().equals("admin")) { %>
                <th>Update</th>
                <th>Delete</th>
                    <% } %>

            </tr>


            <% for (Employee e : employees) {%>
            <tr>
                <td style="text-align:center"><%= e.getId()%></td>
                <td style="text-align:center"><%= e.getName()%></td> 
                <td style="text-align:center"><%= e.getLocation()%></td>
                <td style="text-align:center"><%= e.getSalary()%></td>
                <% if (user != null && user.getRol().equals("admin")) { %>
                <td style="text-align:center">
                    <% String updateUrl = "http://localhost:8080/EmployeesApp/editEmployee?id=" + e.getId();%>
                    <a href=<%= updateUrl%>>
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/edit.png" alt="Edit this item from Database.">
                    </a>
                </td>
                <td style="text-align:center">
                    <% String deleteUrl = "http://localhost:8080/EmployeesApp/deleteEmployee?id=" + e.getId();%>
                    <a href=<%= deleteUrl%>>
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/bin.png" alt="Delete this item from Database.">
                    </a>
                </td>
                <% } %>

            </tr>
            <% }%>
        </table>
        <br>
        <form action="/EmployeesApp/filterEmployees" method="post">
            <label for="model">Filter By: </label>
            <select id="filter" name="filter">
                <option value="id"> ID </option>
                <option value="name"> Name </option>
                <option value="location"> Location </option>
                <option value="salary"> Salary </option>
            </select>
            <br>
            <label for="model">Value: </label>
            <input type="text" id="value" name="value">
            <input type="submit" value="FILTER">  
        </form>
    </body>
</html>
