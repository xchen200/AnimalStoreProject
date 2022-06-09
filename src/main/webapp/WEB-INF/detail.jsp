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
	.col-md-1, .col-md-2, .col-md-3, .col-md-4, .col-md-5, .col-md-6, .col-md-7, .col-md-8, .col-md-9, .col-md-10, .col-md-11, .col-md-12 {
	    float: left;
	}
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

	<div class="single">
		<div class="container">
			<div class="single-grids">				
				<div class="col-md-4 single-grid">		
					<div class="flexslider">
						<ul class="slides">
							<li data-thumb="${animal.pictureUrl}">
								<div class="thumb-image"> <img src="${animal.pictureUrl}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${animal.pictureUrl1}">
								 <div class="thumb-image"> <img src="${animal.pictureUrl1}" data-imagezoom="true" class="img-responsive"> </div>
							</li>
							<li data-thumb="${animal.pictureUrl2}">
							   <div class="thumb-image"> <img src="${animal.pictureUrl2}" data-imagezoom="true" class="img-responsive"> </div>
							</li> 
						</ul>
					</div>
				</div>	
				<div class="col-md-5 single-grid simpleCart_shelfItem">		
					<h3>${animal.name}</h3>
					<div class="tag">
						<p>Classification : <a href="#">${animal.animalType}</a>&nbsp;&nbsp;--&nbsp;&nbsp;<a href="#">${animal.getSubType()}</a></p>
					</div>
					<p>introduce: ${animal.intro}</p>
					<div class="galry">
						<div class="prices">
							<h5 class="item_price">$ ${animal.price}</h5>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="btn_form">
						<a href="javascript:;" class="add-cart item_add" onclick="buy(${animal.id})">add shopping cart</a>
					</div>
				</div>
				<div class="col-md-3 single-grid1">
					<!-- <h2>Categories</h2> -->
					<ul>
						<li><a href="#">Birman</a></li>
						<li><a href="#">Bombay</a></li>
						<li><a href="#">Akita</a></li>
						<li><a href="#">Alaskan Klee Kai</a></li>
						<li><a href="#">Barbet</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>


<jsp:include page="footer.jsp"/>

<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>--%>
<script type="text/javascript" src="/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="/static/js/cart.js"></script>
	<script>
		$(function() {
		  $('.flexslider').flexslider({
			animation: "slide",
			controlNav: "thumbnails"
		  });
		});
	</script>
</body>
</html>