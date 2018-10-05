<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link href="<%=path%>css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
</head>
<body>
    <div class="x-body">
        <form class="layui-form" method="post" action="<%=path%>maDoctorAction/updateDoctorInfo.action" enctype="multipart/form-data">
         <c:forEach items="${adList}"  var="adList" >
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>姓名:
              </label>
              
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*${adList.adminName}</span>
              </div>
          </div>
          
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>背景
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="background" name="background" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${adList.background}">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
                    
          
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input" onblur="checkPhone();" value="${adList.phone}"><samp id="us"></samp>
                  
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          
          
            <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>毕业院校
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="graduated" name="graduated" required="" lay-verify="required"
                  autocomplete="off" class="layui-input" value="${adList.graduated}">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
              </div>
              </c:forEach>
          <div class="layui-form-item">
              <label class="layui-form-label"><span class="x-red">*</span>职务</label>
              <div class="layui-input-block">
                <select name="postId" id="postId" style="width: 150px;">
                    <c:forEach items="${postList}"  var="post" >
                     <option value="${post.postId}">${post.post}</option>
                    </c:forEach>
              </select>
              </div>
          </div>
                 <div class="layui-form-item">
              <label class="layui-form-label"><span class="x-red">*</span>科室</label>
              <div class="layui-input-block">
               <select name="depaId" id="depaId">
               <c:forEach items="${deparList}"  var="depar" >
                 <option value="${depar.depaId}">${depar.depa}</option>
                   </c:forEach>
                  </select>
              </div>
          </div>
          
         
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  保存
              </button>
          </div>
      </form>
    </div>

</body>
<script type="text/javascript">
layui.use(['form','layer'], function(){
    $ = layui.jquery;
  var form = layui.form
  ,layer = layui.layer;

  //自定义验证规则
  form.verify({
    nikename: function(value){
      if(value.length < 5){
        return '昵称至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,repass: function(value){
        if($('#L_pass').val()!=$('#L_repass').val()){
            return '两次密码不一致';
        }
    }
  });	
});

</script>
</html>