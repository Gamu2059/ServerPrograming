<%@page import="tdu_market.dto.ManagerGetInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Bootstrap -->
<link rel="stylesheet" href="/tdu_market/css/import_admin.css" type="text/css" />
<title>ユーザー情報（編集）</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">ユーザー情報（編集）</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_300px">
			<form action="<%= ServletPath.UpdateManagerInfo %>" method="post">
				<br />
				<div class="user_profile">
					<div class="item_for_LeftAndRight_around">
					<!-- セッションデータの受け取り -->
					<%
					ManagerGetInfo profileInfo = (ManagerGetInfo)session.getAttribute("managerProfileInfo");
					String iconURL = "/tdu_market/images/icon.png";
					String name = "";
					if(profileInfo != null){
						iconURL = profileInfo.getIconImageBinary();
						name = profileInfo.getDisplayName();
					}
					%>
						<label id="edit_img_button">
							<img src="<%= iconURL %>" />
							<input type="file" name="iconImageURL" />
							<h3>編集</h3>
						</label>
						<div>
							<h3>ディスプレイネーム</h3>
							<input type="text" id="user_name" placeholder="<%= name %>" name="displayName" />
							<h3>アカウント種別</h3>
							<h2>運営アカウント</h2>
						</div>
					</div>
					<br />
					<h3>パスワード</h3>
					<div class="password">
						<input type="password" placeholder="１回目" name="nonHashedPassword1" /> <input
							type="password" placeholder="確認用" name="nonHashedPassword2" />
					</div>
					<br />
				</div>
				<br />
				<div class="item_for_LeftAndRight_between">
					<button type="button" id="red_button">削除</button>
					<button type="submit" id="orange_button">確定</button>
					<br />
				</div>
				</form>
			</div>
		</article>
		<br />
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<!-- <div id="confirm_dialog_admin">
				<p id="confirm_text">更新しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_submit button_flat_nega">
						確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div> -->
			<div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				/* document.getElementById("orange_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					yes.classList.remove("button_flat_nega");
					yes.classList.add("button_flat_submit");

					document.getElementById("confirm_text").textContent = "更新しますか？";

					dialog.style.display = "block";

					yes.addEventListener("click", function() {
						dialog.style.display = "none";

						//ここに内部処理をいれる

						notify_dialog("更新しました。", "reference_profile_admin");
					});
					no.addEventListener("click", function() {
						dialog.style.display = "none";
					});
				}; */
				document.getElementById("red_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					yes.classList.remove("button_flat_submit");
					yes.classList.add("button_flat_nega");

					document.getElementById("confirm_text").textContent = "削除しますか？";

					dialog.style.display = "block";

					yes.addEventListener("click", function() {
						dialog.style.display = "none";

						//ここに内部処理をいれる

						notify_dialog("削除しました。", "index");
					});
					no.addEventListener("click", function() {
						dialog.style.display = "none";
					});
				};
				function notify_dialog(text, url) {
					let dialog = document.getElementById("notify_dialog_admin");

					document.getElementById("notify_text").textContent = text;

					dialog.style.display = "block";
					ok.addEventListener("click", function() {
						location.href = url + ".html";
						dialog.style.display = "none";
					});
				}
			</script>
		</section>
	</div>
</body>
</html>