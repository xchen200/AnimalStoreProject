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

<%--Header--%>
<div class="px-4 pt-5 mt-5 pb-2 mb-2 text-center">
    <h1 class="display-5 fw-bold">Explore pets you are interested in</h1>
    <div class="col-lg-6 mx-auto">
        <p class="lead mb-2"> Animal Store provides all kinds of pets at lowest price in the United States</p>
    </div>
</div>
<div class="cart-items">
		<div class="container">
		
		<c:if test="${msg!=null}"><div class="alert alert-success">${msg}</div></c:if>
		<c:if test="${order!=null}">
			<h2>my cart</h2>
			
			<c:forEach var="item" items="${order.itemList}">
				<div class="cart-header col-md-6">
					<div class="cart-sec simpleCart_shelfItem">
						<div class="cart-item cyc">
							<a href="detail?goodid=${item.animal.id}">
								<img src="${item.animal.pictureUrl}" class="img-responsive">
							</a>
						</div>
						<div class="cart-item-info">
							<h3><a href="detail?goodid=${item.animal.id}">${item.animal.name}</a></h3>
							<h3><span>price: ¥ ${item.animal.price}</span></h3>
							<h3><span>count: ${item.amount}</span></h3>
							<a class="btn btn-info" href="javascript:buy(${item.animal.id});">add</a>
							<a class="btn btn-warning" href="javascript:lessen(${item.animal.id});">reduce</a>
							<a class="btn btn-danger" href="javascript:deletes(${item.animal.id});">delete</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
			</c:forEach>
			
			<div class="cart-header col-md-12">
				<hr>
				<h3>The total amount of orders: ¥ ${order.total}</h3>
				<a class="btn btn-success btn-lg" style="margin-left:74%" href="save">submit order</a>
			</div>
			</c:if>
			<c:if test="${order==null}"><div class="alert alert-info">empty</div></c:if>
			
		</div>
	</div>
	


<jsp:include page="footer.jsp"/>

<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>--%>
<script type="text/javascript" src="/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="/static/js/cart.js"></script>
</body>
</html>