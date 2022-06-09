<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <script type="module" src="<c:url value="/static/js/Register.js" />"></script>
</head>
<body>

<div class="modal fade" id="RegisterFormModal" tabindex="-1" aria-labelledby="RegisterFormModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal" aria-label="Close"></button>
                <div class="myform bg-dark">
                    <h1 class="text-center">Register Form</h1>
                    <form id="registerForm" action="register" method="post">
                        <div class="mb-3 mt-4">
                            <label for="exampleInputUsername1" class="form-label">Username</label>
                            <input type="text" class="form-control" id="exampleInputUsername1" name="username">
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" name="password">
                        </div>
                        <button type="submit" class="btn btn-light mt-3">Register</button>
                        <p id="registerError"></p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>