import {ajax, setCookie} from "./Common.js";

var modal = document.getElementById('id01');
var domain = "http://localhost:5001/"

// window.onclick = function(event) {
//     if (event.target == modal) {
//         modal.style.display = "none";
//     }
// }

function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var req = {
        username: username,
        password: password
    }
    ajax("GET",
        domain + "login",
        req,
        returnHomePage,
        handleError);
}

function returnHomePage(msg) {
    var jsonObj = JSON.parse(msg);

    var username = jsonObj.name;

    setCookie("username", username);

    alert("Login successful with " + username)

    window.location.replace("http://localhost:5001/")
}

function handleError() {
    alert("username and password mismatch, pls re-enter");
}

window.login = login;

