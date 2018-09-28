<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
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

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=6">

<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/list.php?tid=6";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>

<script type="text/javascript">
function back(){
	window.location.href="<%=path%>/myCompAction/backIndex.action";
}
</script>
</head>
<body class="nobanner">

<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="images/logo.png" height="40" /></a>

    <ul id="nav">

      <li class="navitem"><a  class='active' href="<%=path%>/myCompAction/backIndex.action">首页</a></li>

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

      </li><li class="navitem"><a  href="about.html" >公司简介</a>

        <ul class="subnav">

          

            <li>
          <a href="<%=path%>/myCompAction/selectCompInfo.action"  >公司信息</a>                  
         </li>

          
          <li><a href="<%=path%>/myCompAction/toEditCompInfo.action" >编辑公司信息</a></li>
          <li><a  href="<%=path%>/myCompAction/toUpPws.action"">修改密码</a></li>

          

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

    
<form id="form1" name="form1" method="post" action="<%=path%>myCompAction/EditCompInfo.action" enctype="multipart/form-data">
 <div class="header">

        <p class="title">修改公司信息</p>

      </div>
       <div align="center">   
<table width="490" border="1" align="center">
  <tr>
    <td width="112">头像</td>
    <td width="362">
    <input type="file" name="fileact" id="fileact" />
    <img src="" id="img0" style="width: 5rem; height: 5rem;">
    </td>
    
  </tr>
  <c:forEach items="${compList}"  var="comp">
  <tr>
    <td height="28">企业地址</td>
    <td><label for="textfield"></label>
    <input type="text" name="address" id="textfield" value="${comp.address}" /></td>
  </tr>
  <tr>
    <td>联系人</td>
    <td><label for="textfield2"></label>
    <input type="text" name="contacts" id="textfield2" value="${comp.contacts}"/></td>
  </tr>
  <tr>
    <td>电话</td>
    <td>
      <label for="textfield3"></label>
      <input type="text" name="phone" id="textfield3" value="${comp.phone}"/>
    </td>
  </tr>
  </c:forEach>
  <tr>
      
    <td colspan="2">  <div align="center">  <input type="submit" name="button" id="button" value="提交" />
      <input type="reset" name="button3" id="button3" value="重置" /> </div></td> 
    </tr>
</table>
</div>
</form>



</body>
<script>
		$("#fileact").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img0").attr("src", objUrl);
			}
		});
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) { // mozilla(firefox)  
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) { // webkit or chrome  
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>
</html>