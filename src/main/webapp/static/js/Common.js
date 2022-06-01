export function ajax(method, url, data, callback, errorHandler) {
    var xhr = new XMLHttpRequest();
    if (data != null) {
        url += '/'
        for(let key in data) {
            url += (key + '/' + data[key] + '/');
        }
        url = url.substr(0, url.length -1);
    }
    xhr.open(method, url, true);
    xhr.onload = function() {
        if (xhr.status == 200) {
            if(callback != null) {
                callback(xhr.responseText);
            }
        } else {
            if(errorHandler != null) {
                errorHandler();
            }
        }
    };
    xhr.onerror = function() {
        if (errorHandler != null) {
            errorHandler();
        }
    };
    xhr.send();
}

export function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i< ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if(c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

export function getLoginInfo() {
    return getCookie("username");
}

export function setCookie(key, value) {
    const d = new Date();
    d.setTime(d.getTime() + 10 * 60 * 1000);
    let expires = "expires=" + d.toUTCString();
    document.cookie = key + "=" + value + ";" + expires + ";path=/";
}