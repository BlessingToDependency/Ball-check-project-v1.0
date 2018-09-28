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
    <title>科室管理</title>

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

          <input type="text" name="depa"  placeholder="请输入科室名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("depa")==null?"":request.getAttribute("depa")%>"/>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('新增科室','<%=path%>maDeparAction/toAddDepar.action')"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>科室</th>
            <th>操作</th>
        </thead>
        <tbody>
        
        
        
        
          <c:forEach items="${deli}"  var="deli"  >
			<tr>
			   <td>${deli.depa}</td>
			  
	       	   <td class="td-status">
	       	   <span class="layui-btn layui-btn-normal layui-btn-mini"  onclick="x_admin_show('修改科室名','<%=path%>maDeparAction/toUpdateDepar.action?depaId=${deli.depaId}')">修改</span>
                 <span class="layui-btn layui-btn-danger" onclick="delectDepa(${deli.depaId})" >删除</span>
	           </td>
			</tr>
		
			
		
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
                     总页数/当前页数 ${paNum}/${page}
          <a class="num" href="<%=path%>maDeparAction/selectDe.action?page=1">首页</a>
          <a class="prev" href="<%=path%>maDeparAction/selectDe.action?page=${page-1<1?1:page-1}">上一页</a>
          <a class="next" href="<%=path%>maDeparAction/selectDe.action?page=${(page+1)<=paNum?page+1:paNum}">下一页</a>
          <a class="num" href="<%=path%>maDeparAction/selectDe.action?page=${paNum}">末页</a>
        </div>
      </div>

    </div>

  </body>
<script type="text/javascript">
function delectDepa(depaId){
	var r=confirm("确定?")
	 if(r==true){ 
		 window.location.href="<%=path%>maDeparAction/deleteDepar.action?depaId="+depaId;
	  }
}
</script>
</html>