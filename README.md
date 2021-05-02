# 概要
登録ユーザーでログインし、コンピューターとジャンケンをします。先に5勝したほうが勝ちです。コンピューターに勝利し、  
「送信」ボタンを押下すると成績上位8名とあなたの順位が画面に表示されます（勝ったときのジャンケンの回数が少ないほ  
ど優秀という意味になります）。  

# フレームワークとブラウザ  
バックエンド...JSP、Servlet  
フロントエンド...JavaScript、HTML、CSS  
DB...H2  
Webサーバー...Tomcat  
ブラウザ...Chrom  

# 画面遷移  
1. 管理者ユーザー：Z11101でログインし、ユーザー登録画面にてユーザーID：honda パスワード：honda11を登録

![ユーザー登録](https://user-images.githubusercontent.com/82762778/116816401-be3f4f00-ab9c-11eb-9048-24f5e03444c2.png)

![image](https://user-images.githubusercontent.com/82762778/116816527-3c035a80-ab9d-11eb-8248-0bc48d5d4c83.png)

2. ログイン画面にてユーザーID：honda パスワード：honda11でログイン

![ログイン画面](https://user-images.githubusercontent.com/82762778/116816793-66094c80-ab9e-11eb-8038-1bf00fdf280f.png)

![ジャンケンゲーム](https://user-images.githubusercontent.com/82762778/116816813-78838600-ab9e-11eb-92b1-c3bb24ec6a5f.png)

3-1. ジャンケンで負けた時、「もう一回」ボタンのみが活性になる

![ジャンケン負け](https://user-images.githubusercontent.com/82762778/116817025-7e2d9b80-ab9f-11eb-9ce1-94c79ee80fcd.png)

3-2. ジャンケンで勝った時、「もう一回」ボタンと「結果送信」ボタンが活性になる

![ジャンケン勝ち](https://user-images.githubusercontent.com/82762778/116817187-280d2800-aba0-11eb-9a73-7385706dcdc7.png)

4. 「結果送信」を押下すると、ジャンケンの成績上位8名（より早く5回勝って上がった上位8名）とユーザーのランキングが表示される

![スコア](https://user-images.githubusercontent.com/82762778/116817310-a79af700-aba0-11eb-9ddd-1ffe841b5d48.png)

5. ログアウト

![ログアウト](https://user-images.githubusercontent.com/82762778/116817353-e03ad080-aba0-11eb-8374-078bd37d438e.png)

6. ユーザー：hondaをロックし、hondaでログインした時にロックユーザー画面に遷移することを確認する

![管理者権限ログイン](https://user-images.githubusercontent.com/82762778/116817482-8ab2f380-aba1-11eb-9172-aad61fbe20e7.png)

![ロック](https://user-images.githubusercontent.com/82762778/116817531-bf26af80-aba1-11eb-93c0-99ab7fa0a070.png)

![ロック結果](https://user-images.githubusercontent.com/82762778/116817569-eed5b780-aba1-11eb-8bde-aedda3618258.png)

![ロック検証ログイン](https://user-images.githubusercontent.com/82762778/116817677-8509dd80-aba2-11eb-9fc9-f12510a7d70b.png)

![ロック検証画面](https://user-images.githubusercontent.com/82762778/116817725-c601f200-aba2-11eb-816e-8f2d22ae0646.png)

7. ユーザー：hondaのロックを解除する。ロック解除後、ユーザー：hondaでログインしてプレイ画面に遷移することを確認

![ロック解除前画面](https://user-images.githubusercontent.com/82762778/116817809-3446b480-aba3-11eb-9383-c8e52172cb3e.png)

![ロック解除後画面](https://user-images.githubusercontent.com/82762778/116817887-8b4c8980-aba3-11eb-8d9a-1627cd29188d.png)

![ロック解除後ログイン画面](https://user-images.githubusercontent.com/82762778/116817964-d6ff3300-aba3-11eb-921f-50f5661632d3.png)

![ロック解除後プレイ画面](https://user-images.githubusercontent.com/82762778/116818010-1af23800-aba4-11eb-8b97-cd72dcf34ac9.png)

※他にパスワード変更の機能もあるが割愛
