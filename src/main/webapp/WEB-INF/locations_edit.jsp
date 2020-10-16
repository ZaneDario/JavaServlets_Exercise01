
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
        
        <h1>Edit the location info: </h1>
        <form action="/EmployeesApp/editLocation" method="post">
            <label for="brand">New Name: </label>
            <input type="text" id="name" name="name" value="${location.name}">
            <br>
            <input type="submit" value="EDIT"> 
        </form>
    </body>
</html>
