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
     .zt{width:600px;  color: blcak;font-size: 70px;border:blue 0px solid;font-weight: 10px;margin: 100px 0px 10px 250px;text-align:left;line-height:150px;letter-spacing:5px;}
         #div{width:600px; height:1000px;font-size: 30px;   margin: 100px 0px 10px 250px;border:red 0px solid;line-height:60px; float:left;text-align:left;letter-spacing:2px;}
          #div2{width:800px; height:1500px;font-size: 25px;margin: 0px 100px 10px 100px;border:red 0px solid;line-height:60px; float:left;text-align:left;letter-spacing:2px;}
       .zt1{width:600px; height:70px; color: blcak;font-size: 70px;border:red 0px solid;font-weight: 10px;margin: 0px 0px 100px 190px;text-align:left;letter-spacing:35px;}    
	</style>
  </head>
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
     <button class="layui-btn layui-btn-warm" onclick="javascript:history.back(-1)">返回</button>
      </span>
      <img alt="dyj" src="<%=path%>images/dyj.png" onclick="daying();">
     <%--   111<img alt="dyj" src="<%=path%>images/dyj.png" onclick="print();"> --%>
       <!--   <button id="dy" name="name" onclick="print2();">打印</button>  -->
 <!--      //<button id="dy" name="name" onclick="daying();">打印</button> -->
    </div>
    <div class="x-body" id="dadad">  
    <!--startprint-->     
      <xblock>
        <span class="x-right" style="line-height:40px"></span>
      </xblock>
      
       <table class="layui-table">
       		<!-- 	<thead>
     			   <tr>
                   <th>健康体检中心</th>     
                   </tr>   
        		</thead> -->
        				<tr>
								<td >
								<div id="div">
									<div>团    体： ${staffBean.userBean.company}</div>
								    <div>团体序号： ${staffBean.companyId} </div>
								    <div>体检号码：${staffBean.myGuChId}        </div>
    								<div>姓    名：${staffBean.staffName}    	&nbsp;&nbsp;&nbsp;&nbsp;  性    别：${staffBean.sex}     </div>
   									<div>年    龄： ${staffBean.age}   	&nbsp;&nbsp;&nbsp;&nbsp; 手    机：${staffBean.phone}     </div>
   								</div>  	  
   								<!-- 	<br/><span></span><br>									
									<br/><span></span><br> -->
										<br/><span></span><br>	
										<br/><span></span><br>					
    							 
    							    <div class ="zt">健康体检中心</div>	  						
    							    <div  class ="zt1">体   检   报   告</div>		
    							   
    						       														
								
							  </td>													
						</tr>	
				<thead>
        		</thead>
        				<tr>
								<td >
								<div id="div2">
									<div>尊敬的:${staffBean.staffName}先生/女士</div>
								    <div>    感谢您来到厦门协和医院进行健康体检 </div>
    								<div>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;为了增加您对健康体检的认识，我们再次特别向您说明，健康体检的目的在于及时了解自身的健康状况，
    								提高健康保健意识，如果此次检查在正常范围内，值表示您选择的体检项目所反映的身体健康状态，由于体
    								检手段及项目所限，并不能完全排除身体潜在疾病，若有疾病症状出现，请您及时到医院就医。</div>
   									<div>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“健康是人生最高贵的”。不良的生活习惯和行为会损坏您的健康，我们真诚希望您保持科学健康的生活
   									方式，定期接受健康检查，在您最需要的时候随时与我们联系，欢迎您再次光临传一医院。</div>
    							        <div>祝您，健康快乐！		</div>															
								</div>
							  </td>													
						</tr>													
			</table>     
      
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
							<td height="33"><textarea name="proposal" cols="150" readonly="readonly"> ${totalBean.proposal}</textarea>								
							</td>
							
						</tr>
						<tr>
							<td>[建议:]</td>
						</tr>
						<tr>
							<td ><textarea name="suggest" cols="150" readonly="readonly">${totalBean.suggest}</textarea></td>
						</tr>
					<thead>
     			  		<tr>
                   		<th>生活保健指导</th>     
                  		</tr>    
        			</thead>							
						<tr>
							<td><textarea name="lifeGuid" cols="150">${totalBean.lifeGuid}</textarea></td>
						</tr>					
					</table>  

	<!--endprint-->
    </div>
</body>
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

function print(){

	var bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
	var startStr="<!--startprint-->";//设置打印开始区域 
	var endStr="<!--endprint-->";//设置打印结束区域 
	var printHtml=bdhtml.substring(bdhtml.indexOf(startStr)+startStr.length,bdhtml.indexOf(endStr));//从标记里获取需要打印的页面 
	window.document.body.innerHTML=printHtml;//需要打印的页面 
	window.print(); 
//	document.execCommand("print");
	window.document.body.innerHTML=bdhtml;//还原界面 
	location.reload();
}


function print2(){
	var bdhtml=window.document.body.innerHTML;//获取当前页的html代码 
	var startStr="<!--startprint-->";//设置打印开始区域 
	var endStr="<!--endprint-->";//设置打印结束区域 
	var printHtml=bdhtml.substring(bdhtml.indexOf(startStr)+startStr.length,bdhtml.indexOf(endStr));//从标记里获取需要打印的页面 
	window.document.body.innerHTML=printHtml;//需要打印的页面 
	window.print(); 
	window.document.body.innerHTML=bdhtml;//还原界面 
	location.reload();
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