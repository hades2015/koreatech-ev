<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KoreatechEV::Home</title>

<link rel="stylesheet" type="css/text" href="/assets/css/normalize.css">
<link rel="stylesheet" type="css/text" href="/assets/css/global.css">
<style>
#side_menu li {
	margin-top: 10px;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/shared/header.jsp" flush="false" />
	<div class="container-fluid">
		<div id="content-container">
			<div class="col-md-2" id="side_nav">
				<ul id="side_menu" class="nav nav-pills nav-stacked">
					<li><a href="#none">강의평가</a></li>
					<li><a href="#none">질문 게시판</a></li>
					<li><a href="#none">커리큘럼</a></li>
					<li><a href="#none">시간표 관리</a></li>
				</ul>
			</div>

			<div id="contents" class="col-md-10">
				<div id="evaluation_list_filter_container" class="row">
					<div class="col-md-8"></div>
					<div class="col-md-2">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button" id="evaluation_list_filter" data-toggle="dropdown" aria-expanded="true">
								정렬순서<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" aria-labelledby="evaluation_list_filter">
								<li><a role="menuitem" tabindex="-1" href="#">최근 순</a></li>
								<li><a role="menuitem" tabindex="-1" href="#">오래된 순</a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-2">
						<a href="/evaluation/create"><button class="btn btn-success">강의평가 작성하기</button></a>
					</div>
				</div>
				<div id="evaluation_list_container" class="container-fluid col-md-12">
					<ul class="nav nav-tabs">
						<li role="presentation" class="active"><a href="#">전체보기</a></li>
						<li role="presentation"><a href="#">친구보기</a></li>
					</ul>
					<ul id="evaluation_list"></ul>
				</div>
				<div id="pagination" class="container-fluid col-md-12 text-center">
					<nav>
						<ul class="pagination pagination-sm">
							<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
