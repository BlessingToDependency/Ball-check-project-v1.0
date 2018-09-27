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
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
 <script type="text/javascript" src="<%=basePath%>js/jquery.validate.min.js"></script>
 <script type="text/javascript" src="<%=basePath%>js/messages_zh.js"></script>
<title>Insert title here</title>
<meta name="keywords" content="" />

<meta name="description" content="" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=basePath%>css/999.css" />

<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="<%=basePath%>js/org1470120033.js" data-main="baseMain"></script>

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
 
/*  $.validator.setDefaults({
	    submitHandler: function() {
	      alert("提交事件!");
	    }
	});
$().ready(function() {
	// 在键盘按下并释放及提交后验证提交表单
	  $("#form1").validate({
	      rules: {
	    	  pwd:{required:true,minlength:6},	
	   	   pwdOk:{required:true,minlength:6,equalTo:"#pwd"}
	      }
	
	  });
	}); */
/*  $(document).ready(function(){
		
		$("#form1").on("submit",function(event){
                alert("1111");
			//event.preventDefaul();//阻止事件默认动作
			//$(this).validate();
			 rules:{			  
			   pwd:{required:true,minlength:6},	
			   pwdOk:{required:true,minlength:6,equalTo:"#pwd"},			  
		   }
		}); */
	  /* $("#form1").validate({
		 
		   rules:{			  
			   pwd:{required:true,minlength:6},	
			   pwdOk:{required:true,minlength:6,equalTo:"#pwd"},			  
		   }
		  
	  }); */
	/* });  */
</script>
<script type="text/javascript">
function back(){
	window.location.href="<%=basePath%>/myCompAction/backIndex.action";
}
</script>
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
    <div align="center"> 
<table width="417"  border="1" align="center" >
  <tr>
    <td width="148">请输入原密码：</td>
    <td width="228"><input name="pwd" type="text" id="acc" onblur="checkDate()"/> <samp id="us"></samp></td>
  </tr>

  <tr>
   <form id="form1" name="form1" method="post" action="<%=path%>myCompAction/updateUserPws.action"> 
    <td>请输入新密码：</td>
    <td>
    <input type="password" name="pwd" id="pwd" /></td>
  </tr>
  <tr>
    <td>请再次输入密码：</td>
    <td><input type="password" name="pwdOk" id="pwdOk" /></td>
  </tr>
  <tr>
   
    <td colspan="2">
        <div align="center">
      <input type="submit" name="button" id="button" value="提交" />
        </div>    
    </td>
   
  </tr>
  </form>
</table>
</div> 
</body>
</html>