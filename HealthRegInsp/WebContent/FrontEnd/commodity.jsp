<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8" />
<meta name="author" content="order by dede58.com/" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>后天健康团检系统</title>

<meta name="description" content="网站描述" />

<meta name="keywords" content="关键词" />

<meta content="yes" name="apple-mobile-web-app-capable" />

<meta content="black" name="apple-mobile-web-app-status-bar-style" />

<meta content="telephone=no" name="format-detection" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/lib.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/style.css" />

<link rel="stylesheet" type="text/css" href="<%=path%>css/999.css" />

<script type="text/javascript" src="<%=path%>js/jquery-1.11.3.min.js"></script>

<script type="text/javascript" src="<%=path%>js/org1470120033.js" data-main="indexMain"></script>

<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/index.php">
<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/index.php";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>
<style type="text/css">
<!--
.STYLE2 {font-size: 36px}
.STYLE3 {font-size: 18px}
.STYLE4 {font-size: 16px}
-->
</style>


<script type="text/javascript">
$(document).ready(function(){
//获得文本框对象
   var t = $("#text_box");
   var hidden = document.getElementById("hidden").value;
//初始化数量为1,并失效减
$('#min').attr('disabled',true);
    //数量增加操作
    $("#add").click(function(){  
    	var count = parseInt(t.val())+1;
      	 t.val(count);
        if (parseInt(t.val())!=1){
            $('#min').attr('disabled',false);
        }
       
        $("#total").val((parseFloat((hidden)*(count))))
      
    }) 
    //数量减少操作
    $("#min").click(function(){
    	var count = parseInt(t.val())-1;
        t.val(count);
        if (parseInt(t.val())==1){
            $('#min').attr('disabled',true);
        }
        $("#total").val((parseFloat((hidden)*(count))))
    })
   
});
</script> 
<script type="text/javascript">
    $(document).ready(function(){
       //点击的时候调用
      $("#linkToCart").click(function(){
    	 var cartNumber = $("#text_box").val();
    	 var setmealId = $("#setmealId").val();
    	 
          //设置linkToCart的href的值
          $("#linkToCart").attr("href","<%=path %>userMainAction/addShoppingCart.action?cartNumber="+cartNumber+"&setmealId="+setmealId+"");
      });
    });
</script>

</head>

<body>
<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="<%=path%>images/logo.png" height="40" /></a>


	<form id="formid"  method="post" action="<%=path %>userMainAction/bespokeNow.action">
  <table width="800" border="1" align="center">
<c:forEach items="${setList }" var="setmealBean">
    <tr>
      <td><span class="STYLE2">
      <input type="hidden" id="setmealId" value="${setmealBean.setmealId}"/>
      <input type="text" value="${setmealBean.setmeal }" name="setmeal" disabled="disabled" style="border:none;"/></span></td>
    </tr>
    <tr>
      <td><span class="STYLE4">主要项目：${setmealBean.itemNick }</span></td>
    </tr>
    <tr>
      <td><span class="STYLE3">优惠价：
       <input type="text" value="${setmealBean.discount*setmealBean.countAll }" name="discount" disabled="disabled" style="border:none;"/>
    <!-- 合计 -->
    <input type="hidden" id="hidden" name="" value="${setmealBean.discount*setmealBean.countAll }"/>
      </span></td>
    </tr>
    <tr>
      <td>原价：${setmealBean.countAll }</td>
    </tr>
    <tr>
      <td>购买数量：
      	<input id="min" name="" type="button" value="-" />  
		<input id="text_box" name="cartNumber" type="text" value="1"style="width:30px;"/>  
		<input id="add" name="" type="button" value="+" /> 
		价格：<input id="total" name="countAll" type="text" value="${setmealBean.discount*setmealBean.countAll }"style="width:30px;"/>  
	</td>

    </tr>
    <tr>
      <td><label>
        <a id="linkToCart">加入购物车</a>
         <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
      </label></td>
    </tr>
</c:forEach>
  </table>
</form>
<div id="footer">

  <p>Copyright &copy; 2002-2011 <a href="http://www.adminbuy.cn" target="_blank">团检系统</a> 版权所有　<a class="beian" href="http://www.miitbeian.gov.cn/" style="display:inline; width:auto; color:#8e8e8e" target="_blank">苏ICP12345678</a></p>

</div>

</body>
</html>
