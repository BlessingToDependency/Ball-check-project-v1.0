// JavaScript Document

/*客户端登录验证*/
function checkd() {

	var uname = document.getElementById("uname").value;
	var upwd = document.getElementById("upwd").value;
	if (uname == "" || uname == null || upwd == "" || upwd == null) {
		document.getElementById("hint").innerHTML = "提示：账号或密码不能为空！"
		return false;
	} else {
		document.getElementById("form1").submit();
	}

}

/* 后台的注册验证 */
function checkReg() {
	alert("进入函数");
	var userName = document.getElementById("userName").value;
/*	var password = document.getElementById("password").value;
	var repwd = document.getElementById("repwd").value;
	var phoneNum = document.getElementById("phoneNum").value;*/
	// var email = document.getElementById("email").value;
	//var parten = /^\s*$/; // 密码不能为空
	if (userName == "" || null==userName) {
		alert("账号不能为空")
		document.getElementById("hint").innerHTML = "提示：账号不能为空"
		return false;
	} /*else if (parten.test(password)) {

		document.getElementById("hint").innerHTML = "提示：密码不能为空格"
		return false;
	} else if (password.length <= 5) {
		document.getElementById("hint").innerHTML = "提示：密码长度有误"
		return false;
	} else if (password != repwd) {
		document.getElementById("hint").innerHTML = "提示：两次输入密码不一致"
		return false;
	} else if (userName == "" && userName == null && password == ""
			&& password == null) {
		document.getElementById("hint").innerHTML = "提示：账号或密码不能为空"
		return false;
	} else if (phoneNum.length != 11 || isNaN(phoneNum)) {
		document.getElementById("hint").innerHTML = "提示：手机号码填写有误"
		return false;
	} else {
		return true;
		// document.getElementById("form2").submit();
	}*/
}

/*
 * //服务端登录验证 function getCode(){ //得到图片对象 var image =
 * document.getElementById("imgCode"); image.src="ImageServlet?"+Math.random;
 * //alert(image.src);
 *  }
 */

/* 服务端登录验证 */
function serCheckd() {
	alert("验证码:");
	alert("验证码:" + validate());
	var uname = document.getElementById("userName").value;
	var upwd = document.getElementById("password").value;
	alert(validate())

	if (uname == "" || uname == null || upwd == "" || upwd == null) {
		document.getElementById("hint").innerHTML = "提示：账号或密码不能为空！"
		return false;
	} else if (validate() == 0) {
		document.getElementById("hint").innerHTML = "提示：验证码不能为空"
		return false;
	} else if (validate() == 1) {
		document.getElementById("hint").innerHTML = "提示：验证码输入错误"
		return false;
	} else {
		/* document.getElementById("form1").submit();8 */
		return true;
	}

}
/* 服务端验证码验证 */
window.onload = function() {
	createCode();
}

var code; // 在全局定义验证码 src="js/check.js"
function createCode() {
	code = "";
	var codeLength = 4; // 验证码长度
	var checkCode = document.getElementById("code");
	var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');// 随机码
	for (var i = 0; i < codeLength; i++) { // 循环操作
		var index = Math.floor(Math.random() * 36);// 根据索引取得随机数加到code上
		code += random[index]; // 根据索引取得随机数加到code上
	}
	checkCode.value = code; // 把code值赋给验证码
}

// 校验验证码
function validate() {
	var inputCode = document.getElementById("checkCode").value.toUpperCase();// 获取输入的验证码
	if (inputCode.length <= 0) { // 输入的验证码长度等于0的情况
		return 0;
	} else if (inputCode != code) { // 输入的验证码和产生的验证码不一致时
		createCode(); // 刷新验证码
		document.getElementById("checkCode").value = ""; // 清空验证码
		return 1; // 验证码输入错误
	}
}

/* 服务端登录验证 */
function serCheckd() {
	var uname = document.getElementById("userName").value;
	var upwd = document.getElementById("password").value;
	var result = validate();
	if (uname == "" || uname == null || upwd == "" || upwd == null) {
		document.getElementById("hint").innerHTML = "提示：账号或密码不能为空！"
		return false;
	} else if (result == 0) {
		document.getElementById("hint").innerHTML = "提示：验证码不能为空"
		return false;
	} else if (result == 1) {
		document.getElementById("hint").innerHTML = "提示：验证码输入错误"
		return false;
	} else {
		/* document.getElementById("form1").submit();8 */
		return true;
	}

}

/*
 * function validate(){ var inputCode =
 * document.getElementById("Yzm").value.toUpperCase(); //取得输入的验证码并转化为大写
 * if(inputCode.length <= 0) { //若输入的验证码长度为0 alert("请输入验证码！"); //则弹出请输入验证码
 * $("#Yzm").focus(); YZM = false; } else if(inputCode != code ) {
 * //若输入的验证码与产生的验证码不一致时 alert("验证码输入错误！@_@"); //则弹出验证码输入错误 createCode();//刷新验证码
 * $("#Yzm").val("");//清空文本框 $("#Yzm").focus();//重新聚焦验证码框 YZM = false; } else {
 * //输入正确时 $("#Yzm").blur();//绑定验证码输入正确时要做的事 YZM = true;
 *  } };
 */

/* 时间函数 */
var timer;
function start() {
	var t = new Date();
	var y = t.getFullYear();
	var mon = t.getMonth() + 1;
	var d = t.getDate();
	var h = check(t.getHours());
	var mi = check(t.getMinutes());
	var s = check(t.getSeconds());
	document.getElementById("time").innerHTML = y + "年" + mon + "月" + d + "日"
			+ h + ":" + mi + ":" + s;
	timer = setTimeout('start()', 1000);
}

function check(i) {
	if (i < 10) {
		i = "0" + i;
	}
	return i;
}
window.onload = function() {
	start();
}

/* 后台登录验证 */

/* 打印： console.log(str); */

/* 动态改变行数 */
var rowindex = 0;
function addRow() {

	rowindex++;
	var newrow = Table02.insertRow(Table02.rows.length);
	newrow.setAttribute("id", "row" + rowindex);

	var newcol = newrow.insertCell(0);
	newcol.innerHTML = "1";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(1);
	newcol.innerHTML = "3";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(2);
	newcol.innerHTML = "4";
	newcol.style = "center";

	var newcol = newrow.insertCell(3);
	newcol.innerHTML = "4";
	newcol.style = "center";

	var newcol = newrow.insertCell(4);
	newcol.innerHTML = "4";
	newcol.style = "center";

	var newcol = newrow.insertCell(5);
	newcol.innerHTML = "4";
	newcol.style = "center";
}

/* 动态改变行数 */
var rowindex1 = 0;
function addRow1() {

	rowindex1++;
	var newrow = Table02.insertRow(Table02.rows.length);
	newrow.setAttribute("id", "row" + rowindex1);

	var newcol = newrow.insertCell(0);
	newcol.innerHTML = "1";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(1);
	newcol.innerHTML = "3";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(2);
	newcol.innerHTML = "4";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(3);
	newcol.innerHTML = "4";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(4);
	newcol.innerHTML = "4";
	newcol.style.textAlign = "center";

	var newcol = newrow.insertCell(5);
	newcol.innerHTML = "<input type='button' value='删除' name='del" + rowindex1
			+ "' onclick=\"deleterow('row" + rowindex1
			+ "')\"> <input type='button' value='编辑' name='edit" + rowindex1
			+ "' onclick=\"editsrow('row" + rowindex1 + "')\">";
	/* newcol.style.textAlign="center"; */
}
// 建立一个函数delete_row用于删除一行
function deleterow(rname) {
	if (!Table02) {
		return;
	}
	var i;
	i = Table02.rows(rname).rowindex1;
	// alert(i);
	Table02.deleteRow(i);
}
function editsrow(num) {
	alert("进入函数");
	var i;
	i = Table02.rows(num).rowindex1;
	Table02.rows(i).cells(0).innerHTML = "<input type='text' name='names' value='1'  style='width:200px;'/> ";
	Table02.rows(i).cells(1).innerHTML = "<input type='text' name='nums'  	    value='3'style='width:30px;'/> ";
	Table02.rows(i).cells(2).innerHTML = "<input type='text' name='price' value='4'  style='width:70px;'/> ";
	Table02.rows(i).cells(2).innerHTML = "<input type='text' name='price' value='4'  style='width:70px;'/> ";
	Table02.rows(i).cells(2).innerHTML = "<input type='text' name='price' value='4'  style='width:70px;'/> ";
	Table02.rows(i).cells(2).innerHTML = "<input type='text' name='price' value='4'  style='width:70px;'/> ";

}
/* 树形结构 */
/*
 * function show(d1) { if (document.getElementById(d1).style.display == 'none') {
 * document.getElementById(d1).style.display = 'block'; // 触动的层如果处于隐藏状态，即显示 }
 * else { document.getElementById(d1).style.display = 'none'; //
 * 触动的层如果处于显示状态，即隐藏 } }
 */