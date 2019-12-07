<%@page import="java.awt.print.Printable"%>
<%@page import="tdu_market.dto.DepartmentGetInfo"%>
<%@page import="tdu_market.dto.TeacherGetInfo"%>
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
<title>シラバス詳細（登録）</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス詳細（登録）</h2>
		<!-- メインコンテンツ -->
		<article>
		<form action="<%= ServletPath.VaildateRegisterSyllabus %>" method="post">
			<br>
			<div class="errorMessage">
				<%
				if(session.getAttribute("createSyllabusErrorMessage")!=null){
					out.print("<p>"+session.getAttribute("createSyllabusErrorMessage")+"</p>");
				}
				%>
			</div>
			<div class="syllabus_profile">
				<div class="item_for_grid_r1c2">
					<h3>授業コード</h3>
					<input type="text" name="classCode" placeholder="例：00000000000000000" required>
				</div>
				<div class="item_for_grid_r1c1">
					<input id="syllabus_name" type="text" name="className" placeholder="授業名 例：ぬこでもわかるJAVA" required>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講主要学科</h3>
					<div id="course_year_list">
					<select name="subjectID" required>
						<!-- 学科情報の展開と表示 -->
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
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講年度</h3>
					<div id="course_year_list">
					<select name="semesterID" required>
						<option value="1">2019年前期</option>
						<option value="2">2019年後期</option>
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
							input_date.setAttribute('name', 'dates');
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
						<input type="number" placeholder="0.0" max="4" min="0" name="unitNum" required>
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教室</h3>
					<input type="text" placeholder="例： 2000教室 " name="classRoom" required>
				</div>
				<div class="item_for_grid_r1c2" id="teacher_syllabus">
					<h3>教員</h3>
					<input type="text" name="teacherName" autocomplete="on" list="teacherList" accept-charset="UTF-8" required >
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
					<!-- <script type="text/javascript">
						let input = document.createElement('input');
						input.autocomplete = true;
						input.setAttribute('list', 'teacher_list');
						document.getElementById('teacher_syllabus').appendChild(input);

						let datalist = document.createElement('datalist');
						datalist.id = 'teacher_list';
						let names = [ '岩井将行', '鉄谷信二' ];/*ここは手打ちでもいいけど、DBなどから取得できると楽*/
						names.forEach(function(name) {
							let option = document.createElement('option');
							option.value = name;
							datalist.appendChild(option);
						});
						document.getElementById('teacher_syllabus').appendChild(datalist);
					</script> -->
				</div>
				<div class="item_for_grid_r1c1">
					<h3>目的概要</h3>
					<textarea name="overview"></textarea>
					<h3>達成目標</h3>
					<textarea name="target"></textarea>
				</div>
				<div class="item_for_grid_r1c2_c12">
					<h3>履修条件</h3>
					<input type="text" name="requierments">
				</div>
				<div class="item_for_grid_r1c1">
					<h3>評価方法</h3>
					<textarea name="evaluationMethod"></textarea>
				</div>
			</div>
			<br>
			<div class="item_for_center">
				<button type="submit" id="orange_button">登録</button>
			</div>
			<br>
		</form>
		</article>

		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<!-- <div id="confirm_dialog_admin">
				<p id="confirm_text">登録しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_submit">確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div> -->

			<script type="text/javascript">
				/* document.getElementById('orange_button').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					document.getElementById('confirm_text').textContent = '登録しますか？';

					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる
						reconfirm_dialog('続けて登録しますか？');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';

					});
				} */
				/* function reconfirm_dialog(text) {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					document.getElementById('confirm_text').textContent = text;

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

					});
					no.addEventListener('click', function() {
						location.href = 'reference_syllabus_list_by_admin.html'
						dialog.style.display = 'none';
					});
				} */
			</script>
		</section>
	</div>
</body>
</html>