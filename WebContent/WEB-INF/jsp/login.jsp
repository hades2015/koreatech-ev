<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<script src="assets/js/lib/jquery-1.12.0.min.js"></script>
<script src="assets/js/lib/bootstrap.js"></script>
<title>Login</title>

<style type="text/css">
html {
	margin: 0px;
	padding: 0px;
}

.container-fluid{
	width: 100%;
	height: 100%;
	background-image: url("assets/img/kev_bg.jpg");
	background-size: 100%;
	background-position: center;
}

#logoImg{
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
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center" id="logoImg">
					<img src="assets/img/kev_logo.jpg"/>
				</div>
			</div>
			<div class="row text-center">
				<form method="post" id="login_form" action="login">
					<div class="row">
						<div class="col-md-7">
							<!-- ID InputBox -->
							<div class="row">
								<div class="col-md-7"></div>

								<div class="input-group col-md-5 text-center">
									<input class="form-control" type="text" id="userId"
										name="userId" placeholder="ID">
								</div>
							</div>

							<!-- PASSWORD InputBox -->
							<div class="row">
								<div class="col-md-7"></div>

								<div class="input-group col-md-5">
									<input class="form-control" type="password" id="password"
										name="password" placeholder="PASSWORD">
								</div>
							</div>
						</div>

						<!-- LOGIN BUTTON -->
						<div class="col-md-5 text-left">
							<input id="loginBtn" class="btn btn-default btn-lg" type="submit"
								value="LOGIN">
						</div>
					</div>
				</form>
				<a href="signup"><button class="btn btn-default btn-sm">Sign Up</button></a>
				<a href="#"><button class="btn btn-default btn-sm">ID/PW찾기</button></a>
			</div>
		</div>
	</div>
</body>
</html>