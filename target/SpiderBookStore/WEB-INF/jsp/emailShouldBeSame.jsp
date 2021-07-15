<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Email Should Not Be Changed</title>
    <style>
        #contact {
            width: 430px;
            margin: 60px auto;
            padding: 60px 30px;
            background: #f8f9fa;
            border: 1px solid #e1e1e1;
            -moz-box-shadow: 0px 0px 8px #444;
            -webkit-box-shadow: 0px 0px 8px #444;
        }

        h1 {
            font-size: 35px;
            color: #445668;
            text-transform: uppercase;
            text-align: center;
            margin: 0 0 35px 0;
            text-shadow: 0px 1px 0px #f2f2f2;
        }

        .btnRegister {
            float: right;
            margin-top: 10%;
            border: none;
            /*//Instead of the line below you could use @include border-radius($radius, $vertical-radius)*/
            border-radius: 1.5rem;
            padding: 2%;
            background: darkred;
            color: darkgreen;
            font-weight: 600;
            width: 50%;
            cursor: pointer;
            color: #f8f9fa;
        }

        .error {
            color: red;
            position: absolute;
            text-align: left;
            margin-left: 30px;
        }

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

        }

        .button1 {
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
<div id="contact">
    <h1>Email Can Not Be Changed</h1>
    <br>
    <br>
    <c:url value="/getSingleCustomer" var="profile"/>
    <button class="button button1"><a href="${profile}">&laquo; Previous</a></button>
</div>
</body>
</html>