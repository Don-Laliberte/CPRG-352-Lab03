<%-- 
    Document   : AgeCalculatorServlet
    Created on : May 26, 2021, 1:14:49 PM
    Author     : toesl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            <label>Enter your age:</label>
            <input type="number" name="age_value" value="${ageValue}">
            <br>
            <input type="submit" value="Age next birthday">
        </form>
        <c:if test="${outputmessage}">
            <p>${message}</p>
        </c:if>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
