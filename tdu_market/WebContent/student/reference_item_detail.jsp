<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>商品情報参照</title>
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
			<div class="first_container"></div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<div class="detail_content">
						<h2 id="item_name">やさしいぬこでもきっとわかるJAVA入門書</h2>
					</div>
					<div class="detail_content">
						<h5 id="syllabus_name">ぬこ先生のプログラミング青空教室</h5>
					</div>
					<div class="detail_content">
						<img src="../images/item_image.png" alt="画像１" /> <img
							src="../images/item_image.png" alt="画像１" /> <img
							src="../images/item_image.png" alt="画像１" />
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
					<div class="detail_content_center">
						<button class="button_flat_submit" type="submit" name="trade"
							value="trade" id="buy_item">取引する</button>
					</div>
				</section>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog">
				<p>取引を申し込みますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_submit">確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('buy_item').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('confirm_dialog');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('取引を申し込みました。<br>相手からの連絡をお待ちください。');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').innerHTML = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
			</script>
		</section>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>