<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 1000px; margin: auto">
    <table>
        <tr style="font-weight: bold; background-color: gainsboro;">
            <td width="120">Name</td>
            <td>Text</td>
        </tr>
        <c:if test="${!empty guests}">
            <c:forEach items="${guests}" var="guest">
                <tr bgcolor="#f0f8ff">
                    <td>${guest.name}</td>
                    <td>${guest.text}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
<br>
<h3>Create note!</h3>
<form:form method="post" modelAttribute="guest" action="/addGuest">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name" id="name"/></td>
        </tr>
        <tr>
            <td>Text: </td>
            <td><form:input path="text" id="text"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"/></td>
        </tr>
    </table>
</form:form>


</body>
</html>
