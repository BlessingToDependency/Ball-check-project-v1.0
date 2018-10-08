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
<title>统计柱状图</title>
 <style>      
    @media print {    
        .noprint {     
            display: none     
        }    
    }    
  </style>
<script defer>
function SetPrintSettings() {
	// – advanced features
	factory.printing.SetMarginMeasure(2) // measure margins in inches
	factory.SetPageRange(false, 1, 3) // need pages from 1 to 3
	factory.printing.printer = "HP DeskJet 870C"
	factory.printing.copies = 2
	factory.printing.collate = true
	factory.printing.paperSize = "A4"
	factory.printing.paperSource = "Manual feed"
	// – basic features
	factory.printing.header = "This is MeadCo"
	factory.printing.footer = "Advanced Printing by ScriptX"
	factory.printing.portrait = false
	factory.printing.leftMargin = 1.0
	factory.printing.topMargin = 1.0
	factory.printing.rightMargin = 1.0
	factory.printing.bottomMargin = 1.0
}
</script>
<script language="javascript">

function printsetup(){
	// 打印页面设置
	wb.execwb(8,1);
}

function printpreview(){
	// 打印页面预览
	wb.execwb(7,1);
}
function printit(){
	if (confirm('确定打印吗？')) {
		wb.execwb(6,6)
	}
}
</script>
</head>
<body style='background-color:#FFFFFF;'>
<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height=0 id=wb name=wb width=0></OBJECT>
 	<input type=button name=button_print value="打印" onclick="javascript:printit()">
 	<input type=button　name=button_setup value="打印页面设置" onclick="javascript:printsetup();">
 	<input type=button　name=button_show value="打印预览" onclick="javascript:printpreview();">
 	<input type=button name=button_fh value="关闭" onclick="javascript:window.close();">
</body>
</html>