<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/passwordCheck.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/zyankenPassWordUpdate.css">
<title>パスワード変更画面</title>
</head>
<body>
  <header>
    <h1 id="title">ジャンケンゲーム</h1>
     <div id="menu-brock">
      <nav>
         <ul>
           <li id="menu-item"><a href="${pageContext.request.contextPath}/ZyankenTopServlet">TOP</a></li>
           <li id="menu-item"><a href="${pageContext.request.contextPath}/LoginServlet">ログイン</a></li>
         </ul>
      </nav>
      </div>
  </header>
   <div id="form">
       <p id="form-title">パスワード変更</p>
          <form name="updateFrml"  method="post"  action="${pageContext.request.contextPath}/PassWordUpdateServlet">
            <p>ユーザーID</p>
            <p><input type="text" name="userID"></p>
            <p>現在のパスワード</p>
            <p><input type="password" name="nowpass"></p>
            <p>新しいパスワード</p>
            <p><input type="password" name="newpass"></p>
            <p>再確認用パスワード</p>
            <p><input type="password" name="remindpass"></p>
            <div id="updateDiv"><input type="button" id="update" value="変更"></div>
         </form>
   </div>
</body>
</html>