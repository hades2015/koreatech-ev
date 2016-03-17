"use strict";

var signupValidation = (function() {
	// module variables
	var domCacheMap = {
		$container : null,
		$form : null,
		$userId : null,
		$password : null,
		$passwordRepeat : null,
		$userName : null,
		$nickname : null,
		$department : null,
		$grade : 0,
		$studentNumber : null,
		$email : null,
		$message : null,
	}, statusMap = {
		userId : false,
		password : false,
		passwordRepeat : false,
		//userName : false,
		nickName : false,
		//department : false,
		//studentNumber : false,
		email : false
	}, 
	init, 						_validate, 			_isEmptyInput, 
	_isPasswordDifferent, 		_isPasswordWeak, 	_checkPasswordStrong, 
	_onUserIdKeyUpHandler,	_clearMessage, 		_onSubmitSignUpForm, 
	_onEmailKeyUpHandler, 		_checkId, 			_onPasswordKeyUpHandler, 
	_onPasswordRepeatKeyUpHandler, 					_onNickNameKeyUpHandler;

	// event handlers
	_onNickNameKeyUpHandler = function() {
		$(this).removeClass("error correct");
		_clearMessage();

		if ($(this).val() === "") {
			$(this).addClass("error");
			domCacheMap.$message
				.append("<li>Input name</li>")
				.show();
			statusMap.nickname = false;
		} else {
			$(this).addClass("correct");
			statusMap.nickName = true;
		}
	};
	_onEmailKeyUpHandler = function() {
		var regx = /.+@.+\..+/, result = regx.test($(this).val());
		
		$(this).removeClass("error correct");
		_clearMessage();
		
		if (!result) {
			$(this).addClass("error");
			domCacheMap.$message.append("<li>Invalid Email</li>").show();
			statusMap.email = false;
		} else {
			var domain = $(this).val().split("@")[1];
			if("kut.ac.kr" === domain || "koreatech.ac.kr" === domain) {
				$(this).addClass("correct");
				statusMap.email = true;
			} else {
				$(this).addClass("error");
				domCacheMap.$message.append("<li>Only Koreatech studnets. Use Koreatech Email</li>").show();
				statusMap.email = false;
			}
		}
	};
	_onPasswordKeyUpHandler = function() {
		$(this).removeClass("error correct");
		_clearMessage();

		if (_isPasswordWeak()) {
			domCacheMap.$message
					.append("<li>Too short password (min : 6)</li>").show();
			$(this).addClass("error");
			statusMap.password = false;
		} else {
			$(this).addClass("correct");
			statusMap.password = true;
		}
	};
	_onPasswordRepeatKeyUpHandler = function() {
		$(this).removeClass("error");
		_clearMessage();

		if (_isPasswordDifferent() && statusMap.password) {
			domCacheMap.$message.append("<li>Confirm password repeat</li>")
					.show();
			domCacheMap.$password.addClass("error");
			domCacheMap.$passwordRepeat.addClass("error");
			statusMap.passwordRepeat = false;
		} else if (statusMap.password) {
			$(this).addClass("correct");
			statusMap.passwordRepeat = true;
		}
	};
	
	_onUserIdKeyUpHandler = function() {
		if (statusMap.userIdKeyUpTemp !== null) {
			clearTimeout(statusMap.userIdKeyUpTemp);
		}

		statusMap.userIdKeyUpTemp = 
			setTimeout(_checkId.bind(this, this), 150);
	};
	
	_onSubmitSignUpForm = function(event) {
		event.preventDefault();
		var validationResult = _validate();

		if (validationResult) {
			$.post("/signup", {
				"userId" : domCacheMap.$userId.val(),
				"password" : domCacheMap.$password.val(),
				"password-repeat" : domCacheMap.$passwordRepeat.val(),
				"userName" : domCacheMap.$userName.val(),
				"nickname" : domCacheMap.$nickname.val(),
				"department" : domCacheMap.$department.val(),
				"grade" : domCacheMap.$grade.val(),
				"studentNumber" : domCacheMap.$studentNumber.val(),
				"userEmail" : domCacheMap.$userEmail.val(),
			}, "json")
			/*
			$.post("/signup", {
				"userId" : domCacheMap.$userId.val(),
				"password" : domCacheMap.$password.val(),
				"password-repeat" : domCacheMap.$passwordRepeat.val(),
				"userName" : domCacheMap.$userName.val(),
				"nickname" : domCacheMap.$nickname.val(),
				"department" : domCacheMap.$department.val(),
				"grade" : domCacheMap.$grade.val(),
				"studentNumber" : domCacheMap.$studentNumber.val(),
				"userEmail" : domCacheMap.$userEmail.val(),
			}, "json").done(
					function(responseJSON) {
						if (responseJSON.status === true) {
							location.href = responseJSON.redirectUrl;
						} else {
							domCacheMap.$container.effect("shake");
							for ( var key in responseJSON.messages) {
								if (responseJSON.messages.hasOwnProperty(key)) {
									domCacheMap.$message.append(
											"<li>" + 
											responseJSON.messages[key] + 
											"</li>");
								}
							}
							domCacheMap.$message.show();
						}
					});
			 */
		} else {
			domCacheMap.$container.effect("shake");
		}
	};

	// private methods
	_checkId = function(input) {
		var that = input;

		if ($(that).val().length < 4) {
			$(that).removeClass("error correct");
			_clearMessage();

			$(that).addClass("error");
			domCacheMap.$message.append("<li>Too short ID (min : 4)</li>")
					.show();
		} else {
			/*
			$.post("/student/check_id", {
				"userId" : $(that).val()
			}, "json").done(
					function(responseJSON) {
						$(that).removeClass("error correct");
						_clearMessage();

						switch (responseJSON.status) {
						case true:
							$(that).addClass("correct");
							statusMap.userId = true;
							break;
						case false:
							$(that).addClass("error");
							domCacheMap.$message.append(
									"<li>" + responseJSON.message + "</li>")
									.show();
							statusMap.userId = false;
						}
					});
			*/
			$(that).removeClass("error correct");
			_clearMessage();
			$(that).addClass("correct");
			statusMap.userId = true;
		}
	};
	_clearMessage = function() {
		domCacheMap.$message.html("").hide();
	};
	_isEmptyInput = function() {
		var inputs = domCacheMap.$form.children("input"), isOk = false;

		for (var i = 0, n = inputs.size(); i < n; i++) {
			if ($(inputs[i]).val() === "") {
				$(inputs[i]).addClass("error");
				isOk = true;
			}
		}

		return isOk;
	};
	_isPasswordDifferent = function() {
		var $password = domCacheMap.$password, 
			$passwordRepeat = domCacheMap.$passwordRepeat;

		return $password.val() !== $passwordRepeat.val();
	};
	_isPasswordWeak = function() {
		return _checkPasswordStrong(domCacheMap.$password.val()) === "weak";
	};
	_checkPasswordStrong = function(str) {
		var strongRegx = /.{6,}/;

		if (strongRegx.test(str)) {
			return "strong";
		} else {
			return "weak";
		}
	};
	_validate = function() {
		var isOk = statusMap.userId && statusMap.nickName &&
			statusMap.email && statusMap.password && statusMap.passwordRepeat;

		return isOk;
	};
	
	// public methods
	init = function($container) {
		// init Module
		domCacheMap.$container = $container;
		domCacheMap.$form = $container.find("form");
		domCacheMap.$userId = $container.find("input[name='userId']");
		domCacheMap.$password = $container.find("input[name='password']");
		domCacheMap.$passwordRepeat = $container.find("input[name='password-repeat']");
		domCacheMap.$userName = $container.find("input[name='userName']");
		domCacheMap.$nickname = $container.find("input[name='nickname']");
		domCacheMap.$department = $container.find("input[name='department']");
		domCacheMap.$grade = $container.find("input[name='grade']");
		domCacheMap.$studentNumber = $container.find("input[name='studentNumber']");
		domCacheMap.$userEmail = $container.find("input[name='userEmail']");
		domCacheMap.$message = $container.find(".message");
		
		// Event Handling
		domCacheMap.$form.on("click", "input", function() {
			$(this).removeClass("error");
		});

		domCacheMap.$form.on("submit", _onSubmitSignUpForm);
		
		domCacheMap.$userId.on("keyup", _onUserIdKeyUpHandler);
		domCacheMap.$nickname.on("keyup", _onNickNameKeyUpHandler);
		domCacheMap.$userEmail.on("keyup", _onEmailKeyUpHandler);
		domCacheMap.$password.on("keyup", _onPasswordKeyUpHandler);
		domCacheMap.$passwordRepeat.on("keyup", _onPasswordRepeatKeyUpHandler);
	};

	return {
		init : init,
	};
}());

$(document).ready(function() {
	signupValidation.init($("#signup_container"));
});