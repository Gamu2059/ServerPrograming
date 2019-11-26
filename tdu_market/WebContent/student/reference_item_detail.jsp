<%@page import="tdu_market.dto.RelatedClassGetInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>商品情報参照</title>
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
			<div class="first_container"></div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<!-- ReferItemPageから渡されるデータを展開・表示 -->
					<%
					ArrayList<RelatedClassGetInfo> info = (ArrayList<RelatedClassGetInfo>)request.getAttribute("relatedClassGetInfo");
					out.print("<div class=\"detail_content\">");
					out.print("<h2 id=\"item_name\">"+info.get(0).getItemGetInfo().getItemName()+"</h2>");
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<h5 id=\"syllabus_name\">"+ info.get(0).getSyllabusGetInfo().getClassName() +"</h5>");
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					//画像の表示
					if(info.get(0).getItemGetInfo().getItemImageBinaries() != null){
						//画像が登録されているのであれば。
						for(int i=0;i < info.get(0).getItemGetInfo().getItemImageBinaries().length; i++){
							out.print("<img src=\""+ info.get(0).getItemGetInfo().getItemImageBinaries()[i] +"\" alt=\"商品画像\" />");
						}
					} else {
						out.print("この商品には画像が登録されていません。");
					}
					out.print("</div>");
					out.print("<div class=\"detail_content\">");
					out.print("<h4 id=\"item_explanation\">"+ info.get(0).getItemGetInfo().getDescription() +"</h4>");
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					switch(info.get(0).getItemGetInfo().getCondition()){
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
						out.print("<h4>状態を取得出来ませんでした</h4>");
						break;
					}
					out.print("</div>");
					out.print("<div class=\"detail_content_right\">");
					out.print("<h4>"+ info.get(0).getItemGetInfo().getPrice() +"円</h4>");
					out.print("</div>");
					%>
					<div class="detail_content_center">
						<button class="button_flat_submit" type="submit" name="trade"
							value="trade" id="buy_item">取引する</button>
					</div>
				</section>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<div id="confirm_dialog">
				<p>取引を申し込みますか？</p>
				<div class="confirm_dialog_button">
					<!-- BuyItemに処理を引き継ぐ -->
					<form action="../BuyItem" method="post">
						<%
						out.print("<input type=\"hidden\" name=\"beginTraderMailAddress\" value=\""+ session.getAttribute("meiladdress") +"\"/>");
						out.print("<input type=\"hidden\" name=\"tradedItemID\" value=\""+ info.get(0).getItemGetInfo().getItemID() +"\"/>");
						%>
						<button type="submit" id="yes" class="button_flat_submit">確認</button>
					</form>
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
				document.getElementById('buy_item').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('confirm_dialog');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('取引を申し込みました。<br>相手からの連絡をお待ちください。');
					});
					no.addEventListener('click', function() {
						dialog.style.display = 'none';
					});
				}
				function notify_dialog(text) {
					let dialog = document.getElementById('notify_dialog');

					document.getElementById('notify_text').innerHTML = text;

					dialog.style.display = 'block';
					ok.addEventListener('click', function() {
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