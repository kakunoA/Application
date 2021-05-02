<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/logout.css">
<title>ログアウト</title>
</head>
<body>
      <div id="logout"><h1 id="logoutMessage">ログアウトしました。</h1></div>
      <div id="logout">
          <h2><a href="${pageContext.request.contextPath}/LoginServlet">ログイン画面に戻る</a></h2>
       </div>
</body>
</html>