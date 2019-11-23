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
				<form action="" method="post">
					<div class="detail_content">
						<h3>授業コード</h3>
						<input id="class_code_field" type="text" name="class_code">
					</div>
					<hr>
					<div class="detail_content">
						<h3>学科組織</h3>
						<select id="department" name="department">
							<option>未来科学部 - 情報メディア学科</option>
							<option>未来科学部 - ロボット・メカトロニクス学科</option>
						</select>
					</div>
					<div class="detail_content">
						<h3>授業名</h3>
						<input id="class_name_field" type="text" name="class_name">
					</div>
					<div class="detail_content">
						<h3>担当教員</h3>
						<input id="teacher_field" type="text" name="teacher">
					</div>
				</form>
				<br>
				<!-- サードコンテナ -->
				<div class="third_container_ver3">
					<button type="submit" class="button_flat_submit">検索</button>
				</div>
			</div>
		</article>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>