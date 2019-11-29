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
  <title>トップ画面</title>
  <!-- InstanceEndEditable -->
  <!-- Bootstrap -->
  <link href="/tdu_market/css/import_student.css" rel="stylesheet">
  <!-- InstanceBeginEditable name="scripts" -->
  <script type="text/javascript" src="/tdu_market/js/student.js" defer="defer"></script>
  <!-- InstanceEndEditable -->
</head>

<body>
  <footer>
    <div class="sitemap">
      <h3>サイトマップ</h3>
    </div>
    <nav class="footer_menu">
      <div>
        <ul>

          <li><a href=<%=ServletPath.ReferStudentPage%>>ユーザー情報</a></li>
           <li><form action=<%=ServletPath.ReferExhibitItemPage %> method="post">
          <button type="submit">
          <a>出品物情報登録</a></li></button></form>
        </ul>
      </div>
      <div>
        <ul>
          <li><form action="<%=ServletPath.ReferItemListPage%>" method="post">
          <input type="hidden" name="oldestDate " value="">
          <input type="hidden" name="itemNameKeyword " value="">
          <input type="hidden" name="condtion " value="">
          <input type="hidden" name="maxPrice " value="">
          <button type="submit">
          <a>商品情報</a></button></form></li>

          <li><form action="<%=ServletPath.SearchItemPage%>" method="get">
          <button type="submit">
          <a>商品検索</a></button></form></li>
          </ul></div>

      <div>
      <form action="<%=ServletPath.SearchSyllabusPage%>" method="get">
      <button type="submit">
      <a>シラバス検索</a></button></form></div>

      <div>
      <form action="<%=ServletPath.ReferMessageBoxListPage%>" method="post">
      <button type="submit">
      <a>メッセージ一覧</a></button></form></div>
    </nav>
    <div class="team_name"> 東京電機大学 千住キャンパス 未来科学部 情報メディア学科<br>
      Team.YAMAGAMI </div>
  </footer>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="/tdu_market/js/jquery-3.3.1.min.js"></script>

  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="/tdu_market/js/popper.min.js"></script>
  <script src="/tdu_market/js/bootstrap-4.3.1.js"></script>
</body>
<!-- InstanceEnd -->
</html>