<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title></title>
    <style>
        .mahendra {
            color: #ED2553;
        }

        * {
            box-sizing: border-box;
        }

        *:focus {
            outline: none;
        }

        body {
            font-family: Arial;
            background-color: #3498DB;
            padding: 50px;
        }

        .login {
            margin: 20px auto;
            width: 300px;
        }

        .login-screen {
            background-color: #FFF;
            padding: 20px;
            border-radius: 5px
        }

        .app-title {
            text-align: center;
            color: #777;
        }

        .login-form {
            text-align: center;
        }

        .control-group {
            margin-bottom: 10px;
        }

        input {
            text-align: center;
            background-color: #ECF0F1;
            border: 2px solid transparent;
            border-radius: 3px;
            font-size: 16px;
            font-weight: 200;
            padding: 10px 0;
            width: 250px;
            transition: border .5s;
        }

        input:focus {
            border: 2px solid #3498DB;
            box-shadow: none;
        }

        .btn {
            border: 2px solid transparent;
            background: #3498DB;
            color: #ffffff;
            font-size: 16px;
            line-height: 25px;
            padding: 10px 0;
            text-decoration: none;
            text-shadow: none;
            border-radius: 3px;
            box-shadow: none;
            transition: 0.25s;
            display: block;
            width: 250px;
            margin: 0 auto;
        }

        .btn:hover {
            background-color: #2980B9;
        }

        .login-link {
            font-size: 12px;
            color: #444;
            display: block;
            margin-top: 12px;
        }

        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }

        #login-box {
            width: 300px;
            padding: 20px;
            margin: 100px auto;
            background: #fff;
            -webkit-border-radius: 2px;
            -moz-border-radius: 2px;
            border: 1px solid #000;
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
            margin-left: -45px;
            margin-top: -397px;

        }

        .button1 {
            background-color: #4CAF50;
        }

        .button2 {
            background-color: #a94442
        }
    </style>
</head>
<body>
<div class="login">
    <div class="login-screen">
        <div class="app-title">
            <h1>Login</h1>
        </div>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <c:url value="/login" var="log"></c:url>

        <div class="login-form">
            <form name='loginForm' action="${log}" method='POST'>
                <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="username" name="username"
                           id="login-name">
                </div>

                <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="password" name='password'
                           id="login-pass">
                </div>

                <input class="btn btn-primary btn-large btn-block" input name="submit" type="submit" value="submit"/>

                <c:url value="/customerRegistration" var="customerRegistration"/>
                <a class="login-link" href="${customerRegistration}">Create an Account</a>

                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>

    </div>
</div>
<c:url value="/customerHome" var="home"/>
<h2>
    <button class="button button1"><a href="${home}">HOME</a></button>
</h2>
</body>
</html>