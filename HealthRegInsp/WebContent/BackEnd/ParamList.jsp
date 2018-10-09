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
    <title>参数配置</title>
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
    <script src="<%=path%>js/bootstrap.min.js"></script>
     <style>
     .zt{color: #06F;font-size: 18px;font-weight: 10px;}
         #div{width:100%; height:50px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
         #divleft{width:35%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:right;}
         #divright{width:63%; height:48px;margin: 0px 0px 0px 0px;border:blue 0px solid; float:left;text-align:center;}
	</style>
  </head>
  <body>
    <div class="x-nav">
     <input type="hidden" name="coun" id="coun" value=""/>
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
      </div>
      <xblock>
        <button class="layui-btn" onclick="addParam();"><i class="layui-icon"></i>添加</button>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            <th>序号</th>
            <th>参数名</th>
            <th>父级参数ID</th>
            <th>操作</th>
        </thead>
        
        <tbody>
          <c:forEach items="${paramList}"  var="list" step="1" varStatus="vs">
			<tr>
			    <td>${vs.index+1}</td>
			   <td>${list.param}</td>
			   <td>${list.parId}</td>
	       	   <td class="td-status">
                 <span id="up" class="layui-btn layui-btn-normal layui-btn-mini" onclick="addHid(${list.paramId});">修改</span>
                 <a href="<%=path%>adminParamAction/delParam.action?pid=${list.paramId}" ><span class="layui-btn layui-btn-danger" onclick="return disable();">删除</span></a>
	           </td>
			</tr>
			</c:forEach>
        </tbody>
      </table>
       
        <div class="page">
        <div>
      当前：第  ${pageNo} 页/ 共 ${AllPage} 页
          <a class="num" href="<%=path %>adminParamAction/systemParam.action?pageNo=1">首页</a>
          <a class="prev" href="<%=path %>adminParamAction/systemParam.action?pageNo=${pageNo-1}" onclick="return chageNO(this)">上一页</a>
          <a class="next" href="<%=path %>adminParamAction/systemParam.action?pageNo=${pageNo+1}" onclick="return chageNE(this)">下一页</a>
          <a class="num" href="<%=path %>adminParamAction/systemParam.action?pageNo=${AllPage}">末页</a>
          <input type="text" id="pageNo" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" onclick="jump();">跳转</a>
        </div>
      </div>


    </div>


<form id="addfrom" method="post" action="<%=path%>adminParamAction/addParam.action"  class="layui-form">
<button type="button" id="addParam" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2"></button>
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加系统参数</h4>
      </div>
     <!--  <div class="modal-body"> -->
        <div id="div">
             <div id="divleft"><span class="zt">参数:</span></div> 
             <div id="divright">
             <input type="text" id="pname" name="param" style="width:200px;" class="form-control" placeholder="参数名"  lay-verify="required">
             </div>          
        </div>  
        
          <div id="div">
             <div id="divleft"><span class="zt">所属参数:</span></div> 
             <div id="divright">
             <select class="form-control" id="conname" name="conname" style="width:200px;">
                 <option value="0">--父级参数--</option>
                 </select>
             </div>          
          </div>  
             
             
 <!--      </div> -->
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit"  class="layui-btn" lay-filter="*" lay-submit>提交</button>
      </div>
    </div>
  </div>
</div>
</form>	

<form id="myform" method="post" action="<%=path%>adminParamAction/saveParam.action" class="layui-form" >
<button type="button" id="dada" style="display:none" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal"></button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">系统参数修改</h4>
        <input type="hidden" name="co" id="co" value=""/>
      </div>
         <div id="div">
             <div id="divleft"><span class="zt">参数:</span></div> 
             <div id="divright">
             <input type="text" id="pn" name="pn" style="width:200px;" class="form-control" placeholder="参数名"   lay-verify="required">
             </div>          
        </div>  
        
          <div id="div">
             <div id="divleft"><span class="zt">所属参数:</span></div> 
             <div id="divright">
             <select class="form-control" id="paramId" name="paramId" style="width:200px;">
                 <option value="0">--父级参数--</option>
                 </select>
             </div>          
          </div>  
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="layui-btn" lay-filter="*" lay-submit>保存</button>
      </div>
    </div>
  </div>
</div>
</form>	


</body>

<script type="text/javascript">
//跳转页码
function jump(){
	window.location.href="<%=path%>adminParamAction/systemParam.action?pageNo="+p;
}


//添加到隐藏域
function addHid(v){
	$.ajax({
		url:"<%=path%>adminParamAction/updateParam.action",//请求地址
		data:"pid="+v,//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(data){
	    	//得到map中的对象
	    	var dd = data.pb;
	    	var tt = data.piList;
	    	var ff = data.fn;
	    	//展开模态框
	      	$("#dada").trigger("click");
	    	//数据展示到页面中
	   		$("#co").val(dd.paramId);
	 	    $("#pn").val(dd.param);
	 	    $("#parId").val(dd.parId);
	 	    $("#paramId").find("option").remove();
	 	     $("#paramId").append("<option value="+dd.parId+">"+ ff + "</option>");
	    	$.each(tt, function(i, item) {
	    	  $("#paramId").append("<option value="+item.paramId+">"+ item.param+ "</option>");
			});
	  }
	});
} 
//新增参数模态框
function addParam(){
	$.ajax({
		url:"<%=path%>adminParamAction/getParam.action",//请求地址
		data:"pid=123",//发送至服务器的键值数据
		dataType:"json",//请求数据格式，如script,json,text等
		type:"post",//发送方式，get/post
	    success:function(redata){
	    	//展开模态框
	    	$("#addParam").trigger("click");
	    	//移除原有的下拉框内容
	    	$("#conname").find("option").remove();
	    	//添加到下拉框中
	        $("#conname").append("<option value=0>--父级参数--</option>");
			$.each(redata, function(i, item) {
				   $("#conname").append("<option value="+item.paramId+">"+ item.param+ "</option>");
			});

	  }
	});
}
//禁用弹窗确认
function disable(){
	 var r=confirm("确定删除吗？")
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
	 //var all=${allPageNo};
	 if(num>${AllPage}){
		 return false;
	 }
	 return true;
}
</script> 
</html>
