<%@page import="tdu_market.util.JspPath"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.*"%>
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
<title>商品情報詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">商品情報詳細</h2>
		<!-- メインコンテンツ -->
		<!-- 商品情報の取得 -->
		<%
		ArrayList<RelatedClassGetInfo> itemInfo = new ArrayList<>();
		itemInfo = (ArrayList<RelatedClassGetInfo>)session.getAttribute("itemInfo");
		String mailAddress = "";
		long itemID = 0;
		String itemName = "未設定";
		String className = "未設定";
		String[] itemURL = new String[3];
		String itemDescription = "未設定";
		int condition = 0;
		int itemPrice = 0;
		if(itemInfo != null){
			mailAddress = itemInfo.get(0).getItemGetInfo().getExhibitorMailAddress();
			itemID = itemInfo.get(0).getItemGetInfo().getItemID();
			itemName = itemInfo.get(0).getItemGetInfo().getItemName();
			className = itemInfo.get(0).getSyllabusGetInfo().getClassName();
			if(itemInfo.get(0).getItemGetInfo().getItemImageBinaries() != null){
				for(int i=0;i<itemInfo.get(0).getItemGetInfo().getItemImageBinaries().length;i++){
					itemURL[i] = itemInfo.get(0).getItemGetInfo().getItemImageBinaries()[i];
				}
			}
			itemDescription = itemInfo.get(0).getItemGetInfo().getDescription();
		}
		%>
		<article>
			<div class="content_margin_200px">
				<br>
				<div class="exhibit_profile">
					<div class="item_for_right">
						<form action="<%= ServletPath.ManagerReferStudentPage %>" method="get">
							<input type="hidden" name="mailAddress" value="<%= mailAddress %>">
							<button type="submit" id="white_button">学生情報へ→</button>
						</form>
					</div>
					<h2 id="title"><%= itemName %></h2>
					<label><%= className %></label> <br>
					<div class="item_for_left">
						<%
						if(itemURL == null){
							out.print("登録されている画像は有りません");
						} else {
							for(int i=0;i<itemURL.length;i++){
								out.print("<img src=\""+itemURL[i]+"\" alt=\"商品画像\">");
							}
						}
						%>
					</div>
					<label>
						<%= itemDescription %>
					</label> <br>
					<div class="item_for_right">
						<div>
							<h2>
							<%
							switch(condition){
							case 0:
								out.print("新品・未使用");
							break;
							case 1:
								out.print("状態：中古（書き込みなし）");
							break;
							case 2:
								out.print("状態：中古（書き込みあり）");
							break;
							case 3:
								out.print("状態：破損・汚れあり");
							break;
							}
							%>

							</h2>
							<h2><%= itemPrice %>円</h2>
						</div>
					</div>
					<div class="item_for_LeftAndRight_between">
						<button id="red_button">削除</button>
						<button id="white_button" onclick="location.href='<%= JspPath.reference_exhibit_item_by_admin %>'">戻る</button>
						<br>
					</div>
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
					<form action="<%= ServletPath.ManagerDeleteItemInfo %>" method="post">
						<input type="hidden" name="studentMailAddress" value="<%= mailAddress %>">
						<input type="hidden" name="itemID" value="<%= itemID %>">
						<button id="yes" class="button_flat_nega">削除</button>
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

					yes.addEventListener('click',
							function() {
								dialog.style.display = 'none';

								//ここに内部処理をいれる

								/* notify_dialog('削除しました。',
										'reference_item_list_by_admin'); */
							});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				/* function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog_admin');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + '.html';
						dialog.style.display = 'none';
					});
				} */
				/* 以下は、有効化すると学生情報ボタンに不具合が発生する */
				/* document.getElementById('white_button').onclick = function() {
					window.history.back(-1);
					return false;
				} */
			</script>
		</section>
	</div>

</body>
</html>