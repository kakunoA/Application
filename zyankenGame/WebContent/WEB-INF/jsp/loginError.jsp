<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/returnLogin.css">
<title>ログインエラー</title>
</head>
<body>
      <div id="loginError"><h1 id="errorMessage">ログインに失敗しました。再度ログインしてください。</h1></div>
      <div id="loginError">
          <h2><a href="${pageContext.request.contextPath}/LoginServlet">ログイン画面に戻る</a></h2>
       </div>
</body>
</html>