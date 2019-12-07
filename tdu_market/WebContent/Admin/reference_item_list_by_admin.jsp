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
				<select name="sort_item">
					<option value="1">商品名</option>
					<option value="2">学籍番号</option>
					<option value="3">名前</option>
					<option value="4">関連授業</option>
					<option value="5">価格</option>
				</select>
			</div>
			<!-- テーブル -->
			<form name="select_item">
				<div class="item_for_center">
					<div class="list">
						<table>
							<!-- テーブルタイトル -->
							<thead class="list_title">
								<tr>
									<th class="check_column1"></th>
									<tb class="hidden_column">商品ID</tb>
									<th class="item_column1">商品名</th>
									<th class="item_column2">学籍場号</th>
									<th class="item_column3">出品者</th>
									<th class="item_column4">関連授業名</th>
									<th class="item_column5">価格</th>
								</tr>
							</thead>
							<!-- テーブル要素 -->
							<tbody class="list_content">
							<%
							ArrayList<ItemGetInfo> itemInfo = new ArrayList<>();
							itemInfo = (ArrayList<ItemGetInfo>)session.getAttribute("itemListInfo");
							Map<Long,String> relatedItemIdAndSyllabusIdMap = new HashMap<>();
							relatedItemIdAndSyllabusIdMap = (Map<Long,String>)session.getAttribute("relatedItemIdAndSyllabusIdMap");
							Map<Long,String> relatedItemIdAndStudentNameMap = new HashMap<>();
							relatedItemIdAndStudentNameMap = (Map<Long,String>)session.getAttribute("relatedItemIdAndStudentNameMap");
							if(itemInfo != null){
								for(ItemGetInfo item : itemInfo){
									%>
									<tr class="exhibitId">
										<td class="check_column1"><input type="checkbox" /></td>
										<td class="hidden_column" hidden><%= item.getItemID() %></td>
										<td class="item_column1"><%= item.getItemName() %></td>
										<td class="item_column2"><%= item.getExhibitorMailAddress().split("@", 0)[0] %></td>
										<td class="item_column3"><%= relatedItemIdAndStudentNameMap.get(item.getItemID()) %></td>
										<td class="item_column4"><%= relatedItemIdAndSyllabusIdMap.get(item.getItemID()) %></td>
										<td class="item_column5"><%= item.getPrice() %></td>
									</tr>
									<%
								}
							}
							%>
							</tbody>
						</table>
						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".exhibitId").on("click",function() {
								//商品IDの取得
								var itemId = $(this).children("td")[1].innerText;
								//Input型エレメントの生成
								var element = document.createElement("input");
								//typeの設定
								element.setAttribute("type","submit");
								//nameの設定
								element.setAttribute("name","selectItem");
								//valueの設定
								element.setAttribute("value",itemId);
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
			</form>
			<!-- 絞り込みボタン -->
			<div class="item_for_LeftAndRight_around">
				<button id="red_button">削除</button>
				<button class="search_button" type="button">
					<img src="/tdu_market/images/search.png" />絞り込み
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
			<div id="confirm_dialog_admin">
				<p>削除しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_nega">確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById("red_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					dialog.style.display = "block";

					yes.addEventListener("click",
							function() {
								dialog.style.display = "none";

								//ここに内部処理をいれる

								notify_dialog("削除しました。",
										"reference_item_list_by_admin"); /*再読み込みがかかります*/
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