<%@page import="tdu_market.util.DialogUtil"%>
<%@page import="tdu_market.util.JspPath"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="tdu_market.entity_bean.ItemInfo"%>
<%@page import="tdu_market.dto.*"%>
<%@page import="java.util.ArrayList"%>
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
	<title>商品情報一覧</title>
</head>

<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">商品情報一覧</h2>
		<!-- メインコンテンツ -->
		<article>
			<!-- ソート -->
			<div class="sort">
				<form name="sort_item">
					<select id="sort_number" onchange="sort_itemList();">
						<option value="1">商品名(昇順)</option>
						<option value="2">商品名(降順)</option>
						<option value="3">学籍番号(昇順)</option>
						<option value="4">学籍番号(降順)</option>
						<option value="5">名前(昇順)</option>
						<option value="6">名前(降順)</option>
						<option value="7">関連授業(昇順)</option>
						<option value="8">関連授業(降順)</option>
						<option value="9">価格(昇順)</option>
						<option value="10">価格(降順)</option>
					</select>
				</form>
			</div>
			<!-- テーブル -->

			<div class="item_for_center">
				<div class="list_content">

					<table id="itemList">
						<!-- テーブルタイトル -->
						<thead class="list_title">
							<tr>
								<th class="check_column1"></th>
								<tb class="hidden_column">商品ID</tb>
								<th class="item_column1" data-sort="item_column1">商品名</th>
								<th class="item_column2" data-sort="item_column2">学籍場号</th>
								<th class="item_column3" data-sort="item_column3">出品者</th>
								<th class="item_column4" data-sort="item_column4">関連授業名</th>
								<th class="item_column5" data-sort="item_column5">価格</th>
							</tr>
						</thead>
						<!-- テーブル要素 -->
						<tbody class="list" id="list_content">
							<form action="<%= ServletPath.ManagerDeleteItemInfo %>" method="post">

								<%
								ArrayList<ItemGetInfoByAdmin> itemInfo = new ArrayList<>();
								Object itemInfoObj = session.getAttribute("itemListInfo");
								if (itemInfoObj != null) {
									itemInfo = (ArrayList<ItemGetInfoByAdmin>) itemInfoObj;
								}
								if (itemInfo != null) {
									for (ItemGetInfoByAdmin item : itemInfo) {
										ItemGetInfo i = item.getItemGetInfo();
										StudentGetInfo s = item.getStudentGetInfo();
										SyllabusGetInfo sy = item.getSyllabusGetInfo();
							%>
								<tr class="exhibitId">
									<th class="check_column1"><input type="checkbox" name="itemIDs"
											value="<%=i.getItemID()%>" />
										</td>
									<td class="hidden_column" hidden><%=i.getItemID()%></td>
									<td class="item_column1"><%=i.getItemName()%></td>
									<td class="item_column2"><%=i.getExhibitorMailAddress().split("@", 0)[0]%></td>
									<td class="item_column3"><%=s != null ? s.getDisplayName() : "未設定"%></td>
									<td class="item_column4"><%=sy != null ? sy.getClassName() : "未設定"%></td>
									<td class="item_column5"><%=i.getPrice()%></td>
								</tr>
								<%
								}
								}
							%>
						</tbody>

						<!-- 複数件削除ダイアログ -->
						<div id="confirm_dialog_admin">
							<p>削除しますか？</p>
							<div class="confirm_dialog_button">
								<button type="submit" id="yes" class="button_flat_nega">確認</button>
								<button tyoe="button" id="no" class="button_flat_normal">キャンセル</button>
							</div>
						</div>
						</form>
					</table>

					<!-- ソート機能 -->
					<script src="/tdu_market/js/list.min.js"></script>
					<script>
						var options = {
							valueNames: ['item_column1', 'item_column2', 'item_column3', 'item_column4', 'item_column5']
						};
						var itemList = new List('itemList', options);
						itemList.sort('item_column1', { order: 'asc' });
						function sort_itemList() {
							sortIndex = document.sort_item.sort_number.selectedIndex;
							switch (sortIndex) {
								case 0:
									itemList.sort('item_column1', { order: 'asc' });
									break;
								case 1:
									itemList.sort('item_column1', { order: 'desc' });
									break;
								case 2:
									itemList.sort('item_column2', { order: 'asc' });
									break;
								case 3:
									itemList.sort('item_column2', { order: 'desc' });
									break;
								case 4:
									itemList.sort('item_column3', { order: 'asc' });
									break;
								case 5:
									itemList.sort('item_column3', { order: 'desc' });
									break;
								case 6:
									itemList.sort('item_column4', { order: 'asc' });
									break;
								case 7:
									itemList.sort('item_column4', { order: 'desc' });
									break;
								case 8:
									itemList.sort('item_column5', { order: 'asc' });
									break;
								case 9:
									itemList.sort('item_column5', { order: 'desc' });
									break;
							}
						}
					</script>

					<form name="select_item" action="<%= ServletPath.ManagerReferItemPage %>" method="get">
					</form>

					</table>
					<form name="select_item" action="<%=ServletPath.ManagerReferItemPage%>" method="get">
					</form>
					<!-- テーブル要素クリック -->
					<script type="text/javascript"
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
					<script type="text/javascript">
						$(".exhibitId").children(":not('th')").on(
							"click",
							function () {
								//商品IDの取得
								var itemId = $(this).parent().children(
									".hidden_column")[0].innerText;
								//Input型エレメントの生成
								var element = document
									.createElement("input");
								//typeの設定
								element.setAttribute("type", "hidden");
								//nameの設定
								element.setAttribute("name", "itemID");
								//valueの設定
								element.setAttribute("value", itemId);
								//取得したIDデータをsetattributeする
								document.select_item.appendChild(element);
								//データをサーバーへ送信する
								document.select_item.submit();
							});
					</script>
					<!-- テーブル要素クリックここまで -->
				</div>
			</div>
			<br />
			<!-- 絞り込みボタン -->
			<div class="item_for_LeftAndRight_around">
				<button id="red_button" type="button">削除</button>
				<button class="search_button" type="button">
					<img src="/tdu_market/images/search.png"
						onclick="location.href='<%=JspPath.search_item_by_admin%>'" />絞り込み
				</button>
				<br />
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
			<% if (DialogUtil.checkDisplayDialog(request, response)) { %>
					notify_dialog(<%=DialogUtil.getDialogMessage(request, response) %>);
			<% } %>

					document.getElementById("red_button").onclick = function() {
						//各ボタンの要素の取得
						let dialog = document
							.getElementById("confirm_dialog_admin");
						let yes = document.getElementById("yes");
						let no = document.getElementById("no");
						dialog.style.display = "block";

						yes.addEventListener("click",
							function () {
								dialog.style.display = "none";
							});
						no.addEventListener("click", function () {
							dialog.style.display = "none";
						});
					};
				function notify_dialog(text) {
					let dialog = document.getElementById("notify_dialog_admin");

					document.getElementById("notify_text").textContent = text;

					dialog.style.display = "block";
					ok.addEventListener("click", function () {
						<% DialogUtil.turnoffDialog(request, response); %>
							dialog.style.display = "none";
					});
				}
			</script>
		</section>
	</div>
</body>

</html>