<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>トップ画面</title>
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
	<article class="content">
		<!-- ファーストコンテナ -->
		<div class="first_container">
			<!-- 商品検索入力フォーム -->
			<form class="input_form" action="#" method="post">
				<div>
					<input type="text" name="item" class="radius_text_form" size="70"
						placeholder="全ての商品から探す（教科書名、道具名など）" />
					<button type="submit" name="item_search" class="search_button">
						<img src="/tdu_market/images/search.png" alt="虫眼鏡" />
					</button>
				</div>
			</form>
			<!-- 出品ボタン -->
			<div class="exhibit_button">
				<button type="button" name="exhibit">出品！</button>
			</div>
		</div>
		<!-- セカンドコンテナ -->
		<div class="second_container">
			<!-- タイトル -->
			<h2>新着</h2>
			<!-- 新着商品一覧 -->
			<div class="new_item_list">
				<button id="item_button">
					<img src="/tdu_market/images/item_image.png" alt="企業と社会" />
					<h5>コーズ・リレーテッド・マーケティング</h5>
					<h4>1000円</h4>
				</button>

			</div>
		</div>
		<!-- サードコンテナ -->
		<div class="third_container">
			<!-- すべて見るボタン -->
			<aside class="aside_info">
				<a href="#">すべて見る...</a>
			</aside>
			<!-- もっと探すボタン -->
			<nav class="more_search">
				<button type="submit" name="search" class="button_flat_submit">
					もっと探す</button>
			</nav>
		</div>
	</article>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>
</body>
</html>