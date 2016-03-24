/**
 * 
 */
"use strict";

var loginValidation = (function() {
    // module variables
    var domCacheMap = {
            $container: null,
            $form: null,
            $userId: null,
            $password: null,
            $message: null,
        },
        statusMap = {},
        init, _validate, _onSubmitLoginForm;

    // event handlers
    _onSubmitLoginForm = function(event) {
        event.preventDefault();
        domCacheMap.$message.html("").hide();

        if (_validate()) {
            $.post("/login", {
                "userId" : domCacheMap.$userId.val(),
                "password" : domCacheMap.$password.val(),
            }, "json").done(function(responseJSON) {
            	if (responseJSON.statusCode === 200) { // OK
            		//$.cookie("LOGIN_TOKEN", responseJSON.token, { expires: 1, path: '/' });
                    location.href = "/evaluation";
                } else {
                	// TODO : Select (Error message and display shake) or (Move to Login fail view)  
                    //domCacheMap.$container.effect("shake");
                    domCacheMap.$message
                        .append("<li>" + responseJSON.message + "</li>")
                        .show();
                }
            });
        } else {
            //domCacheMap.$container.effect("shake");
        	alert("ERROR!!");
        }
    };

    // private methods
    _validate = function() {
        var $message = domCacheMap.$message,
            isOk = true;

        if (domCacheMap.$userId.val() === "") {
            domCacheMap.$userId.addClass("error");
            $message.append("<li>Enter Id</li>").show();
            isOk = false;
        }
        if (domCacheMap.$password.val() === "") {
            domCacheMap.$password.addClass("error");
            $message.append("<li>Enter Password</li>").show();
            isOk = false;
        }

        return isOk;
    };

    // public methods
    init = function($container) {
        // caching DOM objects
        domCacheMap.$container = $container;
        domCacheMap.$form = $container.find("form");
        domCacheMap.$userId = $container.find("input[name=userId]");
        domCacheMap.$password = $container.find("input[name=password]");
        domCacheMap.$message = $container.find(".message");

        // bind Event handler
        domCacheMap.$form.find("input").on("click", function() {
            $(this).removeClass("error");
        });
        domCacheMap.$form.on("submit", _onSubmitLoginForm);
    };

    return {
        init : init,
    };
}());

$(document).ready(function() {
	$('#myModal').modal('hide');
    loginValidation.init($("#login_container"));
});
