<%@page import="tdu_market.util.ServletPath"%>
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
<title>左パネル</title>
</head>
<body>
	<!-- 左パネル -->
	<div class="left_panel">
		<!-- ロゴ -->
		<div class="title_logo">
			<a href="top_admin.jsp"><img src="/tdu_market/images/manager_logo.png"
				alt="ロゴ画像" /></a>
		</div>
		<!-- 左パネルメニュー -->
		<div class="panel_menu">
			<ul>
				<li>
					<h2>運営操作メニュー</h2>
				</li>
				<li>
					<form action=<%=ServletPath.ManagerTopPage %> method="get">
						<button type="submit" class="menu">トップ画面</button>
					</form>
				</li>
				<li>
					<form action=<%=ServletPath.ReferStudentListPage %> method="get">
						<button type="submit" class="menu">学生情報一覧</button>
					</form>
				</li>
				<li>
					<form action=<%=ServletPath.ReferSyllabusListPage %> method="get">
						<button type="submit" class="menu">シラバス情報一覧</button>
					</form>
				</li>
				<li>
					<form action=<%=ServletPath.ReferExhibitItemListPage %> method="get">
						<button type="submit" class="menu">商品情報一覧</button>
					</form>
				</li>
			</ul>
			<br>
				<form action=<%=ServletPath.EditManagerPage %> method="get">
					<button type="submit" class="edit_profile" >運営情報編集</button>
				</form>
		</div>
	</div>
</body>
</html>