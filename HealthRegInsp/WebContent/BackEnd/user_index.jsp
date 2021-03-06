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

</script>
</head>
<body>
<div id="header">

  <div class="content"> <a href="/" id="logo"><img src="<%=path%>images/logo.png" height="40" /></a>
    <ul id="nav">
      <li class="navitem"><a  class='active' href="<%=path %>userMainAction/showSetmeal.action">首页</a></li>
      <li class="navitem"><a  href="<%=path %>userBillAction/billInfo.action?startTime=&endTime=&paramId=&page=1" >我的账户</a>
        <ul class="subnav">
        </ul>
      </li>
      
       <li class="navitem"><a  href="about.html" >公司简介</a>
        <ul class="subnav">
          <li>
          <a href="<%=path%>myCompAction/selectCompInfo.action"  >公司信息</a>                  
         </li>
          <li><a href="<%=path%>myCompAction/toEditCompInfo.action" >编辑公司信息</a></li>
          <li><a  href="<%=path%>myCompAction/toUpPws.action"">修改密码</a></li>
        </ul>
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

<li style="background-image:url(<%=path%>images/banner2.jpg)" class="active"></li>



      </ul>

    </div>

    <div id="mindex" data-options-ease="Expo.easeInOut" data-options-speed="1" data-options-sscreen="0"></div>

    <div id="mservice" class="module">

      <div class="bgmask"></div>

      <div class="content layoutnone">

        <div class="header wow fw" data-wow-delay=".1s">

          <p class="title">医疗特色</p>

          <p class="subtitle"></p>

        </div>

        <div class="module-content fw" id="servicelist">

          <div class="wrapper">

            <ul class="content_list" data-options-sliders="3" data-options-margin="10" data-options-ease="1" data-options-speed="1">

              <li id="serviceitem_0" class="serviceitem wow"><a href="/a/tese/11.html" target="_blank"><img src="<%=path%>images/1-1F5041F041314.png" height="120" />

                <div>

                  <p class="title">新技术针疗法</p>

                  <p class="description">至于新三板，陈阳提到：我认同新三板今...</p>

                </div>

                </a> <a href="/a/tese/11.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="serviceitem_1" class="serviceitem wow"><a href="/a/tese/10.html" target="_blank"><img src="<%=path%>images/1-1F5041AP10-L.png" height="120" />

                <div>

                  <p class="title">特色门诊</p>

                  <p class="description">iOS/Android APP交互设计媒体的核心价值在于...</p>

                </div>

                </a> <a href="/a/tese/10.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="serviceitem_2" class="serviceitem wow"><a href="/a/tese/9.html" target="_blank"><img src="<%=path%>images/1-1F5041AA20-L.png" height="120" />

                <div>

                  <p class="title">特需医疗</p>

                  <p class="description">01. 泛游戏兴趣聚合平台着迷将正式宣布其...</p>

                </div>

                </a> <a href="/a/tese/9.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>



            </ul>

          </div>

        </div>

        <div class="clear"></div>

        <a href="/" class="more wow">MORE<i class="fa fa-angle-right"></i></a> </div>

    </div>

    <div id="mproject" class="module">

      <div class="bgmask"></div>

      <div class="content layoutnone">

        <div class="header wow">

          <p class="title">门诊科室</p>

          <p class="subtitle"></p>

        </div>

        <div id="category" class="hide wow">

        

        <a href="/a/keshi/k1/">非手术科</a>

        

        <a href="/a/keshi/k2/">手术科室</a>

        

        <a href="/a/keshi/k3/">诊断科室</a>

        

        <a href="/a/keshi/k4/">其他科室</a>

        

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

         <a href="/a/keshi/" class="more wow">MORE<i class="fa fa-angle-right"></i></a> </div>

        <!--projectlist-->

        <div class="clear"></div>

      </div>

    </div>

    <!--project-->

    <div id="mteam" class="module">

      <div class="bgmask"></div>

      <div class="content layoutslider">

        <div class="header wow">

          <p class="title">医师团队</p>

          <p class="subtitle"></p>

        </div>

        <div class="module-content fw">

          <div class="wrapper">

            <ul class="content_list" data-options-sliders="1" data-options-margin="40" data-options-ease="1" data-options-speed="0.5">

              <li id="teamitem_0" class="wow">

                <div class="header wow" data-wow-delay=".4s"> <a href="/a/team/19.html" target="_blank"><img src="<%=path%>images/1-1F5041Z202224.png" width="180" height="180" /></a> </div>

                <div class="summary wow">

                  <p class="title"><a href="/a/team/19.html">吴群励</a></p>

                  <p class="subtitle"></p>

                  <p class="description wow">WEB企业版最新研发的针对于中小型企业网站系统，团队有多年丰富的建站经验，了解最新网站体验及交互原则，尽可能的为用户考虑集功能、操作、体验交互一体化的专业网站系统。...</p>

                </div>

                <a href="/a/team/19.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="teamitem_1" class="wow">

                <div class="header wow" data-wow-delay=".4s"> <a href="/a/team/18.html" target="_blank"><img src="<%=path%>images/1-1F5041Z0100-L.png" width="180" height="180" /></a> </div>

                <div class="summary wow">

                  <p class="title"><a href="/a/team/18.html">黄渭清</a></p>

                  <p class="subtitle"></p>

                  <p class="description wow">- 新西兰GOUW设计师平台收录 - 中国网页设计联盟2010-11中国十佳网页 - 世界权威电子设计杂志 NEWWEBPICK 推荐设计师及网站推荐 - 案例被收录NEWWEBPICK电子杂志 （第29期） - 欧美css设计奖项...</p>

                </div>

                <a href="/a/team/18.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="teamitem_2" class="wow">

                <div class="header wow" data-wow-delay=".4s"> <a href="/a/team/4.html" target="_blank"><img src="<%=path%>images/1-1F5041301570-L.png" width="180" height="180" /></a> </div>

                <div class="summary wow">

                  <p class="title"><a href="/a/team/4.html">乔安娜kustra</a></p>

                  <p class="subtitle"></p>

                  <p class="description wow">7年互联网经验，曾服务于搜狐火炬传递、北京建筑设计研究院、日本电通、影时尚、宝迪集团、牛扒工厂、悠怡蓝海、富士达电动车、南中圣淇、伟德福思、安陆恩彼、WEB官网、WEB平台...</p>

                </div>

                <a href="/a/team/4.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="teamitem_3" class="wow">

                <div class="header wow" data-wow-delay=".4s"> <a href="/a/team/3.html" target="_blank"><img src="<%=path%>images/1-1F5041253290-L.png" width="180" height="180" /></a> </div>

                <div class="summary wow">

                  <p class="title"><a href="/a/team/3.html">董怡</a></p>

                  <p class="subtitle"></p>

                  <p class="description wow">世界权威电子设计杂志 NEWWEBPICK 推荐设计师 收录电子杂志 （第29期） 新西兰GOUW设计师平台收录 欧美css设计奖项 cssdesignawards获奖作品 中国设计联盟2010-11中国十佳网页(互动)设计师及专...</p>

                </div>

                <a href="/a/team/3.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>



            </ul>

          </div>

        </div>

        <div class="clear"></div>

        </div>

    </div>

    <div id="mnews" class="module">

      <div class="bgmask"></div>

      <div class="content layoutnone">

        <div class="header wow">

          <p class="title">新闻动态</p>

          <p class="subtitle">News Center</p>

        </div>

        <div class="module-content" id="newslist">

          <div class="wrapper">

            <ul class="content_list" data-options-sliders="3" data-options-margin="40" data-options-ease="1" data-options-speed="0.5" data-options-mode="horizontal" data-options-wheel="0">

              <li id="newsitem_0" class='wow newstitem left'><a class="newscontent" target="_blank" href="/a/news/hyxw/22.html">

                <div class="news_wrapper">

                  <div class="newsbody">

                    <p class="date"><span class="md">2017<span>-</span></span><span class="year">05-04</span></p>

                    <p class="title">如何让自己的网站更有质量？AB模板王有</p>

                    <div class="separator"></div>

                    <p class="description">随着互联网的不断发展，对网站的要求越来越高，如何提高网站的质量，让自己在这个竞争激烈的市场中站稳自己的脚步呢?今天，AB模板王汇总了一些方式，希望对大家有帮助。 第一、...</p>

                  </div>

                </div>

                <div class="newsimg" style="background-image:url(<%=path%>images/1-1F504192020423.jpg)"></div>

                </a> <a href="/a/news/hyxw/22.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="newsitem_1" class='wow newstitem left'><a class="newscontent" target="_blank" href="/a/news/hyxw/21.html">

                <div class="news_wrapper">

                  <div class="newsbody">

                    <p class="date"><span class="md">2017<span>-</span></span><span class="year">05-04</span></p>

                    <p class="title">内容优化之有“心”创作</p>

                    <div class="separator"></div>

                    <p class="description">什么是真正的原创文?小编认为，真正的原创文是作者自己内心的真切感悟或体会，能够体现作者独特风格，且来源于日常生活或工作中，能给大众带来价值的文章。 在网站优化中，内...</p>

                  </div>

                </div>

                <div class="newsimg" style="background-image:url(<%=path%>images/1-1F504191949109.jpg)"></div>

                </a> <a href="/a/news/hyxw/21.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>

<li id="newsitem_2" class='wow newstitem left'><a class="newscontent" target="_blank" href="/a/news/hyxw/20.html">

                <div class="news_wrapper">

                  <div class="newsbody">

                    <p class="date"><span class="md">2017<span>-</span></span><span class="year">05-04</span></p>

                    <p class="title">网络公司告诉你有关面包屑导航的事</p>

                    <div class="separator"></div>

                    <p class="description">面包屑导航来源于童话故事中的汉塞尔利用面包屑来记录回家的路的故事，根据这个故事我们就可以知道它是指可以让用户清楚知道在网站中所处的位置，找得到回到网站首页的路。...</p>

                  </div>

                </div>

                <div class="newsimg" style="background-image:url(<%=path%>images/1-1F504191PS16.jpg)"></div>

                </a> <a href="/a/news/hyxw/20.html" target="_blank" class="details">more<i class="fa fa-angle-right"></i></a> </li>



            </ul>

          </div>

        </div>

        <div class="clear"></div>

        <a href="/a/news/" class="more wow">MORE<i class="fa fa-angle-right"></i></a>

        <div style="height:0"> &nbsp; </div>

      </div>

    </div>

    <div id="mpage" class="module">

      <div class="bgmask"></div>

      <div class="content">

        <div class="module-content">

          <div class="wrapper">

            <ul class="slider one">

              <li>

                <div class="header wow" data-wow-delay=".2s">

                  <p class="title">医院简介</p>

                  <p class="subtitle"></p>

                </div>

                <div class="des-wrap">

                  <p class="description wow" data-wow-delay=".3s"> 优爱精神 严谨、求精、勤奋、奉献 严谨、求精、勤奋、奉献协和精神是协和的核心价值观，是协和医院文化精髓。协和文化以崇尚科学、崇尚知识、专业态度和专业精神为其思想内核，又具有深厚的人文特征，表现方式凝重、内敛、不张扬、戒浮躁，重视口碑效应。具体体现在协和人身上就是科学严谨的作风、浓厚的人文传统与学术的包容...</p>

                </div>

                <a href="/a/about/" class="more wow" data-wow-delay=".5s">MORE<i class="fa fa-angle-right"></i></a>

                <div class="fimg wow" style="background-image:url(<%=path%>images/jianjie.jpg)"></div>

              </li>

            </ul>

          </div>

        </div>

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

            <h3 class="ellipsis name">南京市AB模板网科技有限公司</h3>

            <p class="ellipsis add"><span>地址：</span>江苏省南京市玄武区玄武湖</p>

            <p class="ellipsis tel"><span>电话：</span>4008-888-888</p>

            <p class="ellipsis fax"><span>Q Q：</span>9490489</p>

            <p class="ellipsis email"><span>邮箱：</span>9490489@qq.com</p>

            <div> <a class="fl" target="_blank" href="http://www.weibo.com/gooxao" id="sweibo"><i class="fa fa-weibo"></i></a> <a class="fl" target="_blank" href="tencent://message/?uin=9490489&amp;Site=uemo&amp;Menu=yes"><i class="fa fa-qq"></i></a> <a id="mpbtn" class="fl" href="<%=path%>/style/images/ma.jpg"><i class="fa fa-weixin"></i></a> </div>

          </div>

        </div>

      </div>

    </div>

  </div>

</div>

<div id="footer">

  <p>Copyright &copy; 2002-2011 <a href="http://www.adminbuy.cn" target="_blank">团检系统</a> 版权所有　<a class="beian" href="http://www.miitbeian.gov.cn/" style="display:inline; width:auto; color:#8e8e8e" target="_blank">苏ICP12345678</a></p>

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

