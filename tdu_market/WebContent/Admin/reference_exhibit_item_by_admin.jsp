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
<title>学生情報詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">学生情報詳細</h2>
		<!-- メインコンテンツ -->
		<article>
			<div class="content_margin_200px">
				<br />
				<h2>電大太郎さんの出品物</h2>
				<ul id="user_exhibit_list">
					<li>
						<button>
							<!-- 商品画像 -->
							<img src="/tdu_market/images/item_image.png" />
							<!-- 商品名 -->
							<h3>ぬこでもわかるJAVA入門書</h3>
							<div class="item_for_bottom">
								<!-- 商品価格 -->
								<h3>1000円</h3>
							</div>
						</button>
					</li>
					<li>
						<button>
							<!-- 商品画像 -->
							<img src="/tdu_market/images/item_image.png" />
							<!-- 商品名 -->
							<h3>ぬこでもわかるJAVA入門書</h3>
							<div class="item_for_bottom">
								<!-- 商品価格 -->
								<h3>1000円</h3>
							</div>
						</button>
					</li>
				</ul>
				<br />
				<!-- 戻るボタン -->
				<button id="white_button">戻る</button>
			</div>
		</article>
		<br />
		<script type="text/javascript">
			document.getElementById("white_button").onclick = function() {
				window.history.back(-1);
				return false;
			};
		</script>
	</div>
</body>
</html>