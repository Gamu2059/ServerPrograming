<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.SyllabusGetInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- InstanceBeginEditable name="title" -->
<title>授業名</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="/tdu_market/css/import_student.css" rel="stylesheet" />
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="/tdu_market/js/student.js" defer="defer"></script>
<!-- InstanceEndEditable -->
</head>
<body onLoad="document.searchItem.submit();">
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->

	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver4">
				<nav>
					<!-- ReferSyllabusPageからのデータを展開する -->
					<% SyllabusGetInfo info = (SyllabusGetInfo)request.getAttribute("getInfo"); %>

					<!-- SearchItemPageを使って関連商品を検索する -->
					<form action="../SearchItemPage" name="get">
						<input type="hidden" name="サーブレットの授業コード引数" value="<% out.print(info.getClassCode()); %>"/>
						<input type="submit" class="button_flat_normal" value="関連商品"/>
					</form>

					<!-- SearchItemPageを使って関連商品を５つ検索する(自動実行) -->
					<form name="searchItem" action="../SearchItemPage" method="get">
						<input type="hidden" name=""サーブレットの検索引数（授業コード）を入力する"" value="<% out.print(info.getClassCode()); %>" />
					</form>
					<!-- 検索結果を格納する -->
					<%
					ArrayList<> searchResult = new ArrayLsit<>();
					searchResult = (ArrayList<>)request.getAttribute("SearchItemPageで定義した引数を入力する");
					%>

					<!--ページ内の遷移-->
				</nav>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_syllabus">
				<div class="detail_content_syllabus_top">
					<h3 id="title">授業コード</h3>
					<h3><% out.print(info.getClassCode()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3><% out.print(info.getClassName()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">開講年度</h3>
					<h3><% out.print(info.getOpeningSemester()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">曜日</h3>
						<h3><% out.print(info.getDates()); %></h3>
					</div>
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">単位数</h3>
						<h3><% out.print(info.getUnitNum()); %></h3>
					</div>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教室</h3>
					<h3><% out.print(info.getClassRoom()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教員</h3>
					<h3><% out.print(info.getTeacherName()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">目的概要</h3>
					<h3><% out.print(info.getTarget()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">達成目標</h3>
					<h3><% out.print(info.getRequirments());%></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">履修条件</h3>
					<h3><% out.print(info.getRequirments()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">評価方法</h3>
					<h3><% out.print(info.getEvaluationMethod()); %></h3>
				</div>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver4">
				<nav>
					<h4>出品された教科書</h4>
					<br />
					<div class="new_item_list">
					<%
					if(searchResult == null){
						out.print("出品された教科書は見つかりませんでした。");
					} else {
						if(searchResult.size()<4){
							for(int i=0;i<searchResult.size();i++){
								out.print("<button id=\"item_button\">");
								out.print("<img src=\""+searchResultから商品画像を取得する+"\" alt=\"商品画像\" />");
								out.print("<h5>"+searchResultから商品名を取得する+"</h5>";)
								out.print("<h4>"+searchResultから金額を取得する+"円</h4>");
								out.print("</button>");
							}
						} else {
							for(int i=0;i<5;i++){
								out.print("<button id=\"item_button\">");
								out.print("<img src=\""+searchResultから商品画像を取得する+"\" alt=\"商品画像\" />");
								out.print("<h5>"+searchResultから商品名を取得する+"</h5>";)
								out.print("<h4>"+searchResultから金額を取得する+"円</h4>");
								out.print("</button>");
							}
						}
					}
					%>
					</div>
				</nav>
			</div>
			<div class="third_container_ver4">
				<nav>
					<h4>出品された他の商品</h4>
					<br />
					<div class="new_item_list">
						<%
					if(searchResult == null){
						out.print("出品された教科書は見つかりませんでした。");
					} else {
						if(searchResult.size()<4){
							for(int i=0;i<searchResult.size();i++){
								out.print("<button id=\"item_button\">");
								out.print("<img src=\""+searchResultから商品画像を取得する+"\" alt=\"商品画像\" />");
								out.print("<h5>"+searchResultから商品名を取得する+"</h5>";)
								out.print("<h4>"+searchResultから金額を取得する+"円</h4>");
								out.print("</button>");
							}
						} else {
							for(int i=0;i<5;i++){
								out.print("<button id=\"item_button\">");
								out.print("<img src=\""+searchResultから商品画像を取得する+"\" alt=\"商品画像\" />");
								out.print("<h5>"+searchResultから商品名を取得する+"</h5>";)
								out.print("<h4>"+searchResultから金額を取得する+"円</h4>");
								out.print("</button>");
							}
						}
					}
					%>
					</div>
				</nav>
			</div>
		</article>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>