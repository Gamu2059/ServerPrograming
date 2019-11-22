<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物情報更新</title>
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
			<div class="first_container_ve2">
				<h3>出品物詳細（編集中）</h3>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<form>
						<div class="detail_input_textfield">
							<input id="item_name" type="text" name="exhibit_name"
								value="やさしいJava" />
						</div>
						<div class="detail_input_textfield">
							<input id="syllabus_name" type="text" name="class_name"
								value="オブジェクト指向プログラミング" />
						</div>
						<div class="detail_content_left">
							<div class="item_img_delete_button">
								<img src="/tdu_market/images/item_image.png" alt="画像１" />
								<button name="delete_img">削除</button>
							</div>
							<label class="item_img_add_button"> <input
								class="item_img_input" type="file"></input> <br>
								<h3>+</h3>
							</label>
						</div>
						<div class="detail_content">
							<textarea id="item_explanation_field">
                  この本を読むとよくわからなかったJAVAのことがよく分かるようになります！自宅にいる猫に読ませたところ、猫の手も借りたい状態だったプロジェクトを猫が手伝ってくれて無事に炎上せずに完遂しました。みなさんも一読すべきだと思いました。
                </textarea>
						</div>
						<div class="detail_content_right">
							<h4>
								状態： <select id="condition" name="condition">
									<option value="new">新品・未使用</option>
									<option value="old">中古（書き込みなし）</option>
									<option value="old_written">中古（書き込みあり）</option>
									<option value="old_dirty">破損・汚れあり</option>
								</select>
							</h4>
						</div>
						<div class="detail_content_right">
							<h4>
								<input id="yen_field" type="number" name="price" value="1000" />円
							</h4>
						</div>
					</form>
				</section>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver2">
				<button type="button" name="back" class="button_flat_normal"
					id="back_event">戻る</button>
				<button type="button" name="back" class="button_flat_submit"
					id="update_exhibit">更新</button>
				<button type="button" name="delete" class="button_flat_nega"
					id="delete_exhibit">削除</button>
			</div>
		</article>
		<section>
			<div id="confirm_dialog">
				<p>更新しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_submit">確認</button>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div>
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
				document.getElementById('update_exhibit').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('confirm_dialog');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('更新しました。', 'reference_exhibit_detail');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				document.getElementById('delete_exhibit').onclick = function() {
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
				document.getElementById('back_event').onclick = function() {
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