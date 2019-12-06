<%@page import="tdu_market.util.ServletPath"%>
<%@page import="tdu_market.dto.StudentGetInfo"%>
<%@page import="tdu_market.util.ServletPath"%>
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
			<a href=<%=ServletPath.TopPage %>><img
				src="/tdu_market/images/student_logo.png" alt="ロゴ"></a>
		</h1>
	</div>
	<%
		//StudentGetInfo info_header = (StudentGetInfo) session.getAttribute("studentGet");
		StudentGetInfo info_header = (StudentGetInfo) session.getAttribute("studentInfo");
	%>
	<div class="header_menu">
		<!-- メニュー -->
		<ul>
			<li><a href=<%=ServletPath.SearchItemPage%>>名前から検索</a>
			<li><a href=<%=ServletPath.SearchSyllabusPage%>>シラバスから検索</a>
			<li><form action="<%=ServletPath.ReferMessageBoxListPage%>" method="post">
					<button type="submit" class="noneButton">
						<img src="/tdu_market/images/message.png" alt="メッセージアイコン">
					</button>
				</form>
			<li><a href = "#"><img src=<%=info_header.getIconImageBinary()%> alt="ユーザーアイコン" id="user_information_controller"></a>
		</ul>
	</div>
</header>
<div class="user_control_window" id="user_infomation">
	<div class="user_info">
		<div class="left">
			<!-- <img src="../images/icon.png" alt="アイコン"> -->
			<%
				out.print("<img src=\"" + info_header.getIconImageBinary() + " \" alt=\"アイコン\">");
			%>
		</div>
		<div class="right">
			<%
				//学番とディスプレーネームを取得して表示
				String number = info_header.getMailAddress().substring(0, 7);
				out.print("<h3>" + number + "</h3>");
				out.print("<h2>" + info_header.getDisplayName() + "</h2>");
			%>
		</div>
	</div>
	<div class="another">
		<h2>
			<form action=<%=ServletPath.ReferExhibitItemListPage%> method="get">
				<button type="submit"
					style="background: #ffffff; color: blue; border: none;">出品物情報</button>
			</form>
		</h2>
		<h3>
			<form action=<%=ServletPath.ReferStudentPage%> method="get">
				<button type="submit"
					style="background: #ffffff; color: blue; border: none;">ユーザー情報設定</button>
			</form>
		</h3>
		<form action=<%=ServletPath.Logout%> method="post">
			<button type="submit" id="logout_button">ログアウト</button>
		</form>
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
