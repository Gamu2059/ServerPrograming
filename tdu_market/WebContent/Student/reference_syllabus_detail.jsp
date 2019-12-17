<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.*"%>
<%@page import="tdu_market.util.ServletPath"%>
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
					<%
					ArrayList<RelatedClassGetInfo> info = (ArrayList<RelatedClassGetInfo>)session.getAttribute("getInfo");
					SyllabusGetInfo syllabusGetInfo = (SyllabusGetInfo)session.getAttribute("syllabusInfo");
					%>

					<!-- セッションに関連商品を記録して画面を遷移させる -->
					<form action="<%=ServletPath.SearchItemPage %>" name="get">
						<%
						String classCode ="" ;
						String className="";
						String openingSemester="";
						String date="";
						int unitNum = 0;
						String classRoom="";
						String teacherName="";
						String target="";
						String requirments="";
						String orverView="";
						String evaluationMethod="";
						if(info!=null){
							classCode = info.get(0).getSyllabusGetInfo().getClassCode();
							className = info.get(0).getSyllabusGetInfo().getClassName();
							openingSemester = info.get(0).getSyllabusGetInfo().getOpeningSemester();
							date = info.get(0).getSyllabusGetInfo().getDates();
							unitNum = info.get(0).getSyllabusGetInfo().getUnitNum();
							classRoom = info.get(0).getSyllabusGetInfo().getClassRoom();
							teacherName = info.get(0).getSyllabusGetInfo().getTeacherName();
							target = info.get(0).getSyllabusGetInfo().getTarget();
							requirments = info.get(0).getSyllabusGetInfo().getRequirments();
							orverView = info.get(0).getSyllabusGetInfo().getOverview();
							evaluationMethod = info.get(0).getSyllabusGetInfo().getEvaluationMethod();
						}else if(syllabusGetInfo!=null){
							classCode = syllabusGetInfo.getClassCode();
							className = syllabusGetInfo.getClassName();
							openingSemester = syllabusGetInfo.getOpeningSemester();
							date = syllabusGetInfo.getDates();
							unitNum = syllabusGetInfo.getUnitNum();
							classRoom = syllabusGetInfo.getClassRoom();
							teacherName = syllabusGetInfo.getTeacherName();
							target = syllabusGetInfo.getTarget();
							requirments = syllabusGetInfo.getRequirments();
							orverView = syllabusGetInfo.getOverview();
							evaluationMethod = syllabusGetInfo.getEvaluationMethod();
						}else{
						}

						System.out.println();
						System.out.println("info :"+info);
						System.out.println("syllabusGetInfo :"+syllabusGetInfo);
						System.out.println();

						ArrayList<ItemGetInfo> item_info = new ArrayList<>();
						if(syllabusGetInfo==null){
							for(int i=0;i<info.size();i++){
								item_info.add(info.get(i).getItemGetInfo());
								if(100 < i){
									//１００件を超える商品が登録されている場合は追加を打ち切りにする
									break;
								}
							}
							session.setAttribute("itemList", item_info);
						}else if(info==null){
							session.setAttribute("itemList", null);
							item_info = null;
						}
						%>
						<!-- <input type="submit" class="button_flat_normal" value="商品検索" onClick="location.href='reference_item_list.jsp'"/> -->
						<a href="#related_item"><button type="button" class="button_flat_normal">関連商品へ</button></a>
					</form>
					<!--ページ内の遷移-->
				</nav>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_syllabus">
				<div class="detail_content_syllabus_top">
					<h3 id="title">授業コード</h3>
					<h3><%= classCode %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3><%= className %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">開講年度</h3>
					<h3><%= openingSemester %></h3>
				</div>
				<div class="detail_content_syllabus">
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">曜日</h3>
						<h3><%= date %></h3>
					</div>
					<div class="detail_content_syllabus_ver2">
						<h3 id="title">単位数</h3>
						<h3><%= unitNum %></h3>
					</div>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教室</h3>
					<h3><%= classRoom %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">教員</h3>
					<h3><%= teacherName %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">目的概要</h3>
					<h3><%= target %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">達成目標</h3>
					<h3><%= orverView %></h3>
				</div>
				<div class="detail_content_syllabus">
					<h3 id="title">履修条件</h3>
					<h3><%= requirments %></h3>
				</div>
				<div class="detail_content_syllabus_textbox">
					<h3 id="title">評価方法</h3>
					<h3><%= evaluationMethod %></h3>
				</div>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver4">
				<nav>
					<h4 id="related_item">出品された教科書</h4>
					<br />
					<div class="new_item_list">
					<%
					if(item_info == null){
						out.print("出品された教科書は見つかりませんでした。");
					} else {
						if(item_info.size()<4){
							for(int i=0;i<item_info.size(); i++){
								out.print("<form action=\"/tdu_market/tdu_market/controller/ReferItemPage\" method=\"get\">");
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
								out.print("<form action=\"/tdu_market/tdu_market/controller/ReferItemPage\" method=\"get\">");
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