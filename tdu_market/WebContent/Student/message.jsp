<%@page import="tdu_market.dto.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="tdu_market.util.*"%>
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
<title>メッセージ</title>
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
		<article class="content_ver2">
			<!-- ファーストコンテナ -->
			<!-- セカンドコンテナ -->
			<div class="second_container_message">
				<!--メッセージ一覧-->
				<section class="sec_message_list">
					<div class="message_tab">
						<div class="message_header">メッセージ一覧</div>
						<!--for文で何とかしたい（希望）
						<input type="radio" id="message1" name="m1" />
						<input type="radio" id="message2" name="m2" />
						<input type="radio" id="message3" name="m3" />
						-->

						<!-- メッセージルームを取得、展開 -->
						<%
						String mailAddress = ControllerUtil.getMailAddress(request, response);
						StudentGetInfo studentInfo = (StudentGetInfo) session.getAttribute("studentInfo");
						ArrayList<MessageRoomGetInfo> messageRoomList = new ArrayList<>();
							messageRoomList = (ArrayList<MessageRoomGetInfo>) session.getAttribute("messageRoomInfoList");
							if (messageRoomList != null) {
								//listが展開できているので、trueを渡してしまっている		
								session.setAttribute("isSelect","true");
								for (int i = 0; i < messageRoomList.size(); i++) {
									out.print(
											"<form action=\"/tdu_market/tdu_market/controller/ReferMessageBoxListPage\" method=\"post\">");
									out.print("<input type=\"hidden\" name=\"studentNumber\" value=\""
											+ messageRoomList.get(i).getOpponentStudentGetInfo().getMailAddress() + "\" />");
									out.print("<input type=\"hidden\" name=\"roomID\" value=\""
											+ messageRoomList.get(i).getRoomID() + "\" />");
									out.print("<button type=\"submit\" for=\"message1\" class=\"message_list_tab\">");
									if(messageRoomList.get(i).getOpponentStudentGetInfo().getIconImageBinary() != null){
										out.print("<img src=\"" + messageRoomList.get(i).getOpponentStudentGetInfo().getIconImageBinary()
												+ "\" alt=\"アイコン\" />");
									}else{
										out.print("<img src=\"/tdu_market/images/icon.png\" alt=\"アイコン\" />");
									}
									out.print("<div class=\"message_content\">");
									out.print("<div class=\"message_sender\">"
											+ messageRoomList.get(i).getOpponentStudentGetInfo().getDisplayName() + "</div>");
									out.print("<div class=\"message_text\">"
											+ messageRoomList.get(i).getLatestPostMessageGetInfo().getPostContent() + "</div>");
									out.print("</div>");
									out.print("</button>");
									out.print("</form>");
								}
							}
						%>
					</div>
				</section>
				<!--メッセージ画面-->
				<section class="sec_message_room">
					<div class="message_room">
						<!--メッセージヘッダー-->
						<!-- メッセージの取得 -->
						<%
							ArrayList<MessageGetInfo> messageList =  (ArrayList<MessageGetInfo>) session.getAttribute("messageInfoList");
							StudentGetInfo messageOpponentStudentInfo = (StudentGetInfo) session
									.getAttribute("messageOpponentStudentInfo");
							if (messageOpponentStudentInfo != null) {
						%>
						<div class="message_header" name="message_room_panel">
							<div>
								<%
									
										out.print(messageOpponentStudentInfo.getDisplayName());
									
								%>
							</div>
							<%-- <form action=<%=ServletPath.ReferItemPage %> method="get">
								<input type="button" name="trading_button" class="button_flat_normal" value="取引中の商品" disabled="disabled" />
							</form> --%>
						</div>
						<!--メッセージコンテンツ-->
						<div class="message_post_list">
							<section>
								<div class="message_post" name="system">
									<!--メッセージ一つ-->
									<div class="message_post_content" name="system">
										<%
											if (messageOpponentStudentInfo != null) {
												out.print(messageOpponentStudentInfo.getDisplayName());
											}
										%>さんと取引を開始しました。
									</div>
								</div>
								<%
									if (messageOpponentStudentInfo != null) {
										for (int i = 0; i < messageList.size(); i++) {
											if (messageList.get(i).getPostStudentNumber().equals(messageOpponentStudentInfo.getMailAddress())) {
												//取引相手のメッセージならば
												out.print("<div class=\"message_post\" name=\"opponent\">");
												if(messageOpponentStudentInfo.getIconImageBinary() != null){
													out.print("<img src=\"" + messageOpponentStudentInfo.getIconImageBinary() + "\" alt=\"icon\" />");
												}else{
													out.print("<img src=\"/tdu_market/images/icon.png\" alt=\"icon\" />");
												}
												out.print("<div class=\"message_post_content\" name=\"opponent\">");
												out.print(messageList.get(i).getPostContent());
												out.print("</div>");
												out.print("</div>");
											} else {
												out.print("<div class=\"message_post\" name=\"myself\">");
												out.print("<div class=\"message_post_content\" name=\"opponent\">");
												out.print(messageList.get(i).getPostContent());
												out.print("</div>");
												if(studentInfo.getIconImageBinary() != null){
													out.print("<img src=\"" + studentInfo.getIconImageBinary() + "\" alt=\"icon\" />");
												}else{
													out.print("<img src=\"/tdu_market/images/icon.png\" alt=\"icon\" />");
												}
												out.print("</div>");
											}
										}
									}
								%>
							</section>
						</div>
						<!--メッセージフォーム-->
						<div class="textfield">
							<form action="<%=ServletPath.PostMessage%>" method="post">
							  <input type="hidden" name="roomID" value="<%=session.getAttribute("roomID")%>">
							  <input type="hidden" name="studentNumber" value="<%=mailAddress%>">
								<textarea id="message_form" name="content" cols="40"
									rows="2" placeholder="メッセージを入力"></textarea>
								<input type="image" src="/tdu_market/images/post2.png" alt="post" id="post_icon">
 							</form>
						</div>
					</div>
					<section>
						<!--
			ダイアログ付与手順。
				1.該当するidをボタンに付与する。update, delete, back_button
				2.notify_dialog('表示したいメッセージ','遷移先url')
			-->

					</section>
					<%} %>
				</section>
			</div>
			<!-- サードコンテナ -->
		</article>
		<div id="message_dialog">
	<p id="confirm_text"></p>
		<div class="confirm_dialog_button">
				<button id="yes" class="button_flat_nega">確認</button>
				<button id="no" class="button_flat_normal">キャンセル</button>
			</div>
		</div>
		<div id="message_notify">
			<p id="notify_text">確認ダイアログ</p>
			<div class="notify_dialog_button">
				<button id="ok" class="button_flat_normal">了解</button>
			</div>
		</div>
		<script type="text/javascript">
		<% if(DialogUtil.checkDisplayDialog(request, response)){%>
			notify_dialog('\n'+<%=DialogUtil.getDialogMessage(request, response) %>);
		<% } %>
/* 			document.getElementById('end_trade').onclick = function() {
				//各ボタンの要素の取得
				let dialog = document
						.getElementById('message_dialog');
				let yes = document.getElementById('yes');
				let no = document.getElementById('no');
		
				document.getElementById('confirm_text').innerHTML = '<br>完了報告を行いますか？ <h6>（この取引は双方の同意をもって終了します。）<p>';
				dialog.style.display = 'block';
		
				yes
						.addEventListener(
								'click',
								function() {
									dialog.style.display = 'none';
		
								});
				no.addEventListener('click', function() {
					dialog.style.display = 'none';
				});
			} */
			function notify_dialog(text) {
				let dialog = document
						.getElementById('message_notify');
		
				document.getElementById('notify_text').innerHTML = text;
		
				dialog.style.display = 'block';
				ok.addEventListener('click', function() {
					<% DialogUtil.turnoffDialog(request, response); %>
					dialog.style.display = 'none';
				});
			}
			/*通知として呼び出す確認ダイアログ*/
/* 			function end_notify() {
				//各ボタンの要素の取得
				let dialog = document
						.getElementById('confirm_dialog');
				let yes = document.getElementById('yes');
				let no = document.getElementById('no');
		
				document.getElementById('confirm_text').innerHTML = '<br>相手が完了報告を行いました。<br>同意してもよろしいですか？';
				dialog.style.display = 'block';
		
				yes
						.addEventListener(
								'click',
								function() {
									dialog.style.display = 'none';
		
									//ここに内部処理をいれる
		
									//notify_dialog('<br>取引が完了しました。<br>またのご利用をお待ちしています。');
								});
				no.addEventListener('click', function() {
					dialog.style.display = 'none';
				});
			} */
		</script>
	</div>

	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>
