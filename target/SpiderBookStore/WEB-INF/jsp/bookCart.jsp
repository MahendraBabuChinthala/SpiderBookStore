<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
</head>
<body bgcolor="#e3e3e3" >
<form action="" method="post"><center>
    <table >
        <caption >Welcome to the shopping site</caption>
        <tr>
            <td>Product 1</td><td>Purchase quantity:</td>
            <td><input type="button" value="+" path="quantity" onclick="this.form.c1.value++"/>
                <input type="text" name="c1"value=1 size="4"/>
                <input type="button"  value="-" onclick="this.form.c1.value--"/></td>
        </tr>
        <tr>
            <td>Product 2</td><td>Purchase quantity:</td>
            <td><input type="button" value="+" onclick="this.form.c2.value++"/>
                <input type="text" name="c2"value=0 size="4"/>
                <input type="button"  value="-" onclick="this.form.c2.value--"/></td>
        </tr>
        <tr>
            <td>Product 3</td><td>Purchase quantity:</td>
            <td><input type="button" value="+" onclick="this.form.c3.value++"/>
                <input type="text" name="c3"value=0 size="4"/>
                <input type="button"  value="-" onclick="this.form.c3.value--"/></td>
        </tr>

    </table>
    <input type="submit" value="Save"/>
</center>
</form>
<input type="button" value="Logout" onclick="window.location.href='login.jsp'"/>
</body>
</html>