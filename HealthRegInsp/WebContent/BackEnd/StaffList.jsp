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
    <title>公司体检人员开单</title>
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
		#partYear+div input{
		display:none;
		}
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
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
    </div>
    
    <div class="x-body">
        <form id="myform" name="myform" method="post" action="<%=path %>openBillAction/staff.action">
        <input type="hidden" name="companyId" id="companyId" value="${batchSheetCon.companyId}"/>
        <div id="div">
          <input type="text" id="staffName" name="staffName" style="width:80%;" placeholder="姓名" autocomplete="off" class="layui-input" value="${batchSheetCon.staffName==null?"":batchSheetCon.staffName}">
        </div>
       
        <div id="div">
          <select id="partYear" name="partYear" style="width:90%;height:40px;" value="${batchSheetCon.partYear==null?"":batchSheetCon.partYear}">
          <option value="">年份</option>
           <c:forEach items="${years}"  var="year" step="1" varStatus="vs">
           <option value="${year}" ${batchSheetCon.partYear==year ? 'selected = "selected"':''}>${year}</option>
           </c:forEach>
          </select>
          </div>
          
          <div id="div">
          <select id="batch" name="batch" style="width:90%;height:40px;" value="${batchSheetCon.batch==null?"":batchSheetCon.batch}">
          <option value="0">批次</option>
           <option value="${batchSheetCon.batch}" ${batchSheetCon.batch==null ? '':'selected = "selected"'}>${batchSheetCon.batch}</option>
          </select>
          </div>
          <button class="layui-btn" type="submit" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      <xblock>
        <button class="layui-btn layui-btn-normal" onclick="delAll()"><i class="layui-icon"></i>批量删除</button>
        <span class="x-right" style="line-height:40px">共有数据:${allRecord}条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>名字</th>
            <th>年龄</th>
            <th>性别</th>
            <th>身份证号</th>
            <th>联系方式</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${staffList}"  var="list" step="1" varStatus="vs">
			<tr>
			  <td>
              <div class="layui-unselect layui-form-checkbox" name="ch" lay-skin="primary" data-id='${list.staffId}'><i class="layui-icon">&#xe605;</i></div>
               </td>
			   <td>${vs.index+1}</td>
			   <td>${list.staffName}</td>
			   <td>${list.age}</td>
			   <td>${list.sex}</td>
			   <td>${list.idNum}</td>
			    <td>${list.phone}</td>
	       	   <td class="td-status">
                <span class="layui-btn layui-btn-danger" style="width:80px;" onclick="openBill(${list.staffId});">开单</span>
	           </td>
			</tr>
			</c:forEach>
        </tbody>
      </table>
       
        <div class="page">
        <div>
      当前：第  ${pageNo} 页/ 共 ${AllPage} 页
          <a class="num" href="<%=path %>openBillAction/staff.action?pageNo=1&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}">首页</a>
          <a class="prev" href="<%=path %>openBillAction/staff.action?pageNo=${pageNo-1}&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}" onclick="return chageNO(this)">上一页</a>
          <a class="next" href="<%=path %>openBillAction/staff.action?pageNo=${pageNo+1}&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}" onclick="return chageNE(this)">下一页</a>
          <a class="num" href="<%=path %>openBillAction/staff.action?pageNo=${AllPage}&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}">末页</a>
          <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
        </div>
      </div>


    </div>
</body>
 <script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
 <script>
$(document).ready(function(){
        //ajax判断
  		$("#partYear").change(function(){
				$.ajax({
					url:"<%=path%>openBillAction/getBatchNum.action",//请求地址
					data:"partYear="+$("#partYear").val()+"&companyId="+$("#companyId").val(),//发送至服务器的键值数据
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
 /*    $(document).on('change','#partYear',function(){
    	  alert(000);
       });  */
      function delAll (argument) {

        var data = tableCheck.getData();
  
        layer.confirm('确认要吗？'+data,function(index){
        	//年份
        	var partYear=document.getElementById("partYear").value;
        	//批次号
        	var batchNum=document.getElementById("batch").value;
        	//公司ID
        	var companyId=document.getElementById("companyId").value;
            window.location.href="<%=path%>openBillAction/batchOpenBill.action?partYear="+partYear+"&companyId="+companyId+"&batchNum="+batchNum+"&data="+data;
        });
      }
</script>
<script type="text/javascript">
//跳转页码
function jump(){
	var p=document.getElementById("pageNo").value;
	window.location.href="<%=path%>openBillAction/staff.action?pageNo="+p+"&companyId=${batchSheetCon.companyId}&batch=${batchSheetCon.batch}&staffName=${batchSheetCon.staffName}";
}
//开单
function openBill(v){
	//人员ID
	var staffId=v;
	//年份
	var partYear=document.getElementById("partYear").value;
	//批次号
	var batchNum=document.getElementById("batch").value;
	//公司ID
	var companyId=document.getElementById("companyId").value;
	window.location.href="<%=path%>openBillAction/openBill.action?partYear="+partYear+"&companyId="+companyId+"&batchNum="+batchNum+"&staffId="+staffId;
}

//启用弹窗确认
function disable(){
	 var r=confirm("确定启用该用户吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
//禁用弹窗确认
function disable(){
	 var r=confirm("确定要禁用该用户吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
//重置弹窗确认
function resPwd(){
	 var r=confirm("确定要重置该用户的密码吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
}
//删除弹窗确认
function dele(){
	 var r=confirm("确定要删除该用户吗？")
	 if(r==true){
		 return true;
	 }
	 return false;
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