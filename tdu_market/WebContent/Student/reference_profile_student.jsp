<%@page import="tdu_market.dto.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>ユーザー情報参照</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="/tdu_market/css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="/tdu_market/js/student.js" defer="defer"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>ユーザー情報</h2>
				<div class="profile_edit_button">
					<!-- EditStudentPageへ処理を引き継ぐ -->
					<form action="<%=ServletPath.EditStudentPage %>" method="get">
						<button type="submit" class="button_flat_normal" id="edit">編集</button>
					</form>
				</div>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
	<!-- 			<form action="../ReferStudentPage" method="get"> -->
					<!-- ReferStudentPageからのセッションを展開・表示 -->
					<%
					StudentGetInfo info = (StudentGetInfo)session.getAttribute("studentInfo");
					out.print("<div class=\"top_content\">");
					out.print("<div class=\"top_content_left\">");
					out.print("<img src=\""+ info.getIconImageBinary() +"\" alt=\"ユーザーアイコン\" />");
					out.print("</div>");
					out.print("<div class=\"top_content_right\">");
					out.print("<div class=\"detail_content\">");
					out.print("<h3>ディスプレイネーム</h3>");
					out.print("<div class=\"detail_content_text\">"+ info.getDisplayName() +"</div>");
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<h3>所属学科</h3>");
					out.print("<div class=\"detail_content_text\">"+ "所属学科をここに記載。場合によっては、所属学科IDを所属学科名に変換する処理をする。"+"</div>");
					out.print("</div>");
					out.print("</div>");
					out.print("</div>");
					out.print("<div class=\"bottom_content\">");
					out.print("<div class=\"detail_content\">");
					out.print("<h3>自己紹介</h3>");
					out.print("<div class=\"detail_content_textarea\">"+ info.getSelfIntroduction() +"</div>");
					out.print("</div>");
					out.print("</div>");
					%>
		<!-- 		</form> -->
			</div>
			<!-- サードコンテナ -->
			<div class="third_container">
				<div class="unsubscribe_button">
					<button type="submit" name="unsubscribe" class="button_flat_nega" id="delete">退会</button>
				</div>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="negative_dialog">
				<p>本当に退会しますか？</p>
				<div class="negative_dialog_button">
					<!-- DeleteStudentInfoに処理を引き継ぐ -->
					<form action="../DeleteStudentInfo" method="post">
						<button type="submit" id="nega_yes" class="button_flat_nega">確認</button>
					</form>
					<button id="nega_no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('edit').onclick = function() {
					location.href = 'edit_profile_student' + '.jsp';
				}

				document.getElementById('delete').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('negative_dialog');
					let yes = document.getElementById('nega_yes');
					let no = document.getElementById('nega_no');
					dialog.style.display = 'block';
					console.log(dialog.type)

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + '.jsp';
						dialog.style.display = 'none';
					});
				}
				document.getElementById('back_button').onclick = function() {
					window.history.back(-1);
					return false;
				}
			</script>
		</section>
	</div>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>
</body>
</html>