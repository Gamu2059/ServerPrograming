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
<title>シラバス詳細（内容確認）</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス詳細（内容確認）</h2>
		<!-- メインコンテンツ -->
		<article>
			<%
			SyllabusUpdateInfo syllabusInfo = (SyllabusUpdateInfo)session.getAttribute("confirmUpdateSyllabusInfo");
			String teacherName = (String)session.getAttribute("confirmTeacherName");
			String updateSyllabusClassCode = (String)session.getAttribute("updateSyllabusClassCode");
			%>
			<br>
			<div class="syllabus_profile">
				<div class="item_for_grid_r1c2">
					<h3>授業コード</h3>
					<input type="text" placeholder="<%= syllabusInfo.getClassCode() %>" disabled="disabled">
				</div>
				<div class="item_for_grid_r1c1">
					<input id="syllabus_name" type="text" placeholder="<%= syllabusInfo.getClassName() %>" disabled="disabled">
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講主要学科</h3>
					<div id="course_year_list">
					<select name="subjectID" disabled="disabled">
						<!-- 学科情報の展開と表示 -->
						<%
						ArrayList<DepartmentGetInfo> departmentInfoList = new ArrayList<>();
						departmentInfoList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
						if(departmentInfoList!=null){
							for(DepartmentGetInfo departmentInfo: departmentInfoList){
								if( (int)syllabusInfo.getSubjectID() == (int)departmentInfo.getSubjectID() ){
									out.print("<option value=\""+departmentInfo.getSubjectID()+"\" selected >"+departmentInfo.getSubjectName()+"</option>");
								}else{
									out.print("<option value=\""+departmentInfo.getSubjectID()+"\">"+departmentInfo.getSubjectName()+"</option>");
								}
							}
						}
						%>
					</select>
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講年度</h3>
					<div id="course_year_list">
					<select name="semesterID" disabled="disabled">
						<%
						switch((int)syllabusInfo.getSemesterID()){
						case 1:
							out.print("<option value=\"1\" selected>2019年前期</option>");
							out.print("<option value=\"2\">2019年後期</option>");
							break;
						case 2:
							out.print("<option value=\"1\">2019年前期</option>");
							out.print("<option value=\"2\" selected>2019年後期</option>");
							break;
						}
						%>
					</select>
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<div class="item_for_grid_r1c2" id="week_syllabus">
						<h3>曜日</h3>
						<script type="text/javascript">
							let input_date = document.createElement('input');
							input_date.autocomplete = true;
							input_date.setAttribute('list', 'date_list');
							input_date.setAttribute('placeholder','<%= syllabusInfo.getDates() %>');
							input_date.setAttribute('disabled','disabled');
							document.getElementById('week_syllabus')
									.appendChild(input_date);

							let datalist_date = document
									.createElement('datalist');
							datalist_date.id = 'date_list';
							let name_date = Array(42);

							let week = [ '月曜 - ', '火曜 - ', '水曜 - ', '木曜 - ',
									'金曜 - ', '土曜 - ' ];
							let date = [ '1限', '2限', '3限', '4限', '5限', '6限',
									'7限' ];
							for (let j = 0; j < 6; j++) {
								for (let i = j * 7; i < (j + 1) * date.length; i++) {
									console.log(j)
									name_date[i] = week[j] + date[i - j * 7];
								}
							}
							name_date.forEach(function(name) {
								let option_date = document
										.createElement('option');
								option_date.value = name;
								datalist_date.appendChild(option_date);
							});
							document.getElementById('week_syllabus')
									.appendChild(datalist_date);
						</script>
					</div>
					<div class="item_for_grid_r1c2">
						<h3 id="unit">単位数</h3>
						<input type="number" placeholder="<%= syllabusInfo.getUnitNum() %>" disabled="disabled">
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教室</h3>
					<input type="text" placeholder="<%= syllabusInfo.getClassRoom() %>" disabled="disabled">
				</div>
				<div class="item_for_grid_r1c2" id="teacher_syllabus">
					<h3>教員</h3>
					<script type="text/javascript">
						let input = document.createElement('input');
						input.autocomplete = true;
						input.setAttribute('list', 'teacher_list');
						input.setAttribute('placeholder','<%= teacherName %>');
						input.setAttribute('disabled','disabled');
						document.getElementById('teacher_syllabus')
								.appendChild(input);

						let datalist = document.createElement('datalist');
						datalist.id = 'teacher_list';
						let names = [ '岩井将行', '鉄谷信二' ];/*ここは手打ちでもいいけど、DBなどから取得できると楽*/
						names.forEach(function(name) {
							let option = document.createElement('option');
							option.value = name;
							datalist.appendChild(option);
						});
						document.getElementById('teacher_syllabus')
								.appendChild(datalist);
					</script>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>目的概要</h3>
					<textarea disabled="disabled"><%= syllabusInfo.getOverview() %></textarea>
					<h3>達成目標</h3>
					<textarea disabled="disabled"><%= syllabusInfo.getTarget() %></textarea>
				</div>
				<div class="item_for_grid_r1c2_c12">
					<h3>履修条件</h3>
					<input type="text" placeholder="<%= syllabusInfo.getRequirements() %>" disabled="disabled" >
				</div>
				<div class="item_for_grid_r1c1">
					<h3>評価方法</h3>
					<textarea disabled="disabled"><%= syllabusInfo.getEvaluationMethod() %></textarea>
				</div>
			</div>
			<br>
			<div class="item_for_center">
			<!-- 送信するデータ -->

					<form action="<%= ServletPath.UpdateSyllabusInfo %>" method="post" name="createSyllabusForm" >
						<input type="hidden" name="previousClassCode" value="<%= syllabusInfo.getPreviousClassCode() %>">
						<input type="hidden" name="classCode" value="<%= syllabusInfo.getClassCode() %>">
						<input type="hidden" name="className" value="<%= syllabusInfo.getClassName() %>">
						<input type="hidden" name="subjectID" value="<%= syllabusInfo.getSubjectID() %>">
						<input type="hidden" name="semesterID" value="<%= syllabusInfo.getSemesterID() %>">
						<input type="hidden" name="dates" value="<%= syllabusInfo.getDates() %>">
						<input type="hidden" name="unitNum" value="<%= syllabusInfo.getUnitNum() %>">
						<input type="hidden" name="classRoom" value="<%= syllabusInfo.getClassRoom() %>">
						<input type="hidden" name="teacherID" value="<%= syllabusInfo.getTeacherID() %>">
						<input type="hidden" name="overview" value="<%= syllabusInfo.getOverview() %>">
						<input type="hidden" name="target" value="<%= syllabusInfo.getTarget() %>">
						<input type="hidden" name="requierments" value="<%= syllabusInfo.getRequirements() %>">
						<input type="hidden" name="evaluationMethod" value="<%= syllabusInfo.getEvaluationMethod() %>">
						<button type="submit" id="orange_button">確定</button>
					</form>

			</div>
			<br>
		</article>
	</div>
</body>
</html>