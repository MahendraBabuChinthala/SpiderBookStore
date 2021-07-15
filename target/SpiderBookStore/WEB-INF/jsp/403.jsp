<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
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

    }

    .button1 {
        background-color: #4CAF50;
    }
</style>
<body>
<h1>HTTP Status 403 - Access is denied</h1>
<h2>${msg}</h2>
<c:url value="/logout" var="logoutUrl"/>
<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<a href="javascript:formSubmit()"> Logout</a>
<c:url value="/customerHome" var="home"/>
<button class="button button1"><a href="${home}">&laquo; Home</a></button>
</body>
</html>