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

<title>后天健康团检系统选择套餐</title>

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

<!--渐隐样式-->
 <link rel="stylesheet" href="../csss/luara.css"/>
  <link rel="stylesheet" href="../csss/style.css"/>
<meta http-equiv="mobile-agent" content="format=xhtml;url=/m/index.php">
<script type="text/javascript">if(window.location.toString().indexOf('pref=padindex') != -1){}else{if(/AppleWebKit.*Mobile/i.test(navigator.userAgent) || (/MIDP|SymbianOS|NOKIA|SAMSUNG|LG|NEC|TCL|Alcatel|BIRD|DBTEL|Dopod|PHILIPS|HAIER|LENOVO|MOT-|Nokia|SonyEricsson|SIE-|Amoi|ZTE/.test(navigator.userAgent))){if(window.location.href.indexOf("?mobile")<0){try{if(/Android|Windows Phone|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)){window.location.href="/m/index.php";}else if(/iPad/i.test(navigator.userAgent)){}else{}}catch(e){}}}}</script>
	
<script>

       window.onload=function (){

		   var aId = document.getElementById('newslist')

           var aLi=aId.getElementsByTagName('li');

           for(var i=0;i<aLi.length;i++){

               if(i%2==0){

                   // 0/2余数0  1/2余数1 2/2余数0 3/2余数1

                  aLi[i].className='wow newstitem right' //增加CSS名
               }

               else{
                   aLi[i].className='wow newstitem left' //增加CSS名
               }
           }
       }    

    </script>

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
function checkUser(){
	alert(111);
	window.location.reload();
}
	</script>

</head>

<body>
<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="<%=path%>images/logo.png" height="40" /></a>

    <ul id="nav">

      <li class="navitem"><a  class='active' href="index.html">首页</a></li>


      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action" >账户</a>

        <ul class="subnav">
          

        </ul>

      </li><li class="navitem"><a  href="about.html" >公司简介</a>

        <ul class="subnav">

          

          <li>
          <a href="<%=path%>myCompAction/selectCompInfo.action"  >公司信息</a>                  
         </li>

          
          <li><a href="<%=path%>myCompAction/toEditCompInfo.action" >编辑公司信息</a></li>
          <li><a  href="<%=path%>myCompAction/toUpPws.action"">修改密码</a></li>

        </ul>
      </li>
      
      <li class="navitem">
      <a  href="<%=path %>fileAction/fileDownLoad.action" >下载模板</a>
        <ul class="subnav">
        </ul>
      </li>
      
	  
	   <li class="navitem">
      <a  href="<%=path %>FrontEnd/user_upload.jsp" >上传体检人员信息</a>
        <ul class="subnav">
        </ul>
      </li>
      
      
      <li class="navitem"><a  href="news.html" >新闻动态</a>

        <ul class="subnav">

          

          <li><a href="#">院内新闻</a></li>
          

          <li><a href="#">行业新闻</a></li>
          
          
        </ul>

      </li><li class="navitem"><a  href="<%=path%>userLoginAction/jumpLogin.action" >去登陆</a>

        <ul class="subnav">

        </ul>

      </li>

    </ul>

    <div class="clear"></div>

  </div>
<form id="form1"   method="post" action="<%=path %>userMainAction/bespeakMeal.action?staffId=${staffId}">
<div align="center">
  <table width="800" border="1">
  <c:if test="null !=${staffId }">
       <input type="hidden" id="staffId" name="staffId" value="${staffId }"/>
       </c:if>
  <c:forEach items="${setList }" var="setmealBean">
    <tr>
      <td width="261" rowspan="4"><div align="center"><img  src="<%=path %>images/1-1F5041U4070-L.jpg"></div>
	 <input type="hidden" id="setmealId" name="setmealId" value="${setmealBean.setmealId}"/>
	  <input type="hidden" value="${setmealBean.setmeal }" name="setmeal" disabled="disabled" style="border:none;"/>
	  </td>
      <td height="75" colspan="2"><div align="center" class="STYLE1">${setmealBean.setmeal }</div></td>
    </tr>
    <tr>
      <td height="55" colspan="2"><div align="left" class="STYLE2">主要项目：${setmealBean.itemNick }</div></td>
    </tr>
    <tr>
      <td width="193" height="49"><div align="left" class="STYLE2">优惠价：${setmealBean.discount*setmealBean.countAll }</div>
	   <!-- 合计 -->
    <input type="hidden" id="hidden" name="" value="${setmealBean.discount*setmealBean.countAll }"/>
	  </td>
      <td width="324"><span class="STYLE2">原价：${setmealBean.countAll }</span></td>
    </tr>
    <tr>
      <td height="49"><div align="left" class="STYLE2">购买数量：
	 <!--  <input id="min" name="" type="button" value="-" />   -->
		<input id="text_box" name="number" type="text" disabled="disabled" value="1"style="width:30px;"/>  
		<!-- <input id="add" name="" type="button" value="+" />  -->
	  </div></td>
      <td><span class="STYLE2">价格：
	  <input id="total" name="countAll" type="text" value="${setmealBean.discount*setmealBean.countAll }"style="width:30px;"/>  </span></td>
    </tr>
    <tr>
      <td height="72" colspan="3"><div align="center">
      <input type="Submit" value="立即预约">
	  <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
	  </div></td>
    </tr>
	</c:forEach>
  </table>
  </div>
</form>
</div>
<div id="footer">

  <p>Copyright &copy; 2002-2011 <a href="http://www.adminbuy.cn" target="_blank">团检系统</a> 版权所有　<a class="beian" href="http://www.miitbeian.gov.cn/" style="display:inline; width:auto; color:#8e8e8e" target="_blank">苏ICP12345678</a></p>

</div>

</body>
</html>
