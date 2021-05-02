/**
 *
 */
window.onload = function() {
	document.getElementById("login").onclick = function() { loginCheck(); }
}

function loginCheck() {

	if (document.loginFrml.userID.value == "" && document.loginFrml.pass.value == "") {
		alert("ユーザーIDとパスワードが未入力です。");
	} else if (document.loginFrml.userID.value == "") {
		alert("ユーザーIDが未入力です。");
	} else if (document.loginFrml.pass.value == "") {
		alert("パスワードが未入力です。");
	} else {
		document.loginFrml.submit();
	}
}

