<%--
  Created by IntelliJ IDEA.
  User: ilnas
  Date: 29/03/2022
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Group</title>
    <meta charset="UTF-8">
</head>
<body>
    <form:form method="post" modelAttribute="group">
        <form:label path="members">
            Members:
        </form:label>
        <form:input path="members"/>
        <form:errors path="members"/>
        <input type="submit" value="Submit">
    </form:form>
</body>
</html>
