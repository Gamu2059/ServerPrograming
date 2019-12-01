
<%@page import="tdu_market.dto.StudentGetInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Bootstrap -->
<link rel="stylesheet" href="/tdu_market/css/import_admin.css"
	type="text/css" />
<title>学生情報詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報詳細</h2>
		<!-- メインコンテンツ -->
		<!-- データの受け取りと展開 -->
		<%
			StudentGetInfo studentInfo = (StudentGetInfo) session.getAttribute("studentInfo");
			String studentMailAddress = "";
			String iconURL = "";
			String name = "";
			long department = 0;
			String selfIntroduction = "";
			if (studentInfo != null) {
				studentMailAddress = studentInfo.getMailAddress();
				iconURL = studentInfo.getIconImageBinary();
				name = studentInfo.getDisplayName();
				department = studentInfo.getDepartmentID();
				selfIntroduction = studentInfo.getSelfIntroduction();
			}
		%>
		<article>
			<div class="content_margin_200px">
				<br>
				<div class="item_for_right">
					<form action="<%= ServletPath.ManagerReferExhibitItemListPage %>" method="get">
						<input type="hidden" name="studentMailAddress" value="<%= studentMailAddress %>">
						<button class="exhibit_list_button" type="submit">出品一覧</button>
					</form>
				</div>
				<div class="user_profile">

					<div class="item_for_LeftAndRight_around">
						<img src="<%=iconURL%>" />
						<div>
							<h3>ディスプレイネーム</h3>
							<h2 id="user_name"><%=name%></h2>
							<h3>所属学科</h3>
							<h2><%=department%></h2>
						</div>
					</div>
					<br>
					<h3>自己紹介</h3>
					<h4 id="selfintroduction"><%=selfIntroduction%></h4>
				</div>
				<br>
				<div class="item_for_LeftAndRight_between">
					<button id="red_button">削除</button>
					<form action="<%=ServletPath.ManagerEditStudentPage%>"
						method="get">
						<button id="blue_button">編集</button>
					</form>
				</div>
			</div>
		</article>
		<br>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog_admin">
				<p>削除しますか？</p>
				<div class="confirm_dialog_button">
					<form action=<%=ServletPath.ManagerDeleteStudentInfo%> method="post">
						<input type="hidden" name="delete_student_mailaddress" value="<%=studentMailAddress%>">
						<button id="yes" class="button_flat_nega" type="submit">確認</button>
					</form>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<!-- <div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div> -->
			<script type="text/javascript">
				document.getElementById('red_button').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					/*
					yes.addEventListener('click', function() {
						dialog.style.display = 'none';
						//ここに内部処理をいれる
						notify_dialog('削除しました。', 'reference_student_list');
					})
					*/

					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				/* function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog_admin');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				} */
			</script>
		</section>
	</div>
</body>
</html>