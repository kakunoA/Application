/**
 *
 */

window.onload = function() {

	document.getElementById("update").onclick = function() { passwordCheck(); }
}


function passwordCheck() {
	var brankErrorMessage = "";
	var contentErrorMessage = "";
	if (document.updateFrml.userID.value == "") {
		brankErrorMessage += "ユーザーID";
	}
	if (document.updateFrml.nowpass.value == "") {
		if (brankErrorMessage != "") {
			brankErrorMessage += "・";
		}
		brankErrorMessage += "現在のパスワード";
	}
	if (document.updateFrml.newpass.value == "") {
		if (brankErrorMessage != "") {
			brankErrorMessage += "・";
		}
		brankErrorMessage += "新しいパスワード";

	}
	if (document.updateFrml.remindpass.value == "") {
		if (brankErrorMessage != "") {
			brankErrorMessage += "・";
		}
		brankErrorMessage += "再確認用パスワード";
	}

	if (brankErrorMessage != "") {
		brankErrorMessage += "が未設定です。";
		alert(brankErrorMessage);
	} else if (document.updateFrml.nowpass.value == document.updateFrml.newpass.value || document.updateFrml.newpass.value != document.updateFrml.remindpass.value) {
		if (document.updateFrml.nowpass.value == document.updateFrml.newpass.value) {
			contentErrorMessage += "現在のパスワードと新しいパスワードが同じです。";
		}
		if (document.updateFrml.newpass.value != document.updateFrml.remindpass.value) {
			if (contentErrorMessage != "") {
				contentErrorMessage += "\r\n";
			}
			contentErrorMessage += "新しいパスワードと再確認パスワードが異なります。";
		}
		if (contentErrorMessage != "") {
			alert(contentErrorMessage);
		}
	} else if (document.updateFrml.userID.value == "Z11101") {
		alert("管理者ユーザーのパスワードは変更できません。");
	} else {
		document.updateFrml.submit();
	}
}

