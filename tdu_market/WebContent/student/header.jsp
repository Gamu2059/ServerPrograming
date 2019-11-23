<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/tdu_market/css/import_student.css"
	type="text/css">
<title>ヘッダー</title>
</head>
<header>
	<div class="title_logo">
		<!-- ロゴ -->
		<h1>
			<a href="top.jsp"><img src="/tdu_market/image/student_logo.png"
				alt="ロゴ"></a>
		</h1>
	</div>

	<div class="header_menu">
		<!-- メニュー -->
		<ul>
			<li><a href="search_from_exhibit.jsp">名前から検索</a>
			<li><a href="search_from_syllabus.jsp">シラバスから検索</a>
			<li><a href="#"><img src="/tdu_market/image/message.png"
					alt="メッセージアイコン"></a>
			<li><a href="#"><img src="/tdu_market/image/icon.png"
					alt="ユーザーアイコン"></a>
		</ul>
	</div>
</header>
<div class="user_control_window" id="hoge">
	<div class="user_info">
		<div class="left">
			<img src="../images/icon.png" alt="アイコン">
		</div>
		<div class="right">
			<h3>17FI999</h3>
			<h2>電大太郎</h2>
		</div>
	</div>
	<div class="another">
		<h2>
			<a href="">出品物情報</a>
		</h2>
		<h3>
			<a href="">ユーザー情報設定</a>
		</h3>
		<button id="logout_button">ログアウト</button>
	</div>
</div>
<script type="text/javascript" defer="defer">
	document.getElementById('user_information_controller').onclick = function() {
		let dialog = document.getElementById('hoge');
		let dialog_style = dialog.style.display;
		if (dialog.style.display == "none") {
			dialog.style.display = 'flex';
		} else {
			dialog.style.display = 'none';
		}
	}
</script>
</html>