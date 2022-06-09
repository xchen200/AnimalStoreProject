$("#loginForm").ajaxForm({
    success: function(response, statusText, xhr, $form)  {
        console.log(response);
        if(response == null || response.principal == null || response.principal.username == null) {
            printAuthenticationFail();
        } else {
            document.location.href = "/";
        }
    },
    error: function(response, statusText, error, $form)  {
        if(response != null && response.message == "authentication-failure") {
            printAuthenticationFail();
        } else {
            printNetworkIssue();
        }
    }
});

$("#LoginFormModal").on("hidden.bs.modal", function () {
    $("#loginError").html("")
})

function printAuthenticationFail() {
    $("#loginError").html("Username or Password Error")
}

function printNetworkIssue() {
    $("#loginError").html("Network Issue")
}

