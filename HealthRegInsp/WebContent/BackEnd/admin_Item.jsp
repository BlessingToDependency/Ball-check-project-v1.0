<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
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
	            url: "<%=path %>adminLitemAction/activity.action",
	            dataType: "json",
	            data: {itemId: itemId, //发送的数据部分                       
	            },
	            success: function(reData){//接受后台发送的数据
	                    //alert(reData.page);
	                   /*  var jsonObj=eval("("+reData+")");
	                    alert(jsonObj); */
	                    //清空div里的内容
	                    $("#myModal0").empty();
	                    $("#myModal0").prepend("<div class='modal-footer'>"
	                    		+"<button type='button' class='btn btn-default'"
	                    		+"data-dismiss='modal'>关闭</button></div>"
	                    	)
	                    $.each(reData.termList, function (i, item0) { 
	                    	//alert(item0.term);
	                    	$("#myModal0").prepend("<div class='modal-body'>"+item0.term+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"             
	                    		+item0.downLimit+item0.upLimit+item0.measur
	                    		+"</div>"
	                    	)
	                    });
	                    $("#myModal0").prepend("<div class='modal-body'>--项目细项--</div>");
	                    $.each(reData.list, function (i, item) { 
	                    	//alert(item.item);
	                    	$("#myModal0").prepend("<div class='modal-header'>"
	                    		+"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>" 
        						+"<h4 class='modal-title' id='myModalLabel'>项目名："+item.item +"</h4></div>"
								+"<div class='modal-body'>单价："+item.price +"元</div>"
								+"<div class='modal-body'>简介："+item.introd +"</div>"
	                    	)
	                    });
	                   
	                    $('#myModal').modal('show');
        				
	            }
	   
	    });
			}
		function addItem(){
			$.ajax({
				type: "post",
	            url: "<%=path %>adminLitemAction/selectAllTerm.action",
	            dataType: "json",
	            data: { //发送的数据部分                       
	            },
	            success: function(reData){//接受后台发送的数据
	            	//alert(reData)
	            	$("#myModal0").empty();
	                $("#myModal0").prepend("</div></div></form><div class='modal-footer'>"
	                		+"<button type='button' class='btn btn-default'"
	                		+"data-dismiss='modal'>关闭</button></div>"
	                		
	                	)
					
	            	$.each(reData, function (i, item) { 
	                	//alert(item0.term);
	                	//console.log(item.term)
	                	$("#myModal0").prepend("<input type='checkbox' name='like1[read]' lay-skin='primary' title='阅读'>"
	                	)
                    	
		                
                    }); 
	                	$("#myModal0").prepend("<div class='modal-header'>"
	                		+"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>" 
	   						+"<h4 class='modal-title' id='myModalLabel'>添加项目</h4></div>"
	                		+"<form class='layui-form' action=''>"
	   						+"<div class='layui-form-item'><label class='layui-form-label'>项目名称</label><div class='layui-input-block'>"
	                		+"<input type='text' name='term' lay-verify='title' autocomplete='off' placeholder='请输入项目名称' class='layui-input'></div></div>"
	                		+"<div class='layui-form-item'><label class='layui-form-label'>下限值</label><div class='layui-input-block'>"
	                		+"<input type='text' name='downLimit' lay-verify='title' autocomplete='off' placeholder='请输入下限值' class='layui-input'></div></div>"
	                		+"<div class='layui-form-item'><label class='layui-form-label'>上限值</label><div class='layui-input-block'>"
	                		+"<input type='text' name='upLimit' lay-verify='title' autocomplete='off' placeholder='请输入上限值' class='layui-input'></div></div>"
	                		+"<div class='layui-form-item'><label class='layui-form-label'>计量单位</label><div class='layui-input-block'>"
	                		+"<input type='text' name='measur' lay-verify='title' autocomplete='off' placeholder='请输入计量单位' class='layui-input'></div></div>"
	                		+"<div class='layui-form-item' pane=''>" 
	                		+"<label class='layui-form-label'>细项选择</label>"
	                		+"<div class='layui-input-block'>"
	                	)	                	
	                $('#myModal').modal('show');
	                	layui.use('form', function () {
	                        var form = layui.form;
	                        form.render('checkbox');
	                    });
	            }
			})	
	}
		
	</script>
	<script>
layui.use('form', function(){
  var form = layui.form;
  form.render('checkbox'); //刷新select选择框渲染
  //各种基于事件的操作，下面会有进一步介绍
});
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
          <input type="text" name="itemName"  placeholder="${itemName }" autocomplete="off" class="layui-input">
          <input type="text" name="peakPrice"  placeholder="${peakPrice }" autocomplete="off" class="layui-input">
          <input type="text" name="bottomPrice"  placeholder="${bottomPrice }" autocomplete="off" class="layui-input">
          <input name="page" type="hidden" value="1">
          
  
          
          
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <button class="layui-btn" onclick="addItem()"><i class="layui-icon"></i>添加</button>
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
            <th width="5%">单价</th>
            <th>简介</th>
            <th width="30%">操作</th>
        </thead>
        <tbody>
        <c:forEach items="${list }" var="item" varStatus="i">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
            <td>${i.index+1 }</td>
            <td>${item.item }</td>
            <td>${item.price }</td>
            <td style="text-overflow:ellipsis;white-space:nowrap;overflow:hidden">${item.introd }</td>
            <td class="td-status">
                 <span class="layui-btn layui-btn-normal layui-btn-mini">修改</span>
                 <span class="layui-btn layui-btn-danger">删除</span>
                 <span class="layui-btn layui-btn-normal layui-btn-mini" onClick="myModal(${item.itemId})">查看详情</span>
                 <%-- <span class="layui-btn layui-btn-danger" data-toggle="modal" data-target="#myModal${i.index+1 }">查看详情</span> --%>
	        </td>
          </tr>             
          </c:forEach>
            
        </tbody>
      </table>
      <div class="page">
        <div>    	
        	共${p }页/当前第${page }页
          <a class="num" href="<%=path%>adminLitemAction/selectItem.action?page=1&itemName=${itemName}&peakPrice=${peakPrice}&bottomPrice=${bottomPrice}">首页</a>
          <a class="num" href="<%=path%>adminLitemAction/selectItem.action?page=${page - 1}&itemName=${itemName}&peakPrice=${peakPrice}&bottomPrice=${bottomPrice}">上一页</a>
          <a class="num" href="<%=path%>adminLitemAction/selectItem.action?page=${page + 1}&itemName=${itemName}&peakPrice=${peakPrice}&bottomPrice=${bottomPrice}">下一页</a>
          <a class="num" href="<%=path%>adminLitemAction/selectItem.action?page=${p}&itemName=${itemName}&peakPrice=${peakPrice}&bottomPrice=${bottomPrice}">末页</a>
        </div>
      </div>
    </div>
      <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content" id="myModal0">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
				</button>
				<h4 class="modal-title" id="myModalLabel">
					简介：${item.item }
				</h4>
			</div>
			<div class="modal-body">
				单价：${item.price } 元
			</div>
			<div class="modal-body">
				简介：${item.introd }
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" 
						data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

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