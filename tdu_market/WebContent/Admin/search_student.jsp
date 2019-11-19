<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Bootstrap -->
<link rel="stylesheet" href="../css/import_admin.css" type="text/css" />
<title>学生情報検索</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報検索</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_400px">
				<br>
				<div class="search_box">
					<h2>学生検索</h2>
					<br>
					<h3>学籍番号</h3>
					<input type="text">
					<h3>学科</h3>
					<select name="condition">
						<option value="1">未来科学部 - 情報メディア学科</option>
						<option value="2">未来科学部 - ロボット・メカトロニクス学科</option>
					</select>
					<h3>ディスプレイネーム</h3>
					<input type="text"> <br> <br>
					<div class="item_for_center">
						<button id="orange_button">検索</button>
					</div>
				</div>
				<br>
				<div class="item_for_left">
					<button id="white_button">戻る</button>
				</div>
			</div>
		</article>
		<br>
	</div>
</body>
</html>