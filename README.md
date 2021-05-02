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

# 画面遷移  
1. 管理者ユーザー：Z11101でログインし（画面は割愛）、ユーザー登録画面にてユーザーID：honda パスワード：honda11を登録

![ユーザー登録](https://user-images.githubusercontent.com/82762778/116816401-be3f4f00-ab9c-11eb-9048-24f5e03444c2.png)

![image](https://user-images.githubusercontent.com/82762778/116816527-3c035a80-ab9d-11eb-8248-0bc48d5d4c83.png)

2. ログイン画面にてユーザーID：honda パスワード：honda11でログイン

![ログイン画面](https://user-images.githubusercontent.com/82762778/116816793-66094c80-ab9e-11eb-8038-1bf00fdf280f.png)

![ジャンケンゲーム](https://user-images.githubusercontent.com/82762778/116816813-78838600-ab9e-11eb-92b1-c3bb24ec6a5f.png)

3-1. ジャンケンで負けた時
