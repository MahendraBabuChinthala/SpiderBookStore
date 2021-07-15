<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Title</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans:400,500,300,700);

        * {
            font-family: Open Sans;
        }

        section {
            width: 100%;
            display: inline-block;
            background: #333;
            height: 50vh;
            text-align: center;
            font-size: 22px;
            font-weight: 700;
            text-decoration: underline;
        }

        .footer-distributed {
            background: #666;
            box-shadow: 0 1px 1px 0 rgba(0, 0, 0, 0.12);
            box-sizing: border-box;
            width: 100%;
            text-align: left;
            font: bold 16px sans-serif;
            padding: 55px 50px;
            height: 260px;
            margin-top: 166px;
        }

        .footer-distributed .footer-left,
        .footer-distributed .footer-center,
        .footer-distributed .footer-right {
            display: inline-block;
            vertical-align: top;
        }

        /*   / Footer left /*/

        .footer-distributed .footer-left {
            width: 40%;
        }

        /* / The company logo /*/

        .footer-distributed h3 {
            color: #ffffff;
            font: normal 36px 'Open Sans', cursive;
            margin: 0;
        }

        .footer-distributed h3 span {
            color: lightseagreen;
        }

        /*     / Footer links /*/

        .footer-distributed .footer-links {
            color: #ffffff;
            margin: 20px 0 12px;
            padding: 0;
        }

        .footer-distributed .footer-links a {
            display: inline-block;
            line-height: 1.8;
            font-weight: 400;
            text-decoration: none;
            color: inherit;
        }

        .footer-distributed .footer-company-name {
            color: #222;
            font-size: 14px;
            font-weight: normal;
            margin: 0;
        }

        /*   / Footer Center /*/

        .footer-distributed .footer-center {
            width: 35%;
        }

        .footer-distributed .footer-center i {
            background-color: #33383b;
            color: #ffffff;
            font-size: 25px;
            width: 38px;
            height: 38px;
            border-radius: 50%;
            text-align: center;
            line-height: 42px;
            margin: 10px 15px;
            vertical-align: middle;
        }

        .footer-distributed .footer-center i.fa-envelope {
            font-size: 17px;
            line-height: 38px;
        }

        .footer-distributed .footer-center p {
            display: inline-block;
            color: #ffffff;
            font-weight: 400;
            vertical-align: middle;
            margin: 0;
        }

        .footer-distributed .footer-center p span {
            display: block;
            font-weight: normal;
            font-size: 14px;
            line-height: 2;
        }

        .footer-distributed .footer-center p a {
            color: lightseagreen;
            text-decoration: none;;
        }

        .footer-distributed .footer-links a:before {
            content: "|";
            font-weight: 300;
            font-size: 20px;
            left: 0;
            color: #fff;
            display: inline-block;
            padding-right: 5px;
        }

        .footer-distributed .footer-links .link-1:before {
            content: none;
        }

        /*   / Footer Right /*/

        .footer-distributed .footer-right {
            width: 20%;
        }

        .footer-distributed .footer-company-about {
            line-height: 20px;
            color: #92999f;
            font-size: 13px;
            font-weight: normal;
            margin: 0;
        }

        .footer-distributed .footer-company-about span {
            display: block;
            color: #ffffff;
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        .footer-distributed .footer-icons {
            margin-top: 25px;
        }

        .footer-distributed .footer-icons a {
            display: inline-block;
            width: 35px;
            height: 35px;
            cursor: pointer;
            background-color: #33383b;
            border-radius: 2px;

            font-size: 20px;
            color: #ffffff;
            text-align: center;
            line-height: 35px;

            margin-right: 3px;
            margin-bottom: 5px;
        }

        /* home css tags*/
        body {
            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
        }

        .header-wrapper {

        }

        .price-match-guarantee {
            margin-left: 125px;
            margin-top: 0px;
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
            background-color: #293991;
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
<c:url value="http://localhost:8082/SpiderBookStore_war_exploded/customerRegistration" var="customerRegistration"/>

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
            <%--            <p class="login"></p>--%>
        <p style="margin-top:40px;margin-left:620px"><i class="fa fa-lock"></i><a href="login"><strong>Login<a
                href="customerRegistration"> / Register</a></strong></a></p></div>
    </c:if>
    <%-- after login hidde the login and display the user name --%>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <%--        <h5 style="color: #293991">--%>
        <div class="dropdown" style="position: inherit">
            <button class="dropbtn" style=" margin-left: 558px;"><strong>Hi :${firstName}</strong>
                    <%--                    ${pageContext.request.userPrincipal.name}--%>
                <i class="fa fa-caret-down"></i>
            </button>
            <c:url value="/getSingleCustomer" var="getSingleCustomer"/>
            <c:url value="/sellerPortal" var="sellerPortal"/>
            <div class="dropdown-content" style="margin-left: 565px">
                <a href="${getSingleCustomer}">Profile</a>
                <a href="${sellerPortal}">Seller portal</a>

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

<%-- All book List Data --%>
<c:url value="/getAllBooksData" var="getallBooksData"/>
<c:url value="/customerHome" var="home"/>
<div class="navbar">
    <div class="navbar-link-holder">
        <a href="${home}" style="margin-left: 80px">HOME</a>
        <a href="spiderBookStoreAboutUs" style="margin-left: 80px">ABOUT/CONTACT US</a>
    </div>
</div>
<table>
    <tr>
        <td><img
                src="https://www.impactplus.com/hs-fs/hubfs/blog-image-uploads/best-about-us-pages.jpg?length=980&name=best-about-us-pages.jpg"
                style="Width:133% ; height: 300px;"></td>
    </tr>
</table>
<br>
<br>
<h3 align="center">About Spider Book Store</h3>
<table>
    <tr>
        <td><img
                src="https://s3-ap-southeast-1.amazonaws.com/filehost.sapnaonline.com/widgets/1612357848759_1588913350151_collase-teen.webp"
                style="height:453Px;width:240%"></td>
        <td>
            <div style="color: #1abc9c;text-align: left;font-size:30px;margin-left: 230px;margin-top: -10px;">
                Spider Book Store is India's largest books retailer
            </div>
            <br>
            <p style="font-size: medium;margin-left: 248px;">This site has millions of new and used books for sale,
                including many signed books by famous authors. It also has an ISBN search engine for textbooks, lots of
                50% to 60% off sales, and also sells rare books and art books.</p>
            <p style="font-size: medium;margin-left: 248px;"> Whether you want an eBook, a non-fiction biography, or a
                fantasy novel, you can feel good about your purchase when you shop here; for every purchase you make,
                this store will donate a book to a person in need!</p>
            <p style="font-size: medium;margin-left: 248px;">This one probably doesn’t even need an introduction; Amazon
                is the world’s largest and most popular retailer and has an enormous selection of novels, textbooks,
                Kindle books, audio books, and second-hand books more.</p>
            <p style="font-size: medium;margin-left: 248px;"> With frequent flash sales, special offers, discounts, and
                other deals, you can find a wide variety of books at inexpensive prices at this UK-based website.</p>
        </td>
    </tr>
</table>
<%--footer--%>
<footer class="footer-distributed">

    <div class="footer-left">

        <h3>Spider Book<span> Store</span></h3>

        <p class="footer-links">
            <c:url value="/customerHome" var="home"/>
            <a href="${home}" class="link-1">Home</a>
            <c:url value="/spiderBookStoreAboutUs" var="about"/>
            <a href="${about}">About</a>

            <a href="#">Contact</a>
        </p>

        <p class="footer-company-name">Spider Book Store © 2015</p>
    </div>

    <div class="footer-center">

        <div>
            <i class="fa fa-map-marker"></i>
            <p><span>#8-3-973/1. Hyderabad</span> Telangana, India</p>
        </div>

        <div>
            <i class="fa fa-phone"></i>
            <p>+1.555.555.5555</p>
        </div>

        <div>
            <i class="fa fa-envelope"></i>
            <p><a href="mailto:support@company.com">spiderbookstore@shopping.com</a></p>
        </div>

    </div>

    <div class="footer-right">

        <p class="footer-company-about">
            <span>About the company</span>
            This big box store actually has a solid selection of popular books online, many of which sell for less then
            retail cost.
        </p>

        <div class="footer-icons">

            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
            <a href="#"><i class="fa fa-github"></i></a>

        </div>

    </div>

</footer>
</body>
</html>