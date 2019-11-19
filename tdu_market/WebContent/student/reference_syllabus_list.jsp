<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- InstanceBeginEditable name="title" -->
<title>検索結果</title>
<!-- InstanceEndEditable -->
<!-- Bootstrap -->
<link href="../css/import_student.css" rel="stylesheet">
<!-- InstanceBeginEditable name="scripts" -->
<script type="text/javascript" src="../js/student.js" defer="defer"></script>
<!-- InstanceEndEditable -->
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- InstanceBeginEditable name="body" -->
	<div class="scroll">
		<article class="content">
			<!-- ファーストコンテナ -->
			<!-- セカンドコンテナ -->
			<div class="second_container_ver2">
				<section>
					<h2>検索結果</h2>
					<br>
					<table class="syllabus_list">
						<!-- テーブルタイトル -->
						<thead>
							<tr>
								<th id="syllabus_column1">授業名</th>
								<th id="syllabus_column2">曜日時限</th>
								<th id="syllabus_column3">担当教員</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="syllabus_column1"><button
										id="syllabus_column_button">コンピュータープログラミング</button></td>
								<td id="syllabus_column2"><button
										id="syllabus_column_button">水3</button></td>
								<td id="syllabus_column3"><button
										id="syllabus_column_button">電大太郎</button></td>
							</tr>
							<tr>
								<td id="syllabus_column1"><button
										id="syllabus_column_button">コンピュータープログラミング</button></td>
								<td id="syllabus_column2"><button
										id="syllabus_column_button">水3</button></td>
								<td id="syllabus_column3"><button
										id="syllabus_column_button">電大太郎</button></td>
							</tr>
							<tr>
								<td id="syllabus_column1"><button
										id="syllabus_column_button">コンピュータープログラミング</button></td>
								<td id="syllabus_column2"><button
										id="syllabus_column_button">水3</button></td>
								<td id="syllabus_column3"><button
										id="syllabus_column_button">電大太郎</button></td>
							</tr>
						</tbody>
					</table>
				</section>
			</div>
			<!-- サードコンテナ -->
		</article>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>