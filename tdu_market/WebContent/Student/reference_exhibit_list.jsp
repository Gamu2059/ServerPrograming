<%@page import="tdu_market.dto.ItemGetInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.util.ServletPath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物一覧</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="/tdu_market/css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="/tdu_market/js/student.js"
	defer="defer"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>出品物一覧</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container">
				<!--これはタブです。参考　→　https://bagelee.com/design/css/create_tabs_using_only_css/-->
				<div class="tab">
					<!--idタグとforタグが同じであること。-->
					<input id="exhibiting_list" name="tab_item" type="radio" checked>
					<label class="tab_item" for="exhibiting_list">出品中</label> <input
						id="trading_list" name="tab_item" type="radio"> <label
						class="tab_item" for="trading_list">取引中</label>
					<!--ここは一例です。必要に応じて補ってください。-->
					<!-- ReferExhibitItemListPageからのセッションデータを展開する -->
					<%
						ArrayList<ItemGetInfo> itemList = new ArrayList<>();
						itemList = (ArrayList<ItemGetInfo>) session.getAttribute("itemList");
					%>
					<div class="tab_content" id="exhibiting_content">
						<!-- 取引待ち商品データを表示する -->
						<%
							int count = 0;
							if (itemList != null) {
								for (int i = 0; i < itemList.size(); i++) {
									if (itemList.get(i).getTradingState() == 0) {
										out.print(
												"<form action=\"/tdu_market/tdu_market/controller/ReferExhibitItemPage\" method=\"get\">");
										out.print("<button id=\"exhibit_button\" type=\"submit\" name=\"\">");
										out.print("<img src=\""+itemList.get(i).getItemImageBinaries()[0]+"\" alt=\"商品画像\">");
										out.print("<label id=\"item_name\">" + itemList.get(i).getItemName() + "</label>");
										out.print("<label id=\"item_price\">" + itemList.get(i).getPrice() + "円</label>");
										out.print("</button>");
										out.print("<input type=\"hidden\" name=\"itemID\" value=\"" + itemList.get(i).getItemID() + "\">");
										out.print("</form>");
										count++;
									}
								}
							}
							if (count == 0) {
								out.print("取引待ちの商品が見つかりませんでした。");
							}
						%>
					</div>
					<!-- 取引中の商品データを表示する -->
					<%
						int count2 = 0;
						if (itemList != null) {
							for (int i = 0; i < itemList.size(); i++) {
								if (itemList.get(i).getTradingState() == 1) {
									out.print(
											"<form action=\"/tdu_market/tdu_market/controller/ReferExhibitItemPage\" method=\"get\">");
									out.print("<button id=\"exhibit_button\" type=\"submit\">");
									out.print("<img src=\"itemList.get(i).getItemImageBinaries()[0]\" alt=\"商品画像\">");
									out.print("<label id=\"item_name\">" + itemList.get(i).getItemName() + "</label>");
									out.print("<label id=\"item_price\">" + itemList.get(i).getPrice() + "円</label>");
									out.print("</button>");
									out.print("</form>");
								}
							}
						}
						if (count2 == 0) {
							out.print("取引中の商品が見つかりませんでした。");
						}
					%>
				</div>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
		</article>
		<script type="text/javascript">
			<% if((boolean)session.getAttribute("isDisplayDialog")){%>
				notify_dialog('<%= (String)session.getAttribute("dialogMessage") %>');
			<% } %>
			function notify_dialog(text) {
				let dialog = document.getElementById('notify_dialog');
	
				document.getElementById('notify_text').textContent = text;
	
				dialog.style.display = 'block';
				ok.addEventListener('click', function() {
					<% session.setAttribute("isDisplayDialog", false); %>
					dialog.style.display = 'none';
				});
			}
		</script>
	</div>

	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>