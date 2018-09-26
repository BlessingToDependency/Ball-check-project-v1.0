<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="309" border="1" align="center">
<c:forEach items="${compList}"  var="comp">
  <tr>
    <td width="78">公司名</td>
    <td width="106">${comp.company}</td>
  </tr> 
  <tr>
    <td>公司地址</td>
    <td>${comp.address}</td>
  </tr>
  <tr>
    <td>联系人</td>
    <td>${comp.contacts}</td>
  </tr>
  <tr>
    <td>电话</td>
    <td>${comp.phone}</td>
  </tr>
  <tr>
    <td>工商号</td>
    <td>${comp.busNum}</td>
  </tr>
 </c:forEach>
  <tr>
    <td colspan="2"><a href="<%=path%>myCompAction/backIndex.action">返回</a></td>
  </tr>
</table>
</body>
</html>