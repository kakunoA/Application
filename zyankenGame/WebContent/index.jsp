<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/zyankenTop.css">
<title>トップ画面</title>
</head>
<body>
  <header>
    <h1 id="title">ジャンケンゲーム</h1>
    <div id="menu-brock">
     <nav>
      <ul>
           <li id="menu-item"><a href="${pageContext.request.contextPath}/LoginServlet">ログイン</a></li>
      </ul>
     </nav>
   </div>  
  </header>
   <div id="zyankenBrock">
      <img src="${pageContext.request.contextPath}/images/zyanken_image.jpg" id="zyankenImg">
   </div>
    <h2 id="ruleExplainSubject">ルール説明</h2>
    <div id="ruleExplain">
       <ol>
         <li>ログインします。</li>
         <li>相手とジャンケンをして5回先に勝ったほうの勝ちです。</li>
         <li>なるべく少ない回数で勝てるようにがんばってね。</li>
       </ol>
    </div>
</body>
</html>