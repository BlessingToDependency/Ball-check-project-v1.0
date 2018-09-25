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
<title>项目配置管理</title>
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
	<script type="text/javascript">
		$(document).ready(function() {
           
        });
		/* 查看详情 */
		function myModal(itemId){
			//alert(itemId);	
			$.ajax({
				type: "post",
	            url: "userFEAction!search.action",
	            dataType: "json",
	            data: {condition: itemId, //发送的数据部分                       
	            },
	            success: function(reData){//接受后台发送的数据
	                    //alert(reData.page);
	                    var jsonObj=eval("("+reData+")");
	                    //alert(jsonObj.page);
	                    $("#hid").val(jsonObj.page);
	                    $("#tab").empty();
	                    $("#tab").prepend("<thead>"    
	                    		+"<tr>"      
	                        	+"<th>文档标题</th>"
	                        	+"<th>上传人</th>"   
	                             +"    <th>上传时间</th>" 
	                              +"   <th>下载积分</th>"
	                               +"  <th>文档类型</th>"
	                                 +"<th>下载次数</th>"
	                        		+"</tr>"  
	                       		 +"</thead>");
	                    $.each(jsonObj.list, function (i, item) { 
	                    		//alert(item.title);
	                    		$("#tab").prepend("<tbody>"            
	                       		 	+"<tr>"                        		 	
	                        			+"<td onClick='return  download()'>"
	                        			+"<a href='download!down.action?fileName="+item.title+"."+item.documentType+"'>"
	                        			+item.title
	                        			+"</a>"
	                        			+" </td>" 
	                        			
	                        			+"<td>"+item.userBean.userName +"</td>"
	                                    +"<td>"+item.uploadTime +"</td>"
	                                    +"<td>"+item.downloadIntegral +"</td>"
	                                    +"<td>"+item.documentType +"</td>"  
	                                    +"<td>"+item.down         +"</td>"  
	                      		  	+"</tr>"   
	                        	+"</tbody>");
	                    		
	                    })
	            }
	   
	    });
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
       <form class="layui-form layui-col-md12 x-so">
<!--           <input class="layui-input" placeholder="开始日" name="start" id="start">
          <input class="layui-input" placeholder="截止日" name="end" id="end"> -->
          <input type="text" name="itemName"  value="" placeholder="请输入项目名" autocomplete="off" class="layui-input">
          <input type="text" name="peakPrice" value=""  placeholder="请输入最低价格" autocomplete="off" class="layui-input">
          <input type="text" name="bottomPrice"  value="" placeholder="请输入最高价格" autocomplete="off" class="layui-input">
          <input name="page" type="hidden" value="1">        
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
     <%--  <form id="fileForm" name="fileform" method="post" action="<%=path %>Order/addOrder.action"> --%>  
      <xblock> <%-- onclick="window.location.href='<%=path %>Order/addOrder.action?setItem=${setItem}'" --%>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量添加</button>
  <!--     	<input type= "submit" /> -->
        <button class="layui-btn"  data-toggle="modal" data-target="#myModal" ><i class="layui-icon"></i>添加</button>
        <span> 更改套餐名：<a data-toggle="modal" data-target="#editModal">${setmeal} </a>   </span>
        <span class="x-right" style="line-height:40px">共有数据：${sum } 条</span>
      </xblock>
  
      <table class="layui-table" width="100%" style="table-layout:fixed;">
        <thead>
          <tr>
            <th width="5%">
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th width="5%">序列</th>
            <th width="10%">项目</th>
            <th width="8%">单价</th>
            <th>简介</th>
            <th width="15%">操作</th>
        </thead>
        <tbody>
        <c:forEach items="${itemList }" var="item" varStatus="i">
          <tr>
            <td>
             <input type="checkbox" name="setItem" id="setItem" value="${item.itemId }"  />
           <%--    <div class="layui-unselect layui-form-checkbox" name="setItem" id="setItem" value="${item.itemId }"   lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div> --%>
            </td>
            <td>${i.index+1 }</td>
            <td>${item.item }</td>
            <td>${item.price }</td>
            <td style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">${item.introd }</td>
            <td class="td-status">
                 <%-- <span class="layui-btn layui-btn-normal layui-btn-mini" id="myModal" onClick="myModal(${item.itemId})">查看详情</span> --%>
                  <span class="layui-btn layui-btn-normal layui-btn-mini"><a onclick="return confirm('确认删除?')"   href="<%=path %>Order/deleteItem.action?comId=${list.tblSetCom.comId}&setmealId=${setmealId}">删除 </a></span>
	        </td>
          </tr> 
      </c:forEach>  
     </tbody> 
     </table>      
  	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						套餐名字：${setmeal}
					</h4>
				</div>
		<form method="post" action="<%=path%>Order/addItem.action?setmealId=${setmealId}" enctype="multipart/form-data">				
			<div class="modal-body">
			<!-- class="layui-table" -->		
			<table class="layui-table">
				<thead>
					<tr>
						<th  width="3%">
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						<th  width="13%">项目序号</th>
						<th  width="13%">项目名称</th>
						<th  width="13%">项目单价</th>
						<th >项目简介</th>
				</thead>
				<tbody>
			
					<c:forEach items="${allList}" var="list" varStatus="vs">
						<tr>
							<td>
								<!-- <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'>
									<i class="layui-icon">&#xe605;</i>
								</div> -->
								   <input type="checkbox" name="itembox" id="itembox" value="${list.itemId }"  />
							</td>
							<td>${ (currentPage) *5+(vs.index+1)}</td>
							<td>${list.item }</td>
							<td>${list.price}</td>
							<c:set var="quesdes" value="${fn:substring(list.introd, 0, 25)}" />	
							<td style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">${quesdes }</td>													
						</tr>
					</c:forEach>
			
				</tbody>
			</table>
		 </div>	
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" value="提交" class="btn btn-primary">
						<!-- <button type="submit" class="btn btn-primary"> 提交 </button>-->
					</div>
				</form>	
				<div class="page">
			<div>
				当前：第 ${currentPage } 页/ 共 ${totalPage} 页 <a class="num"
					href="<%=path %>Order/showOrder.action?currentPage=1&setmeal=${setmeal}">首页</a> <a class="prev"
					href="<%=path %>Order/showOrder.action?currentPage=${(currentPage-1)>0?currentPage-1:1}&setmeal=${setmeal}">上一页</a>
				<a class="next"
					href="<%=path%>Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}&setmeal=${setmeal}">下一页</a>
				<a class="num" href="<%=path %>Order/showOrder.action?currentPage=${totalPage}&setmeal=${setmeal}">末页</a>
				<input type="text" id="currentPage" name="code" style="width: 50px; height: 40px;" autocomplete="off" /> <a
					class="num" id="linkToCart" href="">跳转</a>
			</div>
		</div>
			</div>
			<!-- /.modal-content -->
		</div>

      </div>  
        
        	<!-- 更改名字模态框（Modal） -->
	<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px">
			<div class="modal-content">
		<%-- 		<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">
						套餐名字：${setmeal}
					</h4>
				</div> --%>
			<form method="post" action="<%=path%>Order/updateItem.action?setmealId=${setmealId}" enctype="multipart/form-data">								
			<div class="modal-body">
               		 套餐名字：<input type="text" id="setmeal" name="setmeal" value="${setmeal}">     	 
				
	     	</div>	
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input type="submit" value="提交" class="btn btn-primary">
						<!-- <button type="submit" class="btn btn-primary"> 提交 </button>-->
					</div>
				</form>	
			</div>
			<!-- /.modal-content -->
		</div>

      </div> 
     
     <!--  </form> -->
   	<div class="page">
			<div>
				当前：第 ${currentPage } 页/ 共 ${totalPage} 页 <a class="num"
					href="<%=path %>Order/showOrder.action?currentPage=1&setmeal=${setmeal}">首页</a> <a class="prev"
					href="<%=path %>Order/showOrder.action?currentPage=${(currentPage-1)>0?currentPage-1:1}&setmeal=${setmeal}">上一页</a>
				<a class="next"
					href="<%=path%>Order/showOrder.action?currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}&setmeal=${setmeal}">下一页</a>
				<a class="num" href="<%=path %>Order/showOrder.action?currentPage=${totalPage}&setmeal=${setmeal}">末页</a>
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
        });
      }
    </script>
</body>
</html>