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
    <title>体检公司列表</title>
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
         #div{width:20%; height:40px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
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
        <form class="layui-form layui-col-md12 x-so"  method="post" action="<%=path %>openBillAction/massInspList.action">
        <div id="div">
          <input type="text" id="company" name="company"  placeholder="公司名称" autocomplete="off" class="layui-input" value="${companyCon.company==null?"":companyCon.company}">
        </div>
          <button class="layui-btn" type="submit" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <span class="x-right" style="line-height:40px">共有数据:${allRecord}条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>公司名称</th>
            <th>联系人</th>
            <th>电话</th>
            <th>公司地址</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${openBillList}"  var="list" step="1" varStatus="vs">
			<tr>
			  <td>
              <div class="layui-unselect layui-form-checkbox" name="ch" lay-skin="primary" data-id='${list.companyId}'><i class="layui-icon">&#xe605;</i></div>
               </td>
			   <td>${vs.index+1}</td>
			   <td>${list.company}</td>
			   <td>${list.contacts}</td>
			   <td>${list.phone}</td>
			   <td>${list.address}</td>
	       	   <td class="td-status">
                 <a href="<%=path%>openBillAction/staff.action?companyId=${list.companyId}" ><span class="layui-btn layui-btn-warm" style="width:120px;">查看体检人员</span></a>
	           </td>
			</tr>
			</c:forEach>
        </tbody>
      </table>
       
        <div class="page">
        <div>
      当前：第  ${pageNo} 页/ 共 ${AllPage} 页
          <a class="num" href="<%=path %>openBillAction/massInspList.action?pageNo=1&company=${companyCon.company}">首页</a>
          <a class="prev" href="<%=path %>openBillAction/massInspList.action?pageNo=${pageNo-1}&company=${companyCon.company}" onclick="return chageNO(this)">上一页</a>
          <a class="next" href="<%=path %>openBillAction/massInspList.action?pageNo=${pageNo+1}&company=${companyCon.company}" onclick="return chageNE(this)">下一页</a>
          <a class="num" href="<%=path %>openBillAction/massInspList.action?pageNo=${AllPage}&company=${companyCon.company}">末页</a>
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

      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            window.location.href="<%=path%>openBillAction/massInspList.action?data="+data;
        });
      }
    </script>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>openBillAction/massInspList.action?pageNo="+p+"&company=${companyCon.company}";
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
	 if(num>${AllPage}){
		 return false;
	 }
	 return true;
}
</script> 
</html>