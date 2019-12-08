<%@page import="tdu_market.dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="tdu_market.util.ServletPath"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>シラバス検索</title>
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
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2"></div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver4">
				<h3>シラバス照会</h3>
				<br>
				<form action="<%=ServletPath.ReferSyllabusListPage%>" method="post">
					<div class="detail_content">
						<h3>授業コード</h3>
						<input id="class_code_field" type="text" name="classCode">
					</div>
					<hr>
					<div class="detail_content">
						<h3>学科組織</h3>
						<select id="department" name="departmentID">
							<%
							ArrayList<DepartmentGetInfo> departmentList = new ArrayList<>();
							departmentList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentList");
							out.print("<option value=\"0\"></option>");
							if(departmentList!=null){
								for(DepartmentGetInfo _departmentList:departmentList){
									out.print("<option value=\""+_departmentList.getSubjectID()+"\">"+_departmentList.getFacultyName()+" - "+_departmentList.getSubjectName()+"</option>");
								}
							}
							%>
						</select>
					</div>
					<div class="detail_content">
						<h3>授業名</h3>
						<input id="class_name_field" type="text" name="classNameKeyword">
					</div>
					<div class="detail_content">
						<h3>担当教員</h3>
						<input id="teacher_field" type="text" name="seacherNameKeyword" autocomplete="on" list="teacherList">
						<datalist id="teacherList">
						<%
						ArrayList<TeacherGetInfo> teacherList = new ArrayList<>();
						teacherList = (ArrayList<TeacherGetInfo>)session.getAttribute("teacherList");
						if(teacherList!=null){
							for(TeacherGetInfo teacher:teacherList){
								out.print("<option value=\""+teacher.getTeacherName()+"\">");
							}
						}
						%>
						</datalist>
					</div>
					<br>
					<!-- サードコンテナ -->
					<div class="third_container_ver3">
						<button type="submit" class="button_flat_submit">検索</button>
					</div>
				</form>
			</div>
		</article>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>