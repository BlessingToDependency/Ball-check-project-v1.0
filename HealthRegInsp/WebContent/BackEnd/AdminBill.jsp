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
<title>账单管理</title>
 <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <link href="<%=path%>css/bootstrap.min.css" rel="stylesheet" />
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="<%=path%>js/bootstrap.min.js"></script>
	<script type="text/javascript">
	/* 进入授权界面 */
	function myModal(billId,companyId){
		//alert(itemId);	
		$.ajax({
			type: "post",
            url: "<%=path%>userBillAction/refundCause.action",
            dataType: "json",
            data: {billId: billId, 
            	companyId:companyId,//发送的数据部分                       
            },
            success: function(reData){//接受后台发送的数据
                    //alert(reData.money);
                    //alert(reData.bill.billId);
                   /*  var jsonObj=eval("("+reData+")");
                    alert(jsonObj); */
                     var html = '' ;
                    html+="<div class='layui-form-item'><label class='layui-form-label'>账单ID:</label><div class='layui-input-block'>"
                    html+="<input type='text' name='billId' lay-verify='title' autocomplete='off' value='"+reData.bill.billId+"' class='layui-input' readonly></div></div>"
                    html+="<div class='layui-form-item'><label class='layui-form-label'>退款金额:</label><div class='layui-input-block'>"
                    html+="<input type='text' name='actCharge' lay-verify='title' autocomplete='off' value='"+reData.money+"' class='layui-input' readonly></div></div>"
                    html+="<div class='layui-form-item'><label class='layui-form-label'>退款理由:</label> <div class='form-group'>"
                    html+="<textarea class='form-control' rows='3' name='causeInfo'placeholder='请输入退款理由！'></textarea></div></div>"
                    var html2="";
                    html2+=" <button type='button' class='btn btn-primary' id='authoritysubmit'>提交申请</button>";
                    html2+=" <button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>";
                    
                    $("#authorityBody").empty().append(html); 
                    $("#perbutton").empty().append(html2);
                    $("#AuthorityTitle").text("申请退款原因");
                    $("#myModal").modal('show');	            
            }	   
    });
		}
	</script>
</head>
<body>
 <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="<%=path%>FrontEnd/user_index.jsp">首页</a>
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
           <input class="layui-input" placeholder="${startTime }" value="${startTime }"name="startTime" id="startTime" readonly>
          <input class="layui-input" placeholder="${endTime }" value="${endTime }"name="endTime" id="endTime" readonly> 
          <input name="page" type="hidden" value="1">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
       <!-- <button class="layui-btn layui-btn-danger" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
       <button class="layui-btn" onclick="addItem()"><i class="layui-icon"></i>添加</button> -->
        <span class="x-right" style="line-height:40px">共有数据：${sum } 条</span>
      </xblock>
      <table class="layui-table" width="100%" style="table-layout:fixed;">
        <thead>
          <tr>
            <th width="5%">退款序列</th>
            <th width="10%">退款金额</th>
            <th width="40%">退款理由</th>
            <th width="15%">退款状态</th>
            <th width="30%">操作</th>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="li" varStatus="i">
          <tr>
            <td>${i.index+1 }</td>
            <td>${li.reAmount }</td>
            <td>${li.reInfo }</td>
            <td>${li.paramBean.param }</td>    
            <td class="td-status">
            <c:if test="${li.paramBean.param eq '尚未退款'}">
           <a href="<%=path%>userCheckOut/refund.action?refundId=${li.refundId }&billId=${li.billId }&actCharge=${li.reAmount }&causeInfo=无&soleId=1">
               <span class="layui-btn layui-btn-normal layui-btn-mini" >确认退款</span>
	       	</a>
	       	</c:if>
	       	<c:if test="${li.paramBean.param eq '退款完毕'}">
	       	<%-- <a href="<%=path%>userCheckOut/refund.action?billId=${li.billId }&actCharge=${li.actCharge }&causeInfo=无&soleId=1">
               <span class="layui-btn layui-btn-normal layui-btn-mini" onClick="myModal(${li.billId },${li.companyId })">申请退款</span>  --%>
	       <%-- 	<span class="layui-btn layui-btn-normal layui-btn-mini" onClick="myModal(${li.billId },${li.companyId })">申请退款</span> --%>
	       	<!-- </a> -->
	       	</c:if> 
	        </td>
          </tr>  
          </c:forEach>           
        </tbody>
      </table>
      <div class="page">
        <div>    	
        	共${p }页/当前第${page }页
          <a class="num" href="<%=path %>userBillAction/billInfo.action?page=1&startTime=${startTime }&endTime=${endTime }&paramId=">首页</a>
          <a class="num" href="<%=path %>userBillAction/billInfo.action?page=${page - 1}&startTime=${startTime }&endTime=${endTime }&paramId=">上一页</a>
          <a class="num" href="<%=path %>userBillAction/billInfo.action?page=${page + 1}&startTime=${startTime }&endTime=${endTime }&paramId=">下一页</a>
          <a class="num" href="<%=path %>userBillAction/billInfo.action?page=${p}&startTime=${startTime }&endTime=${endTime }&paramId=">末页</a>
        </div>
      </div>
    </div>
      <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				     <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" 
						aria-hidden="true">×
					</button>
                    <h4 class="modal-title" id="AuthorityTitle"></h4>
                </div>
                <div class="modal-body" id="authorityBody">
                  
                </div>
                <div class="modal-footer" id="perbutton">
                    <!-- <input name="" class="btn btn-primary" type="submit" value="授权"> -->
                   <button type="button" class="btn btn-primary" id="authoritysubmit" onClick="accredit()">授权</button> 
                   <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
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