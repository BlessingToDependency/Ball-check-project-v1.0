
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" href="<%=path %>BackEnd/css/jigsaw.css">
<link rel="stylesheet" href="<%=path %>FrontEnd/css/pintuer.css">
<link rel="stylesheet" href="<%=path %>BackEnd/css/admin.css">
<script src="<%=path %>FrontEnd/js/jquery.js"></script>
<script src="<%=path %>FrontEnd/js/pintuer.js"></script>
<script  src="<%=path%>js/jquery.min.js"></script>
<script type="text/javascript">
function getCode(){
	//得到图片对象

	var image = document.getElementById("imgCode");
	image.src="<%=path%>front/validatecode.action?" + Math.random();
	}
<!--这个函数就是在userName的文本框中每输入一个字符就会调用getCookie.action来查找是否有cookie记录下数据-->
<!--success中的功能就是把返回到的data自动输出到文本框中-->
function rememberCheck(string){
	
    $.ajax({
        type:"POST",
        url: "<%=path %>adminLoginAction/getCookie.action", 
        dataType:"json",
        data:{
        	adminId:string,
        },
        success:function(data){
            $("#adminId").val(data.userName);
            $("#adminPwd").val(data.password);
        },
        error:function() {
            $("#adminPwd").val("");
        }
    });
};	

$(function(){
	var msg = "${requestScope.get('login')}";
	if(msg.length > 0){
		console.log(msg);
		alert(msg);
	}
	
})
</script>
<script type="text/javascript" src="jss/jigsaw.js"></script>

<script type="text/javascript">
<%-- $(document).ready(function(){
	$("#save").click(function(){
		$.ajax({		
				url: "<%=path%>UserLogServlet?action=login",
				data : $("#loginform").serialize(),
				dataType : "text",
				type : "post",
				success : function(redata) {
			
					if (redata == 1) {
						alert("登录成功"); 
						location.href="<%=path%>front/user_index.jsp";
					} else {
						alert("登录失败");
					}
				}
			});
		});
	}); --%>
</script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<form action="<%=path %>adminLoginAction/adminLogin.action" method="post" id="loginform" >
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台登录中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="adminId"  placeholder="用户名"  id="adminId"
										 data-validate="required:请填写账号"  onkeyup="rememberCheck(this.value)" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="adminPwd" id="adminPwd"
									placeholder="密码"	 data-validate="required:请填写密码"  value=""/> <span
										class="icon icon-key margin-small"></span><input type="checkbox" value="y" name="check">记住密码<br/> 
								</div>
							</div>	
							<div class="form-group">
								<%-- <div class="field">
									<input type="text" class="input input-big" name="checkCode"
										placeholder="填写右侧的验证码" data-validate="required:请填写右侧的验证码" />
									<img src="<%=path%>front/validatecode.action" id="imgCode"
										alt="" width="100" height="32"
										class="passcode" style="height: 43px; cursor: pointer" onclick="getCode()"> <!-- <a onclick="getCode()">看不清</a> -->
								</div> --%>
								
		<div id="captcha" style="position: relative"></div>
		<div id="msg"></div>						
			<script type="text/javascript">
jigsaw.init(document.getElementById('captcha'), function () {
	document.getElementById('msg').innerHTML = '验证成功！'
	document.getElementById('null').disabled=false;
	return true;
},function () {
	document.getElementById('msg').innerHTML = '验证失败，重新验证！'
	return false;
})
</script>					

</div>					
						</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big" id="null";
								value="登录" disabled="disabled">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>

</html>