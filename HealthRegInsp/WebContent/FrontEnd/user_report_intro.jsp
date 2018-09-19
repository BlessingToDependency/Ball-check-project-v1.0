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
<title>文档管理</title>
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
		<div class="title">体检报告</div>
		<div class="contractlist en_contractlist">
			<div class="row">
				<form action="" method="post">
					<table width="400" border="1" align="center">
						<tr>
							<td>尊敬的： 女生/先生</td>
						</tr>
						<tr>
							<td> <textarea name="textarea"  rows="16" cols="55" readonly="readonly">欢迎您来到    进行健康体检
    为了增加您对健康体检的认识，我们再次特别向您说明，健康体检的目的在于及时
了解自身的健康状况，提高健康保健意识，如果此次检查在正常范围内，值表示您选择的体检项目所反映的身体健康状态，
由于体检手段及项目所限，并不能完全排除身体潜在疾病，若有疾病症状出现，请您及时到医院就医。
   “健康是人生最高贵的”。不良的生活习惯和行为会损坏您的健康，我们真诚希望您保持科学健康的生活方式，
定期接受健康检查，在您最需要的时候随时与我们联系，欢迎您再次光临传一医院。
    祝您，健康快乐!</textarea>
							</td>
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
		<div class="addr-name en_addr-name">健康体检中心</div>
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