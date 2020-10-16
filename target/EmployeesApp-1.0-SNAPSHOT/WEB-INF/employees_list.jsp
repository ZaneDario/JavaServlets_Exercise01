
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:if test="${user.rol eq 'admin'}">
            <text><a href="http://localhost:8080/EmployeesApp/addEmployee"> Add Employee </a></text>      
        </c:if>

        <h1>List of Employees in the Company:</h1>

        <table style="width:100%">
            <tr>
                <td>ID</td>
                <th>Name</th>
                <th>Location ID</th>
                <th>Salary</th>
                    <c:if test="${user != null && user.rol eq 'admin'}">
                    <th>Update</th>
                    <th>Delete</th>
                    </c:if> 
            </tr>


            <c:forEach items="${employees}" var="e">
                <tr>
                    <td style="text-align:center"> ${e.id} </td>
                    <td style="text-align:center">${e.name}</td> 
                    <td style="text-align:center">${e.location}</td>
                    <td style="text-align:center">${e.salary}</td>
                    <c:if test="${user != null && user.rol eq 'admin'}">
                        <td style="text-align:center">
                            <a href="http://localhost:8080/EmployeesApp/editEmployee?id=" + ${e.id}>
                                <img height="25px" width="25px" src="/TecnaraWebApp/images/edit.png" alt="Edit this item from Database.">
                            </a>
                        </td>
                        <td style="text-align:center">
                            <a href="http://localhost:8080/EmployeesApp/deleteEmployee?id=" + ${e.id}>
                                <img height="25px" width="25px" src="/TecnaraWebApp/images/bin.png" alt="Delete this item from Database.">
                            </a>
                        </td>  
                    </c:if>

                </tr>
            </c:forEach>

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
        <br>
        <text><a href="http://localhost:8080/EmployeesApp/listEmployees"> Reset   </a></text>
    </body>
</html>
