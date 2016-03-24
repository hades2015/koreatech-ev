<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- css -->
<link rel="stylesheet" href="/assets/css/bootstrap.min.css">

<!-- js -->
<script src="/assets/js/lib/jquery-1.12.0.min.js"></script>
<script src="/assets/js/lib/bootstrap.js"></script>

<!-- custom js -->
<script src="/assets/js/login.js"></script>
<script src="/assets/js/signup.js"></script>

<title>Login</title>

<style type="text/css">
html {
	margin: 0px;
	padding: 0px;
}

.container-fluid {
	width: 100%;
	height: 100%;
	background-image: url("assets/img/kev_bg.jpg");
	background-size: 100%;
	background-position: center;
}

#logoImg {
	margin: 20px;
	margin-top: 10%;
}

#loginBtn {
	margin: 10px;
}
</style>

</head>
<body>
	<div class="container-fluid">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12 text-center" id="logoImg">
					<img src="assets/img/kev_logo.jpg" />
				</div>
			</div>
			<div class="row text-center">
				<form method="post" id="login_form" action="login">

					<!-- spring security -->
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

					<div class="row">
						<div class="col-md-7">
							<!-- ID InputBox -->
							<div class="row">
								<div class="col-md-7"></div>

								<div class="input-group col-md-5 text-center">
									<input class="form-control" type="text" id="userId" name="userId" placeholder="ID">
								</div>
							</div>

							<!-- PASSWORD InputBox -->
							<div class="row">
								<div class="col-md-7"></div>

								<div class="input-group col-md-5">
									<input class="form-control" type="password" id="password" name="password" placeholder="PASSWORD">
								</div>
							</div>
						</div>

						<!-- LOGIN BUTTON -->
						<div class="col-md-5 text-left">
							<input id="loginBtn" class="btn btn-default btn-lg" type="submit" value="LOGIN">
						</div>
					</div>
				</form>
				<!-- 
				<a href="signup">
					<button class="btn btn-default btn-sm">Sign Up</button>
				</a>
				-->
				<!-- Button trigger modal -->
				<button type="button" class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal">SIGN UP</button>
				<a href="#">
					<button class="btn btn-default btn-sm">ID/PW찾기</button>
				</a>

				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h1 class="modal-title" id="myModalLabel">회원가입</h1>
							</div>
							<div class="modal-body">
								<div id="signup_container">
									<form method="post" id="sign_up_form" action="signup">
										<div class="form-group">
											<input type="text" class="form-control" id="user_id" name="userId" placeholder="ID"> <input type="password" class="form-control" id="password" name="password" placeholder="Password"> <input type="password" class="form-control" id="password" name="password-repeat"
												placeholder="Password Repeat"> <input type="text" class="form-control" id="user_name" name="userName" placeholder="Name"> <input type="text" class="form-control" id="nickname" name="nickname" placeholder="Nickname"> <input type="text" class="form-control"
												id="department" name="department" placeholder="department">
											<div class="radio">
												<label class="radio-inline"> <input type="radio" id="grade" name="grade" value="1">1학년
												</label> <label class="radio-inline"> <input type="radio" id="grade" name="grade" value="2">2학년
												</label> <label class="radio-inline"> <input type="radio" id="grade" name="grade" value="3">3학년
												</label> <label class="radio-inline"> <input type="radio" id="grade" name="grade" value="4">4학년
												</label>
											</div>
											<input type="text" class="form-control" id="student_nuumber" name="studentNumber" placeholder="studentNumber"> <input type="text" class="form-control" id="user_email" name="userEmail" placeholder="email">
											<ul class="message form-control"></ul>

											<input type="submit" id="sign_btn" class="btn btn-default btn-lg" value="SIGNUP">
											<button type="button" class="btn btn-default btn-lg" data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>