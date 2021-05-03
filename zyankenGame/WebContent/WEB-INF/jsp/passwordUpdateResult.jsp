<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/passwordUpdateResult.css">
<title>パスワード変更</title>
</head>
<body>
	<c:choose>
		<c:when test="${not empty loginUser}">
			<div id="updateSuccess">
				<h1 id="successMessage">パスワード変更成功しました。</h1>
			</div>
			<div id="updateSuccess">
				<h2>
					<a href="${pageContext.request.contextPath}/LoginServlet">ログイン画面へ</a>
				</h2>
			</div>
		</c:when>
		<c:otherwise>
			<div id="updateFail">
				<h1 id="failMessage">パスワード変更失敗しました。</h1>
			</div>
			<div id="updateFail">
				<h2>
					<a href="${pageContext.request.contextPath}/PassWordUpdateServlet">パスワード変更画面へ</a>
				</h2>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>