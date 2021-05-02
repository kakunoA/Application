<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/lockUser.css">
<meta charset="UTF-8">
<title>ロックユーザー</title>
</head>
<body>
	<div id="lock">
		<h1 id="lockMessage">現在ロックされています。管理者に連絡してください。</h1>
	</div>
	<div id="lock">
		<h2>
			<a href="${pageContext.request.contextPath}/LoginServlet">ログイン画面に戻る</a>
		</h2>
	</div>
</body>
</html>