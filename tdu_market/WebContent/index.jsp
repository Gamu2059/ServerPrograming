<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/import_student.css" type="text/css">

<title>ログイン・新規登録画面</title>
<style id="applicationStylesheet" type="text/css">


* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	border: none;
}



#input_form {
	position: absolute;
	width: 670px;
	height: 160px;
	left: 625px;
	top: 540px;
	overflow: visible;
}

#address_form {
	position: absolute;
	width: 670px;
	height: 80px;
	left: 0px;
	top: 0px;
	overflow: visible;
}

.address_graph {
	position: absolute;
	overflow: visible;
	width: 670px;
	height: 80px;
	left: 0px;
	top: 0px;
}

#mailaddress {
	position: absolute;
	left: 10px;
	top: 15px;
	overflow: visible;
	width: 344px;
	white-space: nowrap;
	text-align: left;
	font-family: Meiryo;
	font-style: normal;
	font-weight: normal;
	font-size: 50px;
	color: rgba(232, 232, 232, 1);
}

#password_form {
	position: absolute;
	width: 670px;
	height: 80px;
	left: 0px;
	top: 80px;
	overflow: visible;
}

.password_graph {
	position: absolute;
	overflow: visible;
	width: 670px;
	height: 80px;
	left: 0px;
	top: 0px;
}

#password {
	position: absolute;
	left: 10px;
	top: 15px;
	overflow: visible;
	width: 249px;
	white-space: nowrap;
	text-align:;
	font-family: Meiryo;
	font-style: normal;
	font-weight: normal;
	font-size: 50px;
	color: rgba(232, 232, 232, 1);
}

#title {
	filter: blur(0px);
	position: absolute;
	left: 420px;
	top: 270px;
	overflow: visible;
	width: 1073px;
	white-space: nowrap;
	text-align: left;
	font-family: Iwata Antic Std;
	font-style: normal;
	font-weight: normal;
	font-size: 90px;
	color: rgba(0, 0, 0, 1);
}



#login_button {
	position: absolute;
	width: 386px;
	height: 81px;
	left: 767px;
	top: 765px;
	overflow: visible;
}

.login_graph {
	position: absolute;
	overflow: visible;
	width: 386px;
	height: 81px;
	left: 0px;
	top: 0px;
}

#login {
	position: absolute;
	left: 130px;
	top: 19px;
	overflow: visible;
	width: 118px;
	white-space: nowrap;
	text-align: left;
	font-family: Iwata Antic Std;
	font-style: normal;
	font-weight: normal;
	font-size: 30px;
	color: rgba(255, 255, 255, 1);
}


#crestre_account_button {
	position: absolute;
	width: 257px;
	height: 63px;
	left: 832px;
	top: 926px;
	overflow: visible;
}

.create_account_graph {
	position: absolute;
	overflow: visible;
	width: 257px;
	height: 63px;
	left: 0px;
	top: 0px;
}

#create_account {
	position: absolute;
	left: 58px;
	top: 12px;
	overflow: visible;
	width: 121px;
	white-space: nowrap;
	text-align: left;
	font-family: Iwata Antic Std;
	font-style: normal;
	font-weight: normal;
	font-size: 30px;
	color: rgba(255, 255, 255, 1);
}
button {
 font-size: 1.2em;
 font-weight: bold;
 background-color : transparent ;
    color: #fff;
    border-style: none;
}

input {
	font-size: 80%;
}
body {
  background-image: url("../image/univ1.png");
}
</style>

</head>
<body>

	<div id="title">
		<span>電大マーケットへようこそ</span>
	</div>
	<div>
		<img src="../image/student_logo.png" alt="logo">
	</div>

	<div id="input_form">
		<div id="address_form">
			<svg class="address_graph">
				<rect fill="rgba(255,255,255,1)" stroke="rgba(112,112,112,1)"
					stroke-width="1px" stroke-linejoin="miter" stroke-linecap="butt"
					stroke-miterlimit="4" shape-rendering="auto" id="address_graph"
					rx="0" ry="0" x="0" y="0" width="670" height="80">
				</rect>
			</svg>
				<%-- servlet記述部分1/ --%>
		<form action="Login" method="post">
			<div id="mailaddress">
				<span><input type="email" name="mailaddress" maxlength="23"
					value="" placeholder="xxxxxx@ms.dendai.ac.jp"></span>
			</div>
		</div>
		<div id="password_form">
			<svg class="password_graph">
				<rect fill="rgba(255,255,255,1)" stroke="rgba(112,112,112,1)"
					stroke-width="1px" stroke-linejoin="miter" stroke-linecap="butt"
					stroke-miterlimit="4" shape-rendering="auto" id="password_graph"
					rx="0" ry="0" x="0" y="0" width="670" height="80">
				</rect>
			</svg>
			<div id="password">
				<span> <input type="password" name="password" value=""
					maxlength="16" placeholder="パスワード"></span>
			</div>
		</div>
	</div>


	<div id="login_button">
		<svg class="login_graph">
			<rect fill="rgba(81,171,255,1)" stroke="rgba(112,112,112,1)"
				stroke-width="1px" stroke-linejoin="miter" stroke-linecap="butt"
				stroke-miterlimit="4" shape-rendering="auto" id="login_graph"
				rx="40.5" ry="40.5" x="0" y="0" width="386" height="81">
			</rect>
		</svg>
		<div id="login">
	
			<span> <button type="submit" name="name" value="value">ログイン</button></span>
		</form>
		</div>
		
	</div>

	<div id="crestre_account_button">
		<svg class="create_account_graph">
			<rect fill="rgba(81,171,255,1)" stroke="rgba(112,112,112,1)"
				stroke-width="1px" stroke-linejoin="miter" stroke-linecap="butt"
				stroke-miterlimit="4" shape-rendering="auto"
				id="create_account_graph" rx="31.5" ry="31.5" x="0" y="0"
				width="257" height="63">
			</rect>
		</svg>
		<div id="create_account">
			<span><button type="submit" name="name" value="value">新規登録</button></span>
		</div>
	</div>

</body>
</html>
</html>