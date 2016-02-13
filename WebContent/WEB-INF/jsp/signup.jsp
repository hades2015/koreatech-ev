<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="contents">
		<form method="post" id="sign_up_form" action="signup">
			<input type="text" id="user_id" name="userId" placeholder="ID"><br>
			<input type="password" id="password" name="password" placeholder="Password"><br>
			<input type="text" id="name" name="name" placeholder="Name"><br>
			<input type="text" id="nickname" name="nickName" placeholder="NickName"><br>
			<input type="text" id="department" name="department" placeholder="department"><br>
			<input type="radio" id="grade" name="grade" value="1">1학년
			<input type="radio" id="grade" name="grade" value="2">2학년
			<input type="radio" id="grade" name="grade" value="3">3학년
			<input type="radio" id="grade" name="grade" value="4">4학년<br>
			<input type="text" id="student_nuumber" name="studentNumber" placeholder="studentNumber"><br>
			<input type="text" id="email" name="email" placeholder="email"><br>
			<input type="submit" value="Sign Up"><br>
		</form>
		<a href="login">Go to Login</a>
	</div>
</body>
</html>