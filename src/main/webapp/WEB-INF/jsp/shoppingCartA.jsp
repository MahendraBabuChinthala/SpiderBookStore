<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <title>Shopping Cart</title>
    <style>
        html {
            background: white;
        }
        h3 {
            margin: 0px;
            padding: 0px;
        }
        body {
            max-width: 860px;
            min-width: 360px;
            margin: 0px auto;
            background: #F8F8F8;
            padding:0px 5px;
            text-align:center;
        }

        .page-title  {
            font-size:120%;
            text-align: left;
            margin:10px 0px;
        }
        .header-container {
            text-align: left;
            border-bottom: 1px solid #ccc;
            position: relative;
            background: #5f5f5f;
            color: white;
        }
        .header-container .header-bar  {
            position: absolute;
            right: 10px;
            bottom: 20px;
        }
        .header-container .header-bar  a  {
            color: white;
            font-size: bold;
        }

        .footer-container {
            text-align: center;
            margin-top: 10px;
            padding: 5px 0px 0px 0px;
            border-top: 1px solid #ccc;
        }
        .menu-container {
            text-align: right;
            margin: 10px 5px;
        }
        .menu-container a {
            margin: 5px 5px 5px 10px;
            color: #004d99;
            font-weight: bold;
            text-decoration: none;
        }

        .site-name {
            font-size:200%;
            margin:10px 10px 10px 0px;
            padding: 5px;
        }

        .container  {
            margin: 5px 0px;
        }

        .demo-container, .login-container, .account-container {
            padding: 5px;
            border: 1px solid #ccc;
            text-align:left;
            margin:20px 0px;
        }

        .customer-info-container {
            text-align: left;
            border: 1px solid #ccc;
            padding: 0px 5px;
        }
        .product-preview-container {
            border: 1px solid #ccc;
            padding: 5px;
            width: 250px;
            margin: 10px ;
            display: inline-block;
            text-align:left;
        }

        .product-preview-container input {
            width: 50px;
        }


        .product-image {
            width: 120px;
            height: 80px;
        }

        ul {
            list-style-type: none;
            padding-left: 5px;
            margin:5px;
        }


        .navi-item {
            margin: 5px 5px 5px 20px;
        }

        .button-update-sc {
            color: red;
            margin: 5px 5px 5px 20px;
        }

        .button-send-sc {
            color: red;
            margin: 5px 5px 5px 20px;
        }

        .error-message {
            font-size: 90%;
            color: red;
            font-style: italic;
        }

        .price {
            color: blue;
            font-weight: bold;
        }

        .subtotal {
            color: red;
            font-weight: bold;
        }

        .total {
            color: red;
            font-weight: bold;
            font-size: 120%;
        }

        table td {
            padding: 5px;
        }
    </style>
</head>
<body>
<fmt:setLocale value="en_US" scope="session"/>

<div class="page-title">My Cart</div>

<c:if test="${empty bookDto or empty bookDto.bookId}">
    <h2>There is no items in Cart</h2>
    <c:url value="/customerHome" var="productList"/>
    <a href="${productList}">Show
        Product List</a>
</c:if>

<c:if test="${not empty bookDto and not empty bookDto.bookId}">
    <form:form method="POST" modelAttribute="bookDto"
               action="${pageContext.request.contextPath}/shoppingCart">

      <%--  <c:forEach items="${bookDto}" var="bookDto">--%>
        <form:form method="POST" modelAttribute="bookDto" action="${pageContext.request.contextPath}/shoppingCart">
            <%--varStatus="varStatus"--%>
            <div class="product-preview-container">
                <ul>
                    <li><img class="product-image" src="https://wallpaperaccess.com/full/124378.jpg" />
                    </li>
                    <li>Code: ${bookDto.bookId} <%--<form:hidden
                            &lt;%&ndash;path="cartLines[${varStatus.index}].productInfo.code" />&ndash;%&gt;--%>

                    </li>
                    <li>Name: ${bookDto.bookName}</li>
                    <li>Price: <span class="price">

                         <fmt:formatNumber value="${bookDto.bookPrice}"/>

                       </span></li>
                    <li>Quantity: <%--<form:input
                            &lt;%&ndash;path="cartLines[${}}].quantity" /></li>&ndash;%&gt;--%>
                    <li>Subtotal:
                        <span class="subtotal">

                            <fmt:formatNumber value="${bookDto.bookPrice}"/>

                         </span>
                    </li>
                    <li>
                        <c:url value="/deleteBookCart" var="delete"/>
                        <a href="${delete}">
                        Delete </a></li>
                </ul>
            </div>
        </form:form>
        <div style="clear: both"></div>
        <input class="button-update-sc" type="submit" value="Update Quantity" />
        <a class="navi-item" href="${pageContext.request.contextPath}/shoppingCartCustomer">Enter Customer Info</a>
        <c:url value="/customerHome" var="home"/>
        <a class="navi-item" href="${home}">Continue
            Buy</a>
    </form:form>
</c:if>
</body>
</html>