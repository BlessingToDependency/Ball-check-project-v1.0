<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>注册界面</title>
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/common.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				
				<div class="logo"></div>
				
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							注册
						</div>
						<form action="<%=path%>UserRegiServlet?action=register" method="post"
			class="layui-form" id="regform">
							
							<div class="form_text_ipt">
								<input name="username" type="text" placeholder="账号">
							</div>
							<div class="ececk_warning"><span>手机号/邮箱不能为空</span></div>
							<div class="form_text_ipt">
								<input name="password" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_text_ipt">
								<input name="repassword" type="password" placeholder="重复密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div >
								&nbsp;&nbsp;&nbsp;<input type="radio" name="RadioGroup1" value="男" id="RadioGroup1_0" />男
								<input type="radio" name="RadioGroup1" value="女" id="RadioGroup1_1" />女
							</div>
							<div class="ececk_warning"><span>手机号码为11位</span></div>
							<div class="form_text_ipt">
								<input name="phone" type="text" placeholder="手机号">
							</div>
							<div class="ececk_warning"><span>手机号码为11位</span></div>
							<div class="form_text_ipt">
								<input name="code" type="text" placeholder="通讯地址">
							</div>
							<div class="ececk_warning"><span>不为空且在30个字符以内</span></div>
							
							<div class="form_btn">
								<button type="submit">注册</button>
							</div>
							<div class="form_reg_btn">
								<span>已有帐号？</span><a href="<%=path%>user_login.jsp">马上登录</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/common.js" ></script>
		<div style="text-align:center;">

</div>
	</body>
</html>