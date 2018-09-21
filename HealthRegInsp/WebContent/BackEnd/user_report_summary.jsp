<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>健康体检中心</title>
<link rel="stylesheet" type="text/css" href="<%=path%>css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>css/newstyle.css" />
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>

</head>
<style>
* {
	/* 	margin: 0; */
	padding: 0;
	list-style: none;
}
</style>

<body>

	<!--联系我们-->
	<div class="contract wrap" style="margin-top: 100px;" align:center>
		<div class="title">体检总结及建议</div>
		<div class="contractlist en_contractlist">
			<div class="row">
				<form action="" method="post">
					<table width="950" border="1" align="center">
						<tr>
							<td>[综述]</td>
						</tr>
						<tr>
							<td height="33"><p>一、检验室：</p>
								<p>体检血常规</p>
								<p>血小板</p>
								<p>体检血型：</p>
								<p>O型</p></td>
						</tr>
						<tr>
							<td><p>二、 身高体重血压：</p>
								<p>身高：153cm 体重:58kg BML-34.5（超重）</p>
								<p>血压：102/55mmhg</p></td>
						</tr>
						<tr>
							<td>建议：</td>
						</tr>
						<tr>
							<td><p>检验室：</p>
								<p>一、血小板计数（PLT）偏高</p>
								<p>身高体重血压：</p>
								<p>一、超重</p>
								<p>体重指数位于24-29</p></td>
						</tr>
						<tr>
							<td>二、血压偏低</td>
						</tr>
						<tr>
							<td>正常状态下成人舒张压低于</td>
						</tr>
						<tr>
							<td align="right">总结日期：2018.9.18 总结医生：${totalBean.doctor}</td>
						</tr>				
					</table>
				</form>
			</div>
		</div>
	</div>

	<div class="map">
		<!-- <img src="img/map.png" /> -->
		<div class="dingwei">
			<!-- <img src="img/dingwei.png" /> -->
		</div>
		<div class="addr-name en_addr-name"></div>
	</div>
	</div>

	<!--footer-->
	<div class="footer">
		<%-- <img src="<%=path%>front/img/foot_logo.png" />  --%>
		健康体检中心
	</div>

</body>

<script type="text/javascript">
	function fileNext() {
		//获得表单
		var form = document.getElementById("fileForm");
		//设置地址
		form.action = "fileShow.action?currentPage=${(fileCon.currentPage+1)<=fileCon.totalPage?fileCon.currentPage+1:fileCon.totalPage}";
		//提交表单
		form.submit();

	}
	function fileLast() {
		var form = document.getElementById("fileForm");
		//设置地址
		form.action = "fileShow.action?currentPage=${(fileCon.currentPage-1)>0?fileCon.currentPage-1:1}";
		//提交表单
		form.submit();
	}
</script>

</html>