<%@page import="tdu_market.dto.StudentGetInfo"%>
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
			<a href="top.jsp"><img src="/tdu_market/images/student_logo.png"
				alt="ロゴ"></a>
		</h1>
	</div>
<%
StudentGetInfo info = (StudentGetInfo)session.getAttribute("studentGet");
%>
	<div class="header_menu">
		<!-- メニュー -->
		<ul>
			<li><a href="search_from_exhibit.jsp">名前から検索</a>
			<li><a href="search_from_syllabus.jsp">シラバスから検索</a>
			<li><a href="message.jsp"><img src="/tdu_market/images/message.png"
					alt="メッセージアイコン"></a>
			<li><img src="/tdu_market/images/icon.png"
					alt="ユーザーアイコン" id="user_information_controller">
		</ul>
	</div>
</header>
<div class="user_control_window" id="user_infomation">
	<div class="user_info">
		<div class="left">
			<img src="../images/icon.png" alt="アイコン">
		</div>
		<div class="right">
		<%
		//学番とディスプレーネームを取得して表示
		String number = info.getMailAddress().substring(0,7);
		out.print("<h3>" + number + "</h3>");
		out.print("<h2>" + info.getDisplayName() + "</h2>");
		%>
		</div>
	</div>
	<div class="another">
		<h2>
			<a href="/tdu_market/Student/reference_exhibit_list.jsp">出品物情報</a>
		</h2>
		<h3>
			<a href="/tdu_market/Student/reference_profile_student.jsp">ユーザー情報設定</a>
		</h3>
		<button id="logout_button">ログアウト</button>
	</div>
</div>
<script type="text/javascript" defer="defer">
	document.getElementById('user_information_controller').onclick = function() {
		let dialog = document.getElementById('user_infomation');
		let dialog_style = dialog.style.display;
		if (dialog.style.display == "none") {
			dialog.style.display = 'flex';
		} else {
			dialog.style.display = 'none';
		}
	}
</script>
</html>