<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/zyankenPlay.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/zyankenPlay.css">
<title>プレイ</title>
</head>
<body>
	<header>
		<h1 id="title">ジャンケンゲーム</h1>
		<div id="menu-brock">
			<nav>
				<ul>
					<li id="menu-item"><a
						href="${pageContext.request.contextPath}/LoginServlet">ログアウト</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<h2>
		<c:out value="${loginUser.userID}" />
		さん、ジャンケンをします。
	</h2>
	<div id="handList">
		<form name="zyankenfrml">
			<input type="radio" name="hand" value="guu" checked><b>ぐー</b>
			<input type="radio" name="hand" value="choki"><b>ちょき</b> <input
				type="radio" name="hand" value="paa"><b>ぱー</b>
			<p>
				<input type="button" id="handSubmit" value="しょうぶ">
			</p>
		</form>
	</div>
	<h3 id="midwayGrade"></h3>
	<div id="imageHand"></div>
	<h2 id="winOrLose"></h2>
	<div id="buttonBrock">
		<form name="resultfrml">
			<input type="button" id="retry" value="もう一回">
		</form>
		<form name="resultSend" method="post"
			action="${pageContext.request.contextPath}/ScoreServlet">
			<input type="hidden" name="total" value="">
			<input type="button" id="send" value="結果送信">
		</form>
	</div>

</body>
</html>