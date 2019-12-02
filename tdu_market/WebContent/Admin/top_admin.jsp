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
<title>トップ画面</title>
</head>
<body>
<%@ include file="panel.jsp" %>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">トップ画面</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content">
				<ul class="top_ul">
					<li>
						<button type="button" class="top_menu"
							onclick="location.href='<%= ServletPath.ReferStudentListPage %>'">
							<h2>学生情報一覧</h2>
							<br />
							<h3>学生情報の編集・更新を行うことができます。</h3>
						</button>
					</li>
					<li>
						<form action="<%= ServletPath.ManagerReferSyllabusListPage %>" method="post">
							<button type="submit" class="top_menu">
								<h2>シラバス一覧</h2>
								<br />
								<h3>シラバス情報の登録・削除・更新を行うことができます。</h3>
							</button>
						</form>
					</li>
					<li>
					<form action="<%= ServletPath.ManagerReferItemListPage %>" method="post">
						<button type="submit" class="top_menu">
							<h2>商品情報一覧</h2>
							<br />
							<h3>商品情報の参照・削除対応を行うことが出来ます。また、出品者の確認を行うこともできます。</h3>
						</button>
					</form>
					</li>
				</ul>
			</div>
		</article>
	</div>

</body>
</html>