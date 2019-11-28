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
							<option value="0">システムデザイン工学部 - 情報システム工学科</option>
							<option value="1">システムデザイン工学部 - デザイン工学科</option>
							<option value="2">未来科学部 - 建築学科</option>
							<option value="3">未来科学部 - 情報メディア学科</option>
							<option value="4">未来科学部 - ロボット・メカトロニクス学科</option>
							<option value="5">工学部 - 電気電子工学科</option>
							<option value="6">工学部 - 電子システム工学科</option>
							<option value="7">工学部 - 応用化学科</option>
							<option value="8">工学部 - 機械工学科</option>
							<option value="9">工学部 - 先端機械工学科</option>
							<option value="10">工学部 - 情報通信工学科</option>
							<option value="11">工学部（夜間） - 電気電子工学科</option>
							<option value="12">工学部（夜間） - 機械工学科</option>
							<option value="13">工学部（夜間） - 情報通信工学科</option>
							<option value="14">情報環境学部 - ネットワーク・コンピュータ工学コース</option>
							<option value="15">情報環境学部 - デジタル情報工学コース</option>
							<option value="16">情報環境学部 - 建築デザインコース</option>
							<option value="17">情報環境学部 - コミュニケーション工学コース</option>
							<option value="18">大学院 - 未来科学研究科</option>
							<option value="19">大学院 - 工学研究科</option>
							<option value="20">大学院 - 情報環境学研究科</option>
							<option value="21">大学院 - 先端科学技術研究科</option>
						</select>
					</div>
					<div class="detail_content">
						<h3>授業名</h3>
						<input id="class_name_field" type="text" name="classNameKeyword">
					</div>
					<div class="detail_content">
						<h3>担当教員</h3>
						<input id="teacher_field" type="text" name="seacherNameKeyword">
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