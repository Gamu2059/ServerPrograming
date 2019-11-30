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
				<select name="sort_student">
					<option value="1">学籍番号</option>
					<option value="2">名前</option>
					<option value="3">学部</option>
					<option value="4">学科</option>
					<option value="5">出品数</option>
				</select>
			</div>
			<!-- テーブル -->
			<div class="item_for_center">
				<div class="list">
					<form action="<%= ServletPath.ManagerReferStudentPage %>" name="select_student" method="get">
						<table>
							<!-- テーブルタイトル -->
							<thead class="list_title">
								<tr>
									<th class="check_column1"></th>
									<tb class="hidden_column">メールアドレス</tb>
									<th class="student_column1">学籍番号</th>
									<th class="student_column2">名前</th>
									<th class="student_column3">学部</th>
									<th class="student_column4">学科</th>
									<th class="student_column5">出品数</th>
								</tr>
							</thead>
							<!-- テーブル要素 -->
							<tbody class="list_content">
								<!-- Sessionからデータを受け取る -->
								<%
								ArrayList<StudentGetInfo> studentList = new ArrayList<>();
								studentList = (ArrayList<StudentGetInfo>)session.getAttribute("studentList");
								if(studentList==null){
									out.print("登録されている学生情報はありません。");
								}else{
									for(int i=0;i<studentList.size();i++){
										out.print("<tr class=\"studentId\">");
										out.print("<th class=\"check_column1\"><input type=\"checkbox\" /></th>");
										out.print("<tb class=\"hidden_column\">"+studentList.get(i).getMailAddress()+"</tb>");
										out.print("<td class=\"student_column1\">未習得</td>");
										out.print("<td class=\"student_column2\">"+studentList.get(i).getDisplayName()+"</td>");
										out.print("<td class=\"student_column3\">"+studentList.get(i).getDepartmentID()+"</td>");
										out.print("<td class=\"student_column4\">"+studentList.get(i).getDepartmentID()+"</td>");
										out.print("<td class=\"student_column5\">未習得</td>");
										out.print("</tr>");
									}
								}
								%>
							</tbody>
						</table>
						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".studentId").on(
									"click",
									function() {
										//メールアドレスの取得
										var student_mailaddress = $(this)
												.children("td")[1].innerText;
										//Input型エレメントの生成
										var element = document
												.createElement("input");
										//typeの設定
										element.setAttribute("type", "submit");
										//nameの設定
										element.setAttribute("name",
												"selectStudent");
										//valueの設定
										element.setAttribute("value",
												"");
										//取得したIDデータをsetattributeする
										document.select_student
												.appendChild(element);
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
				<button class="search_button" type="button">
					<img src="/tdu_market/images/search.png" />絞り込み
				</button>
			</div>
		</article>
	</div>
</body>
</html>