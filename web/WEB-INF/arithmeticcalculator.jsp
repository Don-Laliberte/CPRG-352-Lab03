<%-- 
    Document   : arithmeticcalculator
    Created on : Jun 3, 2021, 6:33:37 PM
    Author     : toesl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="arithmetic">
            <label>First:</label>
            <input type="number" name="first_value" value="${firstValue}">
            <br>
            <label>Second:</label>
            <input type="number" name="second_value" value="${secondValue}">
            <br>
            <input type="submit" value="+" name="add">
            <input type="submit" value="-" name="minus">
            <input type="submit" value="*" name="multiply">
            <input type="submit" value="%" name="modulus">
        </form>
        <br>
        <span>${message}</span>
        <br>
        <a href="age">Age Calculator</a>
    </body>
</html>
