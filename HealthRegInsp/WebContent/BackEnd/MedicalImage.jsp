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
    <title>影像体检</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
     <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
     <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css"  media="all">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
   <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <style>
         #div{width:100%; height:100px;margin: 10px 30px 2px 0px; border:gray 1px solid;text-align:center; float:left;}
	</style>
  </head>
  
   <body>
    <div class="x-body">
         <form action="<%=path%>imageAction/fileact.action" method="post" enctype="multipart/form-data">
     
    <%--  <input type="hidden" id="guChId" name="guChId" value="${giBean.guChId}"> --%>
     <input type="hidden" id="itemId" name="itemId" value="${giBean.itemId}">
     <input type="hidden" id="doctor" name="doctor" value="${giBean.doctor}">
      
       <div class="layui-form-item layui-form-text">
         <blockquote class="layui-elem-quote">
          <input type="text" id="guChId" name="guChId"  placeholder="请输入导检单号" class="layui-input">
         </blockquote>
      <pre class="layui-code" lay-title="JavaScript" lay-skin="notepad">
        <table  width="100%" border="0" cellspacing="0" cellpadding="0" class="main" class="layui-table layui-input-block">
               <tbody>
                   <tr>
                     <td >
                              <input type="file" name="fileact" id="fileact1" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img1" style="width: 15rem; height: 8rem;">
                    </td>
                    <td>
                              <input type="file" name="fileact" id="fileact2" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img2" style="width: 15rem; height: 8rem;">
                    </td>
                    <td>
                              <input type="file" name="fileact" id="fileact3" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img3" style="width: 15rem; height: 8rem;">
                    </td>
                  </tr>
                  <tr>
                  <td >
                              <input type="file" name="fileact" id="fileact4" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img4" style="width: 15rem; height: 8rem;">
                    </td>
                    <td>
                              <input type="file" name="fileact" id="fileact5" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img5" style="width: 15rem; height: 8rem;">
                    </td>
                    <td>
                              <input type="file" name="fileact" id="fileact6" multiple="multiple"/>
                              <img src="<%=path%>images/bg.jpg" id="img6" style="width: 15rem; height: 8rem;">
                    </td>
                  </tr>
               
               </tbody>
               
            </table>
      </pre>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                       检查结果：
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="termVal" name="termVal" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align:center;">
               <button type="submit" class="layui-btn">提交</button>
                 <a href="<%=path%>doctorSummaryAction/getThisItemStaff.action"><button type="button" class="layui-btn">返回</button></a>
              </div>
            </form>
    </div>
<script>
		$("#fileact1").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img1").attr("src", objUrl);
			}
		});
		$("#fileact2").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img2").attr("src", objUrl);
			}
		});
		$("#fileact3").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img3").attr("src", objUrl);
			}
		});
		$("#fileact4").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img4").attr("src", objUrl);
			}
		});
		$("#fileact5").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img5").attr("src", objUrl);
			}
		});
		$("#fileact6").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img6").attr("src", objUrl);
			}
		});
		function getObjectURL(file) {
			var url = null;
			if (window.createObjectURL != undefined) {
				url = window.createObjectURL(file);
			} else if (window.URL != undefined) { // mozilla(firefox)  
				url = window.URL.createObjectURL(file);
			} else if (window.webkitURL != undefined) { // webkit or chrome  
				url = window.webkitURL.createObjectURL(file);
			}
			return url;
		}
	</script>

  </body>

</html>