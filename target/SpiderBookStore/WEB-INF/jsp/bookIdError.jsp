<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Book ID Error</title>
    <style>
        .button {
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
            margin-left: 10px;
            margin-top: 8px;

        }

        .button1 {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
<center><h3 style="color: red">Book Id is Not There</h3></center>
<c:url value="/customerHome" var="home"/>
<button class="button button1"><a href="${home}">HOME</a></button>
</body>
</html>
