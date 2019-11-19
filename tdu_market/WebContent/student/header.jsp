<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<!-- InstanceBegin template="/Templates/student_base.dwt" codeOutsideHTMLIsLocked="false" -->

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- InstanceBeginEditable name="title" -->
  <!-- <title>トップ画面</title> -->
  <!-- InstanceEndEditable -->
  <!-- Bootstrap -->
  <link href="../css/import_student.css" rel="stylesheet">
  <!-- InstanceBeginEditable name="scripts" -->
  <script type="text/javascript" src="../js/student.js" defer="defer"></script>
  <!-- InstanceEndEditable -->
</head>

<body>
  <!-- body code goes here -->
  <!-- ヘッダー -->
  <header>
    <div class="title_logo">
      <!-- ロゴ -->
      <h1> <a href="top.jsp"><img src="../images/student_logo.png" alt="ロゴ"></a> </h1>
    </div>
    <nav class="header_menu">
      <!-- メニュー -->
      <ul>
        <li><a href="search_from_exhibit.jsp">名前から検索</a></li>
        <li><a href="search_from_syllabus.jsp">シラバスから検索</a></li>
        <li><a href="message.jsp"><img src="../images/message.png" alt="メッセージアイコン"></a></li>
        <li><img src="../images/icon.png" alt="ユーザーアイコン" id="user_information_controller"></li>
      </ul>
    </nav>
  </header>
  <div class="user_control_window" id="hoge">
    <div class="user_info">
      <div class="left">
        <img src="../images/icon.png" alt="アイコン">
      </div>
      <div class="right">
        <h3>17FI999</h3>
        <h2>電大太郎</h2>
      </div>
    </div>
    <div class="another">
      <h2><a href="">出品物情報</a></h2>
      <h3><a href="">ユーザー情報設定</a></h3>
      <button id="logout_button">ログアウト</button>
    </div>
  </div>
  <script type="text/javascript" defer="defer">
    document.getElementById('user_information_controller').onclick = function () {
      let dialog = document.getElementById('hoge');
      let dialog_style = dialog.style.display;
      if (dialog.style.display == "none") {
        dialog.style.display = 'flex';
      } else {
        dialog.style.display = 'none';
      }
    }
  </script>

</body>
</html>