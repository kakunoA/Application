# 概要
登録ユーザーでログインし、コンピューターとジャンケンをします。先に5勝したほうが勝ちです。コンピューターに勝利し、  
「送信」ボタンを押下すると成績上位8名とあなたの順位が画面に表示されます（勝ったときのジャンケンの回数が少ないほ  
ど優秀という意味になります）。  

# フレームワークとブラウザ  
バックエンド...JSP、サーブレット  
フロントエンド...JavaScript、HTML、CSS  
DB...H2  
Webサーバーソフト...Tomcat  
ブラウザ...Chrom  

# クラス概要  
zyankenGame  
&nbsp;&nbsp;&nbsp;&nbsp; daoパッケージ  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ZyankenDAO.java...DBとのやりとりを行うDAOクラス  
&nbsp;&nbsp;&nbsp;&nbsp; modelパッケージ  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DBUtil.java...DBの接続・切断を行うクラス  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;GetScore.java...ジャンケン勝利ユーザーの情報を格納しているBeanクラス（ユーザーとジャンケン回数とユーザーのランキングを保持）  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LockUser.java...ユーザーをロックしたときのBeanクラス（ロックユーザーとロック日時情報を保持） 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Login.java...ログイン情報のBeanクラス（ユーザーIDとパスワードを保持）
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LoginLogic.java...ログインチェックを行うクラス  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PasswordInfo.java...パスワード変更を行うときに必要となるBeanクラス（ユーザーIDと旧パスワードと新パスワードを保持）
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;PasswordUpdateLogic.java...パスワード変更を行うクラス  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ScoreLogic.java...ジャンケンで勝利したスコア上位8名の表示とユーザーのランキングを表示するクラス  


