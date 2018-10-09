<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-transform" />
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>我的网站</title>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<%=path%>skin/css/bootstrap.min.css">
		<link rel="stylesheet" href="<%=path%>skin/css/animate.min.css">
		<link rel="stylesheet" href="<%=path%>skin/css/style.css">
		<style>
     .zt{color: white;}
         #div{width:580px; height:300px;margin: 0px 0px 100px 250px;line-height:40px; float:left;text-align:left; color: white;}
	</style>
	</head>

	<body id="moar">
		<header class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
					<h1 class="logo"><a class="navbar-brand" href="index.html">我的网站</a></h1>
				</div>
				<nav class="collapse navbar-right navbar-collapse" role="navigation">
					<ul class="list-inline navbar-nav">
						<li>
							<a href="index.html">首页</a>
						</li>

						<li>
							<a href="design.html">设计</a>
						</li>

						<li>
							<a href="youshi.html">优势</a>
						</li>

						<li>
							<a href="case.html">案例</a>
						</li>

						<li>
							<a href="team.html">团队</a>
						</li>

						<li>
							<a href="about.html">关于</a>
						</li>

						<li>
							<a href="news.html">资讯</a>
						</li>

						<li>
							<a href="contact.html">联系</a>
						</li>

						<li class="tel visible-lg-inline-block">
							<a href="javascript:;"><span class="icon-page-lianxi"></span> 027-88888888</a>
						</li>
					</ul>
				</nav>
			</div>
		</header>

		<!--end-->
		<section class="banner">
			<div id="owl-banner" class="owl-carousel owl-theme">
				<div class="item" style="background:url(skin/images/1-1P3200Z1570-L.jpg)">
					<a><img src="skin/images/banner-height.gif" class="center-block" alt="幻灯3" /></a>
				</div>
				<div class="item" style="background:url(skin/images/1-1P3200Z2230-L.jpg)">
					<a><img src="skin/images/banner-height.gif" class="center-block" alt="幻灯3" /></a>
				</div>
				<div class="item" style="background:url(skin/images/1-1P3200Z2100-L.jpg)">
					<a><img src="skin/images/banner-height.gif" class="center-block" alt="幻灯3" /></a>
				</div>

			</div>
			<div class="banner-bc"></div>
		</section>
		<!--end-->

		<section class="case sx-jianju">
			<div class="container text-center">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2-white"> 案例 </h2>
					<p class="m-sm-white"> case </p>
				</div>
				<div class="row">
				  <c:forEach items="${setList }" var="setmealBean">
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="<%=path%>userMainAction/showSetmeal.action?setmealId=${setmealBean.setmealId}" title="滨海幸福里"><img src="<%=path%>skin/images/1-1P3201024310-L.jpg" alt="滨海幸福里" />
								<figcaption>
								<div class="zt">
									<h3>滨海幸福里<span>办公写字楼</span></h3>
									 <p class="title">${setmealBean.setmeal}
                       		
                       				 销量：${setmealBean.salsvolume} </p>
                      				 <p class="title" align="right">
                       			 	<span style="text-decoration:line-through;">
                        				原价：${setmealBean.countAll}</span>
                        	
                        			优惠价格：${setmealBean.discount*setmealBean.countAll}
              	 					 </p></div>
								</figcaption>
							</a>
						</figure>
					</div>
				</c:forEach>
					
					
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="javascript:;" title="中国铁塔"><img src="skin/images/1-1P320102J30-L.jpg" alt="中国铁塔" />
								<figcaption>
									<h3>中国铁塔<span>办公写字楼</span></h3>
								</figcaption>
							</a>
						</figure>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="javascript:;" title="广州医疗美容会所"><img src="skin/images/1-1P3201211110-L.jpg" alt="广州医疗美容会所" />
								<figcaption>
									<h3>广州医疗美容会所<span>办公写字楼</span></h3>
								</figcaption>
							</a>
						</figure>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="javascript:;" title="生物岛办公室装修"><img src="skin/images/1-1P3201211380-L.jpg" alt="生物岛办公室装修" />
								<figcaption>
									<h3>生物岛办公室装修<span>办公写字楼</span></h3>
								</figcaption>
							</a>
						</figure>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="javascript:;" title="富力新天地办公室"><img src="skin/images/1-1P3201211570-L.jpg" alt="富力新天地办公室" />
								<figcaption>
									<h3>富力新天地办公室<span>餐厅酒楼</span></h3>
								</figcaption>
							</a>
						</figure>
					</div>
					<div class="col-xs-6 col-sm-4 col-md-4 col-lg-4 wow animated fadeInUp">
						<figure>
							<a href="javascript:;" title="温碧泉化妆品"><img src="skin/images/1-1P3201210390-L.jpg" alt="温碧泉化妆品" />
								<figcaption>
									<h3>温碧泉化妆品<span>办公写字楼</span></h3>
								</figcaption>
							</a>
						</figure>
					</div>

				</div>
				<p class="b-m-none">
					<a href="javascript:;" class="btn-center">更多案例 →</a>
				</p>
			</div>
		</section>
		<!--end-->

		<section class="kehu sx-jianju">
			<div class="container text-center">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2" style=" color:#333"> 合作客户 </h2>
					<p class="m-sm"> Testimonials </p>
				</div>
				<div class="row">
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3211000060-L.jpg" alt="网易" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3210959440-L.jpg" alt="酷狗" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P320112Q20-L.jpg" alt="赛意" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P320112J60-L.jpg" alt="创科" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P320112I20-L.jpg" alt="国际影城" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P320112H00-L.jpg" alt="珍爱网" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P320112F40-L.jpg" alt="RUST" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3201126460-L.jpg" alt="迪卡" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3201126340-L.jpg" alt="华晨" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3201126230-L.jpg" alt="LG" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3201125570-L.jpg" alt="蔬稻餐厅" /></figure>
					<figure class="col-xs-4 col-sm-4 col-md-2 col-lg-2 wow animated fadeInUp"><img src="skin/images/1-1P3201125430-L.jpg" alt="温碧泉" /></figure>

				</div>
				<p class="b-m-none">
					<a href="javascript:;" class="btn-center">更多知名客户 →</a>
				</p>
			</div>
		</section>
		<!--end-->

		<section class="team sx-jianju text-center">
			<div class="container">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2-white"> 团队 </h2>
					<p class="m-sm-white"> team </p>
					<p class="m-sm-white2"> 设计、策划、企划、项目管理等各类高端人才系统，从办公室设计到开业全程顾问式设计服务 </p>
				</div>
				<div class="team-box container wow animated fadeInUp">
					<div id="owl-team" class="owl-carousel owl-theme wow animated fadeInUp">
						<div class="item">
							<dl class="dl-horizontal list-unstyled">
								<dt><a href="javascript:;" title="张鑫"><img src="skin/images/1-1P3201103480-L.jpg" alt="张鑫" /></a></dt>
								<dd>
									<h3><a href="javascript:;" title="张鑫">张鑫</a><small>深化设计师</small></h3>
									<p class="hg-3">学习及工作经历： 23年项目管理经验，精通施工工艺、把控工地能力强。 熟悉工地现场施工管理、国家及行业的质量标准、施工工艺及流程、验收规范、材料性能及价格等。 主持过众...</p>
								</dd>
							</dl>
						</div>
						<div class="item">
							<dl class="dl-horizontal list-unstyled">
								<dt><a href="javascript:;" title="陈伟"><img src="skin/images/1-1P3201103480-L.jpg" alt="陈伟" /></a></dt>
								<dd>
									<h3><a href="javascript:;" title="陈伟">陈伟</a><small>深化设计师</small></h3>
									<p class="hg-3">学习及工作经历： 23年项目管理经验，精通施工工艺、把控工地能力强。 熟悉工地现场施工管理、国家及行业的质量标准、施工工艺及流程、验收规范、材料性能及价格等。 主持过众...</p>
								</dd>
							</dl>
						</div>
						<div class="item">
							<dl class="dl-horizontal list-unstyled">
								<dt><a href="javascript:;" title="林凯"><img src="skin/images/1-1P3201103480-L.jpg" alt="林凯" /></a></dt>
								<dd>
									<h3><a href="javascript:;" title="林凯">林凯</a><small>深化设计师</small></h3>
									<p class="hg-3">学习及工作经历： 23年项目管理经验，精通施工工艺、把控工地能力强。 熟悉工地现场施工管理、国家及行业的质量标准、施工工艺及流程、验收规范、材料性能及价格等。 主持过众...</p>
								</dd>
							</dl>
						</div>
						<div class="item">
							<dl class="dl-horizontal list-unstyled">
								<dt><a href="javascript:;" title="李强"><img src="skin/images/1-1P3201103480-L.jpg" alt="李强" /></a></dt>
								<dd>
									<h3><a href="javascript:;" title="李强">李强</a><small>深化设计师</small></h3>
									<p class="hg-3">学习及工作经历： 23年项目管理经验，精通施工工艺、把控工地能力强。 熟悉工地现场施工管理、国家及行业的质量标准、施工工艺及流程、验收规范、材料性能及价格等。 主持过众...</p>
								</dd>
							</dl>
						</div>

					</div>
				</div>
				<p class="t-m-30 b-m-none">
					<a href="javascript:;" class="btn-center">更多团队 →</a>
				</p>
			</div>
		</section>
		<!--end-->

		<section class="youshi sx-jianju text-center">
			<div class="container">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2"> 为什么选择我们 </h2>
					<p class="m-sm"> Why choose us </p>
					<p class="m-sm2"> 空间装饰设计服务三大优势和三大保障，关乎最终效果体现的根本，我们将其列为重中之重。 </p>
				</div>
				<div class="row">

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163434135.png"/></dt>
							<dd>
								<h3>15年诚信品牌</h3>
								<p class="hg-2">5年诚信企业，设计与施工二级资质，追求专业设计，注重施工品质。</p>
							</dd>
						</dl>
					</div>

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163523C9.png"/></dt>
							<dd>
								<h3>8项设计系统</h3>
								<p class="hg-2">精确定位客户需求，系统化、人性化且符合人体工程学的创意设计。</p>
							</dd>
						</dl>
					</div>

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163540364.png"/></dt>
							<dd>
								<h3>专业工程管控</h3>
								<p class="hg-2">专业的施工团队，系统化的工程控制，做到保质保量保时间。</p>
							</dd>
						</dl>
					</div>

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163555405.png"/></dt>
							<dd>
								<h3>24小时全方位服务</h3>
								<p class="hg-2">全方位，高品质的售后体系，24小时响应，时刻铭记为客户服务。</p>
							</dd>
						</dl>
					</div>

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163J2J2.png"/></dt>
							<dd>
								<h3>坚持环保理念</h3>
								<p class="hg-2">从设计之初就注重环保、设计、工艺及材料的使用，保证全局环保性。</p>
							</dd>
						</dl>
					</div>

					<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt><img src="skin/images/1-1P320163P3963.png"/></dt>
							<dd>
								<h3>一站式无忧配套</h3>
								<p class="hg-2">智能空间、消防报建、办公家具、软装配饰等一站式配套，省心无忧。</p>
							</dd>
						</dl>
					</div>

				</div>
				<p class="b-m-none t-m-10">
					<a href="javascript:;" class="btn-center">更多优势 →</a>
				</p>
			</div>
		</section>
		<!--end-->

		<section class="tixi sx-jianju">
			<div class="container text-center">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2-white"> 服务体系 </h2>
					<p class="m-sm-white"> service system </p>
					<p class="m-sm-white2"> 高效的服务体系，打造更高端地装饰设计作品 </p>
				</div>
				<div class="row system">
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-tuandui"></span> </p>
							<h3> 15年诚信企业 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-sheji"></span> </p>
							<h3> 8项设计系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-fengshui"></span> </p>
							<h3> 符合风水自然 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-chengben"></span> </p>
							<h3> 成本控制系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-zhiliang"></span> </p>
							<h3> 质量管理系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-cailliao"></span> </p>
							<h3> 材料保障 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-zhaoming"></span> </p>
							<h3> 节能设计 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-office"></span> </p>
							<h3> 智能办公系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-xiaofang"></span> </p>
							<h3> 智能空调系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-ruodian"></span> </p>
							<h3> 消防报建 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-ruanzhuang"></span> </p>
							<h3> 软装配饰系统 </h3>
						</figure>
					</div>
					<div class="col-xs-4 col-sm-2 col-md-2 col-lg-2 wow animated fadeInUp">
						<figure>
							<p class="ico"> <span class="icon-yzspt"></span> </p>
							<h3> 一站式配套 </h3>
						</figure>
					</div>
				</div>
			</div>
		</section>
		<!--end-->

		<section class="about sx-jianju text-center">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
						<div class="home-title wow animated fadeInUp">
							<h2 class="h-h2-white"> 关于 </h2>
							<p class="m-sm-white"> About </p>
							<p class="m-sm-white2"> 15年耕耘，上千成功案例，客户满意度高达95%以上 </p>
						</div>
						<p class="hg-4 wow animated fadeInUp"> 武汉某某装饰集团股份有限公司由余先生创办于1991年，1998年经国家工商行政总局商标局注册，以某某装饰为品牌商标标识。某某装饰是一家以承担各类建筑室内、室外装饰装修工程设计和施工为主，以制造家具，销售建筑装饰材料、装饰工艺品和家具为辅的大型专业装饰集团公司。公司注册资本1.59亿元，分支机构遍布全国20多个省、直辖市、自治区，拥有下属企业400多家，设计师5000多人，工程管理人员50000多人，是中国驰名商标企业，中国建筑协会常务理事单位，中国建筑装饰协会住宅委员会副主任委员单位和设计委员会副主...</p>
						<div class="row shuju">
							<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 wow animated fadeInUp">
								<figure>
									<figcaption>
										<h3>15年</h3>
										<p>资深行业经验</p>
									</figcaption>
								</figure>
							</div>
							<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 wow animated fadeInUp">
								<figure>
									<figcaption>
										<h3>8项</h3>
										<p>设计系统保障</p>
									</figcaption>
								</figure>
							</div>
							<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 wow animated fadeInUp">
								<figure>
									<figcaption>
										<h3>1000+</h3>
										<p>品牌成功案例</p>
									</figcaption>
								</figure>
							</div>
							<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3 wow animated fadeInUp">
								<figure>
									<figcaption>
										<h3>95%</h3>
										<p>客户满意度</p>
									</figcaption>
								</figure>
							</div>
						</div>
						<p>
							<a href="javascript:;" class="btn-center">详细了解 →</a>
							<a href="javascript:;" class="btn-center">荣誉资质 →</a>
						</p>
					</div>
				</div>
			</div>
		</section>
		<!--end-->
		<section class="news sx-jianju">
			<div class="container text-center">
				<div class="home-title wow animated fadeInUp">
					<h2 class="h-h2"> 资讯 </h2>
					<p class="m-sm"> </p>
					<ul class="list-inline menu-kj2">

						<li>
							<a href="javascript:;">动态</a>
						</li>

						<li>
							<a href="javascript:;">问答</a>
						</li>

						<li>
							<a href="javascript:;">行业</a>
						</li>

						<li>
							<a href="javascript:;">常识</a>
						</li>

					</ul>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="将文化融入设计 以设计推动创新">将文化融入设计 以设计推动创新</a> <img src="skin/images/new.gif" alt="将文化融入设计 以设计推动创新"/></h3>
								<p class="hg-2">2013年11月13日，装饰有限公司联合北京大学政府管理学院承办了...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="迎“七一” 抓党建 除“四风”">迎“七一” 抓党建 除“四风”</a> <img src="skin/images/new.gif" alt="迎“七一” 抓党建 除“四风”"/></h3>
								<p class="hg-2">在七一建党节到来之际，为庆祝中国共产党成立92周年,进一步推...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="低碳建筑首选天然石材 环保健康受欢迎">低碳建筑首选天然石材 环保健康受欢迎</a> <img src="skin/images/new.gif" alt="低碳建筑首选天然石材 环保健康受欢迎"/></h3>
								<p class="hg-2">所谓低碳经济，是指在可持续发展理念指导下，通过技术创新、...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="装修旺季促销建材家居景气指数回升">装修旺季促销建材家居景气指数回升</a> <img src="skin/images/new.gif" alt="装修旺季促销建材家居景气指数回升"/></h3>
								<p class="hg-2">由中国建筑材料流通协会发布的全国建材家居景气指数BHI9月份为...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="全球原木材原料严重紧缺危及建材行业">全球原木材原料严重紧缺危及建材行业</a> <img src="skin/images/new.gif" alt="全球原木材原料严重紧缺危及建材行业"/></h3>
								<p class="hg-2">据了解，中国原木材及下游产品主要的进口贸易国依次为马来西...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="中国经济数据公布 GDP总量料破70万亿元">中国经济数据公布 GDP总量料破70万亿元</a> <img src="skin/images/new.gif" alt="中国经济数据公布 GDP总量料破70万亿元"/></h3>
								<p class="hg-2">按照日程安排，国家统计局今日将公布2016年国内生产总值(GDP)等...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="珠三角GDP总量超西班牙 进入“湾区经济”时代">珠三角GDP总量超西班牙 进入“湾区经济”时代</a> <img src="skin/images/new.gif" alt="珠三角GDP总量超西班牙 进入“湾区经济”时代"/></h3>
								<p class="hg-2">继2014年深圳市政府工作报告中首次提出发展湾区经济之后，在今...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="智慧城市建设莫入误区">智慧城市建设莫入误区</a> <img src="skin/images/new.gif" alt="智慧城市建设莫入误区"/></h3>
								<p class="hg-2">智慧城市是城市治理创新的重要方面。国家信息中心信息化研究...</p>
							</dd>
						</dl>
					</div>
					<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 wow animated fadeInUp">
						<dl class="dl-horizontal">
							<dt class="cssa274b01dd50cc">03-22<span>2018</span></dt>
							<dd>
								<h3><a href="javascript:;" title="当结构邂逅设计 发生了什么？">当结构邂逅设计 发生了什么？</a> <img src="skin/images/new.gif" alt="当结构邂逅设计 发生了什么？"/></h3>
								<p class="hg-2">在业内看来，新政明确了通过中介机构完成的交易必须在各区房...</p>
							</dd>
						</dl>
					</div>

				</div>
				<p class="t-m-20">
					<a href="javascript:;" class="btn-center">更多资讯 →</a>
				</p>
			</div>
		</section>
		<footer class="foot text-center">
			<div class="addess">
				<div class="container">
					<div class="row">
						<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<dl class="dl-horizontal list-unstyled">
								<dt><span class="icon-foot-addess"></span></dt>
								<dd>
									<h3>中国·武汉市</h3>
									<p>武昌区经济开发区</p>
								</dd>
							</dl>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<dl class="dl-horizontal list-unstyled">
								<dt><span class="icon-foot-tel"></span></dt>
								<dd>
									<h3>24小时服务</h3>
									<p>027-88888888</p>
								</dd>
							</dl>
						</div>
						<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
							<dl class="dl-horizontal list-unstyled">
								<dt><span class="icon-foot-map"></span></dt>
								<dd>
									<h3><a href="javascript:;" target="_blank">在地图上找到我们</a></h3>
									<p>欢迎阁下莅临公司参观指导！</p>
								</dd>
							</dl>
						</div>
					</div>
				</div>
			</div>
			<div class="copy container">
				<ul class="list-inline menu-kj list-paddingleft-2">

					<li>
						<p>
							<a href="javascript:;">设计</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">优势</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">案例</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">团队</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">关于</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">资讯</a>
						</p>
					</li>

					<li>
						<p>
							<a href="javascript:;">联系</a>
						</p>
					</li>

				</ul>
				<p>
					Copyright &copy; 2002-2018 某某装饰有限公司 版权所有 <span class="hidden-xs"><a href="javascript:;" target="_blank">备案号：鄂ICP备88888888号</a></span></p>
				<ul class="list-inline kjcd">
					<li class="qq">
						<a href="javascript:;" target="_blank"><span class="icon-qq"></span></a>
					</li>
					<li class="weixin">
						<a href="javascript:;" data-toggle="modal" data-target="#foot-weixin"><span class="icon-weixin"></span></a>
					</li>
					<li class="weibo">
						<a href="javascript:;" target="_blank"><span class="icon-weibo"></span></a>
					</li>
				</ul>
				<div class="well hidden-xs"> 友情链接：
					<a href="http://www.mycodes.net/" target="_blank">源码之家</a> /
					<a href="http://#" target='_blank'>源码商城</a> /
					<a href="http://#" target='_blank'>DedeCMS模板</a> /
					<a href="http://#" target='_blank'>响应式模板</a> /
					<a href="http://#" target='_blank'>企业网站模板</a> / 链接交换QQ：1236549 </div>
				<div class="modal fade" id="foot-weixin" tabindex="-1" role="dialog" aria-labelledby="myweixin" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content text-center">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
								<h4 class="modal-title" id="myweixin">微信扫一扫，关注我们</h4>
							</div>
							<div class="modal-body"> <img src="skin/images/weixin-pic.jpg" alt="微信公众号" />
								<p>打开微信，使用扫一扫即可关注我们。</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
		<!--end-->
		<ul class="list-unstyled kefu visible-xs-block">
			<li>
				<a class="gt" href="javascript:;" title="在线沟通" target="_blank"><span class="icon-goutong"></span></a>
			</li>
			<li class="hidden-xs">
				<a class="lx" href="javascript:;" title="联系"><span class="icon-page-lianxi"></span></a>
			</li>
			<li class="visible-xs-inline-block">
				<a class="lx" href="javascript:;" title="拔打电话"><span class="icon-page-lianxi"></span></a>
			</li>
			<li>
				<a id="top" class="top" href="javascript:;" title="回顶部"><span class="icon-top"></span></a>
			</li>
		</ul>
		<!--end-->
		<script src="skin/js/jquery.min.js"></script>
		<script src="skin/js/owl.carousel.min.js"></script>
		<script src="skin/js/owl.carousel.quote.js"></script>
		<script src="skin/js/wow.min.js"></script>
		<script src="skin/js/base.js"></script>
		<script src="skin/js/bootstrap.min.js"></script>
		<script>
			wow = new WOW({
				animateClass: 'animated',
				offset: 100
			});
			wow.init();
			document.getElementById('moar').onclick = function() {
				var section = document.createElement('section');
				section.className = 'section--purple wow fadeInDown';
				this.parentNode.insertBefore(section, this);
			};
		</script>
		<script src="skin/js/fastclick.min.js"></script>
		<script>
			$(function() {
				$(".navbar-nav li:first-child").addClass("hover");
			})
		</script>
	</body>

</html>