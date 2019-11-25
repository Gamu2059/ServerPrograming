<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form action="../SearchSyllabusPage" method="get">
					<div class="detail_content">
						<h3>授業コード</h3>
						<input id="class_code_field" type="text" name="サーブレットの授業コード引数">
					</div>
					<hr>
					<div class="detail_content">
						<h3>学科組織</h3>
						<select id="department" name="department">
							<option value="サーブレットの引数">システムデザイン工学部 - 情報システム工学科</option>
							<option value="">システムデザイン工学部 - デザイン工学科</option>
							<option value="">未来科学部 - 建築学科</option>
							<option value="">未来科学部 - 情報メディア学科</option>
							<option value="">未来科学部 - ロボット・メカトロニクス学科</option>
							<option value="">工学部 - 電気電子工学科</option>
							<option value="">工学部 - 電子システム工学科</option>
							<option value="">工学部 - 応用化学科</option>
							<option value="">工学部 - 機械工学科</option>
							<option value="">工学部 - 先端機械工学科</option>
							<option value="">工学部 - 情報通信工学科</option>
							<option value="">工学部（夜間） - 電気電子工学科</option>
							<option value="">工学部（夜間） - 機械工学科</option>
							<option value="">工学部（夜間） - 情報通信工学科</option>
							<option value="">情報環境学部 - ネットワーク・コンピュータ工学コース</option>
							<option value="">情報環境学部 - デジタル情報工学コース</option>
							<option value="">情報環境学部 - 建築デザインコース</option>
							<option value="">情報環境学部 - コミュニケーション工学コース</option>
							<option value="">大学院 - 未来科学研究科</option>
							<option value="">大学院 - 工学研究科</option>
							<option value="">大学院 - 情報環境学研究科</option>
							<option value="">大学院 - 先端科学技術研究科</option>
						</select>
					</div>
					<div class="detail_content">
						<h3>授業名</h3>
						<input id="class_name_field" type="text" name="サーブレットの授業名引数">
					</div>
					<div class="detail_content">
						<h3>担当教員</h3>
						<input id="teacher_field" type="text" name="サーブレットの授業名引数">
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