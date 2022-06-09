<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

	<!--cart-items-->
	<div class="cart-items">
		<div class="container">
		
		<c:if test="${msg!=null}"><div class="alert alert-success">${msg}</div></c:if>
		<c:if test="${orderList!=null}">
			<h2>my order</h2>
			
				<table class="table table-bordered table-hover">

				<tr>
					<th width="10%">ID</th>
					<th width="10%">total</th>
					<th width="20%">product details</th>
					<th width="20%">delivery information</th>
					<th width="10%">Order Status</th>
					<th width="10%">payment method</th>
					<th width="10%">order time</th>
					<!-- <th width="10%">operate</th> -->
				</tr>
				<c:forEach var="order" items="${orderList}">
			         <tr>
			         	<td><p>${order.id}</p></td>
			         	<td><p>${order.total}</p></td>
			         	<td>
				         	<c:forEach var ="item" items="${order.itemList}">
					         	<p>${item.animal.name}(${item.price}) x ${item.amount}</p>
				         	</c:forEach>
			         	</td>
			         	<td>
			         		<p>${order.name}</p>
			         		<p>${order.phone}</p>
			         		<p>${order.address}</p>
			         	</td>
						<td>
							<p>
								<c:if test="${order.status==1}">Unpaid</c:if>
								<c:if test="${order.status==2}"><span style="color:red;">Paid</span></c:if>
								<c:if test="${order.status==3}">in delivery</c:if>
								<c:if test="${order.status==4}">completed</c:if>
							</p>
						</td>
						<td>
							<p>
								<c:if test="${order.paytype==1}">wechat</c:if>
								<c:if test="${order.paytype==2}">Alipay</c:if>
								<c:if test="${order.paytype==3}">cash on delivery</c:if>
							</p>
						</td>
						<td><p><fmt:formatDate value="${order.systime}" pattern="yyyy-MM-dd HH:mm:ss" /></p></td>
						<%-- <td>
							<c:if test="${order.status==1}">
								<a class="btn btn-success" href="topay?orderid=${order.id}">支付</a>
							</c:if>
						</td> --%>
			       	</tr>
				</c:forEach>
			     
			</table>
			
			</c:if>
			<c:if test="${orderList==null}"><div class="alert alert-info">空空如也</div></c:if>
			
		</div>
	</div>
	<!--//cart-items-->	

	


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