$("#registerForm").ajaxForm({
    success: function(response, statusText, xhr, $form)  {
        console.log(response);
        if(response == null || response.username == null) {
            printAuthenticationFail();
        } else {
            document.location.href = "/";
        }
    },
    error: function(response, statusText, error, $form)  {
        if(response != null) {
            printAuthenticationFail();
        } else {
            printNetworkIssue();
        }
    }
});

$("#RegisterFormModal").on("hidden.bs.modal", function () {
    $("#registerError").html("")
})


function printAuthenticationFail() {
    $("#registerError").html("Duplicate Username")
}

function printNetworkIssue() {
    $("#registerError").html("Network Issue")
}
