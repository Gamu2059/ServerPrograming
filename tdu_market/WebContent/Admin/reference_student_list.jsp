<%@page import="tdu_market.util.DialogUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="tdu_market.dto.DepartmentGetInfo"%>
<%@page import="tdu_market.dto.StudentGetInfo"%>
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
<title>学生情報一覧</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報一覧</h2>
		<!-- メインコンテンツ -->
		<article>
			<!-- ソート -->
			<div class="sort">
				<form name="sort_student">
				<select id="sort_number" onchange="sort_studentList();">
					<option value="1">学籍番号(昇順)</option>
					<option value="２">学籍番号(降順)</option>
					<option value="3">名前(昇順)</option>
					<option value="4">名前(降順)</option>
					<option value="5">学部(昇順)</option>
					<option value="6">学部(降順)</option>
					<option value="7">学科(昇順)</option>
					<option value="8">学科(降順)</option>
					<option value="9">出品数(昇順)</option>
					<option value="10">出品数(降順)</option>
				</select>
				</form>
			</div>
			<!-- テーブル -->
			<div class="item_for_center">
				<div class="list_content">
					<form action="<%= ServletPath.ManagerReferStudentPage %>" name="select_student" method="get">

						<table id="studentList">
							<!-- テーブルタイトル -->
							<thead class="list_title">
								<tr>
									<th class="check_column1"></th>
									<tb class="hidden_column">メールアドレス</tb>
									<th class="student_column1" data-sort="student_column1">学籍番号</th>
									<th class="student_column2" data-sort="student_column2">名前</th>
									<th class="student_column3" data-sort="student_column3">学部</th>
									<th class="student_column4" data-sort="student_column4">学科</th>
									<th class="student_column5" data-sort="student_column5">出品数</th>
								</tr>
							</thead>
							<!-- テーブル要素 -->
							<tbody class="list" id="list_content" >
								<!-- Sessionからデータを受け取る -->
								<%
								ArrayList<StudentGetInfo> studentList = new ArrayList<>();
								ArrayList<DepartmentGetInfo> departmentList = new ArrayList<>();
								Map<String,Integer> studentAndExhibitMap = new HashMap<>();

								studentList = (ArrayList<StudentGetInfo>)session.getAttribute("studentList");
								departmentList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
								studentAndExhibitMap = (HashMap<String,Integer>)session.getAttribute("studentAndExhibitMap");

								if(studentList==null){
									out.print("登録されている学生情報はありません。");
								}else{
									for(int i=0;i<studentList.size();i++){
										out.print("<tr class=\"studentId\">");
										out.print("<th class=\"check_column1\"><input type=\"checkbox\" /></th>");
										out.print("<td class=\"hidden_column\">"+studentList.get(i).getMailAddress()+"</td>");
										out.print("<td class=\"student_column1\">"+studentList.get(i).getMailAddress().split("@", 0)[0]+"</td>");
										out.print("<td class=\"student_column2\">"+studentList.get(i).getDisplayName()+"</td>");
										out.print("<td class=\"student_column3\">"+departmentList.get((int)studentList.get(i).getDepartmentID() -1).getFacultyName()+"</td>");
										out.print("<td class=\"student_column4\">"+departmentList.get((int)studentList.get(i).getDepartmentID() -1).getSubjectName()+"</td>");
										out.print("<td class=\"student_column5\">"+studentAndExhibitMap.get(studentList.get(i).getMailAddress())+"</td>");
										out.print("</tr>");
									}
								}
								%>
							</tbody>
						</table>

						<!-- ソート機能 -->
						<script src="/tdu_market/js/list.min.js"></script>
						<script>
						var options = {
							valueNames: [ 'student_column1', 'student_column2', 'student_column3', 'student_column4','student_column5' ]
						};
						var studentList = new List('studentList', options);
						studentList.sort( 'student_column1', {order : 'asc'} );
						function sort_studentList(){
							sortIndex = document.sort_student.sort_number.selectedIndex;
							switch (sortIndex) {
					        case 0:
					        	studentList.sort( 'student_column1', {order : 'asc'} );
					          break;
					        case 1:
					        	studentList.sort( 'student_column1', {order : 'desc'} );
					          break;
					        case 2:
					        	studentList.sort( 'student_column2', {order : 'asc'} );
					          break;
					        case 3:
					        	studentList.sort( 'student_column2', {order : 'desc'} );
					          break;
					        case 4:
					        	studentList.sort( 'student_column3', {order : 'asc'} );
					          break;
					        case 5:
					        	studentList.sort( 'student_column3', {order : 'desc'} );
					          break;
					        case 6:
					        	studentList.sort( 'student_column4', {order : 'asc'} );
					          break;
					        case 7:
					        	studentList.sort( 'student_column4', {order : 'desc'} );
					          break;
					        case 8:
					        	studentList.sort( 'student_column5', {order : 'asc'} );
					          break;
					        case 9:
					        	studentList.sort( 'student_column5', {order : 'desc'} );
					          break;
					      }
						}
						</script>

						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".studentId").on("click", function() {
										//メールアドレスの取得
										var student_mailaddress = $(this).children("td")[0].innerText;
										//Input型エレメントの生成
										var element = document.createElement("input");
										//typeの設定
										element.setAttribute("type", "hidden");
										//nameの設定
										element.setAttribute("name","mailAddress");
										//valueの設定
										element.setAttribute("value",student_mailaddress);
										//取得したIDデータをsetattributeする
										document.select_student.appendChild(element);
										//データをサーバーへ送信する
										document.select_student.submit();
									});
						</script>
						<!-- テーブル要素クリックここまで -->
					</form>
				</div>
			</div>
			<br />
			<!-- 絞り込みボタン -->
			<div class="item_for_center">
			<form action="<%= ServletPath.ManagerSearchStudentPage %>" method="get">
				<button class="search_button" type="submit">
					<img src="/tdu_market/images/search.png" />絞り込み
				</button>
			</form>
			</div>
		</article>
		<!-- ダイアログ関係の表記 -->
		<div id="notify_dialog_admin">
			<p id="notify_text">確認ダイアログ</p>
			<div class="notify_dialog_button">
				<button id="ok" class="button_flat_normal">了解</button>
			</div>
		</div>
		<script type="text/javascript">
		<% if(DialogUtil.checkDisplayDialog(request, response)){ %>
			notify_dialog(<%=DialogUtil.getDialogMessage(request, response)%>);
		<% } %>
		function notify_dialog(text) {
			let dialog = document.getElementById("notify_dialog_admin");

			document.getElementById("notify_text").textContent = text;

			dialog.style.display = "block";
			ok.addEventListener("click", function() {
				<% DialogUtil.turnoffDialog(request, response); %>
				dialog.style.display = "none";
			});
		}</script>
	</div>
</body>
</html>