<%@page import="tdu_market.entity_bean.StudentInfo"%>
<%@page import="tdu_market.dto.*"%>
<%@page import="tdu_market.util.ServletPath"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>ユーザー情報編集</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="/tdu_market/css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="/tdu_market/js/jquery-3.3.1.min.js"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->

	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>ユーザー情報（編集中）</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<form action=<%=ServletPath.UpdateStudentPage %> method="post" enctype="multipart/form-data">
				<%
				//Get information
				StudentGetInfo info = (StudentGetInfo)session.getAttribute("studentInfo");
				%>
					<div class="top_content">
						<div class="top_content_left">
							<label class="user_icon_button">
							<%
 							if(info.getIconImageBinary() != null){
								out.print("<img src=\""+ info.getIconImageBinary() +" \" alt=\"ユーザーアイコン\" id=\"icon\">");
							}
							%>
							<input class="user_icon_button2" type="file" name="iconImageURL" id="iconFile"/>
								<h3>変更</h3>
							</label>
						</div>
						<!-- アイコン画像のプレビュー -->
						<script>
 						$('#iconFile').on('change', function (e) {
						    var reader = new FileReader();
						    reader.onload = function (e) {
						        $("#icon").attr('src', e.target.result);
						    }
						    reader.readAsDataURL(e.target.files[0]);
						});
						</script>
						<div class="top_content_right">
							<div class="detail_content">
								<h3>ディスプレイネーム</h3>
								<div class="detail_input_textfield">
								<% out.println("<input name=\"displayName\" type=\"text\" value=\"" + info.getDisplayName() +"\" />"); %>
								</div>
							</div>
							<div class="detail_content">
								<h3>所属学科</h3>
								<select name="departmentID">
									<% out.println("<option name=\"media\" value=\""+ info.getDepartmentID() +"\">"+ "情報メディア学科" +"</option>");%>
								</select>
								<p id="note_Text">※注意 - 転科した学生はサポートまで連絡をお願いします。</p>
							</div>
						</div>
					</div>
					<div class="detail_content">
						<h3>自己紹介</h3>
						<% out.println("<textarea id=\"self_introduction_textfield\" name=\"selfIntroduction\">"+info.getSelfIntroduction()+"</textarea>"); %>
					</div>
					<div class="detail_content">
						<h3>パスワード</h3>
						<div class="password_textfield">
							<input name="nonHashedPassword1" type="password" placeholder="一回目" />
							<input name="nonHashedPassword2" type="password" placeholder="二回目" />
						</div>
					</div>
					<div id="confirm_dialog">
						<p>更新しますか？</p>
						<div class="confirm_dialog_button">
							<input type="submit" id="yes" class="button_flat_submit" value="確認">
							<button id="no" class="button_flat_normal">キャンセル</button>
						</div>
					</div>
				</form>
			</div>
			<!-- サードコンテンツ -->
			<div class="third_container_ver2">
				<button id="back_button" type="button" name="back"
					class="button_flat_normal">戻る</button>
				<button type="submit" name="edited" class="button_flat_submit"
					id="update">更新</button>
				<p></p>
			</div>

		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('update').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('confirm_dialog');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						<% //session.setAttribute("isDisplayDialog", false); %>
						dialog.style.display = 'none';
					});
				}
				document.getElementById('back_button').onclick = function() {
					window.history.back(-1);
					return false;
				}
			</script>
		</section>
	</div>

	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>

</body>
</html>
