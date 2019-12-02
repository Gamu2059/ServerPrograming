<%@page import="tdu_market.dto.SyllabusGetInfo"%>
<%@page import="tdu_market.entity_bean.SyllabusInfo"%>
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
<title>シラバス詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス詳細</h2>
		<!-- メインコンテンツ -->
		<%
		SyllabusGetInfo syllabusGetInfo = (SyllabusGetInfo)session.getAttribute("syllabusInfo");
		String classCode = "";
		String className = "";
		String openingSemester = "";
		String date = "";
		int unitNum = 0;
		String classRoom = "";
		String teacherName = "";
		String overview = "";
		String target = "";
		String requirment = "";
		String evaluationMethod = "";
		if(syllabusGetInfo != null){
			classCode = syllabusGetInfo.getClassCode();
			className = syllabusGetInfo.getClassName();
			openingSemester = syllabusGetInfo.getOpeningSemester();
			date = syllabusGetInfo.getDates();
			unitNum = syllabusGetInfo.getUnitNum();
			classRoom = syllabusGetInfo.getClassRoom();
			teacherName = syllabusGetInfo.getTeacherName();
			overview = syllabusGetInfo.getOverview();
			target = syllabusGetInfo.getRequirments();
			requirment = syllabusGetInfo.getRequirments();
			evaluationMethod = syllabusGetInfo.getEvaluationMethod();
		}
		%>
		<article>
			<br>
			<div class="content_size_50vw">
				<div class="item_for_LeftAndRight_between">
					<form action="<%= ServletPath.ManagerReferSyllabusListPage %>" method="post">
						<input type="hidden" name="isBack" value="true">
						<button id="white_button">一覧へ</button>
					</form>
					<button id="white_button">関連商品で絞り込む</button>
				</div>
			</div>
			<br>
			<div class="syllabus_profile">
				<div class="item_for_grid_r1c2">
					<h3>授業コード</h3>
					<h3 id="no_subtitle"><%= classCode %></h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3 id="no_subtitle"><%= className%></h3>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講学科</h3>
					<input type="text" placeholder=" 未取得 " readonly="readonly">
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講年度</h3>
					<input type="text" placeholder="<%= openingSemester %>" readonly="readonly">
				</div>
				<div class="item_for_grid_r1c2">
					<div class="item_for_grid_r1c2">
						<h3>曜日</h3>
						<h3 id="no_subtitle"><%= date %></h3>
					</div>
					<div class="item_for_grid_r1c2">
						<h3 id="unit">単位数</h3>
						<h3 id="no_subtitle"><%= unitNum %></h3>
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教室</h3>
					<h3 id="no_subtitle"><%= classRoom %></h3>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教員</h3>
					<h3 id="no_subtitle"><%= teacherName %></h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>目的概要</h3>
					<h3 id="explanation"><%= overview  %></h3>
					<h3>達成目標</h3>
					<h3 id="explanation"><%= target %></h3>
				</div>
				<div class="item_for_grid_r1c2_c12">
					<h3>履修条件</h3>
					<h3 id="no_subtitle"><%= requirment %></h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>評価方法</h3>
					<h3 id="explanation"><%= evaluationMethod %></h3>
				</div>
			</div>
			<br>
			<div class="item_for_LeftAndRight_around">
				<button id="red_button">削除</button>
				<form action="<%= ServletPath.EditSyllabusPage %>" method="get">
					<input type="hidden" name="classCode" value="<%= classCode %>">
					<button id="blue_button">編集</button>
				</form>
			</div>
			<br>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog_admin">
				<p>削除しますか？</p>
				<div class="confirm_dialog_button">
					<form action="<%= ServletPath.DeleteSyllabusInfo %>" method="post">
						<input type="hidden" name="classCode" value="<%= classCode %>">
						<button id="yes" class="button_flat_nega">削除</button>
					</form>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<!-- <div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div> -->
			<script type="text/javascript">
				document.getElementById('red_button').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('削除しました。',
								'reference_syllabus_list_by_admin');/*再読み込みがかかります*/
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog_admin');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + '.html';
						dialog.style.display = 'none';
					});
				}
			</script>
		</section>
	</div>
</body>
</html>