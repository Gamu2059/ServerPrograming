<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.util.ServletPath"%>
<%@page import="tdu_market.dto.*"%>
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
<script type="text/javascript" src="/tdu_market/js/student.js"
	defer="defer"></script>
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
					<form action="<%=ServletPath.UpdateItemInfo %>" method="post" enctype="multipart/form-data">
					<!-- フォームの初期設定 -->
					<%
					//１．更新対象の商品情報を取得
					RelatedClassGetInfo info = (RelatedClassGetInfo)session.getAttribute("relatedClassGetInfo");
					//２．更新対象の商品情報を展開して入力フォームを生成
					out.print("<input type=\"hidden\" name=\"itemID\" value=\""+info.getItemGetInfo().getItemID()+"\" />");
					out.print("<div class=\"detail_input_textfield\">");
					out.print("<input id=\"item_name\" type=\"text\" name=\"itemName\" value=\" " + info.getItemGetInfo().getItemName() + " \" />");
					out.print("</div>");
					out.print("<div class=\"detail_input_textfield\">");
					out.print("<input id=\"syllabus_name\" type=\"text\" name=\"class_name\" value=\""+ info.getSyllabusGetInfo().getClassName() +"\" />");
					out.print("</div>");
					out.print("<div class=\"detail_content_left\">");
					//商品画像の表示
					%>
					<h3 id="error">画像をアップロード</h3>
					<%
					ArrayList<String> itemImageURLs = new ArrayList<>();
					for(int i=0;i<info.getItemGetInfo().getItemImageBinaries().length;i++){
						itemImageURLs.add(info.getItemGetInfo().getItemImageBinaries()[i]);
					}
					if(itemImageURLs == null){
						//画像が0枚のとき（追加ボタンのみ表示）
						out.print("<label class=\"item_img_add_button\">"+
						" <input class=\"item_img_input\" type=\"file\" name=\"itemImageURLs\"></input> <br><h3>+</h3></label>");
					} else {
						//画像が1枚４枚のとき
						if(4 < itemImageURLs.size()){
							//画像が４枚のとき（画像のみ表示）
							for(int i=0; i < itemImageURLs.size(); i++){
								out.print("<div class=\"item_img_delete_button\">");
								out.print("<img src=\""+ itemImageURLs.get(i) +"\" alt=\"商品画像\" />");
								out.print("<button name=\"itemImageURLs\" onClick=\""+ itemImageURLs.remove(i) +" \">削除</button>");
								out.print("</div>");
							}
						} else {
							//画像が３枚以下のとき（画像と追加ボタンを表示）
							for(int i=0; i < itemImageURLs.size(); i++){
								out.print("<div class=\"item_img_delete_button\">");
								out.print("<img src=\""+ itemImageURLs.get(i) +"\" alt=\"商品画像\" />");
								out.print("<button name=\"itemImageURLs\" onClick=\""+ itemImageURLs.remove(i) +" \" >削除</button>");
								out.print("</div>");
							}
							out.print("<label class=\"item_img_add_button\"> <input class=\"item_img_input\" type=\"file\" name=\"itemImageURLs\"></input> <br><h3>+</h3></label>");
						}
					}
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<textarea id=\"item_explanation_field\" name=\"description\">"+info.getItemGetInfo().getDescription()+"</textarea>");
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					out.print("<h4>状態： <select id=\"condition\" name=\"condition\">");
					//汚損状態の選択
					switch(info.getItemGetInfo().getCondition()){
					case 0:
						out.print("<option value=\"0\" selected>新品・未使用</option>");
						out.print("<option value=\"1\">中古（書き込みなし）</option>");
						out.print("<option value=\"2\">中古（書き込みあり）</option>");
						out.print("<option value=\"3\">破損・汚れあり</option>");
						break;
					case 1:
						out.print("<option value=\"0\">新品・未使用</option>");
						out.print("<option value=\"1\" selected>中古（書き込みなし）</option>");
						out.print("<option value=\"2\">中古（書き込みあり）</option>");
						out.print("<option value=\"3\">破損・汚れあり</option>");
						break;
					case 2:
						out.print("<option value=\"0\">新品・未使用</option>");
						out.print("<option value=\"1\">中古（書き込みなし）</option>");
						out.print("<option value=\"2\" selected>中古（書き込みあり）</option>");
						out.print("<option value=\"3\">破損・汚れあり</option>");
						break;
					case 3:
						out.print("<option value=\"0\">新品・未使用</option>");
						out.print("<option value=\"1\">中古（書き込みなし）</option>");
						out.print("<option value=\"2\">中古（書き込みあり）</option>");
						out.print("<option value=\"3\" selected>破損・汚れあり</option>");
						break;
					default:
						out.print("<option value=\"0\">新品・未使用</option>");
						out.print("<option value=\"1\">中古（書き込みなし）</option>");
						out.print("<option value=\"2\">中古（書き込みあり）</option>");
						out.print("<option value=\"3\">破損・汚れあり</option>");
						break;
					}
					out.print("</select>");
					out.print("</h4>");
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					out.print("<h4><input id=\"yen_field\" type=\"number\" name=\"price\" value=\""+ info.getItemGetInfo().getPrice()+"\" />円</h4>");
					out.print("</div>");
					%>
					<script type="text/javascript">
						function imageError(){
							if(document.getElementById('fileItem').value == ''){
								document.getElementById('error').innerHTML = '<h3>画像をアップロード</h3><p style="color:red;"> 画像は1枚以上必須です。</p>';
								scrollTo(0,0);
							}
						}
					</script>
					<!-- ３．更新ボタンを押して、Servletにデータを渡す -->
						<div id="confirm_dialog">
							<p>更新しますか？</p>
							<div class="confirm_dialog_button">

								<button id="yes" class="button_flat_submit" type="submit">確認</button>

								<button id="no" class="button_flat_normal">キャンセル</button>

							</div>
						</div>

				</section>
			</div>
			<!-- サードコンテナ -->
			<div class="third_container_ver2">

				<button type="button" name="back" class="button_flat_normal"
					id="back_event">戻る</button>

				<button type="button" name="back" class="button_flat_submit"
					id="update_exhibit">更新</button>

					<form>
					<button type="button" name="delete" class="button_flat_nega"
					id="delete_exhibit">削除</button>
					</form>
			</div>
		</article>
		<section>

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
				 		<%
				 		boolean isDisplayDialog = true;
				 		String dialogMessage = "更新しました";
				 		session.setAttribute("dialogMessage", dialogMessage);
				 		session.setAttribute("isDisplayDialog", isDisplayDialog);
				 		%>
						//notify_dialog('更新しました。', 'reference_exhibit_detail');
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
				 		<%
				 		isDisplayDialog = true;
				 		dialogMessage = "削除しました";
				 		session.setAttribute("dialogMessage", dialogMessage);
				 		session.setAttribute("isDisplayDialog", isDisplayDialog);
				 		%>
						//notify_dialog('削除しました。', 'reference_exhibit_list');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').textContent = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
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
