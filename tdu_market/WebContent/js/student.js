// JavaScript Document

//function toHoge(String str){
//	location.href = str;
//}


//const logout = document.getElementById('logout');
//const exhibit_check = document.getElementById('exhibit_check');//出品、更新、削除は簡略化。
//const update_exhibit = document.getElementById('update_exhibit'); //更新
//const delete_exhibit = document.getElementById('delete_exhibit'); //削除
//const buy_item = document.getElementById('buy_item');
//const complete_trading = document.getElementById('complete_trading');
//const complete_trading_res = document.getElementById('complete_trading_res');



/*
var idlist = [];
idlist.push(update_exhibit);
idlist.push(delete_exhibit);

//logout.addEventListener('click', function(){
//	var logout_now = window.confirm('どうしますか');
//	if(logout_now){
//		location.href='index.html';
//		window.alert('はい');
//	}
//})

//'出品','更新','削除'
const dolist = ['更新', '削除'];
for (let i = 0; i < dolist.length; i++) {
  if (idlist[i] == null) {//nullが格納されていた場合は次へ
    continue;
  }
  idlist[i].addEventListener('click', function () {
    simple_dialog(dolist[i]);
  });
}


buy_item.addEventListener('click', function () {
  var buy = window.confirm('取引を申し込みますか？');
  if (buy) {
    window.alert('取引を申し込みました。\n相手からの連絡をお待ちください。')
  }
})

//complete_trading.addEventListener('click',function(){
//	var cmp_mes = window.confirm('完了報告を行いますか？ \n（この取引は双方の同意を持って完了します。）');
//	if(cmp_mes){
//		window.alert('完了報告を行いました。\n相手からの同意を待っています。');
//	}
//})
//complete_trading_res.addEventListener('click',function(){
//	var response = window.confirm('相手が完了報告を行いました。\n同意してもよろしいですか？');
//	if(response){
//		window.alert('取引が完了しました。\nまたのご利用をお待ちしております。');
//	}
//})
*/





//これ以下は残骸
/*
function dialog_ttt(id) {
  //各ボタンの要素の取得
  let dialog = document.getElementById(id);//引数はシングルクオートで加工
  let text = document.getElementById('confirm_text');
  let btn = document.getElementById('btn');
  let yes = document.getElementById('yes');
  let no = document.getElementById('no');

  dialog.style.display = 'block';

  yes.addEventListener('click', function () {
    console.log('yesdekita')
    dialog.style.display = 'none';
    notify_dialog();
  });
  no.addEventListener('click', function () {
    console.log('no')
    dialog.style.display = 'none';

  });
}

function confirm_dialog() {
  //各ボタンの要素の取得
  let dialog = document.getElementById('confirm_dialog');
  let text = document.getElementById('confirm_text');
  let btn = document.getElementById('btn');
  let yes = document.getElementById('yes');
  let no = document.getElementById('no');

  dialog.style.display = 'block';

  yes.addEventListener('click', function () {
    console.log('yes')
    dialog.style.display = 'none';
    notify_dialog();
  });
  no.addEventListener('click', function () {
    console.log('no')
    dialog.style.display = 'none';

  });
}

function negative_dialog() {
  //各ボタンの要素の取得
  let dialog = document.getElementById('negative_dialog');
  let text = document.getElementById('confirm_text');
  let btn = document.getElementById('btn');
  let yes = document.getElementById('nega_yes');
  let no = document.getElementById('nega_no');

  dialog.style.display = 'block';

  yes.addEventListener('click', function () {
    console.log('yes')
    dialog.style.display = 'none';
    notify_dialog();
  });
  no.addEventListener('click', function () {
    console.log('no')
    dialog.style.display = 'none';

  });
}

function notify_dialog() {
  let dialog = document.getElementById('notify_dialog');
  let btn = document.getElementById('btn');
  let ok = document.getElementById('ok');

  dialog.style.display = 'block';
  ok.addEventListener('click', function () {
	//ここに、遷移する記述をいれる。引数でうまく渡せないかなぁ。シングルクオートで渡せる。
	//location.href='index.html';
    dialog.style.display = 'none';
  });
}



function logout() {
  var a = window.confirm("ログアウトしますか？");
  if (a) {
    location.href = 'message.html';
  }
}

function logout_message() {
  window.alert("ログアウトしました。");
}

function exhibit_confirm() {
  window.confirm("出品完了");
}

*/
