<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.*"%>
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
					<% ArrayList<RelatedClassGetInfo> info = (ArrayList<RelatedClassGetInfo>)request.getAttribute("getInfo"); %>

					<!-- セッションに関連商品を記録して画面を遷移させる -->
					<form action="../SearchItemPage" name="get">
						<%
						ArrayList<ItemGetInfo> item_info = new ArrayList<>();
						for(int i=0;i<info.size();i++){
							item_info.add(info.get(i).getItemGetInfo());
							if(100 < i){
								//１００件を超える商品が登録されている場合は追加を打ち切りにする
								break;
							}
						}
						session.setAttribute("itemList", item_info);
						%>
						<input type="submit" class="button_flat_normal" value="関連商品" onClick="location.href='reference_item_list.jsp'"/>
					</form>
					<!--ページ内の遷移-->
				</nav>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_syllabus">
				<div class="detail_content_syllabus_top">
					<h3 id="title">授業コード</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getClassCode()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getClassName()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">開講年度</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getOpeningSemester()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">曜日</h3>
						<h3><% out.print(info.get(0).getSyllabusGetInfo().getDates()); %></h3>
					</div>
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">単位数</h3>
						<h3><% out.print(info.get(0).getSyllabusGetInfo().getUnitNum()); %></h3>
					</div>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教室</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getClassRoom()); %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教員</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getTeacherName()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">目的概要</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getTarget()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">達成目標</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getRequirments());%></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">履修条件</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getRequirments()); %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">評価方法</h3>
					<h3><% out.print(info.get(0).getSyllabusGetInfo().getEvaluationMethod()); %></h3>
				</div>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver4">
				<nav>
					<h4>出品された教科書</h4>
					<br />
					<div class="new_item_list">
					<%
					if(item_info == null){
						out.print("出品された教科書は見つかりませんでした。");
					} else {
						if(item_info.size()<4){
							for(int i=0;i<item_info.size(); i++){
								out.print("<form action=\"../ReferItemPage\" method=\"get\">");
								out.print("<input type=\"hidden\" name=\"itemID\" value=\""+item_info.get(i).getItemID()+"\" />");
								out.print("<button id=\"item_button\" type=\"submit\">");
								out.print("<img src=\""+item_info.get(i).getItemImageBinaries()[0]+"\" alt=\"商品画像\" />");
								out.print("<h5>"+item_info.get(i).getItemName()+"</h5>");
								out.print("<h4>"+item_info.get(i).getPrice()+"円</h4>");
								out.print("</button>");
								out.print("</form>");
							}
						} else {
							for(int i=0;i<5;i++){
								out.print("<form action=\"../ReferItemPage\" method=\"get\">");
								out.print("<input type=\"hidden\" name=\"itemID\" value=\""+item_info.get(i).getItemID()+"\" />");
								out.print("<button id=\"item_button\" type=\"submit\">");
								out.print("<img src=\""+item_info.get(i).getItemImageBinaries()[0]+"\" alt=\"商品画像\" />");
								out.print("<h5>"+item_info.get(i).getItemName()+"</h5>");
								out.print("<h4>"+item_info.get(i).getPrice()+"円</h4>");
								out.print("</button>");
								out.print("</form>");
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