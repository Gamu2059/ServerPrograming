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
					<br />
					<form name="select_syllabus">
						<table class="syllabus_list">
							<!-- テーブルタイトル -->
							<thead>
								<tr>
									<th hidden>授業コード</th>
									<th id="syllabus_column1">授業名</th>
									<th id="syllabus_column2">曜日時限</th>
									<th id="syllabus_column3">担当教員</th>
								</tr>
							</thead>
							<tbody>
								<tr class="syllabusId">
									<td hidden>0000000000000</td>
									<td id="syllabus_column1">コンピュータープログラミング</td>
									<td id="syllabus_column2">水3</td>
									<td id="syllabus_column3">電大太郎</td>
								</tr>
							</tbody>
						</table>
						<!-- テーブル要素クリック -->
						<script type="text/javascript"
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
						<script type="text/javascript">
							$(".syllabusId").on(
									"click",
									function() {
										//授業コードの取得
										var syllabusCode = $(this).children(
												"td")[0].innerText;
										//Input型エレメントの生成
										var element = document
												.createElement("input");
										//typeの設定
										element.setAttribute("type", "submit");
										//nameの設定
										element.setAttribute("name",
												"selectSyllabus");
										//valueの設定
										element.setAttribute("value",
												syllabusCode);
										//取得したIDデータをsetattributeする
										document.select_syllabus
												.appendChild(element);
										//データをサーバーへ送信する
										document.select_syllabus.submit();
									});
						</script>
						<!-- テーブル要素クリックここまで -->
					</form>
				</section>
			</div>
			<!-- サードコンテナ -->
		</article>
	</div>
	<!-- InstanceEndEditable -->
	<%@ include file="footer.jsp"%>
</body>
</html>