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
    <title>公司列表</title>
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
    
     <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	//点击公司名展示信息
    <script type="text/javascript">
	function info(id){
	$.ajax({
		url:"<%=path %>userAdminAction/userAdmin.action",
		data:"companyId="+id,
		dataType:"json",
		type:"POST"
	
	});
};
</script>
<script type="text/javascript">
    $(document).ready(function(){
       //点击链接的时候调用
      $("#linkToCart").click(function(){
 
          //得到input的值
          var pages = $("#pages").val();
          if(pages>${pageCountAll}){
          	return; 
          }
 
          //设置linkToCart的href的值
          $("#linkToCart").attr("href","<%=path %>userAdminAction/company.action?pages="+pages+"");
      });
    });
</script>
<script type="text/javascript">
function checkUser(){
	document.getElementById("formid").submit();
}
	</script>
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
        <i class="layui-icon" style="line-height:30px">?</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formid" action="<%=path %>userAdminAction/company.action">
          <input type="text" name="company"  placeholder="请输入公司名" autocomplete="off" class="layui-input">
          <input type="text" name="contacts"  placeholder="请输入联系人" autocomplete="off" class="layui-input">
          <input type="text" name="busNum"  placeholder="请输入工商号" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick = "checkUser();"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
       <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>公司名称</th>
            <th>地址</th>
            <th>联系人</th>
            <th>联系电话</th>
            <th>状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${uList}" var="userBean">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
          	<input type="hidden" id="hidden" name="hidden" value="${userBean.companyId}"/>
            <td>${userBean.companyId}</td>
            <td><a onclick="location.href='<%=path %>userAdminAction/userAdmin.action?companyId=${userBean.companyId}'">${userBean.company}</a></td>
           
            
            <td>${userBean.address}</td>
            <td>${userBean.contacts}</td>
            <td>${userBean.phone}</td>
            <td>
            <c:if test="${userBean.stateId==3}">启用</c:if>
            <c:if test="${userBean.stateId==4}">禁用</c:if>
            </td>
            <td class="td-status">
              
              <span class="layui-btn layui-btn-warm  layui-btn-mini">
              <c:if test="${userBean.stateId==3}">
              <a onclick="return confirm('确认禁用?')" href="<%=path %>userAdminAction/disableCompany.action?companyId=${userBean.companyId}&stateId=${userBean.stateId}">禁用</a>
              </c:if>
              <c:if test="${userBean.stateId==4}">
              <a onclick="return confirm('确认启用?')" href="<%=path %>userAdminAction/disableCompany.action?companyId=${userBean.companyId}&stateId=${userBean.stateId}">启用</a>
              </c:if>
              </span>
              
              <span class="layui-btn layui-btn-warm  layui-btn-mini">
              <a onclick="return confirm('确认删除,该操作不可更改?')" href="<%=path %>userAdminAction/deleteCompany.action?companyId=${userBean.companyId}&logicId=${userBean.logicId}">刪除</a>
              </span>
              
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
      当前：第  ${pages } 页/ 共 ${pageCountAll} 页
          <a class="num" href="<%=path %>userAdminAction/company.action?pages=1">首页</a>
          <a class="prev" href="<%=path %>userAdminAction/company.action?pages=${(pages-1)>0?pages-1:1}">上一页</a>
          <a class="next" href="<%=path %>userAdminAction/company.action?pages=${(pages+1)<=pageCountAll?pages+1:pageCountAll}">下一页</a>
          <a class="num" href="<%=path %>userAdminAction/company.action?pages=${pageCountAll}">末页</a>
          <input type="text" id="pages" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" href="">跳转</a>
        </div>
      </div>

    </div>
  
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
</body>

</html>