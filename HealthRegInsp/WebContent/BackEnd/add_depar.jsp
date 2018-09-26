<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
    String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
 <script type="text/javascript" src="<%=path%>js/jquery.validate.min.js"></script>
 <script type="text/javascript" src="<%=path%>js/messages_zh.js"></script>
<script type="text/javascript">
function checkDate(){

	  $.ajax({
		  type:"post",
 	   url:"<%=path%>maDeparAction/checkDepar.action",
 	   data:{"depa":$("#depa").val()},
 	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
		    	$("#us").html(redata);
			}
		  
		  
	  });

} 

</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="<%=path%>maDeparAction/innserDepar.action" >
<table width="200" border="1" align="center">
  <tr>
    <td><input type="text" name="depa"  id="depa" placeholder="请输入新增的科室名"  onblur="checkDate()"/><samp id="us"></samp></td>
  </tr>
  <tr>
    <td><input name="" type="submit" value="提交" />
    <input name="input2" type="reset" value="重置" /></td>
  </tr>
</table>
</form>
</body>
</html>