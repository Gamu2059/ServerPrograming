<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ログイン画面</title>
<link href="/tdu_market/css/import_general_student.css" rel="stylesheet" />
</head>
<body>
	<header>
		<img id="title_log" src="/tdu_market/images/student_logo.png"
			alt="logo" />
	</header>
	<div class="center_container">
		<article>
			<h1>電大マーケットへようこそ</h1>
			<form action="/tdu_market/tdu_market/controller/Login" method="post">
				<div class="input_field">
					<input type="text" name="mailaddress" placeholder="メールアドレス" /> <input
						type="password" name="password" placeholder="パスワード" />
				</div>
				<button id="send_mailaddress_button" type="submit"
					class="button_flat_blue">ログイン</button>
			</form>
			<button id="new_account_button" type="submit"
				class="button_flat_blue" onclick="location.href='/tdu_market/general/send_mail.jsp'">新規登録</button>
		</article>
	</div>
</body>
</html>
