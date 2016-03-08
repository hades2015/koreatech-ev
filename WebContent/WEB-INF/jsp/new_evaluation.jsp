<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>KoreatecEV::강의평가 작성</title>
<link rel="stylesheet" type="css/text" href="/assets/css/normalize.css" />
<link rel="stylesheet" type="css/text" href="/assets/css/global.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/shared/header.jsp" flush="false" />
	<div class="container">
		<form class="evaluation_form" method="post" action="/evaluation/create">
			<div id="contents">
				<div id="evaluation_header">
					<h1>강의평가 작성</h1>
				</div>
				<div>
					<label for="name">제목</label>
					<input type="text" id="name" name="name"></input>
				</div>
				<div id="description_container">
					<label for="description">내용</label>
					<textarea name="description"></textarea>
				</div>

				<div class="right_align">
					<input type="submit" value="생성"></input>
				</div>
			</div>
		</form>
	</div>
	<script src="/assets/js/lib/jquery-1.12.0.min.js"></script>
</body>
</html>