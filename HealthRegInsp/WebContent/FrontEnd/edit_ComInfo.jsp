<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑公司信息</title>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
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
    
 <meta name="keywords" content="" />

<meta name="description" content="" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/999.css" /> 



<%-- <script type="text/javascript" src="<%=basePath%>js/org1470120033.js" data-main="baseMain"></script> --%>

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=6">

<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/list.php?tid=6";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>


</head>
<body >
<div id="header">

  <div class="content">

   <a href="/" id="logo"><img src="<%=path%>images/lo.png" height="40" /></a>

    <ul id="nav">
      <li class="navitem"><a  class='active' href="<%=path %>userMainAction/showSetmeal.action">首页</a></li>
      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action" >我的账户</a>
        <ul class="subnav">
        </ul>
      </li>
      
       <li class="navitem"><a  href="<%=path%>myCompAction/selectCompInfo.action" >公司简介</a>
      
      </li>
      
      <li class="navitem">
      <a  href="<%=path %>fileAction/fileDownLoad.action" >下载体检信息模板</a>
        <ul class="subnav">
        </ul>
      </li>
	   <li class="navitem">
      <a  href="<%=path %>fileAction/userUpload.action" >上传体检人员信息</a>
        <ul class="subnav">
        </ul>
      </li>
      <li class="navitem"><a  href="<%=path %>fileAction/companyStaffList.action" >配置套餐</a>
        <ul class="subnav">
        </ul>
      </li><li class="navitem"><a  href="<%=path%>userLoginAction/jumpLogin.action" >去登陆</a>
        <ul class="subnav">
        </ul>
      </li>
    </ul>
    <div class="clear"></div>
  </div>
  <a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a> </div>



 
  <div id="a" style=" background:url(<%=path%>images/cf.jpg); width: 100%; height: 720px; margin-top: 50px">

  <div id="a" style="background-color: #9FF; width: 100%; height: 720px; margin-top: 50px">

 
  <form  method="post" action="<%=path%>myCompAction/EditCompInfo.action" class="layui-form" enctype="multipart/form-data">
         
          
          <c:forEach items="${compList}" var="comp">
               <div >
              <label for="username"  style="padding-top: 100px; padding-left: 700px ;">
                                         企业地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="address" name="address"  required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${comp.address}">
              </div>
            
          </div>
          
                <div>
              <label for="contacts" style="padding-top: 40px; padding-left: 700px ;">
                                                   联&nbsp;&nbsp;系&nbsp;&nbsp;人
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="contacts" name="contacts"  required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  value="${comp.contacts}">
              </div>
          
          </div>
          
          
           <div>
          <label for="phone" style="padding-top: 40px; padding-left: 700px ;">
                                                            手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone"   lay-verify="phone"
                  autocomplete="off" class="layui-input" value="${comp.phone}" >
                  
              </div>
          </div>
          
          
              <div >
              <label for="username" style="padding-top: 40px; padding-left: 700px ;">
                                                  头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像
              </label>
              <div style=" padding-left: 755px ;">
                  <input type="file" id="fileact" name="fileact" style="width: 170px;" lay-verify="required"
                  autocomplete="off"  >
               
                  
              </div >
                
               <div style="padding-top:20px; padding-left:710px ;">
                 <img src="" id="img0" style="width: 20rem; height: 10rem;">
               </div>
               
          </div>   
              
            </c:forEach> 
       <div >
              <label for="L_repass" style="padding-top: 50px;padding-left: 800px ; ">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                                保存
              </button>
          </div>
    
 </form>
 </div>
 

</body>
<script>
	$("#fileact").change(function() {
		var objUrl = getObjectURL(this.files[0]);//获取文件信息  
		console.log("objUrl = " + objUrl);
		if (objUrl) {
			$("#img0").attr("src", objUrl);
		}
	});
	function getObjectURL(file) {
		var url = null;
		if (window.createObjectURL != undefined) {
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { // mozilla(firefox)  
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { // webkit or chrome  
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	
	 layui.use(['form','layer'], function(){
	            $ = layui.jquery;
	          var form = layui.form
	          ,layer = layui.layer;
	        
	          //自定义验证规则
	          form.verify({
	            nikename: function(value){
	              if(value.length < 5){
	                return '昵称至少得5个字符啊';
	              }
	            }
	            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
	            ,repass: function(value){
	                if($('#L_pass').val()!=$('#L_repass').val()){
	                    return '两次密码不一致';
	                }
	            }
	          });	
		  });
</script>
</html>