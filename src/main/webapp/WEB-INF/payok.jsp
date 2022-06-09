<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.markuptag.com/bootstrap/5/css/bootstrap.min.css">
    <link rel="stylesheet" href="<c:url value="/static/css/HomePage.css" />">
    <link type="text/css" rel="stylesheet" href="/static/css/style.css">
	<link type="text/css" rel="stylesheet" href="/static/css/flexslider.css">
	<style type="text/css">
	</style>
	
</head>
<body>
<jsp:include page="navBar.jsp"/>
<!--cart-items-->
	<div class="cart-items">
		<div class="container">
		
			<c:if test="${msg!=null}"><div class="alert alert-success">${msg}</div></c:if>
			
			<p><a class="btn btn-success" href="order">check my order</a></p>
		</div>
	</div>


<jsp:include page="footer.jsp"/>

<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>--%>
<script type="text/javascript" src="/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="/static/js/cart.js"></script>
</body>
</html>