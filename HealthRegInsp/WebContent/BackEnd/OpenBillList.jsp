<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="UTF-8">
    <title>单位团检开单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so">
          <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end">
          <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>

      <table class="layui-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>单位名称</th>
            <th>单位地址</th>
            <th>联系人</th>
            <th>电话</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${openBillList}"  var="list" step="1" varStatus="vs">
			<c:if test="${vs.index%2 == 0}">
			<tr   style="background-color:cyan">
			   <td>${vs.index+1}</td>
			   <td>${list.company}</td>
			   <td>${list.address}</td>
			   <td>${list.contacts}</td>
			   <td>${list.phone}</td>
	       	   <td class="td-status">
                 <a href="<%=path%>demo/userManger!enable.action?name=${list.company}"><span class="layui-btn layui-btn-normal layui-btn-mini">批量开单</span>启用</a>
	           </td>
			</tr>
			</c:if>
			
		   <c:if test="${vs.index%2 == 1}">
			<tr   style="background-color:pink">
			    <td>${vs.index+1}</td>
			   <td>${list.company}</td>
			   <td>${list.address}</td>
			   <td>${list.contacts}</td>
			   <td>${list.phone}</td>
	       	   <td class="td-status">
               <span class="layui-btn layui-btn-normal layui-btn-mini">批量开单</span>
	           </td>
			</tr>
			</c:if>
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
          <a class="prev" href="">&lt;&lt;</a>
          <a class="num" href="">1</a>
          <span class="current">2</span>
          <a class="num" href="">3</a>
          <a class="num" href="">489</a>
          <a class="next" href="">&gt;&gt;</a>
        </div>
      </div>

    </div>

  </body>

</html>