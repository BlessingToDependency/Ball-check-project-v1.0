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
		<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0, user-scalable=no">
		<title>购物车-地址及付款详情</title>
		<!--css类引用-->
		<link rel="stylesheet" href="<%=path %>plugins/bootstrap/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=path %>plugins/layui/css/layui.css" />
		<link rel="stylesheet" href="<%=path %>plugins/awesome/css/font-awesome.min.css" />
		<link rel="stylesheet" href="<%=path %>plugins/eleme-ui/index.css" />
		<link rel="stylesheet" href="<%=path %>css/CivilMilitaryIntegration/public.css" />
		<link rel="stylesheet" href="<%=path %>css/CivilMilitaryIntegration/ShoppingCartAdress.css" />
	</head>
<body>
<!--主要内容-->
		<div class="row" id="myVue"  v-cloak>
			<div class="col-lg-10 col-lg-offset-1" >
				<el-row style="text-align: center;margin-top: 5px;background: #F1F1F1;">
				<h1><font size="7">订单详情</font></h1>
				</el-row>
				<div class="contenter">
					<ul>
						<li>
							<el-row>
								<span class="addAddressCons">收货人信息</span>
								<!-- <span class="addAddress" @click="AddressShowClick">新增收货地址</span> -->
							</el-row>
							<div class="scolleShow" >
							<el-row  class="consignee" v-for="(items,index) in filterAddress"  >
								<div v-on:mouseout="MouseOutList(items)" v-on:mouseleave="MouseOverList(items)">
									<el-col :span='4'>
										<div class="consigneeList consigneeListWidth"  :class="{'consigneeListClick':items.addressDefult}" @click="currentIndexClick(items,index)">
											<span>${userBean.contacts }</span>
											<span></span>
											<div v-show="items.addressDefult">
												<div class="arrow-right"></div>
												<i class="fa fa-check" aria-hidden="true"></i>
											</div>
										</div>
									</el-col>
									<el-col class='rightAddress'  :span='20' :class='{BackColor:items.addressIsShow}'>
										<span0> ${userBean.address } ${userBean.phone }</span>
										
										<span v-if='items.isShowDefult' class="addressDefultClass">默认地址</span>
									</el-col>
									<div class="clearfix"></div>
								</div>
							</el-row>
							</div>
						</li>
						<li>
							<span class="addAddressCons">支付方式</span>
							<div class="consignee">
								<span class="consigneeList" v-for="" :class="{'consigneeListClick':paymentIndex == index}" @click="paymentIndex=index">
									<span >支付宝</span>
									
									<div v-show="paymentIndex == index">
										<div class="arrow-right"></div>
										<i class="fa fa-check" aria-hidden="true"></i>
									</div>
								</span>
							</div>
						</li>
						
						<li>
							<span class="addAddressCons">发票信息</span>
							<div class="consignee">
								<span class="consigneeList" v-for="(invoiceDatas,index) in invoicedatas" :class="{'consigneeListClick':invoiceIndex == index}" @click="invoiceIndex=index">
									<span v-text="invoiceDatas.name"></span>
									<div v-show="invoiceIndex == index">
										<div class="arrow-right"></div>
										<i class="fa fa-check" aria-hidden="true"></i>
									</div>
								</span>
							</div>
							<div class="consignee" v-if="invoiceIndex > 0">
								<span class="CompanyInformation">增值税普通发票</span>
								<span class="CompanyInformation">公司名</span>
								<span class="CompanyInformation">套餐名</span>
							</div>
							
						</li>
					</ul>
					<div class="row totalRow">金额抵用：{{couponPrice | moneyFiler}}</div>
				</div>
				<c:forEach items="${setList}" var="setmealBean">
				<div class="contenterFooter">
				<font size="4">
					<p>套餐名：<span class="footerPrice">${setmealBean.setmeal }</span></p>
					<p>选购数量：<span class="footerPrice">${setmealBean.number }</span></p>
					<p>总金额：<span class="footerPrice">${setmealBean.countAll*setmealBean.number }</span></p>
					<p>优惠折扣：<span class="footerPrice footercouponPrice">${setmealBean.discount }</span></p>
				</font>
				</div>
				<div class="clearfix"></div>
				<div class="row footerRow">
						<span class="footerRowprice">应付金额：<span>￥${setmealBean.countAll*setmealBean.discount*setmealBean.number }</span></span>  
				</div>
				</c:forEach>
				<button class="btn submitForm">提交订单</button>
			</div>
		</div>

		<!--js类引用-->
		<script type="text/javascript" src="<%=path %>plugins/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="<%=path %>plugins/bootstrap/bootstrap.min.js"></script>
		<script type="text/javascript" src="<%=path %>plugins/vue/vue.js"></script>
		<script type="text/javascript" src="<%=path %>plugins/eleme-ui/index.js"></script>
		<script type="text/javascript" src="<%=path %>js/CivilMilitaryIntegration/ShoppingCart.js"></script>
</body>
</html>