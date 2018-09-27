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
<body class="nobanner">

<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="<%=path %>images/logo.png" height="40" /></a>

    <ul id="nav">

      <li class="navitem"><a  class='active' href="index.html">首页</a></li>

      <li class="navitem"><a  href="keshi.html" >门诊科室</a>

        <ul class="subnav">

          

          <li><a href="keshi.html">非手术科</a></li>

          

          <li><a href="keshi.html">手术科室</a></li>

          

          <li><a href="keshi.html">诊断科室</a></li>

          

          <li><a href="keshi.html">其他科室</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="tese.html" >医疗特色</a>

        <ul class="subnav">

        </ul>

      </li><li class="navitem"><a  href="about.html" >医院简介</a>

        <ul class="subnav">

          

          <li><a href="#">企业文化</a></li>

          

          <li><a href="#">发展历程</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="team.html" >医师团队</a>

        <ul class="subnav">

          

        </ul>

      </li><li class="navitem"><a  href="news.html" >新闻动态</a>

        <ul class="subnav">

          

          <li><a href="#">院内新闻</a></li>

          

          <li><a href="#">行业新闻</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="contact.html" >联系我们</a>

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
	请选择文件：<input name="fileact" type="file">
	 <input name="submit" type="submit" value="上传">
 	</form>

      <div id="pages"></div>

    </div>

  </div>

</div>

<div id="footer">
  <p>Copyright &copy; 2002-2011 AB模板网 版权所有　<a class="beian" href="http://www.miitbeian.gov.cn/" style="display:inline; width:auto; color:#8e8e8e" target="_blank">苏ICP12345678</a></p>
</div>
</body>
</html>