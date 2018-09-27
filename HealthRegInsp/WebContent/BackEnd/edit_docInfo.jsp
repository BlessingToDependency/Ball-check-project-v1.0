<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form id="form1" name="form1" enctype="multipart/form-data" method="post" action="<%=path%>maDoctorAction/updateDoctorInfo.action" >
<table width="570" border="1" align="center">
 <c:forEach items="${adList}"  var="adList" >
  <tr>
    <td width="20">姓名：</td>
    <td width="471">${adList.adminName}</td>
  </tr>
  <tr>
    <td>背景：</td>
    <td><label for="textfield"></label>
      <label for="textarea"></label>
    <textarea name="background" id="background" cols="45" rows="5"  >
    ${adList.background} </textarea></td>
  </tr>
  <tr>
    <td>手机号：</td>
    <td><label for="textfield2"></label>
    <input type="text" name="phone" id="phone" value="${adList.phone}"/></td>
  </tr>
  <tr>
    <td>毕业院校：</td>
    <td><input type="text" name="graduated" id="graduated" value="${adList.graduated}"/></td>
  </tr>
   </c:forEach>
  <tr>
 
    <td>职务：</td>
    <td><label for="select"></label>
      <select name="postId" id="postId" >
        <c:forEach items="${postList}"  var="post" >
        <option value="${post.postId}">${post.post}</option>
      </c:forEach>
    </select></td>
  </tr>

  <tr>
    <td>科室：</td>
    <td><select name="depaId" id="depaId">
         <c:forEach items="${deparList}"  var="depar" >
        <option value="${depar.depaId}">${depar.depa}</option>
      </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提交" />
    <input type="reset" name="button3" id="button3" value="重置" /></td>
  </tr>
</table>
</form>
</body>
</html>