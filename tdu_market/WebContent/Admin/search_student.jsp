<%@page import="tdu_market.dto.DepartmentGetInfo"%>
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
<title>学生情報検索</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報検索</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_400px">
				<br>
				<div class="search_box">
				<form action="<%= ServletPath.ReferStudentListPage %>" method="get">
					<h2>学生検索</h2>
					<br>
					<h3>学籍番号</h3>
					<input type="text" name="studentNumberKeyword">
					<h3>学科</h3>
					<select name="condition" name="subjectID">
						<option value="0"></option>
						<%
						ArrayList<DepartmentGetInfo> departmentInfo = new ArrayList<>();
						departmentInfo = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
						for( DepartmentGetInfo info:departmentInfo ){
							out.print("<option value=\""+info.getSubjectID()+"\">"+info.getFacultyName()+" - "+info.getSubjectName()+"</option>");
						}
						%>
					</select>
					<h3>ディスプレイネーム</h3>
					<input type="text" name="displayNameKeyword"> <br> <br>
					<div class="item_for_center">
						<button id="orange_button">検索</button>
					</div>
				</form>
				</div>
				<br>
				<div class="item_for_left">
					<form action="<%= ServletPath.ReferStudentListPage %>" method="get">
						<button id="white_button">戻る</button>
					</form>
				</div>
			</div>
		</article>
		<br>
	</div>
</body>
</html>