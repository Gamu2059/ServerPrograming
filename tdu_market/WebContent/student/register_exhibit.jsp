<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物登録</title>
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
			<div class="first_container_ver2">
				<h2>出品物情報登録（※すべて必須項目）</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<form action="" method="get">
					<!-- 上部コンテンツ -->
					<div class="top_content_ver2">
						<div class="detail_content">
							<h3>出品物名</h3>
							<input id="exhibit_textfield" type="text" name="exhibit_name"
								placeholder="例：やさしい〇〇" />
						</div>
						<div class="detail_content">
							<h3>授業名</h3>
							<input id="exhibit_textfield" type="text" name="class_name"
								placeholder="例：コンピュータプログラミングⅠ" />
						</div>
					</div>
					<!-- 中部コンテンツ -->
					<div class="dialog_middle_content">
						<div class="detail_content_ver2">
							<h3>画像をアップロード</h3>
							<div class="item_image_list">
								<div class="item_img_delete_button">
									<img src="../images/item_image.png" alt="画像１" />
									<button name="delete_img">削除</button>
								</div>

								<label class="item_img_add_button"> <input
									class="item_img_input" type="file"></input> <br>
									<h3>+</h3>
								</label>

							</div>
						</div>
						<div class="detail_content">
							<h3>出品物の説明</h3>
							<textarea id="exhibit_description_textfield"
								name="exhibit_description_textfield">
                最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。
              				</textarea>
						</div>
						<div class="detail_content">
							<h3>状態</h3>
							<select id="condition" name="condition">
								<option value="new">新品・未使用</option>
								<option value="old">中古（書き込みなし）</option>
								<option value="old_written">中古（書き込みあり）</option>
								<option value="old_dirty">破損・汚れあり</option>
							</select>
						</div>
						<div class="detail_content">
							<h3>出品価格</h3>
							<div class="yen">
								<input type="number" name="price" />
								<h4>円</h4>
							</div>
						</div>
					</div>
				</form>
				<!-- 中部コンテンツ２ -->
				<div class="middle2_content">
					<button type="submit" name="submit" class="button_flat_submit"
						id="upload">確認</button>
				</div>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="exhibit_infomation">
				<article class="exhibit_dialog_content">
					<!-- セカンドコンテナ -->
					<div class="dialog_info_base" id="exhibit_information">
						<form action="" method="get">
							<!-- 上部コンテンツ -->
							<div class="dialog_exhibit_top">
								<div class="detail_content">
									<h3>出品物名</h3>
									<input id="exhibit_textfield_confirm" type="text"
										name="exhibit_name" placeholder="入力された値" disabled="disabled" />

								</div>
								<div class="detail_content">
									<h3>授業名</h3>
									<input id="exhibit_textfield_confirm" type="text"
										name="class_name" placeholder="入力された値" disabled="disabled" />
								</div>
							</div>
							<!-- 中部コンテンツ -->
							<div class="middle_content">
								<div class="dialog_detail">
									<div class="item_image_list">
										<div class="dialog_item_image">
											<img src="../images/item_image.png" alt="商品画像" width="60%" />
										</div>
										<div class="dialog_item_image">
											<img src="../images/item_image.png" alt="商品画像" width="60%" />
										</div>
										<div class="dialog_item_image">
											<img src="../images/item_image.png" alt="商品画像" width="60%" />
										</div>
									</div>
								</div>
							</div>
							<div class="detail_content">
								<h3 class="exhibit_description">出品物の説明</h3>
								<textarea id="exhibit_description_textfield"
									name="exhibit_description_textfield" disabled="disabled">
                最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。
              					</textarea>
							</div>
							<div class="detail_content">
								<h3 class="exhibit_description">状態</h3>
								<select id="dialog_condition" name="condition"
									disabled="disabled">
									<option value="new">新品・未使用</option>
									<option value="old">中古（書き込みなし）</option>
									<option value="old_written">中古（書き込みあり）</option>
									<option value="old_dirty">破損・汚れあり</option>
								</select>
							</div>
							<br>
							<div class="detail_content">
								<h3 class="exhibit_description">出品価格</h3>
								<div class="yen">
									<input type="number" name="price" disabled="disabled"
										placeholder="100" />
									<h4>円</h4>
								</div>
							</div>
						</form>
					</div>
					<!-- 中部コンテンツ２ -->
					<div class="dialog_check_button">
						<button type="submit" name="submit" class="button_flat_submit"
							id="yes">出品</button>
						<button type="submit" name="cancel" class="button_flat_normal"
							id="no">キャンセル</button>
					</div>
				</article>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
				document.getElementById('upload').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('exhibit_infomation');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('出品しました。', 'reference_exhibit_detail');
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
			</script>
		</section>
	</div>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>