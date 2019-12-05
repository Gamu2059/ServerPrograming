<%@page import="tdu_market.controller.ReferItemPage"%>
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
<title>商品情報一覧</title>
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
	<article class="content">
		<!-- ファーストコンテナ -->
		<div class="first_container_ver3">
			<h2>商品情報一覧</h2>
			<select name="sort_item" id="sort_item">
				<!--新着,カテゴリ,キャンパス,名前,価格,講義名-->
				<option value="new_item">新着</option>
				<option value="category">カテゴリ</option>
				<option value="campus">キャンパス</option>
				<option value="name_asc">名前（昇順）</option>
				<option value="name_desc">名前（降順）</option>
				<option value="price_asc">価格（昇順）</option>
				<option value="price_desc">価格（降順）</option>
				<option value="class_asc">講義名（昇順）</option>
				<option value="class_desc">講義名（降順）</option>
			</select>
		</div>
		<br>
		<div class="new_item_list">
			<!-- ReferSyllabusListPageからのセッションデータを展開する -->
			<%
			ArrayList<ItemGetInfo> itemList = new ArrayList<>();
			itemList = (ArrayList<ItemGetInfo>)session.getAttribute("itemList");
			if(itemList == null){
				out.print("商品が見つかりませんでした。");
			} else {
				for(int i=0;i<itemList.size();i++){
					out.print("<form action=\"/tdu_market/tdu_market/controller/ReferItemPage\" method=\"get\">");
					out.print("<button type=\"submit\" id=\"item_button\" name = \"itemID\" value=\""+itemList.get(i).getItemID()+"\">");
					out.print("<img src=\""+itemList.get(i).getItemImageBinaries()[0]+"\" alt=\"商品画像\" />");
					out.print("<h5>"+itemList.get(i).getItemName()+"</h5>");
					out.print("<h4>"+itemList.get(i).getPrice()+"円</h4>");
					out.print("</button>");
					out.print("</form>");
				}
			}
			%>
		</div>
	</article>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>

</body>
</html>