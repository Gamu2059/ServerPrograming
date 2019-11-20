<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>ユーザー登録画面</title>
<link href="../css/import_general_admin.css" rel="stylesheet" />
</head>
<body>
	<header>
		<img id="title_log" src="../images/student_logo.png" alt="logo" />
	</header>
	<div class="center_container">
		<article id="create">
			<form action="#" method="post">
				<div class="input_field_ver2">
					<div class="input_content_img">
						<img id="icon" src="../images/icon.png" alt="icon" />
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
					<button id="new_account_button" type="submit"
						class="button_flat_blue">登録</button>
				</div>
			</form>
		</article>
	</div>

</body>
</html>