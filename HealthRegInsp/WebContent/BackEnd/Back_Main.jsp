<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

        <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>桌面</title>

<style type="text/css">

</style>


</head>
<body>
<div id="pageAll">
		<div class="page">
			<!-- main页面样式 -->

			<div class="indexL" id="a">
				 <img class="indexBn" src="<%=path %>images/ba1.png"  width="100%"/><br> 

			<div class="indexL">
				<img class="indexBn" src="images/ba1.png" /><br>

				
			</div>
			<!-- main页面样式end -->
		</div>
	</div>
</body>
</html>