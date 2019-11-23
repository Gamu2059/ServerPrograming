<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ログイン画面</title>
<link href="/tdu_market/css/import_general_student.css" rel="stylesheet" />
</head>

<body>
	<header>
		<img id="title_log" src="/tdu_market/images/student_logo.png" alt="logo" />
	</header>
	<div class="center_container">
		<article>
			<form action="#" method="post">
				<div class="input_field_ver2">
					<div class="input_content_img">
						<img id="icon" src="/tdu_market/images/icon.png" alt="icon" />
						<div>
							<label>
								<h2>アイコン</h2>
							</label> <input type="file" name="" /> <label> <br /> 画像形式：.png
								.jpg <br /> 画像のサイズ：400px*400px未満
							</label>
						</div>
					</div>
					<div class="input_content">
						<h2>ディスプレイネーム</h2>
						<input type="text" name="text" placeholder="" />
					</div>
					<div class="input_content">
						<h2>パスワード</h2>
						<input type="password" id="password" name="password"
							placeholder="パスワード" /> <input type="password"
							id="password" name="password" placeholder="確認用" />
					</div>
					<div class="input_content">
						<h2>自己紹介</h2>
						<textarea></textarea>
					</div>
					<button id="new_account_button" type="submit"
						class="button_flat_blue">登録</button>
				</div>
			</form>
		</article>
	</div>
</body>
</html>
