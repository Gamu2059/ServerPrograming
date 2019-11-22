<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>メッセージ</title>
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
		<article class="content_ver2">
			<!-- ファーストコンテナ -->
			<!-- セカンドコンテナ -->
			<div class="second_container_message">
				<!--メッセージ一覧-->
				<section class="sec_message_list">
					<div class="message_tab">
						<div class="message_header">メッセージ一覧</div>
						<!--for文で何とかしたい（希望）-->
						<input type="radio" id="message1" name="m1" /> <input
							type="radio" id="message2" name="m2" /> <input type="radio"
							id="message3" name="m3" />

						<!--jsで繰り返しを行い、メッセージタブを作成する。-->
						<label for="message1" class="message_list_tab" onclick="">
							<img src="/tdu_market/images/icon.png" alt="アイコン" />
							<div class="message_content">
								<div class="message_sender">TestUser1</div>
								<div class="message_text">今日はいい天気ですね。進捗はいかかでしょうか。</div>
							</div>
						</label>
						<!--jsで繰り返しを行い、メッセージタブを作成する。-->
						<label for="message2" class="message_list_tab" onclick="">
							<img src="/tdu_market/images/icon.png" alt="アイコン" />
							<div class="message_content">
								<div class="message_sender">TestUser2</div>
								<div class="message_text">今日はいい天気ですね。進捗はいかかでしょうか。</div>
							</div>
						</label>
						<!--jsで繰り返しを行い、メッセージタブを作成する。-->
						<label for="message3" class="message_list_tab" onclick="">
							<img src="/tdu_market/images/icon.png" alt="アイコン" />
							<div class="message_content">
								<div class="message_sender">TestUser3</div>
								<div class="message_text">今日はいい天気ですね。進捗はいかかでしょうか。</div>
							</div>
						</label>
					</div>
				</section>
				<!--メッセージ画面-->
				<section class="sec_message_room">
					<div class="message_room">
						<!--メッセージヘッダー-->
						<div class="message_header" name="message_room_panel">
							<div>TestUser</div>
							<input type="button" name="trading_button"
								class="button_flat_normal" value="取引中の商品" /> <input
								type="button" name="end_button" class="button_flat_nega"
								value="取引終了" id="end_trade" />
						</div>
						<!--メッセージコンテンツ-->
						<div class="message_post_list">
							<section>
								<div class="message_post" name="system">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="system">
										TestUserさんが取引を申し込みました。</div>
								</div>
								<div class="message_post" name="opponent">
									<!--メッセージ一つ-->
									<img src="/tdu_market/images/icon.png" alt="icon" />
									<div class="message_post_content" name="opponent">こんにちは！
									</div>
								</div>
								<div class="message_post" name="myself">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="myself">
										こんにちは！取引お願いします</div>
								</div>
								<div class="message_post" name="opponent">
									<!--メッセージ一つ-->
									<img src="/tdu_market/images/icon.png" alt="icon" />
									<div class="message_post_content" name="opponent">
										ところで、サバプロの進捗はどうですか？</div>
								</div>
								<div class="message_post" name="myself">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="myself">
										死んでますね。まもなくプロジェクトが火車になりそうになってます。よろしければ手伝ってもらえませんか？</div>
								</div>
								<div class="message_post" name="opponent">
									<!--メッセージ一つ-->
									<img src="/tdu_market/images/icon.png" alt="icon" />
									<div class="message_post_content" name="opponent">
										お断りします。</div>
								</div>
								<div class="message_post" name="myself">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="myself">
										お願いします！なんでもしまｓ</div>
								</div>
								<div class="message_post" name="opponent">
									<!--メッセージ一つ-->
									<img src="/tdu_market/images/icon.png" alt="icon" />
									<div class="message_post_content" name="opponent">
										ん？今なんでもって言いましたよね？</div>
								</div>
								<div class="message_post" name="myself">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="myself">言ってないです</div>
								</div>
							</section>
						</div>
						<!--メッセージフォーム-->
						<div class="textfield">
							<form action="#" method="post">
								<textarea id="message_form" name="message_form" cols="50"
									rows="2" placeholder="メッセージを入力"></textarea>
								<img src="/tdu_market/images/post.png" alt="post" />
							</form>
						</div>
					</div>
					<section>
						<!--
			ダイアログ付与手順。
				1.該当するidをボタンに付与する。update, delete, back_button
				2.notify_dialog('表示したいメッセージ','遷移先url')
			-->
						<div id="message_dialog">
							<p id="confirm_text"></p>
							<div class="confirm_dialog_button">
								<button id="yes" class="button_flat_nega">確認</button>
								<button id="no" class="button_flat_normal">キャンセル</button>
							</div>
						</div>
						<div id="message_notify">
							<p id="notify_text">確認ダイアログ</p>
							<div class="notify_dialog_button">
								<button id="ok" class="button_flat_normal">了解</button>
							</div>
						</div>
						<script type="text/javascript">
							document.getElementById('end_trade').onclick = function() {
								//各ボタンの要素の取得
								let dialog = document
										.getElementById('message_dialog');
								let yes = document.getElementById('yes');
								let no = document.getElementById('no');

								document.getElementById('confirm_text').innerHTML = '<br>完了報告を行いますか？ <h6>（この取引は双方の同意をもって終了します。）<p>';
								dialog.style.display = 'block';

								yes
										.addEventListener(
												'click',
												function() {
													dialog.style.display = 'none';

													//ここに内部処理をいれる

													notify_dialog(
															'<br>完了報告をしました。<br>相手からの同意を待っています。',
															'reference_item_detail');/*再読み込みがかかります*/
												});
								no.addEventListener('click', function() {
									dialog.style.display = 'none';
								});
							}
							function notify_dialog(text, url) {
								let dialog = document
										.getElementById('message_notify');

								document.getElementById('notify_text').innerHTML = text;

								dialog.style.display = 'block';
								ok.addEventListener('click', function() {
									location.href = url + '.html';
									dialog.style.display = 'none';
								});
							}
							/*通知として呼び出す確認ダイアログ*/
							function end_notify() {
								//各ボタンの要素の取得
								let dialog = document
										.getElementById('confirm_dialog');
								let yes = document.getElementById('yes');
								let no = document.getElementById('no');

								document.getElementById('confirm_text').innerHTML = '<br>相手が完了報告を行いました。<br>同意してもよろしいですか？';
								dialog.style.display = 'block';

								yes
										.addEventListener(
												'click',
												function() {
													dialog.style.display = 'none';

													//ここに内部処理をいれる

													notify_dialog(
															'<br>取引が完了しました。<br>またのご利用をお待ちしています。',
															'student_top');/*再読み込みがかかります*/
												});
								no.addEventListener('click', function() {
									dialog.style.display = 'none';
								});
							}
						</script>
					</section>
				</section>
			</div>
			<!-- サードコンテナ -->
		</article>
	</div>

	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>