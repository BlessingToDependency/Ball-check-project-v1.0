<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    
     <a href="userAdminAction/userAdmin.action">HelloWorld</a>
  </body>
</html>
