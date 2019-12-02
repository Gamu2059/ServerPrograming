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
<title>シラバス情報検索</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス情報検索</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_300px">
				<br />
				<div class="search_box">
				<form action="<%= ServletPath.ManagerSearchSyllabusInfo %>" method="post" >
					<h2>シラバス検索</h2>
					<br />
					<h3>授業コード</h3>
					<input type="text" name="classCodeKeyword" />
					<h3>授業名</h3>
					<input type="text" name="classNameKeyword" />
					<h3>学科</h3>
					<select name="subjectID">
					<!-- 学科情報の展開と表示 -->
						<option value="0"></option>
						<%
						ArrayList<DepartmentGetInfo> departmentInfoList = new ArrayList<>();
						departmentInfoList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
						if(departmentInfoList!=null){
							for(DepartmentGetInfo departmentInfo: departmentInfoList){
								out.print("<option value=\""+departmentInfo.getSubjectID()+"\">"+departmentInfo.getSubjectName()+"</option>");
							}
						}
						%>
					</select>
					<h3>担当教員</h3>
					<input type="text" name="teacherNameKeyword" autocomplete="on" list="teacherList" accept-charset="UTF-8" />
					<datalist id="teacherList">
					<!-- 教員情報の展開と表示 -->
					<%
					ArrayList<TeacherGetInfo> teacherInfo = new ArrayList<>();
					teacherInfo = (ArrayList<TeacherGetInfo>)session.getAttribute("teacherInfoList");
					if(teacherInfo!=null){
						for(TeacherGetInfo teacher:teacherInfo){
							out.print("<option value=\""+teacher.getTeacherName()+"\">");
						}
					}
					%>
					</datalist>
					<h3>開講年度</h3>
					<select name="semesterID">
					<!-- 開講年度の展開と表示 -->
						<option value="0"></option>
					<%
					ArrayList<SemesterGetInfo> semesterInfo = new ArrayList<>();
					semesterInfo = (ArrayList<SemesterGetInfo>)session.getAttribute("semesterInfoList");
					if(semesterInfo!=null){
						for(SemesterGetInfo info:semesterInfo){
							out.print("<option value=\""+info.getSemesterID()+"\">"+info.getYear()+"年度"+info.getSemester()+"</option>");
						}
					}
					%>
					</select> <br /> <br />
					<div class="item_for_center">
						<button type="submit" id="orange_button">検索</button>
					</div>
				</form>
				</div>
				<br />
				<div class="item_for_left">
					<form action="<%= ServletPath.ManagerReferSyllabusListPage %>" method="post">
						<button id="white_button">戻る</button>
					</form>
				</div>
			</div>
		</article>
		<br />
	</div>
</body>
</html>