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
<!-- ------------------------------购物车------------------------ -->
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="apple-touch-fullscreen" content="yes">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta name="format-detection" content="telephone=no">

	<title>右侧购物车</title>
	
	<link rel="stylesheet" href="../css/css/base.css">
	<link rel="stylesheet" href="../css/css/home.css">

<!-- ------------------------购物车-------------------- -->
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


<!-- 拼接购物车 -->
<script type="text/javascript">
function shoppingInfo(){
	$.ajax({
		url:"<%=path %>userMainAction/shoppingCart.action",
		dataType:"json",
		type:"POST",
		success : function(a){
			if(null != a || "" != a){
				 var strHtml="";
				 var strBuy="";
				 
					$.each(a, function(i, item) {
						strHtml+="<li class='clearfix' data-url=''>"+
						"<input type='checkbox' class='checkbox_c' name='checkbox_c_Name' data-url='' checked='checked'>"+
						
						"<div class='img_con'>"+
						"<img src='../images/pd/pd1.jpg' alt=''>"+
						"</div>"+
						"<div class='product_name'>"+
						"<span title='S5700-28P-PWR-LI-AC'>"+item.setmeal+"&emsp;&emsp;"+item.countAll*item.discount*item.acrtNumber+" 元"+"</span>"+
						"<a href='javascript:void(0)' class='del_pro_btn' onClick=''>删除</a>"+
						"</div>"+
						"<div class='amount_btn clearfix'>"+
						"<input type='text' id='acrtNumber' value='"+item.acrtNumber+"'  onBlur='isDigit(this)' class='spinnerExample'>"+
						"<input type='hidden' id='setmealId' value='"+item.setmealId+"'>"+
						"</div>"+
					"</li>";
					
					});
					var acrtNumber = $("#acrtNumber").val();
					var setmealId = $("#setmealId").val();
					strBuy+="<a href='<%=path%>userMainAction/orderDetails.action?acrtNumber='acrtNumber'&setmealId='setmealId'' class='more redbtn-moddle1' id='btn_popup_login'>"+
						"<span id='login'>去购买</span>"+
						"</a>";
					$("#shoppingShow").html(strHtml);
					$("#div_login").html(strBuy);
			}else{
				var strLogin="";
				strLogin+="<a href='<%=path%>userLoginAction/jumpLogin.action' class='more redbtn-moddle1' id='btn_popup_login'>"+
				"<span id='login'>去登录</span>"+
				"</a>";
				$("#div_login").html(strLogin);
			}
		}
	});
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
    $(document).ready(function(){
       //点击的时候调用
      $("#linkToCart").click(function(){
    	 var acrtNumber = $("#text_box").val();
    	 var setmealId = $("#setmealId").val();
          //设置linkToCart的href的值
         <%--  $("#linkToCart").attr("href","<%=path %>userMainAction/addShoppingCart.action?acrtNumber="+acrtNumber+"&setmealId="+setmealId+""); --%>
      	$.ajax({
    		url:"<%=path %>userMainAction/addShoppingCart.action",
    		data:"acrtNumber="+acrtNumber+"&"+"setmealId="+setmealId,
    		dataType:"json",
    		type:"POST",
    		success : function(str){
    			if(str=="1"){
    				alert("已加入购物车！");
    			}else{
    				/* alert("<a data-toggle="modal" data-target="#myModal">请先登陆</a>"); */
    				alert('请先登陆！');
    			}
    		}
    	});
      });
    });
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

<form id="formid"  method="post" action="<%=path %>userMainAction/orderDetails.action">
<div align="center">
  <table width="800" border="1">
  <c:forEach items="${setList }" var="setmealBean">
    <tr>
	 <input type="hidden" id="setmealId" name="setmealId" value="${setmealBean.setmealId}"/>
      <td width="261" rowspan="4"><div align="center">图片</div></td>
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
	  <input id="min" name="" type="button" value="-" />  
		<input id="text_box" name="cartNumber" type="text" value="1"style="width:30px;"/>  
		<input id="add" name="" type="button" value="+" /> 
	  </div></td>
      <td><span class="STYLE2">价格：
	  <input id="total" name="countAll" type="text" value="${setmealBean.discount*setmealBean.countAll }"style="width:30px;"/>  </span></td>
    </tr>
    <tr>
      <td height="72" colspan="3"><div align="center">
      <a id="linkToCart" href="">加入购物车</a> 
      <input type="Submit" value="立即购买">
	  <input type="button" name="Submit" onclick="javascript:history.back(-1);" value="返回">
	  </div></td>
    </tr>
	</c:forEach>
  </table>
  </div>
</form>

</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel" >
            请登录    
                </h4>
            </div>
            
            <div class="modal-body">
                 公司名：<input type="text" id="name">
            </div>
            <div class="modal-body">
                密码：<input type="text" id="sex">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- ----------------------------购物车------------------------------ -->
<div class="global_toolbar">
		<div class="toolbar_btn center" style="top: 50%; margin-top: -150px;">
			<a href="#" id="needtohelp_0_GetPricing" class="bar_forum bar_project_consulting">
				<samp>
					<i class="iconi icon-LiveChat1">
						<img src="../images/icon/car-0.png" alt="">
					</i>
				</samp>
				<em>
					<i>项目咨询</i>
				</em>
			</a>
			
			<!-- ----------------购物车图-------------- -->
			<a id="needtohelp_0_shoppingCart" class="bar_cart " data-id="global_toolbar" onclick="shoppingInfo()">
				<samp>
					<i class="iconi icon-LiveChat1">
						<img src="../images/icon/car-1.png" alt="">
					</i>
				</samp>
				<em>
					<i>购物车</i>
				</em>
				<span id="lmliCount" style="display: block;"></span>
			</a>
			<!-- ---------------------------------------------------- -->
			
			<a href="#" id="needtohelp_0_forum" class="bar_forum">
				<samp>
					<i class="iconi icon-LiveChat1">
						<img src="../images/icon/car-2.png" alt="">
					</i>
				</samp>
				<em>
					<i>查找经销商</i>
				</em>
			</a>
			<a href="#" id="needtohelp_0_GetQuote" class="bar_forum bar_inquire">
				<samp>
					<i class="iconi icon-LiveChat1">
						<img src="../images/icon/car-3.png" alt="">
					</i>
				</samp>
				<em>
					<i>售前咨询</i>
				</em>
			</a>
			<a href="#" id="needtohelp_0_contactus" class="bar_contact bar_forum" data-id="contact_column">
				<samp>
					<i class="iconi icon-LiveChat1">
						<img src="../images/icon/car-4.png" alt="">
					</i>
				</samp>
				<em>
					<i>更多联系方式</i>
				</em>
			</a>
		</div>
		<div class="toolbar_content">
			<div class="css_column cart_column js_column" id="shop_cart">
				<h4>
					购物车<a href="javascript:void(0)" class="icon-close " >X</a>
				</h4>
				<div id="resultData">
					<ul style="height: auto;" id="shoppingShow">
					
					<%-- <c:forEach items="shoppingList" var="shoppingCartBean">
						<li class="clearfix" data-url="7115213">
							<input type="checkbox" class="checkbox_c" name="checkbox_c_Name" data-url="7115213|" checked="checked">
							<span class="check"></span>
							<div class="img_con">
								<img src="../images/pd/pd1.jpg" alt="">
							</div>
							<div class="product_name">
								<span title="S5700-28P-PWR-LI-AC">${shoppingList.setmealId }</span>
								<a href="javascript:void(0)" class="del_pro_btn" onClick="">删除</a>
							</div>
							<div class="amount_btn clearfix">
								<input type="text" value="1" class="spinnerExample" onBlur="isDigit(this)">
							</div>
						</li>
					</c:forEach> --%>
						
					</ul>
				</div>
				<div class="count_info clearfix">
					<label>
						<input type="checkbox" class="select_all" checked="checkbox">
						<!-- <span class="check"></span>
						<span class="text">全选</span> -->
					</label>
					<!-- <p>
						共计： <span>12</span>
						个产品
					</p> -->
				</div>
				<div class="more shop-more clearfix">
					
				</div>
				<div class="shop_function_btn clearfix" id="div_login">
				
					
					
				</div>
			</div>
		</div>
	</div>

	<!-- 登录弹窗 默认隐藏 begin -->
	<div style="display: none;" class="popup_login">
		<div class="login_form">
			<a class="close_popup" href="javascript:void(0)">
				<img src="../images/icon/icon-clo.png" alt="">
			</a>
			<h3>登录</h3>
			<div>
				<div class="form_block">
	                        <span class="username_icon input_icon">
	                            <img src="img/icon/user.png" alt="">
	                        </span>
					<input type="text" placeholder="帐号/邮箱" maxlength="52" name="userNamepopup" id="userNamepopup">
				</div>
				<div class="form_block">
	                        <span class="password_icon input_icon">
	                            <img src="../images/icon/password.png" alt="">
	                        </span>
					<input type="password" placeholder="密码" maxlength="52" name="pwdpopup" id="pwdpopup">
				</div>
				<div class="tips_error"></div>
				<input type="button" class="form_login_btn" id="btnLoginpopup" value="登录">
			</div>
			<div class="login_else_info clearfix">
	                    <span>
	                        <a href="#">忘记密码</a>
	                        <label>|</label>
	                        <a href="#">修改密码</a>
	                    </span>
				<div class="need_reg">
					没有帐号？<a href="#">立即创建一个</a>
				</div>
			</div>
			<div class="other-sign-in-methods"></div>
		</div>
		<input type="hidden" value="用户名不能为空" id="userNamepopupErrMsg">
		<input type="hidden" value="密码不能为空" id="passwordpopupErrMsg">
	</div>
	<!-- 登录弹窗 默认隐藏 end -->

	<script type="text/javascript" src="../js/js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="../js/js/common.js"></script>

</body>
</html>
