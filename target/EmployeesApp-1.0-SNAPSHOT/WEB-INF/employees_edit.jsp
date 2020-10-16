
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
        <h1>Edit the employee info: </h1>
        <form action="/EmployeesApp/editEmployee" method="post">
            <label for="model">New Name: </label>
            <input type="text" id="name" name="name" value="${employee.name}">
            <br>
            <label for="model">New Location: </label>
            <select id="location" name="location">
                <c:forEach items="${locations}" var="loc">
                    <option value="${loc.name}"
                            <c:if test="${loc.id == employee.locationId}">
                                selected="selected" </c:if>> ${loc.name}    
                    </option>
                </c:forEach>                
            </select>
            <br>
            <label for="model">New Salary: </label>
            <input type="text" id="salary" name="salary" value=${employee.salary}>
            <br>
            <input type="submit" value="EDIT"> 
        </form>
    </body>
</html>
