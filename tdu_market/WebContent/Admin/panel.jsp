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
<title>左パネル</title>
</head>
<body>
	<!-- 左パネル -->
	<div class="left_panel">
		<!-- ロゴ -->
		<div class="title_logo">
			<a href="top_admin.jsp"><img src="../images/manager_logo.png"
				alt="ロゴ画像" /></a>
		</div>
		<!-- 左パネルメニュー -->
		<div class="panel_menu">
			<ul>
				<li>
					<h2>運営操作メニュー</h2>
				</li>
				<li>
					<button type="button" class="menu"
						onclick="location.href='top_admin.jsp'">トップ画面</button>
				</li>
				<li>
					<button type="button" class="menu"
						onclick="location.href='reference_student_list.jsp'">
						学生情報一覧</button>
				</li>
				<li>
					<button type="button" class="menu"
						onclick="location.href='reference_syllabus_list.jsp'">
						シラバス情報一覧</button>
				</li>
				<li>
					<button type="button" class="menu"
						onclick="location.href='rederece_item_list.jsp'">商品情報一覧</button>
				</li>
			</ul>
			<br>
			<button type="button" class="edit_profile"
				onclick="location.href='edit_profile_admin.jsp'">運営情報編集</button>
		</div>
	</div>
</body>
</html>