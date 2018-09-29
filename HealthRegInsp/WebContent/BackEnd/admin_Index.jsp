<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>团检系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" /> -->
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>css/font.css">
	<link rel="stylesheet" href="<%=path%>css/xadmin.css">
    <script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>
    <script src="<%=path%>lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>js/xadmin.js"></script>

</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.html">健康生活优质团检后台系统</a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
              <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
               <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
            </dl>
          </li>
        </ul>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">admin</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
              <dd><a href="./login.html">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        	
            <c:forEach items="${parentList}" var="parent" varStatus="varSt">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>${parent.menu }</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                <c:forEach items="${sonList}" var="son" varStatus="status">
                 <c:if test="${son.parId == parent.jurisId}">
                    <li>
                        <a _href="<%=path%>${son.url }">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>${son.menu }</cite>
                        </a>
                    </li>
                    </c:if>
                </c:forEach>
                </ul>
            </li>
           </c:forEach> 
           
          <%-- <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>会员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>userAdminAction/company.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>会员列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
                  <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>医生作结</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>doctorSummaryAction/getThisItemStaff.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>医生小结</cite>
                        </a>
                    </li>
                      <li>
                        <a _href="<%=path%>adminParamAction/systemParam.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>医生总结</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>科室医生</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>doctorAction/doctorMain.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>查询</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
            
            
            
            
            <!--体检报告  -->
         <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>体检报告</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>Report/showRepoert.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>体检报告</cite>
                        </a>
                    </li>
                     <li>
                        <a _href="<%=path%>Report/showCompany.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>团检套餐配置</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>团检单位开单</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>openBillAction/massInspList.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>团检单位列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>后台人员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                         <a _href="<%=path%>maDoctorAction/selectAllDoctor.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>医生管理</cite>
                        </a>
                    </li >
                      <li>
                        <a _href="<%=path%>adminManagerAction/getAdminList.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>科室管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                          <a _href="<%=path%>maDeparAction/selectDe.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>科室管理</cite>
                         </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>体检项目管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                      <li>
                         <a _href="<%=path%>Order/showOrder.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>套餐配置管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="<%=path%>adminLitemAction/selectItem.action?page=1&itemName=&peakPrice=&bottomPrice=">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>项目配置管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="<%=path%>adminDetailAction/selectDetail.action?page=1&termName=">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>细项配置管理</cite>
                        </a>
                    </li >
                </ul>
            </li>
            
            
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>权限角色管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                         <a _href="<%=path%>maRoleAction/selectAllRole.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>角色管理</cite>
                        </a>
                    </li>
                      <li>
                        <a _href="<%=path %>adminJurisAction/showRole.action?page=1&role=">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限分配</cite>
                        </a>
                    </li>
                      <li>
                        <a _href="<%=path%>adminPrivilegeAction/selectPrivilege.action?page=1&menu=">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>菜单管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
            
            
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ce;</i>
                    <cite>系统统计</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="echarts1.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>拆线图</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="echarts2.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>柱状图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts3.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>地图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts4.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>饼图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts5.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>雷达图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts6.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>k线图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts7.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>热力图</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="echarts8.html">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>仪表图</cite>
                        </a>
                    </li>
                </ul>
            </li>
            
             <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>系统参数配置</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>adminParamAction/systemParam.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>参数配置</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>日志管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="<%=path%>logAction/selectAllLog.action">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>日志查看</cite>
                        </a>
                    </li>
                </ul>
            </li>   --%>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright">Copyright ©2017 x-admin 2.3 All Rights Reserved  更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></div>  
    </div>
    <!-- 底部结束 -->

</body>
</html>