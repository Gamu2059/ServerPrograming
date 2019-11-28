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
<title>商品検索</title>
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
				<h3>商品検索</h3>
				<br>
				<form action="<%=ServletPath.ReferItemListPage%>" method="post">
					<div class="detail_content">
						<h3>商品名</h3>
						<input id="item_name_field" type="text" name="itemNameKeyword">
					</div>
					<div class="detail_content">
						<h4>状態</h4>
						<select id="condition" name="condtion">
							<option value="0">新品・未使用</option>
							<option value="1">中古（書き込みなし）</option>
							<option value="2">中古（書き込みあり）</option>
							<option value="3">破損・汚れあり</option>
						</select>
					</div>
					<div class="detail_content">
						<h3>価格</h3>
						<input type="text" name="maxPrice"> 円
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