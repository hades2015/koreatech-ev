<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<script src="/assets/js/lib/jquery-1.12.0.min.js"></script>
<link rel="stylesheet" href="/assets/css/bootstrap.min.css">
<script src="/assets/js/lib/bootstrap.js"></script>

<style>
#logo_img {
	width: 20%;
	margin: 10px;
}

#student_info {
	margin-top: 10px;
}

.form-control {
	margin: 10px;
}
</style>

<div id="header">
	<div id="nav" class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<div class="wrap navbar-header navbar-left col-md-4">
				<a class="nav-brand" href="/evaluation"><img src="/assets/img/kev_logo.jpg" class="img-rounded" id="logo_img"></a>
			</div>
			<div class="nav navbar-nav col-md-4 text-left">
				<form class="navbar-form" role="search">
					<div id="nav-search" class="form-group">
						<input type="text" id="keyword" class="form-control" placeholder="Search">
					</div>
					<input type="button" class="btn btn-default btn-sm" value="SEARCH">
				</form>
			</div>
			<div id="student_info" class="col-md-4 text-right">
				<div class="row">
					<span>이름 : ${userName} </span>
					<span>학년 : ${grade} </span>
					<span>학부 : ${department} </span>
				</div>
				<div class="row">
					<a href="/user/update">정보수정</a> <a href="/logout">Logout</a>
				</div>
			</div>
		</div>
	</div>
</div>