<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/zyankenScore.css">
<title>スコア画面</title>
</head>
<body>
	<header>
		<h1 id="title">ジャンケンゲーム</h1>
		<div id="menu-brock">
			<nav>
				<ul>
					<li id="menu-item"><a
						href="${pageContext.request.contextPath}/ZyankenPlayServlet">プレイ</a></li>
					<li id="menu-item"><a
						href="${pageContext.request.contextPath}/LoginServlet">ログアウト</a></li>
				</ul>
			</nav>
		</div>
	</header>
</body>
<h2 id="tableSubject">ランキングテーブル</h2>
<table class="tablecss">
	<tr>
		<th>ランキング</th>
		<th>WINNER</th>
		<th>ジャンケン回数</th>
	</tr>
	<c:forEach var="rankFactor" items="${scoreView}">
		<tr>
			<td><c:out value="${rankFactor.rank}" /></td>
			<td><c:out value="${rankFactor.userID}" /></td>
			<td><c:out value="${rankFactor.total}" /></td>
		</tr>
	</c:forEach>
</table>
<h2 id="yourScore">
	<c:out value="${loginUser.userID}" />
	さんの順位は
	<c:out value="${userRanking}" />
	位です。
</h2>
</html>