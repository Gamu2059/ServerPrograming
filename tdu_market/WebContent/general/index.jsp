<%@page import="tdu_market.util.ServletPath"%>
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
			<h2>
			<%
			String obj = (String)session.getAttribute("errorMessage");
			if(obj != null && !obj.trim().isEmpty()){
				out.println(obj);
			}
			%>
			</h2>
			<form action=<%=ServletPath.Login%> method="post">
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
	<div id="notify_dialog">
		<p id="notify_text">確認ダイアログ</p>
		<div class="notify_dialog_button">
			<button id="ok" class="button_flat_normal">了解</button>
		</div>
	</div>
	<script type="text/javascript">
		<% if((boolean)session.getAttribute("isDisplayDialog")){%>
		notify_dialog('<%= (String)session.getAttribute("dialogMessage") %>');
		<% } %>
		function notify_dialog() {
			let dialog = document.getElementById('notify_dialog');

			document.getElementById('notify_text').textContent = '確認メールを送信しました。';

			dialog.style.display = 'block';
			ok.addEventListener('click', function() {
				dialog.style.display = 'none';
			});
		}
	</script>
</body>
</html>
