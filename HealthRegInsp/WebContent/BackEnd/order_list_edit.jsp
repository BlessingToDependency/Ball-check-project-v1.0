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
		<div class="title">套餐详情</div>
		<div class="contractlist en_contractlist">
			<div class="row">
				<form action="" method="post">
				 <table width="650" border="1" align="center">
  <tr>
    <td width="65">项目Id</td>
    <td width="92">项目名称</td>
    <td width="92">项目单价</td>
    <td width="92">项目简介</td>
     <td width="92">操作</td>
    </tr>
  <c:forEach items="${itemList}" var="list"  varStatus="vs">
  <tr>
    <td>${vs.index+1}</td>
    <td>${list.item }</td>
    <td>${list.price }</td>
    <td> <textarea name="textarea"  readonly="readonly" cols="38" rows="3">${list.introd }</textarea></td>
  	<td><a onclick="return confirm('确认删除?')"   href="<%=path %>Order/deleteItem.action?comId=${list.tblSetCom.comId}&setmealId=${setmealId}">删除 </a> </td>
   </tr>
  </c:forEach>

  <tr>
    <td colspan="5" align="center">
      <input type="submit" name="Submit" value="增加项目">
      <input type="button" onclick="location.href='javascript:history.go(-1)'" value="返回"></td>
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