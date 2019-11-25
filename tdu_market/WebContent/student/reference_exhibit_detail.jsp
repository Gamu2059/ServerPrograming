<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物詳細</title>
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
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver3">
				<h3>出品物詳細</h3>
				<button type="submit" name="edit" class="button_flat_normal"
					id="edit">編集</button>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<div class="detail_content">
						<h2 id="item_name">やさしいぬこでもきっとわかるJAVA入門書</h2>
					</div>
					<div class="detail_content">
						<h5 id="syllabus_name">授業名</h5>
					</div>
					<div class="detail_content">
						<img src="/tdu_market/images/item_image.png" alt="画像１" /> <img
							src="/tdu_market/images/item_image.png" alt="画像１" /> <img
							src="/tdu_market/images/item_image.png" alt="画像１" />
					</div>
					<div class="detail_content">
						<h4 id="item_explanation">
							この本を読むとよくわからなかったJAVAのことがよく分かるようになります！自宅にいる猫に読ませたところ、猫の手も借りたい状態だったプロジェクトを猫が手伝ってくれて無事に炎上せずに完遂しました。みなさんも一読すべきだと思いました。
						</h4>
					</div>
					<div class="detail_content_right">
						<h4>状態：非常に良い</h4>
					</div>
					<div class="detail_content_right">
						<h4>1000円</h4>
					</div>
				</section>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver2">
				<button type="button" name="back" class="button_flat_normal"
					id="back_button">戻る</button>
				<button type="button" name="delete" class="button_flat_nega"
					id="delete">削除</button>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="negative_dialog">
				<p>削除しますか？</p>
				<div class="negative_dialog_button">
					<button id="nega_yes" class="button_flat_nega">確認</button>
					<button id="nega_no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('edit').onclick = function() {
					//ここに内部処理をかく。

					location.href = 'edit_exhibit' + '.html';
				}

				document.getElementById('delete').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('negative_dialog');
					let yes = document.getElementById('nega_yes');
					let no = document.getElementById('nega_no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('削除しました。', 'reference_exhibit_list');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text, url) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						location.href = url + '.html';
						dialog.style.display = 'none';
					});
				}
				document.getElementById('back_button').onclick = function() {
					window.history.back(-1);
					return false;
				}
			</script>
		</section>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>