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
<title>局部打印案例</title>
<OBJECT ID="DLPrinter" CLASSID="CLSID:5C230622-45E5-4e3c-893C-3BFDDC4DB5E4"  codebase="DLPrinter.cab" height="0" width="0" ></OBJECT>
<script>
  DLPrinter.MarginLeft=20;
  DLPrinter.MarginRight=20;
  DLPrinter.MarginTop=20;
  DLPrinter.MarginBottom=20;
  DLPrinter.CopyCount=2;
  DLPrinter.PageHeader="这是测试的页眉";
  DLPrinter.PageFooter="这是测试的页脚";
  DLPrinter.IsLandScape=1;
      //DLPrinter.ContentURL="www.baidu.com";
    //DLPrinter.ContentURL="http://www.cnblogs.com/Yahong111/archive/2007/09/19/898326.html";
</script>
 <body>
<input type="button" id="btnPrint" value="Print Preview" onclick="DLPrinter.PrintPreview()" />
<input type="button" id="btnPrint" value="Print with prompt" onclick="DLPrinter.Print()" />
<input type="button" id="btnPrint" value="Print without prompt" onclick="DLPrinter.PrintDirect()" />
</body>
<script>
  DLPrinter.MarginLeft=20;
  DLPrinter.MarginRight=20;
  DLPrinter.MarginTop=20;
  DLPrinter.MarginBottom=20;
  DLPrinter.CopyCount=2;
  DLPrinter.PageHeader="这是测试的页眉";
  DLPrinter.PageFooter="这是测试的页脚";
  DLPrinter.IsLandScape=1;
      //DLPrinter.ContentURL="www.baidu.com";
    //DLPrinter.ContentURL="http://www.cnblogs.com/Yahong111/archive/2007/09/19/898326.html";
</script>
</html>