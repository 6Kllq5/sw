function b() {
	document.getElementById("li2").style.background = "url(img/libg.png)";
	document.getElementById("wenzi2").style.color = "#FFFFFF";
	document.getElementById("jiantou2").src = "img/yuan.png";

	document.getElementById("li1").style.background = "none";
	document.getElementById("wenzi1").style.color = "#000";
	document.getElementById("jiantou1").src = "img/hz.png";

	document.getElementById("li3").style.background = "none";
	document.getElementById("wenzi3").style.color = "#000";
	document.getElementById("jiantou3").src = "img/hz.png";
	if(document.getElementById("xiabian1").style.display == "none") {
		document.getElementById("xiabian1").style.display = "block";

	} else {
		document.getElementById("xiabian1").style.display = "none";
	}
}

function a() {
	document.getElementById("li1").style.background = "url(img/libg.png)";
	document.getElementById("wenzi1").style.color = "#FFFFFF";
	document.getElementById("jiantou1").src = "img/yuan.png";
	if(document.getElementById("xiabian").style.display == "none") {
		document.getElementById("xiabian").style.display = "block";

	} else {
		document.getElementById("xiabian").style.display = "none";
	}

	document.getElementById("li2").style.background = "none";
	document.getElementById("wenzi2").style.color = "#000";
	document.getElementById("jiantou2").src = "img/hz.png";

	document.getElementById("li3").style.background = "none";
	document.getElementById("wenzi3").style.color = "#000";
	document.getElementById("jiantou3").src = "img/hz.png";
}

function c() {
	document.getElementById("li3").style.background = "url(img/libg.png)";
	document.getElementById("wenzi3").style.color = "#FFFFFF";
	document.getElementById("jiantou3").src = "img/yuan.png";
	if(document.getElementById("xiabian2").style.display == "none") {
		document.getElementById("xiabian2").style.display = "block";

	} else {
		document.getElementById("xiabian2").style.display = "none";
	}

	document.getElementById("li1").style.background = "none";
	document.getElementById("wenzi1").style.color = "#000";
	document.getElementById("jiantou1").src = "img/hz.png";

	document.getElementById("li2").style.background = "none";
	document.getElementById("wenzi2").style.color = "#000";
	document.getElementById("jiantou2").src = "img/hz.png";

}

function m1() {
	document.getElementById("wenzi1").style.color = "#55ecb9";

}

function m2() {
	document.getElementById("wenzi2").style.color = "#55ecb9";
}

function m3() {
	document.getElementById("wenzi3").style.color = "#55ecb9";
}