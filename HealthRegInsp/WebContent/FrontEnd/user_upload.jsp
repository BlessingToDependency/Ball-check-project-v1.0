<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8" />
<meta name="author" content="order by dede58.com/" />

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>上传</title>

<meta name="keywords" content="" />

<meta name="description" content="" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=path %>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=path %>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=path %>css/999.css" />

<script type="text/javascript" src="<%=path %>js/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="<%=path %>js/org1470120033.js" data-main="baseMain"></script>

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=6">

<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/list.php?tid=6";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>

</head>
<body>

<div id="header">

   <div class="content"> <a href="/" id="logo"><img src="<%=path%>images/lo.png" height="40" /></a>

    <ul id="nav">

      <li class="navitem"><a  class='active' href="<%=path %>userMainAction/showSetmeal.action">首页</a></li>

      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action" >我的账户</a>

        <ul class="subnav">

        </ul>

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

<div id="sitecontent">

  <div class="npagePage Pageyemian" id="page_none">

    <div class="content">

      <div class="header">

        <p class="title">体检人员信息上传</p>

      </div>
      
      <form action="<%=path %>fileAction/fileUpload.action" enctype="multipart/form-data" method="post">
	<h2>请选择文件：</h2>
	</br>
	<input name="fileact" type="file">
	 <input name="submit" type="submit" value="上传" style="width:50px;height:40px">
 	</form>
		<img src="<%=path %>/images/banner1.jpg"/>
      <div id="pages"></div>
    </div>

  </div>

</div>

<div id="footer">
  <p>Copyright &copy; 2002-2011 AB模板网 版权所有　<a class="beian" href="http://www.miitbeian.gov.cn/" style="display:inline; width:auto; color:#8e8e8e" target="_blank">苏ICP12345678</a></p>
</div>
</body>
</html>