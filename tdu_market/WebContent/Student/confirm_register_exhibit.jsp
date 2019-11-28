<%@page import="java.util.ArrayList"%>
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
<title>出品物登録確認</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="/tdu_market/css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="/tdu_market/js/student.js" defer="defer"></script>
<script type="text/javascript" src="/tdu_market/js/jquery-3.3.1.min.js"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<!-- ヘッダー挿入位置 -->
	<!-- InstanceBeginEditable name="body" -->
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>出品物情報登録確認画面</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<!-- RegisterExhibitItemPageへ処理を引き継ぐ -->
				<!-- VaildateExhibitItemから取得したデータを展開する -->
				<% ItemCreateInfo info = (ItemCreateInfo)session.getAttribute("createInfo"); %>
				<form action="<%= ServletPath.RegisterItemInfo %>" method="post" id="exhibit_form">
					<!-- 上部コンテンツ -->
					<div class="top_content_ver2">
						<div class="detail_content">
							<h3>出品物名</h3>
							<input id="exhibit_textfield" type="text" name="itemName" placeholder="<% info.getItemName(); %>" readonly="readonly" />
						</div>
						<div class="detail_content">
							<h3>授業名</h3>
							<input id="exhibit_textfield" type="text" name="relatedClassCode" placeholder="<% info.getRelatedClassCode(); %>" readonly="readonly"  />
						</div>
					</div>
					<!-- 中部コンテンツ -->
					<div class="dialog_middle_content">
						<div class="detail_content_ver2">
							<h3>画像をアップロード</h3>
							<div class="item_image_list">
							<!-- 画像の表示に関して -->
							<%
							if(info.getItemImageBinaries() == null){
								out.print("登録された商品画像はありません。");
							} else {
								for(int i = 0 ; i < info.getItemImageBinaries().length;i++){
									out.print("<label class=\"item_img_add_button\">");
									out.print("<input id=\"fileItem\" class=\"item_img_input\" type=\"file\" name=\"itemImageURLs[]\" value=\""+info.getItemImageBinaries()[i]+"\" disabled=\"disabled\" ></input>");
									out.print("<img id=\"plus\" src=\""+info.getItemImageBinaries()[i]+"\">");
									out.print("</label>");
								}
							}
							%>
							</div>
						</div>
						<div class="detail_content">
							<h3>出品物の説明</h3>
							<textarea id="exhibit_description_textfield" name="description" readonly="readonly"><% info.getDescription(); %></textarea>
						</div>
						<div class="detail_content">
							<h3>状態</h3>
							<select id="condition" name="condtion" disabled="disabled">
							<%
							//汚損状態の選択
							switch(info.getCondition()){
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
							%>
							</select>
						</div>
						<div class="detail_content">
							<h3>出品価格</h3>
							<div class="yen">
								<input type="number" name="price" readonly="readonly" />
								<h4><%out.print(info.getPrice());%>円</h4>
							</div>
						</div>
					</div>
					<div class="middle2_content">
					<button type="submit" name="submit" class="button_flat_submit"
						id="upload">確認</button>
				</div>
				</form>
				<!-- 中部コンテンツ２ -->
			</div>
		</article>
	</div>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>