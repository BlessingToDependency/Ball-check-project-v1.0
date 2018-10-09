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
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="<%=path%>/css/font.css">
<link rel="stylesheet" href="<%=path%>/css/xadmin.css">
<link rel="stylesheet" href="<%=path%>lib/layui/css/layui.css" media="all">
<script type="text/javascript" src="<%=path%>js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 x-so" action="<%=path%>Order/showOrder.action">
				<input type="text" name="setmeal" value="${setmeal}" placeholder="请输入套餐名" autocomplete="off"
					class="layui-input">
				<button class="layui-btn" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
		<button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn" data-toggle="modal" data-target="#myModal">
			<i class="layui-icon"></i>添加
		</button>

		 <%--   <button class="layui-btn" onclick="x_admin_show('添加用户','<%=path %>Order/addItem.action')"><i class="layui-icon"></i>添加</button> --%>
		<span class="x-right" style="line-height: 40px">共有数据：${count } 条</span> </xblock>
		<form id="fileForm" name="fileform" method="post" action="fileShow.action">
			<table class="layui-table">
				<thead>
					<tr>
						<th>
							<div class="layui-unselect header layui-form-checkbox" lay-skin="primary">
								<i class="layui-icon">&#xe605;</i>
							</div>
						</th>
						<th>套餐ID</th>
						<th>套餐名字</th>
						<th>套餐折扣</th>
						<th>套餐销量</th>
						<th>操作</th>
				</thead>
				<tbody>
					<c:forEach items="${orderList}" var="list" varStatus="vs">
						<tr>
							<td>
								<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${list.setmealId }'>
									<i class="layui-icon">&#xe605;</i>
								</div>
							</td>

							<td>${ (currentPage-1) *5+(vs.index+1)}</td>
							<td>${list.setmeal }</td>
							<td>${list.discount }</td>
							<td>${list.salsvolume }</td>
							<%--      onclick="x_admin_show('编辑','<%=path %>Order/showItem.action?setmealId=${list.setmealId }')"   data-toggle="modal" data-target="#myModal" onclick="info(${list.setmealId })"--%>
							<td class="td-status" align="center">
								<!--  <span class="layui-btn layui-btn-normal layui-btn-mini">增加</span> --> <span
								class="layui-btn layui-btn-warm  layui-btn-mini"><a onclick="return confirm('确认删除?')"
									href="<%=path %>Order/delteOrder.action?setmealId=${list.setmealId }">刪除</a></span> <span
								class="layui-btn layui-btn-primary"> <a
									href="<%=path %>Order/showItem.action?setmealId=${list.setmealId }&setmeal=${list.setmeal}">修改</a></span> <!--  <span class="layui-btn layui-btn-danger  layui-btn-mini">查看</span> -->
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
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
					<input type="hidden" id="totalPage" value="${totalPage}" >
			</div>
		</div>

	</div>
          <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<!-- <h4 class="modal-title" id="myModalLabel">
					套餐名字：<input name="orderName" type="text">
				</h4> -->
			</div>
		<form method="post" action="<%=path %>Order/addOrder.action?" enctype="multipart/form-data" class="layui-form">
			<div class="modal-body"> 
		
				套餐名字：<input name="setmeal" type="text" id="orderName" class="layui-input" lay-verify="required" ><span id="hiden"></span>			
			</div>
			<div class="modal-body">
				套餐折扣：<input name="discount" type="text" class="layui-input" lay-verify="required">
			</div>
			<div class="modal-body">
				套餐图片：<input name=myPic type="file" class="layui-input" lay-verify="required">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" 
						data-dismiss="modal">关闭
				</button>
				<input type="submit" value="提交" class="layui-btn" lay-filter="*" lay-submit id="checkName"> 
				<!-- <button type="submit" class="btn btn-primary"> 
                   	 提交
                </button>-->
			</div>
		</form>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script>
	  /*添加套餐除重*/
    $(document).ready(function(){	
    	  $("#orderName").blur(function(){
    		$.ajax({
    			url:"<%=path%>Order/checkOrderName.action",
    		    data:"setmeal="+$("#orderName").val(),
    		    type:"post",
    		    dataType:"json",
    		    success:function(redata){
    		    	if(redata==1){
    		    		$("#hiden").css("color", "green");
    		    		$("#hiden").html("套餐名可用");	
    		    		document.getElementById('checkName').disabled=false;
    		   		}else{
    		   			$("#hiden").css("color", "red");
    		    		$("#hiden").html("套餐已存在");	
    		    		document.getElementById('checkName').disabled=true;
    		   		}
    		    }
    		   });
    		});
    	});
    </script>
	<script>
</script>
	<script type="text/javascript">
    $(document).ready(function(){
       //点击链接的时候调用
      $("#linkToCart").click(function(){
          //得到input的值
          var currentPage = $("#currentPage").val();
          var  totalPage  = $("#totalPage").val();
          if(currentPage>totalPage){
        	
        	  return;
          }else{
        	//设置linkToCart的href的值
              $("#linkToCart").attr("href","<%=path%>Order/showOrder.action?currentPage="+currentPage);
          }
          
      });
    });
    
    function delAll (argument) {

        var setmealId = tableCheck.getData();
  
        layer.confirm('确认要删除吗？'+setmealId,function(index){
            //捉到所有被选中的，发异步进行删除
            layer.msg('删除成功', {icon: 1});
            $(".layui-form-checked").not('.header').parents('tr').remove();
            window.location.href="<%=path %>Order/delteOrder.action?setmealId="+setmealId;
        });
      }
    
</script>
	<script type="text/javascript">
	function info(id){
	$.ajax({
		url:"<%=path%>Order/showItem.action",
		data : "setmealId=" + id,
		dataType : "json",
		type : "POST",
		success : function(str) {
							$.each(str,function(i, data) {
								alert(data.itemId)
							/* 	  <div class="modal-body"> 项目名称：<input type="text" id="item" value=""> </div> */
							/* 	$("#itemId").append("<option value ="+item.adminId+">"+item.adminName+"</option>"); */
							/* 	$("#itemId").append("<textarea value ='itemId'>"+data.itemId+"</textarea>"); */
							/* 	$("#itemId").val(data.itemId);	
							$("#item").val(data.item);	
							$("#price").val(data.price);	 */
							/* 	 	$("#itemId").append('<input type="text"  value='+data.itemId+">"); */
							/* 	$("#item").append('<input type="text" id="item" value="'data.item '">');  */
						$("#itemId").append(
					"<input type='text' id='itemId' value='"+data.itemId+"'/>");
				});
			}
		});
	};
	</script>
</body>

</html>