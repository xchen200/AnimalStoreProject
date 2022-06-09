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

<%--Explore Region--%>

<div class="container">
    <div class="col-lg-6 mx-auto text-center">
        <p class="lead mt-4"> Explore by pets' kind</p>
    </div>
    <div class="row justify-content-md-center">
        <div class="col col-lg-3 py-4">
            <div class="card">
                <img class="card-img" src="/static/img/birman.jpg" alt="Sheep 9">
                <div class="card-img-overlay text-white d-flex justify-content-center align-items-end overlay-dark">
                    <p>Birman</p>
                </div>
            </div>
        </div>
        <div class="col col-lg-3 py-4">
            <div class="card">
                <img class="card-img" src="/static/img/bombay.jpg" alt="Sheep 9">
                <div class="card-img-overlay text-white d-flex justify-content-center align-items-end overlay-dark">
                    <p>Bombay</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row justify-content-md-center">
        <div class="col col-lg-3">
            <div class="card">
                <img class="card-img" src="/static/img/akita.jpg" alt="Sheep 9">
                <div class="card-img-overlay text-white d-flex justify-content-center align-items-end overlay-dark">
                    <p>Akita</p>
                </div>
            </div>
        </div>
        <div class="col col-lg-3">
            <div class="card">
                <img class="card-img" src="/static/img/alaskan.jpg" alt="Sheep 9">
                <div class="card-img-overlay text-white d-flex justify-content-center align-items-end overlay-dark">
                    <p>Alaskan Klee Kai</p>
                </div>
            </div>
        </div>
        <div class="col col-lg-3">
            <div class="card">
                <img class="card-img" src="/static/img/barbet.jpg" alt="Sheep 9">
                <div class="card-img-overlay text-white d-flex justify-content-center align-items-end overlay-dark">
                    <p>Barbet</p>
                </div>
            </div>
        </div>
    </div>
</div>

<%--Main Card Region--%>


<jsp:include page="animalList.jsp"/>


<jsp:include page="footer.jsp"/>

<script src="https://www.markuptag.com/bootstrap/5/js/bootstrap.bundle.min.js"></script>
<%--<script src="https://cdn.jsdelivr.net/npm/masonry-layout@4.2.2/dist/masonry.pkgd.min.js"></script>--%>
</body>
</html>