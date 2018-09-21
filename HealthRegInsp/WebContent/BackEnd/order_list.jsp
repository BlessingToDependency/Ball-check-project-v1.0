<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <link rel="stylesheet" href="<%=path %>lib/layui/css/layui.css"  media="all">
    <script type="text/javascript" src="<%=path%>js/jquery-1.11.3.min.js"></script>
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
        <form class="layui-form layui-col-md12 x-so" >
          <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end">
          <input type="text" name="username"  placeholder="请输入用户名" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="x_admin_show('添加用户','./admin-add.html')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">页数：${currentPage}/${totalPage }</span>
      </xblock>
    <form id="fileForm" name="fileform" method="post" action="fileShow.action">  
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>套餐ID</th>
            <th>套餐名字</th>
            <th>套餐折扣</th>
            <th>套餐销量</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${orderList}" var="list"  >
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
         
            <td>${list.setmealId }</td>
            <td>${list.setmeal }</td>
            <td>${list.discount }</td>
            <td>${list.salsvolume }</td>
         
            <td class="td-status" align="center">
              <span class="layui-btn layui-btn-normal layui-btn-mini">增加</span>
           	 <span class="layui-btn layui-btn-warm  layui-btn-mini">刪除</span>
      			 <span class="layui-btn  layui-btn-mini">刪除</span>
      			 	 <span class="layui-btn layui-btn-danger  layui-btn-mini">查看</span>
            </td>            
          </tr>
          </c:forEach>
        </tbody>
      </table>
      </form>
     <div class="page">
        <div>
     	 当前：第  ${currentPage } 页/ 共 ${totalPage} 页
          <a class="num" href="<%=path %>Order/showOrder.action?currentPage=1">首页</a>
          <a class="prev" href="<%=path %>Order/showOrder.action?currentPage=${(currentPage-1)>0?currentPage-1:1}">上一页</a>
          <a class="next" href="<%=path%>Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}">下一页</a>
          <a class="num" href="<%=path %>Order/showOrder.action?currentPage=${totalPage}">末页</a>
                    <input type="text" id="currentPage" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" href="">跳转</a>
        </div>
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
<script>
<%-- layui.use(['laypage', 'layer'], function(){
		
  var currentPage  = $("#currentPage").val();
  var pagecount = ${count}
  var laypage = layui.laypage 
  ,layer = layui.layer;
  
  //总页数低于页码总数
  laypage.render({
    elem: 'demo2'
    ,count: pagecount //数据总数
  	,limit: 5
  	,curr: currentPage
  	,jump: function(obj, first){
  	    //obj包含了当前分页的所有参数，比如：
  	    console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
  	    console.log(obj.limit); //得到每页显示的条数
  	 //   var form  = $("#fileForm").val();
  		//form.action="Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}";		
		//提交表单
		//form.submit();  
  	    //首次不执行
  	    if(!first){
  	      //do something
  	      location.href = "<%=path%>Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}"
  	    }
  	  }
  /*   ,jump: function(){
     //	var form =document.getElementById("fileForm");	
    	 var form  = $("#fileForm").val();
  		//设置地址
  		form.action="Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}";		
  		//提交表单
  		form.submit();  
 
    } */
  });
}); --%>
</script>
<script type="text/javascript">
    $(document).ready(function(){
       //点击链接的时候调用
      $("#linkToCart").click(function(){
          //得到input的值
          var currentPage = $("#currentPage").val();
          //设置linkToCart的href的值
          $("#linkToCart").attr("href","<%=path %>Order/showOrder.action?currentPage="+currentPage);
      });
    });
</script>
  </body>

</html>