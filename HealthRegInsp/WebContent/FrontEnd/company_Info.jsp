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

<title>医院简介</title>

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
			<!-- <a href="/" id="logo"><img src="images/logo.png" height="40" /></a> -->

			<ul id="nav">

				<li class="navitem"><a class='active' href="<%=path%>myCompAction/backIndex.action">首页</a></li>

				<li class="navitem"><a href="keshi.html">门诊科室</a>

					<ul class="subnav">



						<li><a href="keshi.html">非手术科</a></li>



						<li><a href="keshi.html">手术科室</a></li>



						<li><a href="keshi.html">诊断科室</a></li>



						<li><a href="keshi.html">其他科室</a></li>



					</ul></li>
				<li class="navitem"><a href="tese.html">医疗特色</a>
					<ul class="subnav">
					</ul></li>
				<li class="navitem"><a href="about.html">公司简介</a>

					<ul class="subnav">

						<li><a href="<%=path%>myCompAction/selectCompInfo.action">公司信息</a></li>
						<li><a href="<%=path%>myCompAction/toEditCompInfo.action">编辑公司信息</a></li>
						<li><a href="<%=path%>myCompAction/toUpPws.action"">修改密码</a></li>



					</ul></li>
				<li class="navitem"><a href="team.html">医师团队</a>

					<ul class="subnav">



					</ul></li>
				<li class="navitem"><a href="news.html">新闻动态</a>

					<ul class="subnav">



						<li><a href="#">院内新闻</a></li>



						<li><a href="#">行业新闻</a></li>



					</ul></li>
				<li class="navitem"><a href="contact.html">联系我们</a>

					<ul class="subnav">
					</ul></li>

			</ul>

			<div class="clear"></div>

		</div>

		<a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a>
	</div>



	<div id="sitecontent">

		<div class="npagePage Pageyemian" id="page_none">

			<div class="content">
					
					<!--联系我们-->
					<div class="contract wrap" style="margin-top: 100px;" align:center>
						<div class="title">公司信息</div>
						<div class="contractlist en_contractlist">
							<div class="row">
								<form id="fileForm" name="fileform" method="post" action="fileShow.action">
									<div align="center">
										<div>

											<table  width="400">
												<c:forEach items="${compList}" var="comp">
													<tr>
														<td align="center">公司名</td>
														<td align="center">${comp.company}</td>
													</tr>
													<tr>
														<td align="center">公司地址</td>
														<td align="center">${comp.address}</td>
													</tr>
													<tr>
														<td align="center">联系人</td>
														<td align="center">${comp.contacts}</td>
													</tr>
													<tr>
														<td align="center">电话</td>
														<td align="center">${comp.phone}</td>
													</tr>
													<tr>
														<td align="center">工商号</td>
														<td align="center">${comp.busNum}</td>
													</tr>
												</c:forEach>

											</table>

										</div>
									</div>
								</form>
							</div>
						</div>
					</div>		
			</div>

		</div>
	</div>
</body>

</html>