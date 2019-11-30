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
<title>シラバス一覧</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス一覧</h2>
		<!-- メインコンテンツ -->
		<article>
			<!-- ソート -->
			<div class="sort">
				<select name="sort_student">
					<option value="1">授業コード</option>
					<option value="2">授業名</option>
					<option value="3">学部</option>
					<option value="4">学科</option>
					<option value="5">担当教員</option>
					<option value="6">開講年度</option>
				</select>
			</div>
			<!-- テーブル -->
			<div class="item_for_center">
				<div class="list">
					<form name="select_syllabus">
						<table>
							<!-- テーブルタイトル -->
							<thead class="list_title">
								<tr>
									<th class="check_column1"></th>
									<th class="syllabus_column1">授業コード</th>
									<th class="syllabus_column2">授業名</th>
									<th class="syllabus_column3">学部</th>
									<th class="syllabus_column4">学科</th>
									<th class="syllabus_column5">担当教員</th>
									<th class="syllabus_column6">開講年度</th>
								</tr>
							</thead>
							<!-- テーブル要素 -->
							<tbody class="list_content">
								<!-- サンプル -->
								<tr class="syllabusId">
									<th class="check_column1"><input type="checkbox" /></th>
									<td class="syllabus_column1">11G0012501</td>
									<td class="syllabus_column2">フレッシュマンセミナー</td>
									<td class="syllabus_column3">未来科学部</td>
									<td class="syllabus_column4">情報メディア学科</td>
									<td class="syllabus_column5">大沢 啓徳</td>
									<td class="syllabus_column6">2019年度後期</td>
								</tr>
							</tbody>
						</table>
						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".syllabusId").on(
									"click",
									function() {
										//商品IDの取得
										var syllabusNumber = $(this).children(
												"td")[1].innerText;
										//Input型エレメントの生成
										var element = document
												.createElement("input");
										//typeの設定
										element.setAttribute("type", "submit");
										//nameの設定
										element.setAttribute("name",
												"selectItem");
										//valueの設定
										element.setAttribute("value",
												syllabusNumber);
										//取得したIDデータをsetattributeする
										document.select_syllabus
												.appendChild(element);
										//データをサーバーへ送信する
										document.select_syllabus.submit();
									});
						</script>
						<!-- テーブル要素クリックここまで -->
					</form>
				</div>
			</div>
			<br />
			<div class="item_for_LeftAndRight_around">
				<!-- checkboxがどれか選択されている場合のみ反応 -->
				<button id="red_button" type="button">削除</button>
				<button class="search_button" type="button">
					<img src="/tdu_market/images/search.png" />絞り込み
				</button>
				<!-- 絞り込みボタン -->
				<div class="edit_and_add_button_box">
					<button id="blue_button" type="button">編集</button>
					<br />
					<button id="blue_button" type="button">登録</button>
				</div>
			</div>
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
				document.getElementById("red_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					dialog.style.display = "block";

					yes.addEventListener("click", function() {
						dialog.style.display = "none";

						//ここに内部処理をいれる

						notify_dialog("削除しました。",
								"reference_syllabus_list_by_admin"); /*再読み込みがかかります*/
					});
					no.addEventListener("click", function() {
						dialog.style.display = "none";
					});
				};
				function notify_dialog(text, url) {
					let dialog = document.getElementById("notify_dialog_admin");

					document.getElementById("notify_text").textContent = text;

					dialog.style.display = "block";
					ok.addEventListener("click", function() {
						//location.href = url + ".jsp";
						dialog.style.display = "none";
					});
				}
			</script>
		</section>
	</div>
</body>
</html>