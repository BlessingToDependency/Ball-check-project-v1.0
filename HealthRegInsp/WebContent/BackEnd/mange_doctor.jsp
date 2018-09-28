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
    <title>参数配置</title>
<script type="text/javascript">
function changeState(stateC,id){
	var r=confirm("确定?")
	 if(r==true){ 
		  if(stateC==3){
			  window.location.href="<%=path%>maDoctorAction/updateDoctorState.action?stateId="+4+"&adminId="+id;
		  }else{
			  window.location.href="<%=path%>maDoctorAction/updateDoctorState.action?stateId="+3+"&adminId="+id;
		  }
	 }
}

function changeLogic(stateC,id){
	var r=confirm("确定?")
	 if(r==true){ 
		  if(stateC==6){
			  window.location.href="<%=path%>maDoctorAction/logicDeleteDoc.action?logicId="+5+"&adminId="+id;
		  }
	 }
}

</script>
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

          <input type="text" name="adminName"  placeholder="请输入医生名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("adminName")==null?"":request.getAttribute("adminName")%>"/>
          <input type="text" name="post"  placeholder="请输入职务名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("post")==null?"":request.getAttribute("post")%>"/>
          <input type="text" name="depa"  placeholder="请输入科室名" autocomplete="off" class="layui-input" value="<%=request.getAttribute("depa")==null?"":request.getAttribute("depa")%>"/>
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('添加医生','<%=path%>maDoctorAction/toAddDoctor.action')"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>医生名字</th>
            <th>年龄</th>
            <th>手机号</th>
            <th>职务</th>
            <th>科室</th>
            <th>用户状态</th>
            <th>操作</th>
        </thead>
        <tbody>
        
        
        
        
          <c:forEach items="${docList}"  var="list" step="1" varStatus="vs">
			<tr>
			   <td>${list.adminName}</td>
			   <td>${list.age}</td>
			   <td>${list.phone}</td>
			   <td>${list.postBean.post}</td>
			   <td>${list.deparBean.depa}</td>
			   <td>${list.paramBean.param}</td>
	       	   <td class="td-status">
	       	   <span class="layui-btn layui-btn-normal layui-btn-mini"  onclick="x_admin_show('修改信息医生','<%=path%>maDoctorAction/toUpdateDoctorInfo.action?adminId=${list.adminId}')">修改</span>
                 <span class="layui-btn layui-btn-danger" onclick="changeLogic(${list.logicId},${list.adminId})">
                         <c:if test="${list.logicId==6}"> 删除 </c:if>
                         <c:if test="${list.logicId==5}"> 已删除 </c:if>
                                                              </span>
                    <span class="layui-btn  layui-btn-warm" onclick="changeState(${list.stateId},${list.adminId})">
                        <c:if test="${list.stateId==3}">
                                                              禁用
                        </c:if>
                           <c:if test="${list.stateId==4}">
                                                              启用
                        </c:if>
                              </span>
	           </td>
			</tr>
		
			
		
			</c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
                     总页数/当前页数 ${paNum}/${page}
         <a class="num" href="<%=path%>maDoctorAction/selectAllDoctor.action?page=1">首页</a>
          <a class="prev" href="<%=path%>maDoctorAction/selectAllDoctor.action?page=${page-1<1?1:page-1}&adminName=${adminName}&post=${post}&depa=${depa}">上一页</a>
          <a class="next" href="<%=path%>maDoctorAction/selectAllDoctor.action?page=${(page+1)<=paNum?page+1:paNum}&adminName=${adminName}&post=${post}&depa=${depa}">下一页</a>
          <a class="num" href="<%=path%>maDoctorAction/selectAllDoctor.action?page=${paNum}">末页</a>
           <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off" />
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
        </div>
      </div>

    </div>

  </body>
  <script type="text/javascript">
//跳转页码
  function jump(){
  	var p=document.getElementById("pageNo").value;
  	window.location.href="<%=path%>maDoctorAction/selectAllDoctor.action?page="+p;
  }
  
  </script>

</html>