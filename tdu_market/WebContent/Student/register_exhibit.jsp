<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.dto.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>出品物登録</title>
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
	<%@ include file="header.jsp" %>
	<!-- InstanceBeginEditable name="body" -->
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<div class="first_container_ver2">
				<h2>出品物情報登録（※すべて必須項目）</h2>
			</div>
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<!-- VaildateExhibitItemへ処理を引き継ぐ -->
				<form action=<%=ServletPath.RegisterItemInfo %> method="post" enctype="multipart/form-data" id="exhibit_form">
					<!-- 上部コンテンツ -->
					<div class="top_content_ver2">
						<div class="detail_content">
							<h3>出品物名</h3>
							<input id="exhibit_textfield" type="text" name="itemName"
								placeholder="例：やさしい〇〇" />
						</div>
						<div class="detail_content" id="class_name_box">
							<h3>授業名</h3>
<!-- 							<input id="exhibit_textfield" type="text" name="relatedClassCode"
								placeholder="例：コンピュータプログラミングⅠ" /> -->

						<input autocomplete="on" type="text" id="exhibit_textfield" list="classList" name="relatedClassCode"/>
 						<datalist id="classList">
							<%
								ArrayList<SyllabusGetInfo> syllabusInfo = (ArrayList<SyllabusGetInfo>) session.getAttribute("classNameList");
								if(syllabusInfo != null){
									for(SyllabusGetInfo syllabusGetInfo : syllabusInfo){
										out.print("<option id=\"exhibit_textfield\" value=\"" + syllabusGetInfo.getClassCode() +" - " + syllabusGetInfo.getClassName() + "\">");
											//+ syllabusGetInfo.getClassName() + "</option>");
									}
								}
							%>
						</datalist>
						<script type="text/javascript">
<%-- 							let input = document.createElement('input');
							input.autocomplete = true;
							input.setAttribute('id', 'exhibit_textfield');
							input.setAttribute('list', 'class_name_list');
							document.getElementById('class_name_box')
								.appendChild(input);

							let datalist = document.createElement('datalist');
							datalist.id = 'class_name_list';
							let classNames = [];
							//java操作でarraylistの中身を代入
							<% for(int i = 0;i < syllabusInfo.size();i++){ %>
								//クオーテーションに色ついてしまっているのが非常に気に食わないが、動きます。
								classNames.push('<%= syllabusInfo.get(i).getClassName() %>');
							<% } %>

							classNames.forEach(function(name) {
								let option = document.createElement('option');
								option.value = name;
								datalist.appendChild(option);
							});
							document.getElementById('exhibit_textfield')
									.appendChild(datalist); --%>
						</script>
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
								<input id="fileItem" class="item_img_input" type="file" name="itemImageURLs_1"></input>
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
								<input id="fileItem2" class="item_img_input" type="file" name="itemImageURLs_2"></input>
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
								<input id="fileItem3" class="item_img_input" type="file" name="itemImageURLs_3"></input>
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
								<input id="fileItem4" class="item_img_input" type="file" name="itemImageURLs_4"></input>
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
					<div class="middle2_content">
					<button type="submit" name="submit" class="button_flat_submit"
						id="upload">確認</button>
				</form>
				<!-- 中部コンテンツ２ -->

				</div>
			</div>
		</article>
		
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
		<%-- 	<div id="exhibit_infomation">
				<article class="exhibit_dialog_content">
					<!-- セカンドコンテナ -->
					<div class="dialog_info_base" id="exhibit_information">
						<form  action=<%=ServletPath.RegisterExhibitItemPage %> method="get">
							<!-- 上部コンテンツ -->
							<div class="dialog_exhibit_top">
								<input type="hidden" name="exhibitorMailAddress"
									value="<%out.print(session.getAttribute("mailaddress"));%>" />
								<div class="detail_content">
									<h3>出品物名</h3>
									<input id="exhibit_textfield_confirm" type="text"
										name="exhibit_name"
										value="<script type="text/javascript">document.write(itemName);</script>"
										placeholder="<script type="text/javascript">document.write(itemName);</script>"
										disabled="disabled" />
								</div>
								<div class="detail_content">
									<h3>授業名</h3>
									<input id="exhibit_textfield_confirm" type="text"
										name="class_name"
										value="<script type="text/javascript">document.write(relatedClassCode);</script>"
										placeholder="<script type="text/javascript">document.write(relatedClassCode);</script>"
										disabled="disabled" />
								</div>
							</div>
							<!-- 中部コンテンツ -->
							<div class="middle_content">
								<div class="dialog_detail">
									<div class="item_image_list">
										<%
											for (int i = 0; i < 3; i++) {
												out.print("<div class=\"dialog_item_image\">");
												out.print("<img src=\"<script type=\"text/javascript\">document.write(itemImages[" + i
														+ "]);</script>\" alt=\"商品画像\" width=\"60%\" higth=\"60%\" />");
												out.print("</div>");
											}
										%>
									</div>
								</div>
							</div>
							<div class="detail_content">
								<h3 class="exhibit_description">出品物の説明</h3>
								<textarea id="exhibit_description_textfield"
									name="exhibit_description_textfield" disabled="disabled"><script
										type="text/javascript">
										document.write(condtion);
									</script></textarea>
							</div>
							<div class="detail_content">
								<h3 class="exhibit_description">状態</h3>
								<select id="dialog_condition" name="condition"
									disabled="disabled">
								</select>
							</div>
							<br>
							<div class="detail_content">
								<h3 class="exhibit_description">出品価格</h3>
								<div class="yen">
									<input type="number" name="price" disabled="disabled" />
									<h4>
										<script type="text/javascript">
											document.write(description);
										</script>
										円
									</h4>
								</div>
							</div>
						</form>
					</div>
					<!-- 中部コンテンツ２ -->
					<div class="dialog_check_button">
						<button type="submit" name="submit" class="button_flat_submit"
							id="yes">出品</button>
						<button type="submit" name="cancel" class="button_flat_normal"
							id="no">キャンセル</button>
					</div>
				</article>
			</div>
			<div id="notify_dialog">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div> --%>
			<script type="text/javascript">
				/*document.getElementById('upload').onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById('exhibit_infomation');
					let yes = document.getElementById('yes');
					let no = document.getElementById('no');
					//入力値の取得
					ver
					item_name = document.getElementsByName('itemName');
					ver
					class_code = document.getElementsByName('relatedClassCode');
					ver
					itemImages = [ 3 ];
					itemImgaes = document.getElementsByName('itemImageURLs');
					ver
					item_description = document
							.getElementsByName('description');
					ver
					item_condtion = document.getElementsByName('condtion');
					ver
					item_price = document.getElementsByName('price');

					dialog.style.display = 'block';

					yes.addEventListener('click', function() {
						dialog.style.display = 'none';

						//ここに内部処理をいれる

						notify_dialog('出品しました。', 'reference_exhibit_detail');
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
				}*/
			</script>
		</section>

	</div>
	<!-- InstanceEndEditable -->

	<%@ include file="footer.jsp"%>

</body>
</html>
