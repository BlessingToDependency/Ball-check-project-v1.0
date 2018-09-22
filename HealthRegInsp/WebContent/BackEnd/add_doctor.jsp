<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
<form id="form1" name="form1" method="post" action="<%=path%>maDoctorAction/AddDoctor.action" enctype="multipart/form-data" >
<table width="454" border="1" align="center">
  <tr>
    <td width="28">姓名</td>
    <td width="344"><label for="textfield"></label>
      <input type="text" name="adminName" id="adminName" /></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><label for="textfield2"></label>
      <input type="password" name="adminPwd" id="adminPwd" /></td>
  </tr>
    <tr>
    <td>头像</td>
    <td>
      <input type="file" name="fileact" id="fileact" multiple="multiple"/>
       <img src="" id="img0" style="width: 5rem; height: 5rem;">
      </td>
  </tr>
  <tr>
    <td>年龄</td>
    <td><input type="text" name="age" id="age" /></td>
  </tr>
  <tr>
    <td>性别</td>
    <td><input type="radio" name="sex" id="sex" value="男" />
      <label for="radio">男
        <input type="radio" name="sex" id="sex" value="女" />
      女</label></td>
  </tr>
  <tr>
    <td>手机号</td>
    <td><input type="text" name="phone" id="phone" /></td>
  </tr>
  <tr>
    <td>毕业院校</td>
    <td><input type="text" name="graduated" id="graduated" /></td>
  </tr>
  <tr>
    <td>职务</td>
    <td><label for="select"></label>
      <select name="postId" id="postId">
       <c:forEach items="${postList}"  var="post" >
        <option value="${post.postId}">${post.post}</option>
      </c:forEach>
      </select></td>
  </tr>
  <tr>
    <td>科室</td>
    <td><select name="depaId" id="depaId">
    <c:forEach items="${deparList}"  var="depar" >
        <option value="${depar.depaId}">${depar.depa}</option>
      </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td>背景</td>
    <td><label for="textarea"></label>
      <textarea name="background" id="background" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提交" />
      <input type="submit" name="button2" id="button2" value="返回" />
      <input type="reset" name="button3" id="button3" value="重置" />
      
    </td>
  </tr>
</table>
</form>
</body>
<script>
		$("#fileact").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img0").attr("src", objUrl);
			}
		});
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) { // mozilla(firefox)  
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) { // webkit or chrome  
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>
</html>