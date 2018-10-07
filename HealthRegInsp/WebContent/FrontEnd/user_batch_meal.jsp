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
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>

<link href="<%=path %>css/user.css" rel="stylesheet" />
<script type="text/javascript">
	function click(){
		document.getElementById("info1").style.display="none";//隐藏

		//document.getElementById("typediv1").style.display="";
	}
</script>
<script type="text/javascript">
	function clickForm() {
		document.getElementById("formid").submit();
	}
</script>
<script type="text/javascript">
    $(document).ready(function(){
    	alert(66);
       //点击链接的时候调用
      $("#clickForm").click(function(){
    	  alert(88);
    	  
    	  
           //得到input的值
    	  <%-- var staffId = $("#staffId").val();
          var setmealId = $("#setmealId").val();
          alert(staffId);
          alert(setmealId);
          //设置linkToCart的href的值
          $("#clickForm").attr("href","<%=path %>userMainAction/batchMeal.action?staffId="+staffId+"+"&"+setmealId="+setmealId+"");
      --%> 
      
      });
    });
</script>
</head>
<body>
	<div id="info1" style="overflow-y: auto">
		<c:forEach items="${setList }" var="setmealBean">
		<div id="details">
              <input type="text" id="setmealId" name="setmealId" value="${setmealBean.setmealId}"/>
                <a id="clickForm" class="projectitem_content" target="_self" href="">
                    <img src="<%=path%>images/1-1F5041UT40-L.jpg" width="150" height="50" /> 
                    <p>${setmealBean.setmeal}&emsp;
                       	销量：${setmealBean.salsvolume}</p>
                    <span style="text-decoration:line-through;">
                     <p>原价：${setmealBean.countAll}</p></span>
					<p>优惠价格：${setmealBean.discount*setmealBean.countAll}</p>
               </a> 
               </div>
        </c:forEach>
        <!-- 未预约人员id -->
        <c:forEach items="${staffList }" var="staffBean">
        	<input type="text" id="staffId" name="staffId" value="${staffBean.staffId }"/> 
        </c:forEach>
        </div>
          
</body>
</html>