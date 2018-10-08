<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>医生总结</title>
 <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
       <form class="layui-form layui-col-md12 x-so"  method="post" action="<%=path %>Report/showCompany.action">
          <input type="text" name="company"  value="${company }" placeholder="请输入公司名" autocomplete="off" class="layui-input">     
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>

      <xblock> 
        <!-- <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn"  data-toggle="modal" data-target="#myModal" ><i class="layui-icon"></i>添加</button>     -->
<%--         <span class="x-right" style="line-height:40px">共有数据：${count } 条</span> --%>
      </xblock>
  
      <table class="layui-table" width="100%" style="table-layout:fixed;">
        <thead>
          <tr>
            <th >序列</th>
            <th >公司名</th>
            <th>公司ID</th>
            <th>下单时间</th>
            <th >操作</th>
        </thead>
        <tbody>
        <c:forEach items="${billList }" var="item" varStatus="i">
          <tr>
            <td>${i.index+1 }</td>
            <td>${item.userBean.company }</td>
            <td>${item.companyId }</td>
      		<td>${item.orderTime }</td>
            <td class="td-status">
                 <%-- <span class="layui-btn layui-btn-normal layui-btn-mini" id="myModal" onClick="myModal(${item.itemId})">查看详情</span> --%>
                  <span class="layui-btn layui-btn-normal layui-btn-mini"><a    href="<%=path %>Report/showUser.action?&companyId=${item.companyId}&orderTime=${item.orderTime }">查看详情 </a></span>
	        </td>
          </tr> 
      </c:forEach>  
     </tbody> 
     </table>          
     <!--  </form> -->
   	<div class="page">
			<div>  
				当前：第 ${currentPage } 页/ 共 ${totalPage} 页 <a class="num"
					href="<%=path %>Report/showCompany.action?currentPage=1&company=${company }">首页</a> <a class="prev"
					href="<%=path %>Report/showCompany.action?currentPage=${(currentPage-1)>0?currentPage-1:1}&company=${company }">上一页</a>
				<a class="next"
					href="<%=path%>Report/showCompany.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}&company=${company }">下一页</a>
				<a class="num" href="<%=path %>Report/showCompany.action?currentPage=${totalPage}&company=${company }">末页</a>
				<input type="text" id="currentPage" name="code" style="width: 50px; height: 40px;" autocomplete="off" /> <a
					class="num" id="linkToCart" href="">跳转</a>
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

       /*用户-停用*/
      function member_stop(obj,id){
          layer.confirm('确认要停用吗？',function(index){

              if($(obj).attr('title')=='启用'){

                //发异步把用户状态进行更改
                $(obj).attr('title','停用')
                $(obj).find('i').html('&#xe62f;');

                $(obj).parents("tr").find(".td-status").find('span').addClass('layui-btn-disabled').html('已停用');
                layer.msg('已停用!',{icon: 5,time:1000});

              }else{
                $(obj).attr('title','启用')
                $(obj).find('i').html('&#xe601;');

                $(obj).parents("tr").find(".td-status").find('span').removeClass('layui-btn-disabled').html('已启用');
                layer.msg('已启用!',{icon: 5,time:1000});
              }
              
          });
      }

      /*用户-删除*/
      function member_del(obj,id){
          layer.confirm('确认要删除吗？',function(index){
              //发异步删除数据
              $(obj).parents("tr").remove();
              layer.msg('已删除!',{icon:1,time:1000});
          });
      }



      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+data,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            window.location.href="<%=path %>Order/deleteItem.action?setmealId=${setmealId }&data="+data;
        });
      }
    </script>
</body>
</html>