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

	<title></title>
	
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
			if(null != a  && "null" != a){
				 var strHtml="";
				 var strBuy="";
				if("" != a){
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
						"<input type='text' oninput = 'value=value.replace(/[^\d]/g,'')' id='acrtNumber'  value='"+item.acrtNumber+"'  onBlur='isDigit(this)' class='spinnerExample'>"+
						"<input type='hidden' id='setmealId' value='"+item.setmealId+"'>"+
						"</div>"+
					"</li>";
					});
					
					strBuy+="<a href='' id='checkShopp' onClick='checkShopp()' class='more redbtn-moddle1' id='btn_popup_login'>"+
						"<span id='login'>去购买</span>"+
						"</a>";
					$("#shoppingShow").html(strHtml);
					$("#div_login").html(strBuy);
				}else{
					strBuy+="<a href='' id='checkLook' onClick='checkLook()' class='more redbtn-moddle1' id='btn_popup_login'>"+
					"<span id='login'>去逛逛</span>"+
					"</a>";
					$("#div_login").html(strBuy);
				}
			}else{
				var strLogin="";
				strLogin+="<a href='<%=path%>userLoginAction/jumpLogin.action' class='more redbtn-moddle1' id='btn_popup_login'>"+
				"<span id='login'>去登录</span>"+
				"</a>";
				$("#div_login").html(strLogin);
			}
		}
	});
};

    //点击链接的时候调用
   function checkShopp(){
	  
	   var acrtNumber = $("#acrtNumber").val();
		var setmealId = $("#setmealId").val();
		
       //设置linkToCart的href的值
       $("#checkShopp").attr("href","<%=path%>userMainAction/orderDetails.action?cartNumber="+acrtNumber+"&setmealId="+setmealId+"");
   };

   function checkLook(){
		  
       //设置linkToCart的href的值
       $("#checkLook").attr("href","<%=path%>userMainAction/showSetmeal.action");
   };
</script>
</head>
<body>
<div id="header">

  <div class="content"> 
  <div style="margin-left: 100px">
  <a href="/" id="logo"><img src="<%=path%>images/lo.png" height="40" /></a>
  </div>
    <ul id="nav">
      <li class="navitem"><a  class='active' href="<%=path %>userMainAction/showSetmeal.action">首页</a></li>
      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action?page=1&startTime=&endTime=&paramId=" >账户</a>
        <ul class="subnav">
        </ul>
      </li>
      
       <li class="navitem"><a  href="<%=path%>myCompAction/selectCompInfo.action"" >公司简介</a>
  
      </li>
      
      <li class="navitem">
      <a  href="<%=path %>fileAction/fileDownLoad.action" >下载体检信息模板</a>
        <ul class="subnav">
        </ul>
      </li>
	   <li class="navitem">
      <a  href="<%=path %>fileAction/userUpload.action" >上传体检人员信息</a>
        <ul class="subnav">
        </ul>
      </li>
      <li class="navitem"><a  href="<%=path %>fileAction/companyStaffList.action" >配置套餐</a>
        <ul class="subnav">
        </ul>
      </li><li class="navitem"><a  href="<%=path%>userLoginAction/jumpLogin.action" >去登陆</a>
        <ul class="subnav">
        </ul>
      </li>
    </ul>
    <div class="clear"></div>
  </div>
  <a id="headSHBtn" href="javascript:;"><i class="fa fa-bars"></i></a> </div>
<div id="sitecontent">
  <div id="indexPage">
    <div id="mslider" class="module"> 
      <script type="text/javascript">$(function(){$("#mslider li video").each(function(index, element) {element.play();});})</script>

      <ul class="slider" data-options-height="660" data-options-auto="1" data-options-mode="0" data-options-pause="6" data-options-ease="ease-out">

        <li style="background-image:url(<%=path%>images/banner1.jpg)" class="active"></li>

<li style="background-image:url(<%=path%>images/banner1.jpg)" class="active"></li>



      </ul>

    </div>

    <div id="mindex" data-options-ease="Expo.easeInOut" data-options-speed="1" data-options-sscreen="0"></div>


    <div id="mproject" class="module">

      <div class="bgmask"></div>

      <div class="content layoutnone">

        <div class="header wow">

          <p class="title">热门套餐</p>

          <p class="subtitle"></p>

        </div>


        <!--yyLayout masonry-->

        <div class="module-content" id="projectlist">

          <div class="projectSubList" id="projectSubList_">

            <div class="projectSubHeader">

              <p class="title"></p>

              <p class="subtitle"></p>

            </div>

            <div class="wrapper">
              <ul class="content_list" data-options-sliders="8" data-options-margin="15" data-options-ease="1" data-options-speed="1">
<!-- ------------------------ -->

             <c:forEach items="${setList }" var="setmealBean">
                <li id="projectitem_0" class="projectitem wow"> 
                <a href="<%=path %>userMainAction/showSetmeal.action?setmealId=${setmealBean.setmealId}" class="projectitem_content" target="_self">
                  <div class="projectitem_wrapper"> 
                    <div class="project_img"> <img src="<%=path%>images/1-1F5041UT40-L.jpg" width="650" height="385" /> </div>
                    <div class="project_info">
                      <div>
                        <p class="title">${setmealBean.setmeal}
                        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                       	 销量：${setmealBean.salsvolume} </p>
                        <p class="title" align="right">
                        <span style="text-decoration:line-through;">
                        	原价：${setmealBean.countAll}</span>
                        	&emsp;
                        	优惠价格：${setmealBean.discount*setmealBean.countAll}
              	 		 </p>
                      </div>
                    </div>
                 </div> 
                </a> 
              </li>
           </c:forEach>



<!-- ----------------------------- -->
              </ul>
            </div>

            <!--wrapper--> 

          </div>

          <!--projectSubList--> 

         <a href="" class="more wow"><i class="fa fa-angle-right"></i></a> </div>

        <!--projectlist-->

        <div class="clear"></div>

      </div>

    </div>

   


    <div id="mcontact" class="module">

      <div class="bgmask"></div>

      <div class="content">

        <div class="header wow fadeInUp fw" data-wow-delay=".1s">

          <p class="title">联系我们</p>

          <p class="subtitle">Contact us</p>

        </div>

        <div id="contactlist" class="fw">

          <div id="contactinfo" class="fl wow" data-wow-delay=".2s">

            <h3 class="ellipsis name">厦门协和医院</h3>

            <p class="ellipsis add"><span>地址：</span>福建省厦门市思明区软件园二期56号</p>

            <p class="ellipsis tel"><span>电话：</span>4008-888-888</p>

            <p class="ellipsis fax"><span>Q Q：</span>382559544</p>

            <p class="ellipsis email"><span>邮箱：</span>382559544@qq.com</p>

          </div>

        </div>

      </div>

    </div>

  </div>

</div>


 
 
 


<!-- ----------------------------购物车------------------------------ -->
<div class="global_toolbar">
		<div class="toolbar_btn center" style="top: 50%; margin-top: -150px;">
		
			
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
			
	
		</div>
		<div class="toolbar_content">
			<div class="css_column cart_column js_column" id="shop_cart">
				<h4>
					购物车<a href="javascript:void(0)" class="icon-close " >X</a>
				</h4>
				<div id="resultData">
					<ul style="height: auto;" id="shoppingShow">
					
					</ul>
				</div>
				<div class="count_info clearfix">
					<label>
						<input type="checkbox" class="select_all" checked="checkbox">
					</label>
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

