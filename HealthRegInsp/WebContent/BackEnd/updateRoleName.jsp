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
</head>
<body>
<form id="form1" name="form1" method="post" action="<%=path%>maRoleAction/updateRoleNmae.action" >
<table width="200" border="1" align="center">
  <tr>
    <td><input type="text" name="role"  placeholder="请输入新的角色名"  value=""/></samp></td>
  </tr>
  <tr>
    <td><input name="" type="submit" value="提交" />
    <input name="input" type="submit" value="返回主界面"  />
    <input name="input2" type="reset" value="重置" /></td>
  </tr>
</table>
</form>
</body>
</html>