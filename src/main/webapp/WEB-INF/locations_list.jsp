<%-- 
    Document   : locations_list
    Created on : 15 oct. 2020, 12:52:45
    Author     : dario
--%>

<%@page import="com.mycompany.employeesapp.domain.Location"%>
<%@page import="com.mycompany.employeesapp.domain.Employee"%>
<%@page import="java.util.List"%>
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
        <text><a href="http://localhost:8080/EmployeesApp/listEmployees"> Employees List   </a></text>
        <% if(user.getRol().equals("admin")){ %>
        <text><a href="http://localhost:8080/EmployeesApp/addLocation"> Add Location </a></text>
        <% } %>
        
        <% List<Location> locations = (List<Location>) mySession.getAttribute("locations"); %>

        <h1>List of Locations in the Company:</h1>

        <table style="width:100%">
            <tr>
                <td>ID</td>
                <th>Name</th>
                    <% if (user != null && user.getRol().equals("admin")) { %>
                <th>Update</th>
                <th>Delete</th>
                    <% } %>

            </tr>


            <% for (Location loc : locations) {%>
            <tr>
                <td style="text-align:center"><%= loc.getId()%></td>
                <td style="text-align:center"><%= loc.getName()%></td> 
                <% if (user != null && user.getRol().equals("admin")) { %>
                <td style="text-align:center">
                    <% String updateUrl = "http://localhost:8080/EmployeesApp/editLocation?id=" + loc.getId();%>
                    <a href=<%= updateUrl%>>
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/edit.png" alt="Edit this item from Database.">
                    </a>
                </td>
                <td style="text-align:center">
                    <% String deleteUrl = "http://localhost:8080/EmployeesApp/deleteLocation?id=" + loc.getId();%>
                    <a href=<%= deleteUrl%>>
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/bin.png" alt="Delete this item from Database.">
                    </a>
                </td>
                <% } %>

            </tr>
            <% }%>

        </table>
    </body>
</html>
