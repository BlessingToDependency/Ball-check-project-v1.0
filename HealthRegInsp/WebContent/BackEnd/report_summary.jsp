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
    <title>公司总结</title>
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
      <a href="<%=path%>openBillAction/massInspList.action"><button class="layui-btn layui-btn-warm">返回</button></a>
        <a href="">首页</a>
        <a href="">演示</a>
        <a>
          <cite>导航元素</cite></a>
      </span>
      <span id="dd" onclick="daying();">打印</span>

      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    
    <div class="x-body" id="dadad">       
      <xblock>
        <span class="x-right" style="line-height:40px"></span>
      </xblock>
      <c:forEach items="${itemMap}"  var="map" step="1">
      <blockquote class="layui-elem-quote">${map.key.litemBean.item} </blockquote>
       <c:if test="${map.key.litemBean.itemId==itemID}">
         <table class="layui-table">
        <thead>
          <tr>
            <th>影像文件</th>
          </tr>
        </thead>
        <tbody>
            <table  width="100%" border="0" cellspacing="0" cellpadding="0" class="main" class="layui-table layui-input-block">
               <tbody>
                 <tr>
                   <c:forEach items="${fileNameList}"  var="fileName" step="1" varStatus="vs">
                    <td>
                       <img src="<%=path%>doctorSummaryAction/getImage.action?fileName=${fileName}&guChId=${staffBean.myGuChId}" id="img2" style="width: 15rem; height: 10rem;">
                    </td>
                    </c:forEach>
                  </tr>
               </tbody>
            </table>

		<thead>
          <tr>
            <th colspan="4">小结：   ${map.key.sumCont}   </th>  
           </tr>     
        </thead>		
        </tbody>
      </table>
       </c:if>
        <c:if test="${map.key.litemBean.itemId!=itemID}">
         <table class="layui-table">
        <thead>
          <tr>
            <th>细项</th>
            <th>结果</th>
            <th>单位</th>
            <th>参考值</th>
         
        </thead>
        <tbody>
          <c:forEach items="${map.value}"  var="list" step="1" varStatus="vs">
			<tr>
			   <td>${list.term}</td>
			   <td>${list.finresultBean.termVal}  </td>
			   <td>${list.measur}</td>
			   <td>${list.none}</td>
			  	       	   
			</tr>
			</c:forEach>
			<thead>
          <tr>
            <th colspan="4">小结：   ${map.key.sumCont}   </th>  
           </tr>     
        </thead>		
        </tbody>
      </table>
      </c:if>
      
     
    </c:forEach>   
        <form action="<%=path%>Report/insertTotall.action?guChId=${staffBean.myGuChId}" method="post">
     		 <table class="layui-table">
				<thead>
     			   <tr>
                   <th>体检总结及建议</th>     
                   </tr>    
        		</thead>
        				<tr>
							<td>[综述:]</td>
						</tr>									
						<tr>
							<td height="33"><textarea name="proposal" cols="180"></textarea>								
							</td>
							
						</tr>
						<tr>
							<td>[建议:]</td>
						</tr>
						<tr>
							<td ><textarea name="suggest" cols="180"></textarea></td>
						</tr>
					<thead>
     			  		<tr>
                   		<th>生活保健指导</th>     
                  		</tr>    
        			</thead>							
						<tr>
							<td><textarea name="lifeGuid" cols="180"></textarea></td>
						</tr>	
						<tr>   <td align="center">
						 
							<input type="hidden" name="companyId" id="companyId" value="${companyId}"/>
						</td></tr>								
					</table>     			
			</form>
    </div>
     <button class="layui-btn" type="submit" lay-filter="sreach"><i class="layui-icon">&#xe615;</i>提交</button>
						   <button class="layui-btn layui-btn-normal" onclick="delAll()"><i class="layui-icon"></i>返回</button>
</body>
 <span id="dd" onclick="daying();">打印</span>
 <script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
 <script>
$(document).ready(function(){
	
        //ajax判断
  		$("#partYear").change(function(){

				$.ajax({
					url:"<%=path%>Report/showBatch.action",//请求地址
					data:"partYear="+$("#partYear").val()+"&"+"companyId="+$("#companyId").val(),//发送至服务器的键值数据
					dataType:"json",//请求数据格式，如script,json,text等
					type:"post",//发送方式，get/post
					success:function(redata) {//定义各事件发生时回调的函数
		
				     	$("#batch").find("option").remove();
					
						$("#batch").append("<option value=0>批次</option>");
						
						$.each(redata, function(i, item) {
							
							$("#batch").append("<option value="+item+">"+ item+ "</option>");
						
						});
					}
				});
  		});
});
</script>
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
            window.location.href="<%=path%>adminManagerAction/batchDel.action?data="+data;
        });
      }
</script>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>openBillAction/staff.action?pageNo="+p+"&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}";
}
//启用弹窗确认
function daying(){
	 var sText = document.getSelection().toString();
	/*  var obj = document.execCommand("insertHTML",false, "<div class='x-body' id='dadad'>" + sText + "</div>"); */
	var obj = document.getElementById("dadad");
	var newStr = obj.outerHTML;  
	 var oldStr = document.body.innerHTML;  
	 document.body.innerHTML = newStr;  
	 document.execCommand("print");
	 document.body.innerHTML = oldStr; 
}

function printObj(obj) { 
    var newStr = obj.outerHTML;  
    var oldStr = document.body.innerHTML;  
    
    document.body.innerHTML = newStr;  
    document.execCommand("print"); 
    document.body.innerHTML = oldStr;  
    return false;  
  }  

//启用弹窗确认
function disable(){
	 var r=confirm("确定启用该用户吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
</script> 
</html>