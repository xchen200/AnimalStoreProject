<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="<c:url value="/static/css/LoginModal.css" />">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <script src="https://malsup.github.io/jquery.form.js"></script>
    	<script type="text/javascript" src="/static/js/layer.js"></script>
    
    <style type="text/css">
    
    .glyphicon-shopping-cart:before {
	    content: "\e116";
	}
    .glyphicon {
	    position: relative;
	    top: 1px;
	    display: inline-block;
	    font-family: 'Glyphicons Halflings';
	    font-style: normal;
	    font-weight: normal;
	    line-height: 1;
	    -webkit-font-smoothing: antialiased;
	    -moz-osx-font-smoothing: grayscale;
	    font-size: 1.8em;
    color: #fff;
	}
    </style>
</head>
<body>

<jsp:include page="loginModal.jsp"/>
<jsp:include page="registerModal.jsp"/>

<nav class="navbar navbar-expand-md navbar-dark bg-dark" aria-label="Fourth navbar example">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Animal Store</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarsExample04">
            <ul class="navbar-nav me-auto mb-2 mb-md-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
                <c:if test="${pageContext['request'].userPrincipal.principal == null}">
                <li class="nav-item">
                    <a class="nav-link" href="" data-bs-toggle="modal" data-bs-target="#LoginFormModal">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="" data-bs-toggle="modal" data-bs-target="#RegisterFormModal">Register</a>
                </li>
                </c:if>
                <li class="nav-item">
					<a href="cart">
						<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"><span class="card_num">${order.amount==null ? '' :order.amount}</span></span>
					</a>
				</li>
                <c:if test="${pageContext['request'].userPrincipal.principal != null}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-bs-toggle="dropdown" aria-expanded="false">
                        ${pageContext['request'].userPrincipal.principal.username}
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdown04">
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li><a class="dropdown-item" href="/order">Order History</a></li>
                        <li><a class="dropdown-item" href="<c:url value="/logout" />">Logout</a></li>
                    </ul>
                </li>
                </c:if>
                <li  class="nav-item"><a class="nav-link" href="adminLogin" target="_blank">Backstage management</a></li>
            </ul>
            <form role="search">
                <input class="form-control" type="search" placeholder="Search" aria-label="Search">
            </form>
        </div>
    </div>
</nav>

</body>
</html>