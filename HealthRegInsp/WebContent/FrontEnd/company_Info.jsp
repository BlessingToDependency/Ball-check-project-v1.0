<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta charset="utf-8" />
<meta name="author" content="order by dede58.com/" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>公司信息简介</title>

<meta name="keywords" content="" />

<meta name="description" content="" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/999.css" />

<script type="text/javascript" src="<%=path%>js/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="<%=path%>js/org1470120033.js" data-main="baseMain"></script>

 <link rel="stylesheet" type="text/css" href="<%=path%>css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>css/newstyle.css" />
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script> 

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=6">

 <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
   <link rel="stylesheet" href="<%=path%>/lib/layui/css/layui.css">
<style type="text/css">
 #a{
	width: 50%;
	height: 50px;
	margin: 0px 0px 0px 0px;
	border: blue 0px solid;
	float: left;
	text-align: right;
	font-weight: bold;
	font-size: 18px;
}
  #b{
	width: 10%;
	height: 50px;
	margin-left: 15px;
	border: blue 0px solid;
	float: left;
	text-align: left;
	color: #F00;
	font-weight: bold;
	font-size: 18px;
}
 #c{
	  width: 50%;
	height: 50px;
	margin: 0px 0px 0px 0px;
	border: blue 0px solid;
	float: left;
	text-align: right;
	font-weight: bold;
	
	 
	 }
	 
	  #d{
	  width: 10%;
	height: 50px;
	margin: 0px 0px 0px 0px;
	border: blue 0px solid;
	float: left;
	text-align: center;
	font-weight: bold;
	
	 
	 }
</style>
<script type="text/javascript">
	if (window.location.toString().indexOf('pref=padindex') != -1) {
	} else {
		if (/AppleWebKit.*Mobile/i.test(navigator.userAgent)
				|| (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/
						.test(navigator.userAgent))) {
			if (window.location.href.indexOf("?mobile") < 0) {
				try {
					if (/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i
							.test(navigator.userAgent)) {
						window.location.href = "/m/list.php?tid=6";
					} else if (/iPad/i.test(navigator.userAgent)) {
					} else {
					}
				} catch (e) {
				}
			}
		}
	}
</script>

</head>



<body class="nobanner">
<div id="header">

  <div class="content"> 

    <div style="margin-left: 100px">
       <a href="/" id="logo"><img src="<%=path%>images/lo.png" height="40" /></a>
  </div>

    <ul id="nav">
      <li class="navitem"><a  class='active' href="<%=path %>userMainAction/showSetmeal.action">首页</a></li>
      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action" >我的账户</a>
        <ul class="subnav">
        </ul>
      </li>
      
       <li class="navitem"><a  href="<%=path%>myCompAction/selectCompInfo.action" >公司简介</a>
      
      </li>
      
      <li class="navitem">
      <a  href="<%=path %>fileAction/fileDownLoad.action" >下载体检信息模板</a>
        <ul class="subnav">
        </ul>
      </li>
	   <li class="navitem">
      <a  href="<%=path %>fileAction/userUpload.action" >上传体检人员信息</a>
        <ul class="subnav">
        </ul>
      </li>
      <li class="navitem"><a  href="<%=path %>fileAction/companyStaffList.action" >配置套餐</a>
        <ul class="subnav">
        </ul>
      </li><li class="navitem"><a  href="<%=path%>userLoginAction/jumpLogin.action" >去登陆</a>
        <ul class="subnav">
        </ul>
      </li>
    </ul>
    <div class="clear"></div>
  </div>
  <a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a> </div>





	<div class="npagePage Pageyemian" id="page_none">
     <c:forEach items="${compList}" var="comp">

		<div style="background:url(<%=path%>images/cf.jpg); width: 100%; height: 720px;">
		    

		<div style="background-color: #9FF; width: 100%; height: 720px;">

			<div id="a" style="margin-top: 150px;">公 &nbsp;司  &nbsp;名:</div>
			<div id="b" style="margin-top: 150px;">${comp.company}</div>

			<div id="a">公司地址:</div>
			<div id="b">${comp.address}</div>

			<div id="a">联&nbsp;&nbsp;系&nbsp;人:</div>
			<div id="b">${comp.contacts}</div>

			<div id="a">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</div>
			<div id="b">${comp.phone}</div>

			<div id="a">工&nbsp;商&nbsp;号:</div>
			<div id="b">${comp.busNum}</div>

			<div id="c"> <span class="layui-btn layui-btn-normal layui-btn-mini"   onclick="upInfo()">修改信息</span></div>
			<div id="d"><span class="layui-btn layui-btn-normal" onclick="upPws()" >修改密码</span></div>

		</div>
    </c:forEach>

	</div>




</body>
<script type="text/javascript">
function upInfo(){

	window.location.href="<%=path%>myCompAction/toEditCompInfo.action";
}
function upPws(){

	window.location.href="<%=path%>myCompAction/toUpPws.action";
}
</script>
</html>