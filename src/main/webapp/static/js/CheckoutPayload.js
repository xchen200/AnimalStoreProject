export class CheckoutPayload {
    constructor(fname, lname, address, apartment, city, zipCode, mobile, email, payment) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.apartment = apartment;
        this.city = city;
        this.zipCode = zipCode;
        this.mobile = mobile;
        this.email = email;
        this.payment = payment;
    }

    validate() {
        if (!this.validateMobile()) {
            alert("Wrong mobile format");
            return false;
        } else if (!this.validateEmail()) {
            alert("Wrong email format");
            return false;
        } else if (!this.validateZipCode()) {
            alert("Wrong zip code format");
            return false;
        } else {
            return true;
        }
    }

    validateEmail() {
        let pattern = /\S+@\S+\.\S+/;
        return pattern.test(this.email);
    }

    validateZipCode() {
        return this.zipCode.match(/[0-9]+/)
    }

    validateMobile() {
        let pattern = /^\d{10}$/;
        return pattern.test(this.mobile);
    }
}