<%@page import="java.util.*"%>
<%@page import="tdu_market.dto.*" %>
<%@page import="tdu_market.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>トップ画面</title>
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
		<div class="first_container">
			<!-- 商品検索入力フォーム -->
			<form class="input_form" action=<%=ServletPath.ReferItemListPage %> method="post">
				<div>
					<input type="text" name="itemNameKeyword" class="radius_text_form" size="70"
						placeholder="全ての商品から探す（教科書名、道具名など）" />
					<button type="submit" name="item_search" class="search_button">
						<input type="hidden" name="condtion" value="">
						<input type="hidden" name="maxPrice" value="">
						<img src="../images/search.png" alt="虫眼鏡" />
					</button>
				</div>
			</form>
			<!-- 出品ボタン -->
			<div class="exhibit_button">
				<form action="<%=ServletPath.RegisterExhibitItemPage%>">
					<button type="submit" name="exhibit">出品！</button>
				</form>
			</div>
		</div>
		<!-- セカンドコンテナ -->
		<div class="second_container">
			<!-- タイトル -->
			<h2>新着</h2>
			<!-- 新着商品一覧 -->
			<div class="new_item_list">
				<!-- ページを読み込んだ時に新着情報を取得（自動実行） -->
				<% ArrayList<ItemGetInfo> newItemList = new ArrayList<ItemGetInfo>();
	  				newItemList = (ArrayList<ItemGetInfo>)session.getAttribute("newItemList");
	  				if(newItemList == null){
	  					out.print("新着商品はありません");
	  				} else {
	  					for(int i=0;i<newItemList.size();i++){
		  					out.print("<button id=\"item_button\" type=\" submit \" value=\" "+ newItemList.get(i).getItemID() +"  \">");
		  					if(newItemList.get(i).getItemImageBinaries() != null){
		  						out.print("<img src=\" " + newItemList.get(i).getItemImageBinaries()[0] +" \"/>");
		  					}
		  					out.print("<h5>"+newItemList.get(i).getItemName()+"</h5>");
		  					out.print("<h4>"+newItemList.get(i).getPrice()+"</h4>");
		  					out.print("</button>");
		  				}
	  				}
	  				%>
			</div>
		</div>
		<!-- サードコンテナ -->
		<div class="third_container">
			<!-- すべて見るボタン -->
			<aside class="aside_info">
			<form action="<%=ServletPath.ReferItemListPage %>" method="post">
				<input type="hidden" name="oldestDate" value="1"/>
				<button type="submit"class="noneButton"><a>すべて見る...</a></button>
			</form>
			</aside>
			<!-- もっと探すボタン -->
			<nav class="more_search">
				<button type="submit" name="search" class="button_flat_submit" onclick="location.href='<%=JspPath.search_from_exhibit %>'">
					もっと探す</button>
			</nav>
		</div>
	</article>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>
</body>
</html>