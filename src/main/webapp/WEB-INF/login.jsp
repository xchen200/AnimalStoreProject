<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="css/Login.css">
    <script type="module" src="js/Login.js"></script>
</head>
<body>
<h2>Login</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Login</button>

<div id="id01" class="modal">

    <form class="modal-content animate" action="login">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
            <img src="https://static.runoob.com/images/mix/img_avatar.png" alt="Avatar" class="avatar">
        </div>

        <div class="container">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" id="username" required
                value="<c:out value='{customer.username}' />" />

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" id="password" required
                   value="<c:out value='{customer.password}' />" />

            <input type="submit" >Login</input>
            <input type="checkbox" checked="checked"> Remember Me
        </div>

        <div class="container" style="background-color:#f1f1f1">
            <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">
                Cancel
            </button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>
    </form>
</div>


</body>
</html>
