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
    <title>普通小结</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
     <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
<style type="text/css">

.main td{ height:10px; border:#CCCCCC 1px solid;}
#zsdiv1{width:30%; margin: 2px 2px 2px 2px; border:gray 3px solid; text-align:right; float:left;}
#zsdiv2{width:18%; margin: 2px 2px 2px 2px; border:gray 3px solid; text-align:center; float:left;}
#zsdiv3{width:30%; margin: 2px 2px 2px 2px; border:gray 3px solid; text-align:left; float:left;}
       
</style>
  </head>
  
   <body>
    <div class="x-body">
        <form method="post" action="<%=path%>doctorSummaryAction/submitSummary.action">
     
     <input type="hidden" id="guChId" name="guChId" value="${giBean.guChId}">
     <input type="hidden" id="itemId" name="itemId" value="${giBean.itemId}">
     <input type="hidden" id="doctor" name="doctor" value="${giBean.doctor}">
      
                <div class="layui-form-item layui-form-text">
         <blockquote class="layui-elem-quote">${giBean.item}</blockquote>
      <pre class="layui-code" lay-title="JavaScript" lay-skin="notepad">
      <c:forEach items="${finrList}" var="list" step="1" varStatus="vs">
      <span><div id="zsdiv1">${list.termBean.term}</div></span><span><div id="zsdiv2">${list.termVal}</div></span> <span><div id="zsdiv3">${list.termBean.measur}</div></span>
     </c:forEach>
      </pre>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                       小结内容：
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="sumCont" name="sumCont" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align:center;">
                <button type="submit" class="layui-btn">提交</button>
                 <a href="<%=path%>doctorSummaryAction/getThisItemStaff.action"><button type="button" class="layui-btn">返回</button></a>
              </div>
            </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
          
        });
    </script>

  </body>

</html>