<%-- 
    Document   : locations_add
    Created on : 15 oct. 2020, 18:18:15
    Author     : dario
--%>

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
        <form action="/EmployeesApp/addLocation" method="post">
            <label for="brand">Name:</label>
            <input type="text" id="name" name="name">
            <br>
            <input type="submit" value="Add New Location"> 
        </form>
    </body>
</html>
