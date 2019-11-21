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
<title>シラバス詳細（編集）</title>
</head>
<body>
	<%@ include file="panel.jsp"%>
	<!-- 右パネル -->
	<div class="right_panel">
		<!-- タイトル -->
		<h2 id="page_title">シラバス詳細（編集）</h2>
		<!-- メインコンテンツ -->
		<article>
			<br>
			<div class="syllabus_profile">
				<div class="item_for_grid_r1c2">
					<h3>授業コード</h3>
					<input type="text" placeholder="例：00000000000000000">
				</div>
				<div class="item_for_grid_r1c1">
					<input id="syllabus_name" type="text"
						placeholder="授業名 例：ぬこでもわかるJAVA">
				</div>
				<div class="item_for_grid_r1c2">
					<h3>開講年度</h3>
					<input type="text" autocomplete="on" list="course_year_list"
						placeholder="2019年前期">
					<datalist id="course_year_list">
						<option value="2019年前期"></option>
						<option value="2019年後期"></option>
						<option value="2018年前期"></option>
						<option value="2018年後期"></option>
						<option value="2017年前期"></option>
						<option value="2017年後期"></option>
						<option value="2016年前期"></option>
						<option value="2016年後期"></option>
					</datalist>
				</div>
				<div class="item_for_grid_r1c2">
					<div class="item_for_grid_r1c2" id="week_syllabus">
						<h3>曜日</h3>
						<script type="text/javascript">
							let input_date = document.createElement('input');
							input_date.autocomplete = true;
							input_date.setAttribute('list', 'date_list');
							document.getElementById('week_syllabus')
									.appendChild(input_date);

							let datalist_date = document
									.createElement('datalist');
							datalist_date.id = 'date_list';
							let name_date = Array(42);

							let week = [ '月曜 - ', '火曜 - ', '水曜 - ', '木曜 - ',
									'金曜 - ', '土曜 - ' ];
							let date = [ '1限', '2限', '3限', '4限', '5限', '6限',
									'7限' ];
							for (let j = 0; j < 6; j++) {
								for (let i = j * 7; i < (j + 1) * date.length; i++) {
									console.log(j)
									name_date[i] = week[j] + date[i - j * 7];
								}
							}
							name_date.forEach(function(name) {
								let option_date = document
										.createElement('option');
								option_date.value = name;
								datalist_date.appendChild(option_date);
							});
							document.getElementById('week_syllabus')
									.appendChild(datalist_date);
						</script>
					</div>
					<div class="item_for_grid_r1c2">
						<h3 id="unit">単位数</h3>
						<input type="number" placeholder="0.0">
					</div>
				</div>
				<div class="item_for_grid_r1c2">
					<h3>教室</h3>
					<input type="text" placeholder="例： 2000教室 ">
				</div>
				<div class="item_for_grid_r1c2" id="teacher_syllabus">
					<h3>教員</h3>
					<script type="text/javascript">
						let input = document.createElement('input');
						input.autocomplete = true;
						input.setAttribute('list', 'teacher_list');
						document.getElementById('teacher_syllabus')
								.appendChild(input);

						let datalist = document.createElement('datalist');
						datalist.id = 'teacher_list';
						let names = [ '岩井将行', '鉄谷信二' ];/*ここは手打ちでもいいけど、DBなどから取得できると楽*/
						names.forEach(function(name) {
							let option = document.createElement('option');
							option.value = name;
							datalist.appendChild(option);
						});
						document.getElementById('teacher_syllabus')
								.appendChild(datalist);
					</script>
				</div>
				<div class="item_for_grid_r1c1">
					<h3>目的概要</h3>
					<textarea></textarea>
					<h3 name="perpose">達成目標</h3>
					<textarea></textarea>
				</div>
				<div class="item_for_grid_r1c2_c12">
					<h3>履修条件</h3>
					<input type="text">
				</div>
				<div class="item_for_grid_r1c1">
					<h3>評価方法</h3>
					<textarea></textarea>
				</div>
			</div>
			<br>
			<div class="item_for_center">
				<button id="orange_button">確定</button>
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
				<p>更新しますか？</p>
				<div class="confirm_dialog_button">
					<button id="yes" class="button_flat_submit">確認</button>
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
				document.getElementById('orange_button').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document
							.getElementById('confirm_dialog_admin');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click',
							function() {
								dialog.style.display = 'none';

								//ここに内部処理をいれる

								notify_dialog('更新しました。',
										'reference_syllabus_by_admin');/*再読み込みがかかります*/
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