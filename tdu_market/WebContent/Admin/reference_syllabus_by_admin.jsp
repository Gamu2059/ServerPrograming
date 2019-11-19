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
<title>シラバス詳細</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス詳細</h2>
		<!-- メインコンテンツ -->
		<article>
			<br>
			<div class="content_size_50vw">
				<div class="item_for_right">
					<button id="white_button">関連商品で絞り込む</button>
				</div>
			</div>
			<br>
			<div class="syllabus_profile">
				<div class="item_for_grid_r1c2">
					<h3>授業コード</h3>
					<h3 id="no_subtitle">00000000000</h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3 id="no_subtitle">ヌコ先生のプログラミング青空教室</h3>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講年度</h3>
					<input type="text" placeholder="2019年前期" readonly="readonly">
				</div>
				<div class="item_for_grid_r1c2">
					<div class="item_for_grid_r1c2">
						<h3>曜日</h3>
						<h3 id="no_subtitle">水曜・0限</h3>
					</div>
					<div class="item_for_grid_r1c2">
						<h3 id="unit">単位数</h3>
						<h3 id="no_subtitle">0.0</h3>
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教室</h3>
					<h3 id="no_subtitle">2000教室</h3>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教員</h3>
					<h3 id="no_subtitle">水曜日のヌコ</h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>目的概要</h3>
					<h3 id="explanation">ここに説明を入力します。</h3>
					<h3>達成目標</h3>
					<h3 id="explanation">ここに説明を入力します。</h3>
				</div>
				<div class="item_for_grid_r1c2_c12">
					<h3>履修条件</h3>
					<h3 id="no_subtitle">猫語を履修していること</h3>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>評価方法</h3>
					<h3 id="explanation">ここに説明を入力します。</h3>
				</div>
			</div>
			<br>
			<div class="item_for_LeftAndRight_around">
				<button id="red_button">削除</button>
				<button id="blue_button">編集</button>
			</div>
			<br>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog_admin">
				<p>削除しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_nega">確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('red_button').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('削除しました。',
								'reference_syllabus_list_by_admin');/*再読み込みがかかります*/
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog_admin');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + '.html';
						dialog.style.display = 'none';
					});
				}
			</script>
		</section>
	</div>
</body>
</html>