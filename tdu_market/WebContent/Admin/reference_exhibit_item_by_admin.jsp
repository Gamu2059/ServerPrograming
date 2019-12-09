<%@page import="tdu_market.util.JspPath"%>
<%@page import="tdu_market.dto.ItemGetInfo"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="/tdu_market/css/import_admin.css" type="text/css" />
<title>学生情報詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報詳細</h2>
		<!-- メインコンテンツ -->
		<!-- 出品者情報・出品情報の取得 -->
		<%
		StudentGetInfo studentInfo = (StudentGetInfo)session.getAttribute("studentInfo");
		ArrayList<ItemGetInfo> itemListInfo = (ArrayList<ItemGetInfo>)session.getAttribute("exhibitItemList");
		String studentName = "未設定";
		if(studentInfo != null){
			studentName = studentInfo.getDisplayName();
		}
		%>
		<article>
			<div class="content_margin_200px">
				<br />
				<h2><%= studentName %>さんの出品物</h2>
				<ul id="user_exhibit_list">
				<!-- 出品商品の表示 -->
				<%
				if(itemListInfo == null) {
					out.print("出品している商品は有りません");
				} else {
					for(int i=0 ; i<itemListInfo.size();i++){
						String itemImageURL = "/tdu_market/images/item_image.png";
						if(itemListInfo.get(i).getItemImageBinaries() != null) {
							itemImageURL = itemListInfo.get(i).getItemImageBinaries()[0];
						}
					%>
					<li>
					<form action="<%= ServletPath.ManagerReferItemPage %>" method="get">
						<input type="hidden" name="itemID" value="<%= itemListInfo.get(i).getItemID() %>">
						<input type="hidden" name="whereFromToItemPage" value="fromExhibitList">
						<button type="submit">
							<!-- 商品画像 -->
							<img src="<%= itemImageURL %>" />
							<!-- 商品名 -->
							<h3><%= itemListInfo.get(i).getItemName() %></h3>
							<div class="item_for_bottom">
								<!-- 商品価格 -->
								<h3><%= itemListInfo.get(i).getPrice() %>円</h3>
							</div>
						</button>
					</form>
					</li>
					<%
					}
				}
				%>
				</ul>
				<br />
				<!-- 戻るボタン -->
				<button id="white_button">戻る</button>
				<script type="text/javascript">
					document.getElementById("white_button").onclick = function() {
					<%
					if(session.getAttribute("itemInfo")!=null){
					 	out.print("window.history.back(-1);");
					}else{
						out.print("location.href='"+JspPath.reference_student_detail_by_admin+"'");
					}
					%>
					return false;
				};
				</script>
			</div>
		</article>
		<br />
	</div>
</body>
</html>