/**
 *
 */

window.onload = function() {
	selectUserOperationCategory();
	operationAfterDisplayScreen();
	document.getElementById("userOperation").onchange = selectUserOperationCategory;
	document.getElementById("registerbutton").onclick = function() { userInputCheck(); };
}

function selectUserOperationCategory() {
	var subList = ["ユーザー登録", "ユーザーロック"];
	var i = document.getElementById("userOperation").value;
	if (subList[i] == subList[0]) {
		document.getElementById("register").className = "active";
		document.getElementById("rock").className = "passive";
	} else {
		document.getElementById("register").className = "passive";
		document.getElementById("rock").className = "active";
	}

}

function operationAfterDisplayScreen() {
	if (document.getElementById("registerResultMessage")!=null) {
		document.getElementById("userOperation").options[0].selected=true;
        document.getElementById("register").className = "active";
		document.getElementById("rock").className = "passive";
	} else if (document.getElementById("rockResultMessage") != null || document.getElementById("rockReleaseResultMessage")!= null){
		document.getElementById("userOperation").options[1].selected=true;
		document.getElementById("register").className = "passive";
		document.getElementById("rock").className = "active";
	}
}

function userInputCheck() {
	if (document.registerFrml.userID.value == "" || document.registerFrml.password.value == "") {
		alert("ユーザーIDもしくはパスワードが未設定です。")
	} else {
		document.registerFrml.submit();
	}

}
