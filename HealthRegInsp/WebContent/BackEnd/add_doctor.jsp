<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%
String path = request.getScheme() +"://"+request.getServerName()
	+":"+request.getServerPort()+ request.getContextPath()+"/";%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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


<script type="text/javascript">
function checkPhone(){

	  $.ajax({
		  type:"post",
 	   url:"<%=path%>maDoctorAction/checkPhone.action",
 	   data:{"phone":$("#phone").val()},
 	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
		    	$("#us").html(redata);
			}
		  
		  
	  });

} 

function checkidNum(){

	  $.ajax({
		  type:"post",
	   url:"<%=path%>maDoctorAction/checkidNum.action",
	   data:{"idNum":$("#idNum").val()},
	   dataType:"json",
			success : function(redata) {//定义各事件发生时回调的函数
			  console.log(redata);
			
		    	$("#ids").html(redata);
			}
		  
		  
	  });

} 
</script>
</head>
<body>
    <div class="x-body">
        <form class="layui-form" method="post" action="<%=path%>maDoctorAction/AddDoctor.action" enctype="multipart/form-data">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="adminName" name="adminName" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
           <div class="layui-form-item">
              <label for="age" class="layui-form-label">
                  <span class="x-red">*</span>年龄
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="age" name="age" required="" lay-verify="number"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
            <div class="layui-form-item">
             <label for="sex" class="layui-form-label">
                  <span class="x-red">*</span>性别
             </label>
             <div class="layui-input-block">
               <input name="sex" value="男" title="男" checked="" type="radio">
               <input name="sex" value="女" title="女" type="radio">
             </div>
         </div>
          
              <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>身份证
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="idNum" name="idNum" required="" lay-verify="required"
                  autocomplete="off" class="layui-input"  onblur="checkidNum()"><samp id="ids"></samp>
         
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span><span id="ts" style="color:red"></span>
              </div>
          </div>
          
            <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>头像
              </label>
              <div class="layui-input-inline">
                  <input type="file" id="fileact" name="fileact" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
                  <img src="" id="img0" style="width: 15rem; height: 10rem;">
                  
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
                  autocomplete="off" class="layui-input" onblur="checkPhone();"><samp id="us"></samp>
                  
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required="" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
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
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="adminPwd" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
                         <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>毕业院校
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="graduated" name="graduated" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
                 </div>
           
          
                  <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>背景
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="background" name="background" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
      </form>
    </div>







<%-- <form id="form1" name="form1" method="post" action="<%=path%>maDoctorAction/AddDoctor.action" enctype="multipart/form-data" >
<table width="454" border="1" align="center">
  <tr>
    <td width="28">姓名</td>
    <td width="344"><label for="textfield"></label>
      <input type="text" name="adminName" id="adminName" /></td>
  </tr>
  <tr>
    <td>密码</td>
    <td><label for="textfield2"></label>
      <input type="password" name="adminPwd" id="adminPwd" /></td>
  </tr>
    <tr>
    <td>头像</td>
    <td>
      <input type="file" name="fileact" id="fileact" multiple="multiple"/>
       <img src="" id="img0" style="width: 5rem; height: 5rem;">
      </td>
  </tr>
    <tr>
    <td>身份证号</td>
    <td><input type="text" name="idNum" id="idNum" onblur="checkidNum()"/><samp id="ids"></samp></td>
  </tr>
  
      <tr>
    <td>邮箱</td>
    <td><input type="text" name="email" id="email" /></td>
  </tr>
  <tr>
    <td>年龄</td>
    <td><input type="text" name="age" id="age" /></td>
  </tr>
  <tr>
    <td>性别</td>
    <td><input type="radio" name="sex" id="sex" value="男" />
      <label for="radio">男
        <input type="radio" name="sex" id="sex" value="女" />
      女</label></td>
  </tr>
  <tr>
    <td>手机号</td>
    <td><input type="text" name="phone" id="phone" onblur="checkPhone()"/><samp id="us"></samp></td>
  </tr>
  <tr>
    <td>毕业院校</td>
    <td><input type="text" name="graduated" id="graduated" /></td>
  </tr>
  <tr>
    <td>职务</td>
    <td><label for="select"></label>
      <select name="postId" id="postId">
       <c:forEach items="${postList}"  var="post" >
        <option value="${post.postId}">${post.post}</option>
      </c:forEach>
      </select></td>
  </tr>
  <tr>
    <td>科室</td>
    <td><select name="depaId" id="depaId">
    <c:forEach items="${deparList}"  var="depar" >
        <option value="${depar.depaId}">${depar.depa}</option>
      </c:forEach>
    </select></td>
  </tr>
  <tr>
    <td>背景</td>
    <td><label for="textarea"></label>
      <textarea name="background" id="background" cols="45" rows="5"></textarea></td>
  </tr>
  <tr>
    <td colspan="2"><input type="submit" name="button" id="button" value="提交" />
      <input type="reset" name="button3" id="button3" value="重置" />
      
    </td>
  </tr>
</table>
</form> --%>
</body>
<script>
		$("#fileact").change(function() {
			var objUrl = getObjectURL(this.files[0]);//获取文件信息  
			console.log("objUrl = " + objUrl);
			if (objUrl) {
				$("#img0").attr("src", objUrl);
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