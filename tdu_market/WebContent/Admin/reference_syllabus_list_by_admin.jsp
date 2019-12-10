<%@page import="tdu_market.util.DialogUtil"%>
<%@page import="tdu_market.dto.DepartmentGetInfo"%>
<%@page import="tdu_market.dto.SyllabusGetInfo"%>
<%@page import="java.util.ArrayList"%>
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
				<form name="sort_syllabus">
				<select name="sort_number" onchange="sort_syllabusList();">
					<option value="1">授業コード(昇順)</option>
					<option value="2">授業コード(降順)</option>
					<option value="3">授業名(昇順)</option>
					<option value="4">授業名(降順)</option>
					<option value="5">学部(昇順)</option>
					<option value="6">学部(降順)</option>
					<option value="7">学科(昇順)</option>
					<option value="8">学科(降順)</option>
					<option value="9">担当教員(昇順)</option>
					<option value="10">担当教員(降順)</option>
					<option value="11">開講年度(昇順)</option>
					<option value="12">開講年度(降順)</option>
				</select>
				</form>
			</div>
			<!-- テーブル -->
			<div class="item_for_center">
				<div class="list_content">
					<form name="remove_form" action="<%= ServletPath.DeleteSyllabusInfo %>" method="post">
						<table id="syllabusList">
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
							<tbody class="list" id="list_content">


								<!-- データの表示と展開 -->
								<%
								ArrayList<SyllabusGetInfo> syllabusInfoList = new ArrayList<SyllabusGetInfo>();
								ArrayList<DepartmentGetInfo> departmentInfoList = new ArrayList<DepartmentGetInfo>();
								syllabusInfoList = (ArrayList<SyllabusGetInfo>)session.getAttribute("syllabusInfoList");
								departmentInfoList = (ArrayList<DepartmentGetInfo>)session.getAttribute("departmentInfoList");
								if(syllabusInfoList!=null && departmentInfoList !=null ){
									for(SyllabusGetInfo info:syllabusInfoList){
										%>
										<tr class="syllabusId">
											<th class="check_column1"><input type="checkbox" name="classCodes" value="<%= info.getClassCode() %>" /></th>
											<td class="syllabus_column1"><%= info.getClassCode() %></td>
											<td class="syllabus_column2"><%= info.getClassName() %></td>
											<td class="syllabus_column3"><%= departmentInfoList.get((int)info.getSubjectID()-1).getFacultyName() %></td>
											<td class="syllabus_column4"><%= departmentInfoList.get((int)info.getSubjectID()-1).getSubjectName() %></td>
											<td class="syllabus_column5"><%= info.getTeacherName() %></td>
											<td class="syllabus_column6"><%= info.getOpeningSemester() %></td>
										</tr>
										<%
									}
								}
								%>
							</tbody>

							<!-- 複数件削除ダイアログ -->
							<div id="confirm_dialog_admin">
								<p>削除しますか？</p>
								<div class="confirm_dialog_button">
									<button type="submit" id="yes" class="button_flat_nega">削除</button>
									<button type="button" id="no" class="button_flat_normal">キャンセル</button>
								</div>
							</div>

							<!-- ソート機能 -->
						<script src="/tdu_market/js/list.min.js"></script>
						<script>
						var options = {
							valueNames: [ 'syllabus_column1', 'syllabus_column2', 'syllabus_column3', 'syllabus_column4','syllabus_column5', 'syllabus_column6' ]
						};
						var studentList = new List('syllabusList', options);
						studentList.sort( 'syllabus_column1', {order : 'asc'} );
						function sort_syllabusList(){
							sortIndex = document.sort_syllabus.sort_number.selectedIndex;
							switch (sortIndex) {
					        case 0:
					        	studentList.sort( 'syllabus_column1', {order : 'asc'} );
					          break;
					        case 1:
					        	studentList.sort( 'syllabus_column1', {order : 'desc'} );
					          break;
					        case 2:
					        	studentList.sort( 'syllabus_column2', {order : 'asc'} );
					          break;
					        case 3:
					        	studentList.sort( 'syllabus_column2', {order : 'desc'} );
					          break;
					        case 4:
					        	studentList.sort( 'syllabus_column3', {order : 'asc'} );
					          break;
					        case 5:
					        	studentList.sort( 'syllabus_column3', {order : 'desc'} );
					          break;
					        case 6:
					        	studentList.sort( 'syllabus_column4', {order : 'asc'} );
					          break;
					        case 7:
					        	studentList.sort( 'syllabus_column4', {order : 'desc'} );
					          break;
					        case 8:
					        	studentList.sort( 'syllabus_column5', {order : 'asc'} );
					          break;
					        case 9:
					        	studentList.sort( 'syllabus_column5', {order : 'desc'} );
					          break;
					        case 10:
						        	studentList.sort( 'syllabus_column6', {order : 'asc'} );
						       break;
						        case 11:
						        	studentList.sort( 'syllabus_column6', {order : 'desc'} );
						          break;
					      }
						}
						</script>

						</table>
						</form>

						<form name="select_syllabus" action="<%= ServletPath.ManagerReferSyllabusPage %>" method="get">
						</form>
						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".syllabusId").children(":not('th')").on("click",function() {
										//授業コードの取得
										var classCode = $(this).parent().children(".syllabus_column1")[0].innerText;
										//Input型エレメントの生成
										var element = document.createElement("input");
										//typeの設定
										element.setAttribute("type", "hidden");
										//nameの設定
										element.setAttribute("name","classCode");
										//valueの設定
										element.setAttribute("value",classCode);
										//取得したIDデータをsetattributeする
										document.select_syllabus.appendChild(element);
										//データをサーバーへ送信する
										document.select_syllabus.submit();
									});
						</script>
						<!-- テーブル要素クリックここまで -->
				</div>
			</div>
			<br />
			<div class="item_for_LeftAndRight_around">
				<!-- checkboxがどれか選択されている場合のみ反応 -->
				<button id="red_button" type="button">削除</button>
				<form action="<%= ServletPath.ManagerSearchSyllabusPage %>" method="get">
					<button class="search_button" type="submit">
						<img src="/tdu_market/images/search.png" />絞り込み
					</button>
				</form>
				<!-- 絞り込みボタン -->
				<div class="edit_and_add_button_box">
					<!-- <button id="blue_button" type="button">編集</button> -->
					<br />
					<form action="<%= ServletPath.RegisterSyllabusPage%>" method="post">
						<button id="blue_button" type="submit">登録</button>
					</form>
				</div>
			</div>
		</article>
		<section>
			<!--
		ダイアログ付与手順。
			1.該当するidをボタンに付与する。update, delete, back_button
			2.notify_dialog('表示したいメッセージ','遷移先url')
		-->
			<%-- <div id="confirm_dialog_admin">
				<p>削除しますか？</p>
				<div class="confirm_dialog_button">
					<form action="<%= ServletPath.DeleteSyllabusInfo %>" method="post">
						<button id="yes" class="button_flat_nega">確認</button>
					</form>
					<button id="no" class="button_flat_normal">キャンセル</button>
				</div>
			</div> --%>
			<div id="notify_dialog_admin">
				<p id="notify_text">確認ダイアログ</p>
				<div class="notify_dialog_button">
					<button id="ok" class="button_flat_normal">了解</button>
				</div>
			</div>
			<script type="text/javascript">
			<% if(DialogUtil.checkDisplayDialog(request, response)){ %>
				notify_dialog(<%=DialogUtil.getDialogMessage(request, response)%>);
			<% } %>

				document.getElementById("red_button").onclick = function() {
					//各ボタンの要素の取得
					let dialog = document.getElementById("confirm_dialog_admin");
					let yes = document.getElementById("yes");
					let no = document.getElementById("no");
					dialog.style.display = "block";

					yes.addEventListener("click", function() {
						dialog.style.display = "none";
						document.remove_form.submit();
					});
					no.addEventListener("click", function() {
						dialog.style.display = "none";
					});
				};
				function notify_dialog(text) {
					let dialog = document.getElementById("notify_dialog_admin");

					document.getElementById("notify_text").textContent = text;

					dialog.style.display = "block";
					ok.addEventListener("click", function() {
						<% DialogUtil.turnoffDialog(request, response); %>
						dialog.style.display = "none";
					});
				}
			</script>
		</section>
	</div>
</body>
</html>