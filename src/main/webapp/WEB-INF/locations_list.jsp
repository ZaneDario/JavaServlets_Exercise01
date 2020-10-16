
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
        <c:if test="${user.rol eq 'admin'}">
            <text><a href="http://localhost:8080/EmployeesApp/addLocation"> Add Location </a></text>
        </c:if>

        <h1>List of Locations in the Company:</h1>

        <table style="width:100%">
            <tr>
                <td>ID</td>
                <th>Name</th>

                <c:if test="${user != null && user.rol eq 'admin'}">
                    <th>Update</th>
                    <th>Delete</th>
                    </c:if>                   
            </tr>

            <c:forEach items="${locations}" var="loc">
                <tr>
                <td style="text-align:center">${loc.id}</td>
                <td style="text-align:center">${loc.name}</td> 
                <c:if test="${user != null && user.rol eq 'admin'}">
                    <td style="text-align:center">
                    <a href="http://localhost:8080/EmployeesApp/editLocation?id=${loc.id}">
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/edit.png" alt="Edit this item from Database.">
                    </a>
                </td>
                <td style="text-align:center">
                    <a href="http://localhost:8080/EmployeesApp/deleteLocation?id=${loc.id}">
                        <img height="25px" width="25px" src="/TecnaraWebApp/images/bin.png" alt="Delete this item from Database.">
                    </a>
                </td>
                </c:if>               
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
