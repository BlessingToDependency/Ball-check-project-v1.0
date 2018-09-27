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
    <title>检验小结</title>
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

</style>
  </head>
  
   <body>
    <div class="x-body">
        <form action="" method="post" class="layui-form layui-form-pane">
                <div class="layui-form-item layui-form-text">
         <blockquote class="layui-elem-quote">第三代 </blockquote>
      <pre class="layui-code">
          <table  width="100%" border="0" cellspacing="0" cellpadding="0" class="main" class="layui-table layui-input-block">
              <tbody>
                 <tr style="background-color:cyan;">
                    <td colspan="2">
                         <span style="font-size: 16px;;color:orange">细项</span>
                    </td>
                    <td>
                         <span style="font-size: 16px;;color:orange">结果</span>
                    </td>
                    <td>
                         <span style="font-size: 16px;;color:orange">单位</span>
                    </td>
                    <td>
                         <span style="font-size: 16px;;color:fuchsia;">参考</span>
                    </td>
                  </tr>
                  <tr>
                     <td>
                                    的说法是否是
                     </td>
                     <td>
                               撒大大
                     </td>
                  </tr>
               </tbody>
            </table>
      </pre>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="desc" class="layui-form-label">
                       小结内容：
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item" style="text-align:center;">
                <button class="layui-btn" lay-submit="" lay-filter="add">提交</button>
                <button class="layui-btn" lay-submit="" lay-filter="add">返回</button>
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