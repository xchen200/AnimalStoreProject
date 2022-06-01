<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>
    <link rel="stylesheet" href="css/HomePage.css">
    <script type="module" src="js/HomePage.js"></script>
</head>
<body>

<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <a href="#">About</a>
    <a href="login">Login</a>
    <a href="Register.html">Register</a>
    <a href="#">Contact</a>
</div>

<div id="main">
    <div id="username">Please Login in</div>
    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; Home Page</span>
    <div>
        <table cellpadding="15" cellspacing="15">
            <tr>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="https://www.thesprucepets.com/thmb/jEiwPDlnI60tZuCNO0wi5Q-Hj4A=/941x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Akita-GettyImages-588622984-533e955df9214301a56b4c0689b32114-b756891eac2445059cbd59430dbff7e2.jpeg">
                </a></td>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="https://vetstreet.brightspotcdn.com/dims4/default/e577587/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F62%2F35%2Fcabe34064904a472dfdd450b7fee%2Fakita-AP-1BY6BI-645sm71113.jpg">
                </a></td>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="data:image/jpeg;base64,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">
                </a></td>
            </tr>
            <tr>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="https://www.dogtime.com/assets/uploads/2011/01/file_22906_akita.jpg">
                </a></td>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="https://cdn.pixabay.com/photo/2020/11/21/08/34/akita-5763408__340.jpg">
                </a></td>
                <td><a href="AnimalDetails.html"><img width="300" height="200" src="https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F47%2F2021%2F05%2F27%2Fakita-puppy-snow-187024570-2000.jpg">
                </a></td>
            </tr>
        </table>
    </div>
</div>


</body>
</html>