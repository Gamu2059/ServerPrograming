<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物一覧</title>
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
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>出品物一覧</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container">
				<!--これはタブです。参考　→　https://bagelee.com/design/css/create_tabs_using_only_css/-->
				<div class="tab">
					<!--idタグとforタグが同じであること。-->
					<input id="exhibiting_list" name="tab_item" type="radio" checked>
					<label class="tab_item" for="exhibiting_list">出品中</label> <input
						id="trading_list" name="tab_item" type="radio"> <label
						class="tab_item" for="trading_list">取引中</label>
					<!--ここは一例です。必要に応じて補ってください。-->
					<div class="tab_content" id="exhibiting_content">
						<button id="exhibit_button">
							<img src="../images/item_image.png" alt="教科書"> <label
								id="item_name">デザイン入門</label> <label id="item_price">1000円</label>
						</button>
						<button id="exhibit_button">
							<img src="../images/item_image.png" alt="教科書"> <label
								id="item_name">デザイン入門</label> <label id="item_price">1000円</label>
						</button>
					</div>
					<div class="tab_content" id="trading_content">
						<button id="exhibit_button">
							<img src="../images/item_image.png" alt="教科書"> <label
								id="item_name">デザイン入門</label> <label id="item_price">1000円</label>
						</button>
					</div>
				</div>
			</div>
		</article>
	</div>

	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>