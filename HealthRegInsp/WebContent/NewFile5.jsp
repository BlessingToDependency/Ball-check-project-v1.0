<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>图</title>
<style>    
@media print {  
.noprint {   
display: none   
}  
}  
</style>
<body>
这里是打需要打印的内容.<span class="noprint">我只显示不打印哦，很神奇吧。哈哈</span>  
<div class="noprint" >  
<table style="margin:0 auto;width:500px;">  
    <tr align="center" ><td>  
      <object id="WebBrowser" classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0"  
                    width="0">  
      </object>  
       <input type="button" value="测试" onclick="foo6();">  
  <input type="button" value="打印" onclick="foo(6,1);">  
  <input type="button" value="页面设置" onclick="foo2(8,1);">  
<input type="button" value="直接打印" onclick="foo3(6,6)">  
  <input type="button" value="打印预览" onclick="document.all.WebBrowser.ExecWB(7,1)">  
    </td></tr>  
</table></div>
</body>
<script type="text/javascript">
function foo6()
{
document.execCommand("print");
}


function foo(a,b)
{
if (window.navigator.userAgent.indexOf("Chrome") !== -1)
webbrowser.exewb(a,b);
else
window.print();
}

function foo2(a,b)
{
if (window.navigator.userAgent.indexOf("Chrome") !== -1)
webbrowser.exewb(a,b);
else
window.print();
}

function foo3(a,b)
{
if (window.navigator.userAgent.indexOf("Chrome") !== -1)
webbrowser.exewb(a,b);
else
window.print();
}

function foo4(a,b)
{
if (window.navigator.userAgent.indexOf("Chrome") !== -1)
webbrowser.exewb(a,b);
else
window.print();
}
</script>
</html>