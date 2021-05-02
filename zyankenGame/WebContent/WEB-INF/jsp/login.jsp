<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/loginCheck.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/zyankenLogin.css">
<title>ログイン画面</title>
</head>
<body>
  <header>
     <h1 id="title">ジャンケンゲーム</h1>
     <div id="menu-brock">
      <nav>
         <ul>
           <li id="menu-item"><a href="${pageContext.request.contextPath}/ZyankenTopServlet">TOP</a></li>
           <li id="menu-item"><a href="${pageContext.request.contextPath}/PassWordUpdateServlet">パスワード変更</a></li>
         </ul>
      </nav>
    </div>
  </header>
    <div id="formBrock">
       <p id="form-title">Login</p>
          <form name="loginFrml" method="post" action="${pageContext.request.contextPath}/LoginServlet">
            <p>ユーザーID</p>
            <p><input type="text" name="userID"></p>
            <p>パスワード</p>
            <p><input type="password" name="pass"></p>
            <div id="loginDiv"><input type="button" id="login" value="ログイン"></div>
          </form>
    </div>
</body>
</html>