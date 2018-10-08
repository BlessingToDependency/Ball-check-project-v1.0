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
<link href="<%=path %>css/user.css" rel="stylesheet" />
<script type="text/javascript">
	function click(){
		document.getElementById("info1").style.display="none";//隐藏

		//document.getElementById("typediv1").style.display="";
	}
</script>

</head>
<body>
	<div id="info1" style="overflow-y: auto">
		<c:forEach items="${setList }" var="setmealBean">
		<div id="details">
                <a href="<%=path %>userMainAction/chooseMeal.action?setmealId=${setmealBean.setmealId}&staffId=${staffId}" class="projectitem_content" target="_self">
                    <img src="<%=path%>images/1-1F5041UT40-L.jpg" width="150" height="50" /> 
                    <p>${setmealBean.setmeal}&emsp;
                       	销量：${setmealBean.salsvolume}</p>
                     <p>原价：${setmealBean.countAll}</p>
					<p>优惠价格：${setmealBean.discount*setmealBean.countAll} </p>
               </a> 
               </div>
        </c:forEach>
     
          
</body>
</html>