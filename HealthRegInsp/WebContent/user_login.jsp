<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>	
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>登录</title>


<script src="<%=path%>js/jquery.min.js"></script>
<script src="<%=path%>js/snow.js"></script>
<script src="<%=path%>js/jquery.pure.tooltips.js"></script>
<script src="<%=path%>js/spop.min.js"></script>

<link rel="stylesheet" href="<%=path%>css/normalize.css">
<link rel="stylesheet" href="<%=path%>css/login.css">
<link rel="stylesheet" href="<%=path%>css/sign-up-login.css">
<link rel="stylesheet" type="text/css" href="<%=path%>css/font-awesome.min.css">
<link rel="stylesheet" href="<%=path%>css/inputEffect.css" />
<link rel="stylesheet" href="<%=path%>css/tooltips.css" />
<link rel="stylesheet" href="<%=path%>css/spop.min.css" />





<script>	
	(function() {
		// trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
		if (!String.prototype.trim) {
			(function() {
				// Make sure we trim BOM and NBSP
				var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
				String.prototype.trim = function() {
					return this.replace(rtrim, '');
				};
			})();
		}

		[].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
			// in case the input is already filled..
			if( inputEl.value.trim() !== '' ) {
				classie.add( inputEl.parentNode, 'input--filled' );
			}

			// events:
			inputEl.addEventListener( 'focus', onInputFocus );
			inputEl.addEventListener( 'blur', onInputBlur );
		} );

		function onInputFocus( ev ) {
			classie.add( ev.target.parentNode, 'input--filled' );
		}

		function onInputBlur( ev ) {
			if( ev.target.value.trim() === '' ) {
				classie.remove( ev.target.parentNode, 'input--filled' );
			}
		}
	})();
	
	$(function() {	
		$('#login #login-password').focus(function() {
			$('.login-owl').addClass('password');
		}).blur(function() {
			$('.login-owl').removeClass('password');
		});
		$('#login #register-password').focus(function() {
			$('.register-owl').addClass('password');
		}).blur(function() {
			$('.register-owl').removeClass('password');
		});
		$('#login #register-repassword').focus(function() {
			$('.register-owl').addClass('password');
		}).blur(function() {
			$('.register-owl').removeClass('password');
		});
		$('#login #forget-password').focus(function() {
			$('.forget-owl').addClass('password');
		}).blur(function() {
			$('.forget-owl').removeClass('password');
		});
	});
	
	function goto_register(){
		$("#register-username").val("");
		$("#register-password").val("");
		$("#register-repassword").val("");
		$("#register-code").val("");
		$("#tab-2").prop("checked",true);
	}
	
	function goto_login(){
		$("#login-username").val("");
		$("#login-password").val("");
		$("#tab-1").prop("checked",true);
	}
	
	function goto_forget(){
		$("#forget-username").val("");
		$("#forget-password").val("");
		$("#forget-code").val("");
		$("#tab-3").prop("checked",true);
	}
	
	function login(){//登录
		var username = $("#login-username").val(),
			password = $("#login-password").val(),
			validatecode = null,
			flag = false;
		//判断用户名密码是否为空
		if(username == ""){
			$.pt({
        		target: $("#login-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"用户名不能为空"
        	});
			flag = true;
		}
		if(password == ""){
			$.pt({
        		target: $("#login-password"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码不能为空"
        	});
			flag = true;
		}
		
		
	}
	
	var flag = false;
	//注册
	function register(){
		var company = $("#company").val(),
			pwd = $("#pwd").val(),
			pwd2 = $("#pwd2").val(),
			address = $("#address").val(),
			contacts = $("#contacts").val(),
			phone = $("#phone").val(),
			busNum = $("#busNum").val(),
			
			
			validatecode = null;
		
		
		upperCaseReg()
		//判断用户名密码是否为空
		if(company == ""){
			$.pt({
        		target: $("#company"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"用户名不能为空"
        	});
			flag = true;
		}
		
		if(pwd.length<6){
			$.pt({
        		target: $("#pwd"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码长度不能小于6位"
        	});
			flag = true;
		}
		if(pwd == ""){
			$.pt({
        		target: $("#pwd"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码不能为空"
        	});
			flag = true;
		}
		if(pwd2 == ""){
			$.pt({
        		target: $("#pwd2"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码不能为空"
        	});
			flag = true;
		}else{
			if(pwd2 != pwd){
				$.pt({
	        		target: $("#pwd"),
	        		position: 'r',
	        		align: 't',
	        		width: 'auto',
	        		height: 'auto',
	        		content:"两次输入的密码不一致"
	        	});
				flag = true;
			}
		}
		if(address == ""){
			$.pt({
        		target: $("#address"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"地址不能为空"
        	});
			flag = true;
		}
		if(contacts == ""){
			$.pt({
        		target: $("#contacts"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"联系人不能为空"
        	});
			flag = true;
		}
		if(phone == ""){
			$.pt({
        		target: $("#phone"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"手机号不能为空"
        	});
			flag = true;
		}
		
		if(!(/^1[34578]\d{9}$/.test(phone))){
			$.pt({
        		target: $("#phone"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"请输入正确手机号"
        	});
			flag = true;
		}
		
		if(busNum == ""){
			$.pt({
        		target: $("#busNum"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"工商号不能为空"
        	});
			flag = true;
		}
		//用户名只能是15位以下的字母或数字
	
		//检查用户名是否已经存在
		//调后台代码检查用户名是否已经被注册
		
		
		if(flag){
			return false;
		}else{//注册
			spop({			
				template: '<h4 class="spop-title">注册成功</h4>即将于3秒后返回登录',
				position: 'top-center',
				style: 'success',
				autoclose: 3000,
				onOpen : function(){
					var second = 2;
					var showPop = setInterval(function(){
						if(second == 0){
							clearInterval(showPop);
						}
						$('.spop-body').html('<h4 class="spop-title">注册成功</h4>即将于'+second+'秒后返回登录');
						second--;
					},1000);
				},
				onClose : function(){
					goto_login();
				}
			});
			return true;
		}
	}
	
	var flag = false;
	//重置密码
	function forget(){
		var username = $("#forget-username").val(),
			password = $("#forget-password").val(),
			code = $("#forget-code").val(),
			
			validatecode = null;
		//判断用户名密码是否为空
		if(username == ""){
			$.pt({
        		target: $("#forget-username"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"用户名不能为空"
        	});
			flag = true;
		}
		if(password == ""){
			$.pt({
        		target: $("#forget-password"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"密码不能为空"
        	});
			flag = true;
		}
		if(code == ""){
			$.pt({
        		target: $("#forget-code"),
        		position: 'r',
        		align: 't',
        		width: 'auto',
        		height: 'auto',
        		content:"工商号不能为空"
        	});
			flag = true;
		}
	
		//检查用户名是否存在
		//调后台方法
		
		
	 if(flag){
			return false;
		}else{//重置密码
			spop({			
				template: '<h4 class="spop-title">重置密码成功</h4>即将于3秒后返回登录',
				position: 'top-center',
				style: 'success',
				autoclose: 3000,
				onOpen : function(){
					var second = 2;
					var showPop = setInterval(function(){
						if(second == 0){
							clearInterval(showPop);
						}
						$('.spop-body').html('<h4 class="spop-title">重置密码成功</h4>即将于'+second+'秒后返回登录');
						second--;
						},1000);
				},
				onClose : function(){
					goto_login();
				}
			});
			return false;
		} 
	}
	
	
	/* 重置密码查重 */
	function upperCase(){
	$.ajax({
		url:"<%=path %>userLoginAction/userRepeat.action",
		data:"company="+$("#forget-username").val(),
		dataType:"text",
		type:"POST",
		success : function(str){
			if(str==2){
				alert("该账号不存在,请重新输入");
				flag = true;
				return false;
			}
		}
	});
	
	}
	/* 注册查重 */
	function upperCaseReg(){
		$.ajax({
			url:"<%=path %>userLoginAction/userRepeat.action",
			data:"company="+$("#company").val(),
			dataType:"text",
			type:"POST",
			success : function(str){
				if(str==1){
					alert("该账号已存在,请重新输入");
					flag = true;
					return false;
				}
			}
		});
		}
	
	$(function(){
		var msg = "${requestScope.get('msg')}";
		if(msg.length > 0){
			console.log(msg);
			alert(msg);
		}
		
	}) 
	
	$(function(){
		var msg = "${requestScope.get('login')}";
		if(msg.length > 0){
			console.log(msg);
			alert(msg);
		}
		
	}) 
	function getCode(){
			//得到图片对象
			var image =document.getElementById("imgCode")
			image.src = "<%=path %>userLoginAction/imageCode.action?"+Math.random();
		}
	
</script>
<style type="text/css">
html{width: 100%; height: 100%;}

body{

	background-repeat: no-repeat;

	background-position: center center #2D0F0F;

	background-color: #00BDDC;

	background-image: url(<%=path%>images/snow.jpg);

	background-size: 100% 100%;

}

.snow-container { position: fixed; top: 0; left: 0; width: 100%; height: 100%; pointer-events: none; z-index: 100001; }

</style>
</head>
<body>
<!-- 测试文件-->
	<!-- 雪花背景 -->
	<div class="snow-container"></div>
	<!-- 登录控件 -->
	<div id="login">
		<input id="tab-1" type="radio" name="tab" class="sign-in hidden" checked />
		<input id="tab-2" type="radio" name="tab" class="sign-up hidden" />
		<input id="tab-3" type="radio" name="tab" class="sign-out hidden" />
		<div class="wrapper">
			<!-- 登录页面 -->
			<div class="login sign-in-htm">
				<form method="post" class="container offset1 loginform" action="<%=path%>userLoginAction/userLogin.action">
					<!-- 猫头鹰控件 -->
					<div id="owl-login" class="login-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="login-username" name="login_username"
									autocomplete="off" placeholder="请输入公司名" tabindex="1" maxlength="15" />
								<label class="input__label input__label--hideo" for="login-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="login-password" name="login_password" placeholder="请输入密码" tabindex="2" maxlength="15"/>
								<label class="input__label input__label--hideo" for="login-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							
							<span class="input input--hideo">
							<img src="<%=path %>userLoginAction/imageCode.action" id="imgCode" onClick="getCode()" />
							</span>
							
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="imageCode" name="imageCode" placeholder="请输入验证码" tabindex="2" maxlength="15"/>
								<label class="input__label input__label--hideo" for="login-username">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a tabindex="4" class="btn pull-left btn-link text-muted" onClick="goto_forget()">忘记密码?</a>
						<a tabindex="5" class="btn btn-link text-muted" onClick="goto_register()">注册</a>
						<input class="btn btn-primary" type="submit" tabindex="3" onClick="login()" value="登录" 
							style="color:white;"/>
					</div>
				</form>
			</div>
			<!-- 忘记密码页面 -->
			<div class="login sign-out-htm">
				<form onSubmit="return upperCase()" action="<%=path %>userLoginAction/resetPwd.action" onsubmit="return forget()" method="post" class="container offset1 loginform">
					<!-- 猫头鹰控件 -->
					<div id="owl-login" class="forget-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget-username" name="companyNick" autocomplete="off" onblur="upperCase()" placeholder="请输入公司名"/>
								<label class="input__label input__label--hideo" for="forget-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="forget-code" name="industryNum" autocomplete="off" placeholder="请输入工商号"/>
								<label class="input__label input__label--hideo" for="forget-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="forget-password" name="passWord" placeholder="请重新输入密码" />
								<label class="input__label input__label--hideo" for="forget-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a class="btn pull-left btn-link text-muted" onClick="goto_login()">返回登录</a>
						<input class="btn btn-primary" type="submit" onClick="forget()" value="重置密码" 
							style="color:white;"/>
					</div>
				</form>
			</div>
			<!-- 注册页面 -->
			<div class="login sign-up-htm">
				<form onSubmit="return upperCaseReg()" action="<%=path %>userLoginAction/userRegister.action" method="post" class="container offset1 loginform" id="regP">
					<!-- 猫头鹰控件 -->
					<div id="owl-login" class="register-owl">
						<div class="hand"></div>
						<div class="hand hand-r"></div>
						<div class="arms">
							<div class="arm"></div>
							<div class="arm arm-r"></div>
						</div>
					</div>
					<div class="pad input-container">
						<section class="content">
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="company" name="company"
								onblur ="upperCaseReg()"	autocomplete="off" placeholder="请输入公司名" maxlength="50"/>
								<label class="input__label input__label--hideo" for="register-username">
									<i class="fa fa-fw fa-user icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="pwd" name="pwd" placeholder="请输入密码" maxlength="15" />
								<label class="input__label input__label--hideo" for="register-password">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="password" id="pwd2" placeholder="请确认密码" maxlength="15"/>
								<label class="input__label input__label--hideo" for="register-repassword">
									<i class="fa fa-fw fa-lock icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="address" name="address" autocomplete="off" placeholder="请输入公司地址"/>
								<label class="input__label input__label--hideo" for="register-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="contacts" name="contacts" autocomplete="off" placeholder="请输入联系人姓名"/>
								<label class="input__label input__label--hideo" for="register-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="phone" name="phone" autocomplete="off" placeholder="请输入手机号"/>
								<label class="input__label input__label--hideo" for="register-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
							
							<span class="input input--hideo">
								<input class="input__field input__field--hideo" type="text" id="busNum" name="busNum" autocomplete="off" placeholder="请输入公司工商号"/>
								<label class="input__label input__label--hideo" for="register-code">
									<i class="fa fa-fw fa-wifi icon icon--hideo"></i>
									<span class="input__label-content input__label-content--hideo"></span>
								</label>
							</span>
						</section>
					</div>
					<div class="form-actions">
						<a class="btn pull-left btn-link text-muted" onClick="goto_login()">返回登录</a>
						<input class="btn btn-primary" type="submit" onClick="return register()" value="注册" 
							style="color:white;"/>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div style="text-align:center;">

</div>
</body>
</html>

