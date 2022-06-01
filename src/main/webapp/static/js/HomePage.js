import {getLoginInfo, setCookie} from "./Common.js";

function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.getElementById("main").style.marginLeft= "0";
}

window.onload = function () {
    let username = getLoginInfo();
    if (username != "") {
        document.getElementById("username").innerText = username;
    }
}

window.openNav = openNav;
window.closeNav = closeNav;