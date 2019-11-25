<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>ユーザー情報編集</title>
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
			<div class="first_container_ver2">
				<h2>ユーザー情報（編集中）</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<form action="" method="post">
					<div class="top_content">
						<div class="top_content_left">
							<label class="user_icon_button"> <input
								class="user_icon_button2" type="file" /> <img
								src="/tdu_market/images/icon.png" alt="ユーザーアイコン">
								<h3>変更</h3>
							</label>
						</div>
						<div class="top_content_right">
							<div class="detail_content">
								<h3>ディスプレイネーム</h3>
								<div class="detail_input_textfield">
									<input name="student_name" type="text" value="hoge" />
								</div>
							</div>
							<div class="detail_content">
								<h3>所属学科</h3>
								<select name="department">
									<option value="hoge1">情報環境学部 - ネットワーク・コンピュータ工学コース</option>
									<option value="hoge2">情報システム工学科</option>
								</select>
								<p id="note_Text">※注意 - 転科した学生はサポートまで連絡をお願いします。</p>
							</div>
						</div>
					</div>
					<div class="detail_content">
						<h3>自己紹介</h3>
						<textarea id="self_introduction_textfield"
							name="self_introduction">
        最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。最大自己紹介の文字は２００文字です。その文字数を入力した結果がこちらになります。
            </textarea>
					</div>
					<div class="detail_content">
						<h3>パスワード</h3>
						<keygen>
						<!--？ keygenってなんだよｗｗｗ　>>　暗号化を明示するタグだって～（付け焼刃並感） -->
						<div class="password_textfield">
							<input name="password" type="password" placeholder="一回目" /> <input
								name="password" type="password" placeholder="二回目" />
						</div>
					</div>
				</form>
			</div>
			<!-- サードコンテンツ -->
			<div class="third_container_ver2">
				<button id="back_button" type="button" name="back"
					class="button_flat_normal">戻る</button>
				<button type="submit" name="edited" class="button_flat_submit"
					id="update">更新</button>
				<p></p>
			</div>

		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog">
				<p>更新しますか？</p>
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
				document.getElementById('update').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('confirm_dialog');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('更新しました。', 'reference_profile_student');
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