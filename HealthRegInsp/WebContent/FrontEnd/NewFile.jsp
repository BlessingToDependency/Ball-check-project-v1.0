<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=path %>fileAction/fileUpLoad.action" enctype="multipart/form-data">
 <table>
 <tr><td>
  		<input type="file" name="files"/>
        <input type="submit" value="提交上传"/>
        </td></tr>
         </table>
</form>


<form action="<%=path %>fileUploadController.action" enctype="multipart/form-data">
 <table>
 <tr><td>
  		<input type="file" name="file"/>
        <input type="submit" value="提交上传"/>
        </td></tr>
         </table>
</form>
</body>
</html>