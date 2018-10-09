<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon" />
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>/js/xadmin.js"></script>
    
 <meta name="keywords" content="" />

<meta name="description" content="" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/999.css" /> 



<%-- <script type="text/javascript" src="<%=basePath%>js/org1470120033.js" data-main="baseMain"></script> --%>

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/list.php?tid=6">

<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/list.php?tid=6";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>

<script type="text/javascript">

 function checkDate(){

	  $.ajax({
	   type:"post",
   	   url:"<%=basePath%>myCompAction/validateCompPws.action",
   	   data:{"pwd":$("#acc").val()},
   	   dataType:"json",
  			success : function(redata) {//定义各事件发生时回调的函数
  			  console.log(redata);
  			
  		    	$("#us").html(redata);
  			}
		  
		  
	  });

} 
 
 layui.use(['form','layer'], function(){
	    $ = layui.jquery;
	  var form = layui.form
	  ,layer = layui.layer;

	  //自定义验证规则
	  form.verify({
	     pass: [/(.+){6,12}$/, '密码必须6到12位']
	    ,repass: function(value){
	        if($('#L_pass').val()!=$('#L_repass').val()){
	            return '两次密码不一致';
	        }
	    }
	  });	
	}); 


</script>

<style type="text/css">
 .setb{
    background:url(<%=basePath%>/images/b.jpg);
    height:1000px;
    width:1500px;
 }

</style>
</head>
<body>

<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="images/logo.png" height="40" /></a>

    <ul id="nav">

      <li class="navitem"><a  class='active' href="<%=basePath%>/myCompAction/backIndex.action">首页</a></li>

      <li class="navitem"><a  href="keshi.html" >门诊科室</a>

        <ul class="subnav">

          

          <li><a href="keshi.html">非手术科</a></li>

          

          <li><a href="keshi.html">手术科室</a></li>

          

          <li><a href="keshi.html">诊断科室</a></li>

          

          <li><a href="keshi.html">其他科室</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="tese.html" >医疗特色</a>

        <ul class="subnav">

          

        </ul>

      </li><li class="navitem"><a  href="about.html" >医院简介</a>

        <ul class="subnav">

          

              <li>
          <a href="<%=path%>/myCompAction/selectCompInfo.action"  >公司信息</a>                  
         </li>

          
          <li><a href="<%=path%>/myCompAction/toEditCompInfo.action" >编辑公司信息</a></li>
          <li><a  href="<%=path%>/myCompAction/toUpPws.action"">修改密码</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="team.html" >医师团队</a>

        <ul class="subnav">

          

        </ul>

      </li><li class="navitem"><a  href="news.html" >新闻动态</a>

        <ul class="subnav">

          

          <li><a href="#">院内新闻</a></li>

          

          <li><a href="#">行业新闻</a></li>

          

        </ul>

      </li><li class="navitem"><a  href="contact.html" >联系我们</a>

        <ul class="subnav">

          

        </ul>

      </li>

    </ul>

    <div class="clear"></div>

  </div>

  <a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a> </div>

<div id="sitecontent">

  <div class="npagePage Pageyemian" id="page_none">

    <div class="content">

 <div class="header">

        <p class="title">修改密码</p>

      </div>

 <div class="setb" >
  <form  method="post" action="<%=path%>/myCompAction/updateUserPws.action" class="layui-form">
   <div   >
              <label for="L_pass" style="padding-top: 60px; padding-left: 500px ;">
                  <span class="x-red">*</span> 原      &nbsp;     密          码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="acc"  required="" lay-verify="pass"
                  autocomplete="off" class="layui-input" onblur="checkDate()" /><samp id="us"></samp>
              </div>
   </div>
   
   <div >
              <label for="L_pass" style="padding-top: 30px;padding-left: 500px ; ">
                  <span class="x-red">*</span>新       &nbsp;     密          码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="pwd" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input">
              </div>
    </div>
        <div >
              <label for="L_repass" style="padding-top: 30px;padding-left: 500px ; ">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
          
        
       <div >
              <label for="L_repass" style="padding-top: 50px;padding-left: 550px ; ">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  保存
              </button>
          </div>
    
 </form>
 </div>
</body>

</html>