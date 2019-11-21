<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>商品情報一覧</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="../css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="../js/student.js" defer="defer"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->
	<article class="content">
		<!-- ファーストコンテナ -->
		<div class="first_container_ver3">
			<h2>商品情報一覧</h2>
			<select name="sort_item" id="sort_item">
				<!--新着,カテゴリ,キャンパス,名前,価格,講義名-->
				<option value="new_item">新着</option>
				<option value="category">カテゴリ</option>
				<option value="campus">キャンパス</option>
				<option value="name_asc">名前（昇順）</option>
				<option value="name_desc">名前（降順）</option>
				<option value="price_asc">価格（昇順）</option>
				<option value="price_desc">価格（降順）</option>
				<option value="class_asc">講義名（昇順）</option>
				<option value="class_desc">講義名（降順）</option>
			</select>
		</div>
		<br>
		<div class="new_item_list">
			<button id="item_button">
				<img src="../images/item_image.png" alt="企業と社会" />
				<h5>コーズ・リレーテッド・マーケティング</h5>
				<h4>1000円</h4>
			</button>
			<button id="item_button">
				<img src="../images/item_image.png" alt="企業と社会" />
				<h5>コーズ・リレーテッド・マーケティング</h5>
				<h4>1000円</h4>
			</button>

		</div>
	</article>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>

</body>
</html>