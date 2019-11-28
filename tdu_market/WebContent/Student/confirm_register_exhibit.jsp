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
				<% ReturnInfo info = (ReturnInfo)session.getAttribute("itemResult"); %>
				<form action="../RegisterExhibitItemPage" method="get" id="exhibit_form">
					<!-- 上部コンテンツ -->
					<div class="top_content_ver2">
						<div class="detail_content">
							<h3>出品物名</h3>
							<input id="exhibit_textfield" type="text" name="itemName" placeholder="例：やさしい〇〇" />
						</div>
						<div class="detail_content">
							<h3>授業名</h3>
							<input id="exhibit_textfield" type="text" name="relatedClassCode" placeholder="例：コンピュータプログラミングⅠ" />
						</div>
					</div>
					<!-- 中部コンテンツ -->
					<div class="dialog_middle_content">
						<div class="detail_content_ver2">
							<h3>画像をアップロード</h3>
							<div class="item_image_list">
							<!-- 画像の登録に関して -->
							<!-- HTML -->
							<div>
							<label class="item_img_add_button">
								<input id="fileItem" class="item_img_input" type="file" name="itemImageURLs[]"></input>
								<img id="plus" src="/tdu_market/images/plus.png">
							</label>
							<div id="deleteButton" onClick="deleteAction();">
								削除
							</div>
							</div>
							<!-- JavaScript（jQuery） -->
							<!-- 削除（input） -->
							<script>
        					function deleteAction() {
        						var obj = document.getElementById("fileItem");
        						obj.value = "";
        						var img = document.getElementById("plus");
        						img.src = "/tdu_market/images/plus.png";
        					}
    						</script>
    						<!-- プレビュー -->
							<script>
							$('#fileItem').on('change', function (e) {
							    var reader = new FileReader();
							    reader.onload = function (e) {
							        $("#plus").attr('src', e.target.result);
							    }
							    reader.readAsDataURL(e.target.files[0]);
							});
							</script>
							<!-- HTML -->
							<div>
							<label class="item_img_add_button">
								<input id="fileItem2" class="item_img_input" type="file" name="itemImageURLs[]"></input>
								<img id="plus2" src="/tdu_market/images/plus.png">
							</label>
							<div id="deleteButton" onClick="deleteAction2();">
								削除
							</div>
							</div>
							<!-- JavaScript（jQuery） -->
							<!-- 削除（input） -->
							<script>
        					function deleteAction2() {
        						var obj = document.getElementById("fileItem2");
        						obj.value = "";
        						var img = document.getElementById("plus2");
        						img.src = "/tdu_market/images/plus.png";
        					}
    						</script>
    						<!-- プレビュー -->
							<script>
							$('#fileItem2').on('change', function (e) {
							    var reader = new FileReader();
							    reader.onload = function (e) {
							        $("#plus2").attr('src', e.target.result);
							    }
							    reader.readAsDataURL(e.target.files[0]);
							});
							</script>
							<!-- HTML -->
							<div>
							<label class="item_img_add_button">
								<input id="fileItem3" class="item_img_input" type="file" name="itemImageURLs[]"></input>
								<img id="plus3" src="/tdu_market/images/plus.png">
							</label>
							<div id="deleteButton" onClick="deleteAction3();">
								削除
							</div>
							</div>
							<!-- JavaScript（jQuery） -->
							<!-- 削除（input） -->
							<script>
        					function deleteAction3() {
        						var obj = document.getElementById("fileItem3");
        						obj.value = "";
        						var img = document.getElementById("plus3");
        						img.src = "/tdu_market/images/plus.png";
        					}
    						</script>
    						<!-- プレビュー -->
							<script>
							$('#fileItem3').on('change', function (e) {
							    var reader = new FileReader();
							    reader.onload = function (e) {
							        $("#plus3").attr('src', e.target.result);
							    }
							    reader.readAsDataURL(e.target.files[0]);
							});
							</script>
							<!-- HTML -->
							<div>
							<label class="item_img_add_button">
								<input id="fileItem4" class="item_img_input" type="file" name="itemImageURLs[]"></input>
								<img id="plus4" src="/tdu_market/images/plus.png">
							</label>
							<div id="deleteButton" onClick="deleteAction4();">
								削除
							</div>
							</div>
							<!-- JavaScript（jQuery） -->
							<!-- 削除（input） -->
							<script>
        					function deleteAction4() {
        						var obj = document.getElementById("fileItem4");
        						obj.value = "";
        						var img = document.getElementById("plus4");
        						img.src = "/tdu_market/images/plus.png";
        					}
    						</script>
    						<!-- プレビュー -->
							<script>
							$('#fileItem4').on('change', function (e) {
							    var reader = new FileReader();
							    reader.onload = function (e) {
							        $("#plus4").attr('src', e.target.result);
							    }
							    reader.readAsDataURL(e.target.files[0]);
							});
							</script>

							</div>
						</div>
						<div class="detail_content">
							<h3>出品物の説明</h3>
							<textarea id="exhibit_description_textfield" name="description"></textarea>
						</div>
						<div class="detail_content">
							<h3>状態</h3>
							<select id="condition" name="condtion">
								<option value="0">新品・未使用</option>
								<option value="1">中古（書き込みなし）</option>
								<option value="2">中古（書き込みあり）</option>
								<option value="3">破損・汚れあり</option>
							</select>
						</div>
						<div class="detail_content">
							<h3>出品価格</h3>
							<div class="yen">
								<input type="number" name="price" />
								<h4>円</h4>
							</div>
						</div>
					</div>
				</form>
				<!-- 中部コンテンツ２ -->
				<div class="middle2_content">
					<button type="submit" name="submit" class="button_flat_submit"
						id="upload">確認</button>
				</div>
			</div>
		</article>
	</div>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>