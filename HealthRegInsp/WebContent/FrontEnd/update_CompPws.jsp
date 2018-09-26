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
	window.location.href="<%=path%>/myCompAction/backIndex.action";
}
</script>
</head>
<body>

<table width="417" border="1" align="center">
  <tr>
    <td width="148">请输入原密码：</td>
    <td width="228"><input name="pwd" type="text" id="acc" onblur="checkDate()"/> <samp id="us"></samp></td>
  </tr>

  <tr>
   <form id="form1" name="form1" method="post" action="<%=basePath%>myCompAction/updateUserPws.action"> 
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
  
      <input type="submit" name="button" id="button" value="提交" />
     <input type="button" name="button2" id="button2" value="返回" onclick="back()"/>
     
    </td>
   
  </tr>
  </form>
</table>

</body>
</html>