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
<script type="text/javascript">
function back(){
	window.location.href="<%=path%>/myCompAction/backIndex.action";
}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="<%=path%>myCompAction/EditCompInfo.action">
<table width="490" border="1" align="center">
  <tr>
    <td width="112">头像</td>
    <td width="362"><label for="fileField"></label>
    <input type="file" name="head" id="fileField" /></td>
  </tr>
  <c:forEach items="${compList}"  var="comp">
  <tr>
    <td height="28">企业地址</td>
    <td><label for="textfield"></label>
    <input type="text" name="address" id="textfield" value="${comp.address}" /></td>
  </tr>
  <tr>
    <td>联系人</td>
    <td><label for="textfield2"></label>
    <input type="text" name="contacts" id="textfield2" value="${comp.contacts}"/></td>
  </tr>
  <tr>
    <td>电话</td>
    <td>
      <label for="textfield3"></label>
      <input type="text" name="phone" id="textfield3" value="${comp.phone}"/>
    </td>
  </tr>
  </c:forEach>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提交" />
      <input type="button" name="button2" id="button2" value="返回到主页"  onclick="back()" />
      <input type="reset" name="button3" id="button3" value="重置" /></td>
    </tr>
</table>
</form>
</body>
</html>