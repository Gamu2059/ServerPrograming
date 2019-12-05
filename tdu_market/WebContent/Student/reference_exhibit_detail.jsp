<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.entity_bean.RelatedClassInfo"%>
<%@page import="tdu_market.dto.*"%>
<%@page import="tdu_market.util.ServletPath"%>
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
				<!-- EditExhibitItemPageへ処理を引き継ぐ -->
				<form action="<%=ServletPath.EditExhibitItemPage%>" method="get">
					<button type="submit" name="edit" class="button_flat_normal" id="edit">編集</button>
				</form>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<!-- ReferExhibitItemPageからのセッションデータを展開・表示 -->
					<%
					RelatedClassGetInfo info = (RelatedClassGetInfo)session.getAttribute("exhibitInfo");
					out.print("<div class=\"detail_content\">");
					out.print("<h2 id=\"item_name\">"+ info.getItemGetInfo().getItemName() +"</h2>");
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<h5 id=\"syllabus_name\">"+ info.getSyllabusGetInfo().getClassName() +"</h5>");
					out.print("</div>");
					//商品画像の表示
					out.print("<div class=\"detail_content\" style=\" display:flex; \" >");
					ArrayList<String> itemImageURLs = new ArrayList<>();
					for(int i=0;i<info.getItemGetInfo().getItemImageBinaries().length;i++){
						itemImageURLs.add(info.getItemGetInfo().getItemImageBinaries()[i]);
					}
					if(itemImageURLs == null){
						//画像が0枚のとき（追加ボタンのみ表示）
						//out.print("<label class=\"item_img_add_button\"> <input class=\"item_img_input\" type=\"file\" name=\"itemImageURLs\"></input> <br><h3>+</h3></label>");
						out.print("<h3>"+"No Image"+"</h3>");
					} else {
						//画像が1枚４枚のとき
						if(4 < itemImageURLs.size()){
							//画像が４枚のとき（画像のみ表示）
							for(int i=0; i < itemImageURLs.size(); i++){
								if(itemImageURLs.get(i).equals("data:image/png;base64,")){
									continue;
								}
								out.print("<div class=\"item_img_delete_button\">");
								out.print("<img src=\""+ itemImageURLs.get(i) +"\" alt=\"商品画像\" />");
								//out.print("<button name=\"itemImageURLs\" onClick=\""+ itemImageURLs.remove(i) +" \">削除</button>");
								out.print("</div>");
							}
						} else {
							//画像が３枚以下のとき（画像と追加ボタンを表示）
							for(int i=0; i < itemImageURLs.size(); i++){
								if(itemImageURLs.get(i).equals("data:image/png;base64,")){
									continue;
								}
								out.print("<div class=\"item_img_delete_button\">");
								out.print("<img src=\""+ itemImageURLs.get(i) +"\" alt=\"商品画像\" />");
								//out.print("<button name=\"itemImageURLs\" onClick=\""+ itemImageURLs.remove(i) +" \" >削除</button>");
								out.print("</div>");
							}
							//out.print("<label class=\"item_img_add_button\"> <input class=\"item_img_input\" type=\"file\" name=\"itemImageURLs\"></input> <br><h3>+</h3></label>");
						}
					}

					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<h4 id=\"item_explanation\">"+ info.getItemGetInfo().getDescription() +"</h4>");
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					switch(info.getItemGetInfo().getCondition()){
					case 0:
						out.print("<h4>状態：新品・未使用</h4>");
						break;
					case 1:
						out.print("<h4>状態：中古（書き込みなし）</h4>");
						break;
					case 2:
						out.print("<h4>状態：中古（書き込みあり）</h4>");
						break;
					case 3:
						out.print("<h4>状態：破損・汚れあり</h4>");
						break;
					default:
						out.print("<h4>状態：取得に失敗しました</h4>");
						break;
					}
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					out.print("<h4>"+ info.getItemGetInfo().getPrice() +"</h4>");
					out.print("</div>");
					%>
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
					<!-- DeleteItemInfoに処理を引き継ぐ -->
					<form action="<%=ServletPath.DeleteItemInfo%>" method="post">
						<button id="nega_yes" class="button_flat_nega">確認</button>
					</form>
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