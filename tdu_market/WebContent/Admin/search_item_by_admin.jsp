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
<title>商品情報検索</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">商品情報検索</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_300px">
				<br />
				<div class="search_box">
				<form action="<%= ServletPath.ManagerReferItemListPage %>" method="post">
					<h2>商品検索</h2>
					<br />
					<h3>商品名</h3>
					<input type="text" name="itemNameKeyword" />
					<h3>状態</h3>
					<select name="condition">
						<option value="0">新品・未使用</option>
						<option value="1">中古（書き込みなし）</option>
						<option value="2">中古（書き込みあり）</option>
						<option value="3">破損・汚れあり</option>
					</select>
					<h3>価格</h3>
					<input type="text" name="maxPrice" /><label>円以下</label> <br /> <br />
					<div class="item_for_center">
						<button id="orange_button">検索</button>
					</div>
				</form>
				</div>
				<br />
				<div class="item_for_left">
					<button id="white_button" onclick="window.history.back(-1)">戻る</button>
				</div>
			</div>
		</article>
		<br />
	</div>
</body>
</html>