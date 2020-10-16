
<%@page import="com.mycompany.employeesapp.service.LocationService"%>
<%@page import="com.mycompany.employeesapp.domain.Location"%>
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
            
        <form action="/EmployeesApp/addEmployee" method="post">
            <label for="brand">Name: </label>
            <input type="text" id="name" name="name">
            <br>
            <label for="model">Location: </label>
            <select id="location" name="location">
                <c:forEach items="${locations}" var="loc">
                    <option value="${loc.name}"> ${loc.name} </option>
                </c:forEach>   
            </select>
            <br>
            <label for="plate">Salary: </label>
            <input type="text" id="salary" name="salary">
            <br>
            <input type="submit" value="Add New Employee"> 
        </form>
    </body>
</html>
