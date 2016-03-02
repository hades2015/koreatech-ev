<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EV::Home</title>
<link rel="icon" href="/assets/img/favicon.ico" />
<link rel="stylesheet" type="css/text" href="/assets/css/normalize.css">
<link rel="stylesheet" type="css/text" href="/assets/css/global.css">
<style>
* {
	//outline: 1px dashed red;
}

#project_header {
	padding: 15px 0;
	border-bottom: 2px solid #ccc;
}

#content-container {
	display: table;
	width: 100%;
}

#side_nav, #contents {
	display: table;
	float: left;
}

#side_nav {
	width: 200px;
	min-height: 500px;
}

#contents {
	box-sizing: border-box;
	padding-left: 15px;
	width: 685px;
}

#side_nav ul li a {
	display: block;
	width: 100%;
	padding: 10px 0;
	transition-property: margin;
	transition-duration: .2s;
	font-size: 15px; 
	font-weight: 800;
}

#side_nav ul li a:hover, #side_nav ul li.on a{
	margin-left:5px;
	color: #ec581b;
	text-decoration: none;
}

#issue_list_container ul li a{
	width: 100%;
	min-height: 60px;
	display: block;
	padding: 15px 0;
	border-bottom:1px solid #ddd;
}

#issue_list_container ul li a:hover {
	background-color: #f4f4f4;
	text-decoration: none;
}

#project_util_container {
	width: 100%;
	text-align: right;
}

#project_util_container .btn {
	display: inline-block;
	margin-left: 15px;
	font-size: 13px;
	font-weight: 800;
}

#project_util_container a:hover {
	text-decoration: none;
}

.issue_inner {
	position: relative;
	display: block;
	float: left;
}

.issue_info_container {
	margin-left: 10px;
}

.issue_info_container .issue_title {
	font-weight: 800;
}

.issue_author {
	position:relative;
	font-weight: 300;
	font-size: 13px;
	margin-top:5px;
	color: #bababa;
}

.state_box {
	position: relative;
	display: table-cell;
	width: 80px;
	height: 45px;
	background-color: #1fbd91;
	border-radius: 2px;
	color: #fff;
	font-size: 13px;
	font-weight: 800;
	text-align:center;
	vertical-align:middle;
}

.state_box.closed {
	background-color: #5f5f5f;
}

.state_box.assign {
	background-color: #f3a726;
}

.state_box span{
	width: 80px;
	height: 45px;
	overflow: hidden;
	word-break: break-all;
	top: 50%;
	margin-top: -20px;
}

#pagination {
	margin-top: 15px;
	text-align: center;
}

#pagination .btn {
	display: inline-block;
}

#member_menu {
	border-top: 1px solid #ccc;
	margin: 15px 0;
	padding: 15px 0;
}

#member_menu span.title {
	font-size: 12px;
	font-weight: 800;
}

#member_menu #member_input_box {
	padding: 5px 0;
}

#member_menu ul {
	height: 150px;
	overflow-y: scroll;
}

#member_menu ul li {
	font-size: 13px;
	font-weight: 300;
	color: #bababa;
	padding: 5px 10px;
	border-bottom: 1px solid #ccc;
	cursor: pointer;
}

.msg {
	font-weight: 800;
	font-size: 13px;
	color: red;
}

#issue_list_filter {
	padding: 10px 15px;
	background-color: #e5e5e5;
	outline: 1px solid #ddd;
	text-align: right;
}

</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/shared/header.jsp" flush="false" />
	<div class="container">
		<div id="evaluation_header">
			<a href="/evaluation/create" class="btn btn-sm">강의평가 작성하기</a>
		</div>
		<div id="content-container">
			<div id="side_nav">
				<ul id="side_menu">
					<li class="on"><a href="#none">강의평가</a></li>
					<li><a href="#none">질문 게시판</a></li>
					<li><a href="#none">커리큘럼</a></li>
					<li><a href="#none">시간표 관리</a></li>
				</ul>
			</div>

			<div id="contents">
				<div id="evaluation_list_container">
					<div id="evaluation_list_filter">
						<select name="sortby" id="sortby">
							<option value="newest" selected="selected">최근 순</option>
							<option value="oldest">오래된 순</option>
						</select>
					</div>
					<ul id="evaluation_list"></ul>
				</div>
				<div id="pagination">
					<a class="btn btn-sm btn_prev">Prev</a>
					<a class="btn btn-sm btn_next">Next</a>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/js/lib/jquery-1.12.0.min.js"></script>
</body>
</html>