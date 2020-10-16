<%-- 
    Document   : locations_edit
    Created on : 15 oct. 2020, 13:13:20
    Author     : dario
--%>

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
        <% Location loc = (Location)mySession.getAttribute("location"); %>
        <h1>Edit the location info: </h1>
        <form action="/EmployeesApp/editLocation" method="post">
            <label for="brand">New Name: </label>
            <input type="text" id="name" name="name" value=<%= loc.getName() %>>
            <br>
            <input type="submit" value="EDIT"> 
        </form>
    </body>
</html>
