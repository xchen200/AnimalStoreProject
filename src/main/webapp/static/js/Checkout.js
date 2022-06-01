import {CheckoutPayload} from "./CheckoutPayload.js";

function displayEnteredData() {
    let fname = document.getElementById("fname").value;
    let lname = document.getElementById("lname").value;
    let address = document.getElementById("address").value;
    let apartment = document.getElementById("apt").value;
    let city = document.getElementById("city").value;
    let zipCode = document.getElementById("zip").value;
    let mobile = document.getElementById("mobile").value;
    let email = document.getElementById("email").value;
    let payment = document.getElementById("payment").value;
    let checkoutPayload = new CheckoutPayload(fname, lname, address, apartment, city, zipCode, mobile, email, payment);
    if (checkoutPayload.validate()) {
        alert("Successfully checkout");
    } else {
        alert("Checkout fail")
    }
}

window.displayEnteredData = displayEnteredData;