<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>

<div class="container">
    <div class="col-lg-6 mx-auto text-center pb-4">
        <p class="lead"> Explore popular seller posts</p>
    </div>
    <div class="row" data-masonry='{"percentPosition": true }'>
        <c:forEach var="element" items="${pageElements}">
            <div class="col-md-3">
                <div class="card my-3">
                    <c:if test="${element.imageUrl != null}">
                        <img src="${element.imageUrl}" class="img-fluid" alt="thumbnail">
                    </c:if>
                    <div class="card-body">
                        <c:if test="${element.type == 'animal'}">
                            <h3 class="card-title">${element.name}</h3>
                            <p class="card-text">type: ${element.animalType}</p>
                            <p class="card-text">price: $${element.price}</p>
                            <a href="/animalDetail?id=${element.id}" class="btn btn-primary">Read More</a>
                        </c:if>
                        <c:if test="${element.type == 'post'}">
                            <p class="card-text">${element.post}</p>
<%--                            <a href="#" class="btn btn-primary">Read More</a>--%>
                        </c:if>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>
</body>
</html>