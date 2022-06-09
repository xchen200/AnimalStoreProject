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
	        padding-right: 15px;
    padding-left: 15px;
	}
	.thumbnail {
    display: block;
    padding: 4px;
    margin-bottom: 20px;
    line-height: 1.42857143;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 4px;
    }
    .thumbnail a > img {
    margin-right: auto;
    margin-left: auto;
    max-width: 100%;
    height: auto;
}

	</style>
	
</head>
<body>
<jsp:include page="navBar.jsp"/>

	<div class="cart-items">
		<div class="container">
			<h2>Confirm receipt information</h2>
			<form class="form-horizontal" action="pay" method="post" id="payform">
				<input type="hidden" name="id" value="${order.id}">
				<input type="hidden" name="paytype" id="paytype">
				<div class="row">
					<label class="control-label col-md-1">Receiver</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="name" value="${user.name}" style="height:auto;padding:10px;" placeholder="Enter consignee" required="required" id="fname"><br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1">delivery phone</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="phone" value="${user.phone}" style="height:auto;padding:10px;" placeholder="Enter delivery phone" required="required" id="fphone"><br>
					</div>
				</div>
				<div class="row">
					<label class="control-label col-md-1">Shipping address</label>
					<div class="col-md-6">
						<input type="text" class="form-control" name="address" value="${user.address}" style="height:auto;padding:10px;" placeholder="Enter shipping address" required="required" id="faddress"><br>
					</div>
				</div>
			</form>
			
			<br><hr><br>
			
			<h2>Select Payment Method</h2>
			<h3>order id: ${order.id}  Payment amount: ${order.total}</h3><br><br>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="javascript:dopay(1);"> 
						<img src="/static/img/wechat.jpg" alt="WeChat Pay">
					</a>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="javascript:dopay(2);"> 
						<img src="/static/img/alipay.jpg" alt="pay by AliPay">
					</a>
				</div>
			</div>
			<div class="col-sm-6 col-md-4 col-lg-3 ">
				<div class="thumbnail">
					<a href="javascript:dopay(3);"> 
						<img src="/static/img/offline.jpg" alt="cash on delivery">
					</a>
				</div>
			</div>
		</div>
	</div>

	


<jsp:include page="footer.jsp"/>
<script type="text/javascript">
	function dopay(paytype){
		// information verification
		var name = $("#fname").val();
		if(name==null || name==""){
			layer.msg("Please fill in the consignee correctly!");
			return;
		}
		var phone = $("#fphone").val();
		if(phone==null || phone=="" || !/^[0-9]*$/.test(phone)){
			layer.msg("Please fill in the delivery phone number correctly!");
			return;
		}
		var address = $("#faddress").val();
		if(address==null || address==""){
			layer.msg("Please fill in the shipping address correctly!");
			return;
		}
		
		$("#paytype").val(paytype);
		$("#payform").submit();
	}
</script>
<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>--%>
<script type="text/javascript" src="/static/js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="/static/js/cart.js"></script>
</body>
</html>