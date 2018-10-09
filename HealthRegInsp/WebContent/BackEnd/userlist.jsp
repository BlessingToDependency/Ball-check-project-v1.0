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
    <title>用户列表</title>
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
    
     <script src="<%=path%>js/bootstrap.min.js"></script>
    <link href="<%=path%>css/bootstrap.min.css" rel="stylesheet" />
     <!-- <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
    
    <script type="text/javascript">
	function info(id){
	$.ajax({
		url:"<%=path %>userAdminAction/userInfo.action",
		data:"staffId="+id,
		dataType:"json",
		type:"POST",
		success : function(str){
			$("#name").val(str.staffName);
			$("#age").val(str.age);
			$("#sex").val(str.sex);
			$("#numphone").val(str.phone);
			$("#idNum").val(str.idNum);
		}
	});
};
</script>
<!-- 导出excel -->
<script type="text/javascript">
	function exportExcel(){
		var staffName=$("#staffName").val();
		var statTime=$("#start").val();
		var stopTime=$("#end").val();
		var phone=$("#phone").val();
		var myGuChId=$("#myGuChId").val();
		var companyId=$("#companyId").val();
	$.ajax({
		url:"<%=path %>fileAction/exportExcel.action",
		data:"companyId="+$("#companyId").val(),
		dataType:"json",
		type:"POST",
		success : function(str){
			alert("已导出")
		}
	});
};
</script>
<script type="text/javascript">
    $(document).ready(function(){
       //点击链接的时候调用
      $("#linkToCart").click(function(){
          //得到input的值
          var pages = $("#pages").val();
          
          if(pages>(${pageCountAll})){
            	return; 
            }
          //设置linkToCart的href的值
          $("#linkToCart").attr("href","<%=path %>userAdminAction/userAdmin.action?pages="+pages+"&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime }&staffName=${staffBean.staffName }&phone=${staffBean.phone }&myGuChId=${staffBean.myGuChId}");
      });
    });
</script>
<script type="text/javascript">
function checkUser(){
	
	var start = $("#start").val();
	var end = $("#end").val();
	var staffName = $("#staffName").val();
	var myGuChId = $("#myGuChId").val();
	if(start== "" && end== "" && staffName== "" && myGuChId == ""){
		alert("至少选择一项搜索条件！")
		return ;
	}else{
		document.getElementById("formid").submit();
	}
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
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formid" action="<%=path %>userAdminAction/userAdmin.action?pages= ${pages}	">
          <input class="layui-input" value="${staffBean.statTime==null?"":staffBean.statTime}" placeholder="开始日" name="statTime" id="start" autocomplete="off">
          <input class="layui-input" value="${staffBean.stopTime==null?"":staffBean.stopTime}" placeholder="截止日" name="stopTime" id="end" autocomplete="off">
          <input type="text" id="staffName" name="staffName" value="${staffBean.staffName==null?"":staffBean.staffName}"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <%-- <input type="text" id="phone" name="phone" value="${staffBean.phone==null||staffBean.phone==0?"":staffBean.phone}"  placeholder="请输入手机号" autocomplete="off" class="layui-input"> --%>
          <input type="text" id="myGuChId" name="myGuChId" value="${staffBean.myGuChId==null?"":staffBean.myGuChId}"  placeholder="请输入条码号" autocomplete="off" class="layui-input">
         <input type="hidden" name="companyId" value="${staffBean.companyId}"/>
          <button class="layui-btn" lay-filter="sreach" onclick ="checkUser();"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" onclick="exportExcel()"><i class="layui-icon"></i>导出excel</button>
   <!--  <input type="button" onclick="exportExcel()" value="导出" /> -->
   <a onclick="exportExcel()" href="">导出excel</a>
      </xblock>
      <form id="exportForm" action="">
       <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>姓名</th>
            <th>手机号</th>
            <th>体检时间</th>
            <th>条码号</th>
             <th>体检状态</th>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="staffBean" varStatus="vs">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <input type="hidden" id="companyId" name="companyId" value="${staffBean.companyId}"/>
          	<input type="hidden" id="hidden" name="hidden" value="${staffBean.staffId}"/>
            <td>${(pages-1) *5+(vs.index+1)}</td>
            <td><a data-toggle="modal" data-target="#myModal" onclick="info(${staffBean.staffId})">${staffBean.staffName}</a></td>
            <td>${staffBean.phone}</td>
            <td>${staffBean.perguirelaBean.partYear}</td>
             <td>${staffBean.myGuChId}</td>
       	  <td>
       	  <c:if test="${staffBean.medicalId==83}">体检结束</c:if>
       	  <c:if test="${staffBean.medicalId==82}">未体检</c:if>
       	  </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      </form>
      <div class="page">
        <div>
      当前：第  ${pages} 页/ 共 ${pageCountAll} 页
          <a class="num" href="<%=path %>userAdminAction/userAdmin.action?pages=1&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime }&staffName=${staffBean.staffName }&phone=${staffBean.phone }&myGuChId=${staffBean.myGuChId}">首页</a>
          <a class="prev" href="<%=path %>${(pages-1)>0?pages-1:1}&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime }&staffName=${staffBean.staffName }&phone=${staffBean.phone }&myGuChId=${staffBean.myGuChId}">上一页</a>
          <a class="next" href="<%=path %>userAdminAction/userAdmin.action?pages=${(pages+1)<=pageCountAll?pages+1:pageCountAll}&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime }&staffName=${staffBean.staffName }&phone=${staffBean.phone }&myGuChId=${staffBean.myGuChId}">下一页</a>
          <a class="num" href="<%=path %>userAdminAction/userAdmin.action?pages=${pageCountAll}&statTime=${staffBean.statTime}&stopTime=${staffBean.stopTime }&staffName=${staffBean.staffName }&phone=${staffBean.phone }&myGuChId=${staffBean.myGuChId}">末页</a>
          <input type="text" id="pages" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" href="">跳转</a>
        </div>
      </div>

    </div>
    <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel" >
            体检人员信息       
                </h4>
            </div>
            
            <div class="modal-body">
                 姓名：<input type="text" id="name" readonly="readonly" >
            </div>
            <div class="modal-body">
                性别：<input type="text" id="sex" readonly="readonly" >
            </div>
            
            <div class="modal-body">
                年龄：<input type="text" id="age" readonly="readonly" >
            </div>
            <div class="modal-body">
                电话：<input type="text" id="numphone" readonly="readonly" >
            </div>
            <div class="modal-body">
                身份证号：<input type="text" id="idNum" readonly="readonly" >
            </div>
           
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#start' //指定元素
        	  ,type: 'datetime'

        });

        //执行一个laydate实例
        laydate.render({
          elem: '#end' //指定元素
        	  ,type: 'datetime'

        });
      });
 </script>
</body>

</html>