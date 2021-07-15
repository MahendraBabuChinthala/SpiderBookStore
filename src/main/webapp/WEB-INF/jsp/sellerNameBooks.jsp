<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
    <title>Title</title>
    <style>
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
            margin-top: 19px;
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

        .banners {
            border: 1px white solid;
            width: 100%;
            height: 60px;
            display: flex;
            margin-top: 10px;
        }

        .banner1 {
            border: 1px white solid;
            margin-top: 7px;
            margin-left: 240px;
        }

        .banners img {
            float: left;
            margin-top: 10px;
        }

        .vertical-line-small-2 {
            border-left: 2px grey solid;
            margin-left: 50px;
            margin-right: 50px;
            margin-top: 10px;
            margin-bottom: 10px;
        }

        .banner2 {
            border: 1px white solid;
            margin-top: 7px;
        }

        .banner3 {
            border: 1px white solid;
            margin-top: 7px;
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

        .login {
            margin-left: 600px;
            margin-top: 0px;
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

        /*book List color*/

        @import url(https://fonts.googleapis.com/css?family=Lato:400,700);

        body {
            background: #F2F2F2;
            padding: 0;
            maring: 0;
        }

        #price {
            text-align: center;
        }

        .plan {
            display: inline-block;
            margin: 10px 1%;
            font-family: 'Lato', Arial, sans-serif;
        }

        .plan-inner {
            background: #fff;
            margin: 0 auto;
            min-width: 280px;
            max-width: 100%;
            position: relative;
        }

        .entry-title {
            background: #53CFE9;
            height: 140px;
            position: relative;
            text-align: center;
            color: #fff;
            margin-bottom: 30px;
        }

        .entry-title > h3 {
            background: #20BADA;
            font-size: 20px;
            padding: 5px 0;
            text-transform: uppercase;
            font-weight: 700;
            margin: 0;
        }

        .entry-title .price {
            position: absolute;
            bottom: -25px;
            background: #20BADA;
            height: 95px;
            width: 95px;
            margin: 0 auto;
            left: 0;
            right: 0;
            overflow: hidden;
            border-radius: 50px;
            border: 5px solid #fff;
            line-height: 80px;
            font-size: 28px;
            font-weight: 700;
        }

        .price span {
            position: absolute;
            font-size: 9px;
            bottom: -10px;
            left: 30px;
            font-weight: 400;
        }

        .entry-content {
            color: #323232;
        }

        .entry-content ul {
            margin: 0;
            padding: 0;
            list-style: none;
            text-align: center;
        }

        .entry-content li {
            border-bottom: 1px solid #E5E5E5;
            padding: 10px 0;
        }

        .entry-content li:last-child {
            border: none;
        }

        .btn {
            padding: 3em 0;
            text-align: center;
        }

        .btn a {
            background: #323232;
            padding: 10px 30px;
            color: #fff;
            text-transform: uppercase;
            font-weight: 700;
            text-decoration: none
        }

        .hot {
            position: absolute;
            top: -7px;
            background: #F80;
            color: #fff;
            text-transform: uppercase;
            z-index: 2;
            padding: 2px 5px;
            font-size: 9px;
            border-radius: 2px;
            right: 10px;
            font-weight: 700;
        }

        .basic .entry-title {
            background: #75DDD9;
        }

        .basic .entry-title > h3 {
            background: #44CBC6;
        }

        .basic .price {
            background: #44CBC6;
        }

        .standard .entry-title {
            background: #4484c1;
        }

        .standard .entry-title > h3 {
            background: #3772aa;
        }

        .standard .price {
            background: #3772aa;
        }

        .ultimite .entry-title > h3 {
            background: #DD4B5E;
        }

        .ultimite .entry-title {
            background: #F75C70;
        }

        .ultimite .price {
            background: #DD4B5E;
        }

        /*footer*/
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
            margin-top: 120px;
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

        h1 {
            font-size: 35px;
            color: #ffb20e;
            text-transform: uppercase;
            text-align: center;
            margin: 0 0 35px 0;
            text-shadow: 0px 1px 0px #f2f2f2;
        }

        h2 {
            font-size: 35px;
            color: #445668;
            text-transform: uppercase;
            text-align: center;
            margin: 0 0 35px 0;
            text-shadow: 0px 1px 0px #f2f2f2;
        }
    </style>
</head>
<body>
<c:url value="login" var="login"/>
<%--  Customer Registeration form url  --%>
<c:url value="http://localhost:8082/SpiderBookStore_war_exploded/customerRegistration" var="customerRegistration"/>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<header class="header-wrapper">
    <div class="header-part-2">

        <div class="logo"><img
                src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSHvMmB6eucEBEpPeMkHUb3ihzl-jYIZxNFRg&usqp=CAU"
                style="width:145px;height:101px"></div>
        <%--  website name spider book store    --%>
        <div class="price-match-guarantee"><a href=#><strong><p>Spider Book Store</p></strong></a></div>

        <%--  login and registration  --%>
        <c:if test="${pageContext.request.userPrincipal.name == null}">

        <p style="margin-top:40px;margin-left:620px"><i class="fa fa-lock"></i><a href="login"><strong>Login<a
                href="customerRegistration"> / Register</a></strong></a></p></div>
    </c:if>
    <%-- after login hidde the login and display the user name --%>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div class="dropdown">
            <button class="dropbtn" style=" margin-left: 600px;"><i class="fa fa-user"></i><strong>&nbsp;&nbsp;Hi
                :${firstName}</strong>

                <i class="fa fa-caret-down"></i>
            </button>
            <c:url value="/sellerPortal" var="sellerPortal"/>
            <c:url value="/getSingleCustomer" var="profile"/>
            <div class="dropdown-content" style="margin-left: 620px">
                <a href="${profile}">Profile</a>
                <a href="${sellerPortal}">Seller Portal</a>

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
<c:url value="/getSellerNameBooksData?email=${pageContext.request.userPrincipal.name}" var="sellerBooks"/>
<div class="navbar">
    <div class="navbar-link-holder">
        <c:url value="/customerHome" var="home"/>
        <c:url value="/sellerAddBook" var="sellerAddBook"/>
        <a href="${home}">HOME</a>
        <a href="${sellerAddBook}">Add Book</a>
        <a href="spiderBookStoreAboutUs">About us</a>
        <a href="${sellerBooks}">Your Book List</a>
        <a href="${getallBooksData}" hidden>All Books List</a>
    </div>
</div>

<div class="banners">
    <div class="banner1">
        <img src="https://cdn2.bigcommerce.com/server300/3954e/product_images/uploaded_images/truck.png">&nbsp;
        <strong>FREE DELIVERY*</strong><br>&nbsp;&nbsp;with coupon
    </div>
    <div class="vertical-line-small-2"></div>
    <div class="banner2">
        <img src="https://cdn2.bigcommerce.com/server300/3954e/product_images/uploaded_images/price-match.png">&nbsp;
        <strong>PRICE MATCH</strong><br>&nbsp;&nbsp;Guarantee
    </div>
    <div class="vertical-line-small-2"></div>
    <div class="banner3">
        <img src="https://cdn2.bigcommerce.com/server300/3954e/product_images/uploaded_images/dispatch.png">&nbsp;
        <strong>SAME DAY DISPATCH</strong><br>&nbsp;&nbsp;before 1pm (Mon-Fri)
    </div>
    <div class="vertical-line-small-2"></div>
    <div class="banner3">
        <img src="https://cdn2.bigcommerce.com/server300/3954e/product_images/uploaded_images/easy-return.png">&nbsp;
        <strong>EASY RETURN</strong><br>&nbsp;&nbsp;Policy
    </div>
</div>
<br>
<c:url value="/getBookByBookId/" var="getBookByBookId"/>
<h1 align="center">SELLER BOOKS LIST</h1>
<br>
<%-- List Of Books --%>
<div id="price">
    <!--price tab-->
    <c:forEach var="book" items="${sellerNameBooksData}">
        <div class="plan ultimite">
            <div class="plan-inner">
                <div class="entry-title">
                    <h3><a href="${getBookByBookId}/${book.bookId}"> ${book.bookName}</a></h3>
                    <div class="price">${book.bookPrice}<span>/BOOK Price</span>
                    </div>
                </div>
                <div class="entry-content">
                    <ul>
                        <li><a href="${getBookByBookId}/${book.bookId}"><strong>BookId </strong> : ${book.bookId}</a>
                        </li>
                        <li><strong>Author </strong> : ${book.author}</li>
                        <li><strong>Description </strong> : ${book.description}</li>
                        <li><strong>PublishYear </strong> : ${book.publishYear}</li>
                        <li><strong>SellerName </strong> : ${book.sellerName}</li>
                        <li><strong>Publication </strong> : ${book.publication}</li>
                    </ul>
                </div>
                <div class="btn">
                    <c:url value="/editBook/${book.bookId}" var="Edit"/>
                    <c:url value="/deleteBookById/${book.bookId}" var="Delete"/>
                    <a href="${Edit}">Edit Book</a>
                    <a href="${Delete}">Delete</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<%-- footer --%>
<footer class="footer-distributed">
    <c:url value="/customerHome" var="home"/>
    <c:url value="/spiderBookStoreAboutUs" var="about"/>
    <div class="footer-left">
        <h3>Spider Book<span> Store</span></h3>
        <p class="footer-links">
            <a href="${home}" class="link-1">Home</a>
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
            Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus
            vehicula sit amet.</p>
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
