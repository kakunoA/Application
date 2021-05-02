<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="${pageContext.request.contextPath}/js/userManage.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/CSS/userManage.css">
<meta charset="UTF-8">
<title>ユーザー管理</title>
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
	<div id="userOpe">
		ユーザー <select id="userOperation">
			<option value="0">ユーザー登録</option>
			<option value="1">ユーザーロック</option>
		</select>
	</div>
	<div id="register" class="active">
		<p id="form-title">ユーザー登録</p>
		<form name="registerFrml" method="post"
			action="${pageContext.request.contextPath}/UserManagerServlet">
			<p>ユーザーID</p>
			<p>
				<input type="text" name="userID">
			</p>
			<p>パスワード</p>
			<p>
				<input type="password" name="password">
			</p>
			<div id="registerDiv">
				<input type="button" id="registerbutton" value="登録">
			</div>
		</form>
		<c:if test="${not empty registerMessage}">
			<p id="registerResultMessage"><c:out value="${registerMessage}" /></p>
		</c:if>
	</div>
	<div id="rock" class="active">
		<p id="form-title">ユーザーロック</p>
		<form name="rockFrml" method="post"
			action="${pageContext.request.contextPath}/UserManagerServlet">
			<p id="rockSelect">
				ロックユーザー：<select id="rockOperation" name="rockOperation">
					<c:forEach var="lockUser" items="${targetLockUserList}">
						<option value="${lockUser}"><c:out value="${lockUser}" /></option>
					</c:forEach>
				</select>
			</p>
			<div id="rockDiv">
				<input type="submit" id="rockbutton" value="ロック">
			</div>
		</form>
		<form name="rockReleaseFrml" method="post"
			action="${pageContext.request.contextPath}/UserManagerServlet">
			<p id="rockReleaseSelect">
				ロック解除ユーザー：<select id="rockReleaseOperation"
					name="rockReleaseOperation">
					<c:forEach var="lockReleaseUser" items="${targetLockReleaseUserList}">
						<option value="${lockReleaseUser}"><c:out
								value="${lockReleaseUser}" /></option>
					</c:forEach>
				</select>
			</p>
			<div id="rockReleaseDiv">
				<input type="submit" id="rockReleasebutton" value="ロック解除">
			</div>
		</form>
		<c:choose>
			<c:when test="${not empty rockMessage}">
				<p id="rockResultMessage"><c:out value="${rockMessage}" /></p>
			</c:when>
			<c:otherwise>
				<c:if test="${not empty rockReleaseMessage}">
					<p id="rockReleaseResultMessage"><c:out value="${rockReleaseMessage}" /></p>
				</c:if>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>