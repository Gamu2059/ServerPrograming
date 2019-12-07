<%@page import="tdu_market.dto.DepartmentGetInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.StudentGetInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Bootstrap -->
<link rel="stylesheet" href="/tdu_market/css/import_admin.css"
	type="text/css" />
<title>学生情報詳細（編集中）</title>
</head>
<body onLoad="autoinput()">
	<!-- 編集データの取得 -->
	<%
		StudentGetInfo studentInfo = (StudentGetInfo) session.getAttribute("studentInfo");
		String iconURL = "/tdu_market/images/icon.png";
		String name = "未設定";
		long departmentID = 0;
		String selfintroduction = "未設定";
		if (studentInfo != null) {
			iconURL = studentInfo.getIconImageBinary();
			name = studentInfo.getDisplayName();
			departmentID = studentInfo.getDepartmentID();
			selfintroduction = studentInfo.getSelfIntroduction();
		}
	%>
	<!-- 初期input入力 -->
	<script type="text/javascript">
		function autoinupt() {
			document.getElementById("user_name").value = <%=name%>;
			document.getElementById("selfintroduction").value = <%=selfintroduction%>;
		}
	</script>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報詳細（編集中）</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_200px">
				<br />
				<form action="<%=ServletPath.ManagerUpdateStudentInfo%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="mailAddress" value="<%= studentInfo.getMailAddress()%>"/>
					<div class="user_profile">
						<div class="item_for_LeftAndRight_around">
							<label id="edit_img_button">
								<img id="icon" src="<%=iconURL%>" />
								<input type="file" id="iconFile" name="iconImageURL" />
								<h3>編集</h3>
							</label>
							<!-- プレビュー機能 -->
							<script>
								$('#iconFile').on('change',function(e) {
									var reader = new FileReader();
									reader.onload = function(e) {
										$("#icon").attr('src',e.target.result);
									}
									reader.readAsDataURL(e.target.files[0]);
								});
							</script>
							<div>
								<h3>ディスプレイネーム</h3>
								<input id="user_name" type="text" name="displayName" value="<%= name %>" />
								<h3>所属学科</h3>
								<select name="departmentID">
									<%
									ArrayList<DepartmentGetInfo> departmentInfoList = new ArrayList<>();
									departmentInfoList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
									if(departmentInfoList!=null){
										for(DepartmentGetInfo info:departmentInfoList){
											if(departmentID == info.getSubjectID()){
												out.print("<option value=\""+info.getSubjectID()+"\" selected>"+info.getFacultyName()+" - "+info.getSubjectName()+"</option>");
											}else{
												out.print("<option value=\""+info.getSubjectID()+"\">"+info.getFacultyName()+" - "+info.getSubjectName()+"</option>");
											}
										}
									}
									%>
								</select>
							</div>
						</div>
						<br />
						<h3>自己紹介</h3>
						<div class="selfintroduction">
							<textarea id="selfintroduction" name="selfIntroduction"><%= selfintroduction %></textarea>
						</div>
					</div>
				<br />
				<div id="confirm_dialog_admin">
					<p id="confirm_text">更新しますか？</p>
					<div class="confirm_dialog_button">
						<button tyoe="submit" id="yes" class="button_flat_submit button_flat_nega">確認</button>
						<button type="button" id="no" class="button_flat_normal">キャンセル</button>
					</div>
				</div>
				</form>
				<div class="item_for_center">
					<button id="orange_button">確定</button>
				</div>
			</div>
		</article>
		<br />
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<!-- <div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div> -->
			<script type="text/javascript">
				document.getElementById("orange_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					yes.classList.remove("button_flat_nega");
					yes.classList.add("button_flat_submit");

					/* document.getElementById("confirm_text").textContent = "更新しますか？"; */

					dialog.style.display = "block";

					/* yes.addEventListener("click", function() {
						dialog.style.display = "none";

						//ここに内部処理をいれる

						notify_dialog("更新しました。",
								"reference_student_detail_by_admin");
					});
					no.addEventListener("click", function() {
						dialog.style.display = "none";
					}); */
				};

				function notify_dialog(text, url) {
					let dialog = document.getElementById("notify_dialog_admin");

					document.getElementById("notify_text").textContent = text;

					dialog.style.display = "block";
					ok.addEventListener("click", function() {
						location.href = url + ".html";
						dialog.style.display = "none";
					});
				}
			</script>
		</section>
	</div>
</body>
</html>