<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <HEAD>  
  <TITLE> New Document </TITLE>  
  <META NAME="Generator" CONTENT="EditPlus">  
  <META NAME="Author" CONTENT="">  
  <META NAME="Keywords" CONTENT="">  
  <META NAME="Description" CONTENT="">  
  <style>      
    @media print {    
        .noprint {     
            display: none     
        }    
    }    
  </style>    
   <script language="javascript">  
       //提示窗口  
       function printit(MyDiv,type){  
            if(type=='Preview'&&!-[1,]){     
                document.all.WebBrowser.ExecWB(7,1);  
            }else{                                     
     　　      var newstr = document.getElementById(MyDiv).innerHTML;  
     　　      var oldstr = document.body.innerHTML;  
     　　      document.body.innerHTML = newstr;  
     　　      window.print();  
     　　      document.body.innerHTML = oldstr;  
                return false;  
            }  
       }  
  </script>  
 </HEAD>  
<BODY>  
    
    <span id='div1'>把要打印的内容放这里
    
          <table class="layui-table">
        <thead>
          <tr style="background-color:orange;">
            <th colspan="2">细项</th>
            <th>结果</th>
            <th>参考</th>
            <th>单位</th>
        </thead>
        <tbody>
          <c:forEach items="${finrList}" var="list" step="1" varStatus="vs">
			<tr>
			   <td colspan="2">${list.termBean.term}</td>
			   <td>${list.termVal}</td>
			   <td>${list.termBean.none}</td>
			   <td>${list.termBean.measur}</td>
			</tr>
			</c:forEach>
        </tbody>
      </table>
    
    </span></br> </br>   
       
    <span class="noprint" >不打印的内容放这里</span>  </br>  </br>   
       
    <OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height="0" id="WebBrowser" width="0" VIEWASTEXT></OBJECT>  
  
    <input type="button" value="预览" onclick="javascript:printit('div1','Preview');">  
    <input type="button" id="button_print" name="button_print" value="打印本单据" onclick="javascript:printit('div1','print');">  
 </BODY>  
</HTML>  