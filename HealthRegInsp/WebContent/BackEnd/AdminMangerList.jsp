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
    <title>管理员管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link href="<%=path%>css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <%-- <script src="<%=path%>js/bootstrap.min.js"></script> --%>
     <style>
     .zt{color: #06F;font-size: 18px;font-weight: 10px;}
         #div{width:100%; height:50px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
         #divleft{width:35%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:right;}
         #divright{width:63%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
	</style>
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
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：88 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>登录名</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>角色</th>
            <th>加入时间</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${paramList}"  var="list" step="1" varStatus="vs">
			<tr>
			    <td>${vs.index+1}</td>
			   <td>${list.param}</td>
			   <td>${list.parId}</td>
	       	   <td class="td-status">
                 <span id="up" class="layui-btn layui-btn-normal layui-btn-mini" onclick="addHid(${list.paramId});">修改</span>
                 <a href="<%=path%>adminParamAction/delParam.action?pid=${list.paramId}" ><span class="layui-btn layui-btn-danger" onclick="return disable();">删除</span></a>
	           </td>
			</tr>
			</c:forEach>
        </tbody>
      </table>
       
        <div class="page">
        <div>
      当前：第  ${pageNo} 页/ 共 ${AllPage} 页
          <a class="num" href="<%=path %>adminParamAction/systemParam.action?pageNo=1">首页</a>
          <a class="prev" href="<%=path %>adminParamAction/systemParam.action?pageNo=${pageNo-1}" onclick="return chageNO(this)">上一页</a>
          <a class="next" href="<%=path %>adminParamAction/systemParam.action?pageNo=${pageNo+1}" onclick="return chageNE(this)">下一页</a>
          <a class="num" href="<%=path %>adminParamAction/systemParam.action?pageNo=${AllPage}">末页</a>
          <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
        </div>
      </div>


    </div>
</body>
    <script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        });
      });
    </script>
    <script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>adminParamAction/systemParam.action?pageNo="+p;
}
//禁用弹窗确认
function disable(){
	 var r=confirm("确定删除吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
//上一页限制
function chageNO(v){
	 var url = v.href;
	 var a=url.indexOf('=',1);
	 var a2=a+1;
	 var b=a2+2;
	 var num = parseInt(url.substring(a2,b));
	 if(num<1){
		 return false;
	 }
	 return true;
}
//下一页限制
function chageNE(v){
	 var url = v.href;
	 var a=url.indexOf('=',1);
	 var a2=a+1;
	 var b=a2+2;
	 var num = parseInt(url.substring(a2,b));
	 //var all=${allPageNo};
	 if(num>${AllPage}){
		 return false;
	 }
	 return true;
}
</script> 
</html>