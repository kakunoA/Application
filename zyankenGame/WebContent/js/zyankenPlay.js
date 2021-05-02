/**
 *
 */
var total;
var win;
var lose;
var draw;
var winStr = "あなた：かち";
var loseStr = "あなた：まけ";
var drawStr = "あいこ";
var selfVictoryStr = "YOU WIN";
var selfLoseStr = "YOU LOSE"

var selfJankenObj = [{ hand: "guu", img: "../zyankenGame/images/self/guu.jpg" }, { hand: "choki", img: "../zyankenGame/images/self/tyoki.jpg" }, { hand: "paa", img: "../zyankenGame/images/self/paa.jpg" }];
var opponentJankenObj = [{ hand: "guu", img: "../zyankenGame/images/opponent/guu.jpg" }, { hand: "choki", img: "../zyankenGame/images/opponent/tyoki.jpg" }, { hand: "paa", img: "../zyankenGame/images/opponent/paa.jpg" }];

window.onload = function() {
	init();
	document.getElementById("handSubmit").onclick = function() { zankenContena(document.zyankenfrml.hand); }
	document.getElementById("retry").onclick = function() { init(); }
	document.getElementById("send").onclick = function() { sendResult(); }

}

function init() {
	total = 0;
	win = 0;
	lose = 0;
	draw = 0;
	document.getElementById("midwayGrade").innerHTML = zyankenScore(total, win, draw, lose);
	document.getElementById("winOrLose").innerHTML = "";
	document.getElementById("winOrLose").className = "";
	document.getElementById("handSubmit").disabled = false;
	document.getElementById("imageHand").innerHTML = ""
	document.getElementById("retry").disabled = true;
	document.getElementById("send").disabled = true;
}

function judge(zibun, aite) {
	var result = 0;
	if ((zibun == "guu") && (aite == "choki") || (zibun == "choki") && (aite == "paa") || (zibun == "paa") && (aite == "guu")) {
		result = 1;
	} else if (zibun == aite) {
		result = 2;
	} else {
		result = 3;
	}
	return result;
}

function zyankenScore(total, win, draw, lose) {
	return total + "戦" + win + "勝" + lose + "敗" + draw + "分け";
}

function zankenContena(handList) {
	var selfHand = handList[0].value;
	for (var i = 0; i < handList.length; i++) {
		if (handList[i].checked) {
			selfHand = handList[i].value;
			break;
		}
	}
	var opponentHand = handList[Math.floor(Math.random() * 3)].value;
	var selfHandImg, opponentHandImg;
	for (var i = 0; i < selfJankenObj.length; i++) {
		if (selfHand == selfJankenObj[i]["hand"]) {
			selfHandImg = selfJankenObj[i]["img"];
			break;
		}
	}
	for (var i = 0; i < opponentJankenObj.length; i++) {
		if (opponentHand == opponentJankenObj[i]["hand"]) {
			opponentHandImg = opponentJankenObj[i]["img"];
			break;
		}
	}

	document.getElementById("imageHand").innerHTML = "<img src=" + selfHandImg + "><b id=" + "'vsStr'" + ">VS</b><img src=" + opponentHandImg + ">";
	var gameFlag = judge(selfHand, opponentHand);
	total += 1;
	if (gameFlag == 1) {
		document.getElementById("winOrLose").innerHTML = winStr;
		win += 1;
	} else if (gameFlag == 2) {
		document.getElementById("winOrLose").innerHTML = drawStr;
		draw += 1;
	} else {
		document.getElementById("winOrLose").innerHTML = loseStr;
		lose += 1;
	}

	document.getElementById("midwayGrade").innerHTML = zyankenScore(total, win, draw, lose);
	if (win == 5 || lose == 5) {
		document.getElementById("handSubmit").disabled = true;
		document.getElementById("retry").disabled = false;
	}
	if (win == 5) {
		document.getElementById("winOrLose").innerHTML = selfVictoryStr;
		document.getElementById("winOrLose").className = "winsign";
		document.getElementById("send").disabled = false;
	} else if (lose == 5) {
		document.getElementById("winOrLose").innerHTML = selfLoseStr;
		document.getElementById("winOrLose").className = "losesign";
	}

}

function sendResult() {
	document.resultSend.total.value=total
	document.resultSend.submit();
}

