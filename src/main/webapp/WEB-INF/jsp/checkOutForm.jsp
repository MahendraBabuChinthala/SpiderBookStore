<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Add Book Page</title>
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
            background: blue;
            color: white;
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
            margin-left: 10px;
            margin-top: -728px;

        }

        .button1 {
            background-color: #4CAF50;
        }

        /*HOME PAGE*/
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        }

        .header-wrapper {

        }

        .price-match-guarantee {
            margin-left: 120px;
            margin-top: 6px;
            color: #293991;
            font-size: 28px;
        }

        .price-match-guarantee a {
            text-decoration: none;
            color: #293991;
        }

        .price-match-guarantee a:hover {
            color: #ff5c00;
        }

        .currency div {
            margin-top: 12px;
            margin-left: 19px;
        }

        .header-part-2 {
            display: flex;
            background-color: white;
            margin-top: 0px;
            height: 100px;
        }

        .logo {
            margin-left: 2px;
            margin-top: 4px;
            width: 30px;
            height: 5px;
        }

        .search-bar input {
            height: 35px;
            width: 380px;
            margin-top: 28px;
            margin-left: 170px;
            border-top-left-radius: 3px;
            border-bottom-left-radius: 3px;
        }

        .search-button i {
            margin-top: 12px;
            margin-left: 19px;
        }

        .navbar {
            border: 2px white solid;
            height: 60px;
            width: 100%;
            background-color: #13afc1;
        }


        .navbar-link-holder {
            margin-top: 20px;
            text-align: center;
        }

        .navbar-link-holder a {
            text-decoration: none;
            padding: 20px;
            color: white;
        }

        .navbar-link-holder a:hover {
            background-color: #ed1c24;
        }

        .banners img {
            float: left;
            margin-top: 10px;
        }

        .header-part-1-phone a {
            text-decoration: none;
            color: black;
        }

        .header-part-1-lock a {
            text-decoration: none;
            color: black;
        }

        .header-part-1-user a {
            text-decoration: none;
            color: black;
        }

        .header-part-1-phone a:hover {
            color: #ff5c00;

        }

        .header-part-1-lock a:hover {
            color: #ff5c00;
        }

        .header-part-1-user a:hover {
            color: #ff5c00;
        }

        h5 {
            margin-left: 640px;
        }

        .dropdown {
            float: left;
            overflow: hidden;
        }

        .dropdown .dropbtn {
            font-size: 16px;
            border: none;
            outline: none;
            color: red;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
            margin-top: 25px;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }
    </style>
</head>
<body>
<c:url value="/login" var="login"/>
<%--  Customer Registeration form url  --%>
<c:url value="/customerRegistration" var="customerRegistration"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<header class="header-wrapper">
    <div class="header-part-2">
        <%--   logo     --%>
        <div class="logo"><img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHvMmB6eucEBEpPeMkHUb3ihzl-jYIZxNFRg&usqp=CAU"
                style="width:145px;height:101px"></div>
        <%--  website name spider book store    --%>
        <div class="price-match-guarantee"><a href=#><strong><p>Spider Book Store</p></strong></a></div>

        <%--  login and registration  --%>
        <c:if test="${pageContext.request.userPrincipal.name == null}">

        <p style="margin-top:45px;margin-left:750px"><i class="fa fa-lock"></i><a href="login"><strong> Login<a
                href="customerRegistration"> / Register</a></strong></a></p></div>
    </c:if>
    <%-- after login hidde the login and display the user name --%>
    <c:if test="${pageContext.request.userPrincipal.name != null}">

        <div class="dropdown" style="position: inherit">
            <button class="dropbtn" style=" margin-left: 600px;"><i class="fa fa-user"></i><strong>&nbsp;&nbsp;Hi
                :${firstName}</strong>

                <i class="fa fa-caret-down"></i>
            </button>
            <c:url value="/sellerPortal" var="seller"/>
            <c:url value="/getSingleCustomer" var="profile"/>
            <div class="dropdown-content" style="margin-left: 620px">
                <a href="${profile}">Profile</a>
                <a href="${seller}">Seller portal</a>

                <c:url value="/logout" var="login"/>

                <form action="${login}" method="post" id="logoutForm">
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>

                <script>
                    function formSubmit() {
                        document.getElementById("logoutForm").submit();
                    }
                </script>

                <c:if test="${pageContext.request.userPrincipal.name != null}">
                    <a href="javascript:formSubmit()"> Logout</a>
                </c:if>
            </div>
        </div>

    </c:if>
</header>

<%-- Navigation Bar --%>
<c:url value="/getAllBooksData" var="getallBooksData"/>
<c:url value="/customerHome" var="home"/>
<div class="navbar">
    <div class="navbar-link-holder">
        <a href="${home}" style="margin-left: 80px">HOME</a>
        <a href="spiderBookStoreAboutUs" style="margin-left: 80px">ABOUT/CONTACT US</a>
        <a href=# style="margin-left: 80px" hidden>Checkout Page</a>
        <a href="getAllBooksData" style="margin-left: 80px" hidden>All Books List</a>
    </div>
</div>
<div></div>
<h1>CheckOut page</h1>
<div id="contact">
    <h1>Book Will Be Delivered On This Address</h1>
    <hr>
    <c:url value="/saveOrder" var="saveOrder"/>
    <form:form method="post" action="${saveOrder}" modelAttribute="customerDto">
        <table align="center">
            <tr></tr>
            <tr>
                <td><label for="addressLine1">Address1 </label></td>
                <td>: <form:textarea type="textarea" path="addressLine1" id="addressLine1"/>
                    <form:errors path="addressLine1" cssClass="error"/></td>
            </tr>

            <tr></tr>
            <tr>
                <td><label for="pincode">PinCode </label></td>
                <td>: <form:input type="text" path="pincode" id="pincode"/>
                    <form:errors path="pincode" cssClass="error"/></td>
            </tr>
            <tr></tr>
            <tr>
                <td><label for="contact">Contact </label></td>
                <td>: <form:input type="text" path="contact" id="dob"/>
                    <form:errors path="contact" cssClass="error"/></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr>
                <td><label for="paymentMethod"><h3 style="color: #3498DB">Payment Method</h3></label></td>
            <tr>
            <tr>
                <td>Cash On Delivery : <form:checkbox path="cod" value="cod" id="paymentMethod"/>
                    <form:errors path="cod" cssClass="error"/></td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr align="center">
                <td colspan="2"><input type="submit" class="btnregister" value="Order"/></td>
            </tr>
        </table>
    </form:form>
</div>
<c:url value="/customerHome" var="home"/>
<button class="button button1"><a href="${home}">&laquo; Previous</a></button>
</body>
</html>
