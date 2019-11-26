<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>メールアドレス送信画面</title>
<link href="/tdu_market/css/import_general_student.css" rel="stylesheet" />
</head>
<body>
	<header>
		<img id="title_log" src="/tdu_market/images/student_logo.png" alt="logo" />
	</header>
	<div class="center_container">
		<article>
			<h1>電大マーケットへようこそ</h1>
			<form action="#" method="post">
				<input id="mailaddress_field" type="text" name="mailAdress"
					placeholder="メールアドレス" />
				<button id="send_mailaddress_button" type="submit"
					class="button_flat_blue" onClick="notify_dialog()">
					送信</button>
			</form>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				function notify_dialog() {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').textContent = '確認メールを送信しました。';

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + 'index.jsp';
						dialog.style.display = 'none';
					});
				}
			</script>
		</section>
	</div>
</body>
</html>
