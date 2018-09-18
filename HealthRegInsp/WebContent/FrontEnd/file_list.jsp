<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>文档管理</title>
<link rel="stylesheet" type="text/css" href="<%=path%>css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>css/newstyle.css" />
<script type="text/javascript" src="<%=path%>js/jquery.min.js"></script>

</head>
<style>
* {
	/* 	margin: 0; */
	padding: 0;
	list-style: none;
}
</style>

<body>

	<!--联系我们-->
	<div class="contract wrap" style="margin-top: 100px;" align:center>
		<div class="title">文档管理</div>
		<div class="contractlist en_contractlist">
			<div class="row">
				<form id="fileForm" name="fileform" method="post" action="fileShow.action">
					<div align="center">
					  <div>文档标题<input name="fileName" value="${fileCon.fileName}" type="text">&nbsp;上传人<input name="userName" value="${fileCon.userName}" type="text">文档类型
						
						<select name=paraId >
						<option value="">-请选择- </option> 
					  	<c:forEach items="${paralist}" var="para">
					  		<option value="${para.paraId }"  <c:if test="${paraId eq para.paraId}">selected="selected"</c:if> > ${para.paraName } </option> 
					  	</c:forEach>
					    </select>
						
						
					   <!--  <s:select theme="simple" name="paraId" list="paralist" listKey="paraId" listValue="paraName" headerKey="" headerValue="--请选择--">					 					  							  						   				  
					   </s:select> -->
					   </div>
						注册时间 
						<label> <input type="text" value="${fileCon.startTime}" class="inline laydate-icon" id="start"
							name="startTime" style="width: 250px; margin-right: 10px;" />
						</label> 至 <label> <input type="text" value="${fileCon.finishTime}" class="inline laydate-icon" id="end"
							name="finishTime" style="width: 250px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" name="query" value="查询" />					
						</label>
						<div>


							<table width="680" border="1">
								<tr>
									<td>文档标题</td>
									<td>上传人</td>
									<td>上传时间</td>
									<td>下载积分</td>
									<td>文档类型</td>
									<td>下载次数</td>
									<td>操作</td>
								</tr>
								<c:forEach items="${fileList}" var="file">
									<tr>
										<td>${file.fileName}   </td>
										<td>${file.user.userName}  </td>
										<td>${file.uploadTime}</td>
										<td>${file.loadPoint} </td>
										<td>${file.filePara.paraName} </td>
										<td>${file.loadNum} </td>
										<c:if test='${file.fileState == 1 }'>
											<td><a onClick="return confirm('是否禁用？') " href=" 
												<%=path%>backstage/updateAction!update.action?userSta=${userSta}&userId=userId=${user.userId}&userName=${userName}&startTime=${startTime}&finishTime=${finishTime}&currentPage=${currentPage}">
													禁用</a>  
											<a  onclick="return confirm('是否删除该用户？') "  href="<%=path%>backstage/delAction!delete.action?&userId=${user.userId}&currentPage=${currentPage}&userName=${userName}&startTime=${startTime}&finishTime=${finishTime}">删除</a>		
											</td>
										</c:if>
										<c:if  test="${fileState == 2 }">
											<td><a onClick="return confirm('是否启用？') " href=" 
												<%=path%>backstage/updateAction!update.action?userSta=${userSta}&userId=${userId}&userName=${userName}&startTime=${startTime}&finishTime=${finishTime}&currentPage=${currentPage}">
													启用</a>
												<a  onclick="return confirm('是否删除该用户？') "  href="<%=path%>backstage/delAction!delete.action?&userId=${user.userId}&currentPage=${currentPage}">删除</a>			
											</td>
										</c:if >
									</tr>
							</c:forEach>

							</table>
							
							<div>当前页数${fileCon.currentPage}/${fileCon.totalPage} 
								<input type="button" name="button" value="上一页" onClick="fileLast()"/> 
								<input type="button" name="button"
									value="下一页" onClick="fileNext()"/>
<%-- 							location.href='<%=path%>backstage/fileManage!fileList.action?&fileName=${fileName}&userName=${userName}&startTime=${startTime}&finishTime=${finishTime}&currentPage=${(currentPage+1)<=totalPage?currentPage+1:totalPage}'
 --%>							</div>
						</div>
				  </div>
				</form>
			</div>
		</div>
	</div>

	<div class="map">
		<!-- <img src="img/map.png" /> -->
		<div class="dingwei">
			<!-- <img src="img/dingwei.png" /> -->
		</div>
		<div class="addr-name en_addr-name">China·Guangzhou·Yuandong</div>
	</div>
	</div>

	<!--footer-->
	<div class="footer">
		<img src="<%=path%>front/img/foot_logo.png" /> 文档分享平台
	</div>
	<script>
		!function() {
			laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
			laydate({
				elem : '#demo'
			});//绑定元素
		}();
		//日期范围限制
		var start = {
			elem : '#start',
			format : 'YYYY-MM-DD hh：mm：ss',
			//min : laydate.now(), //设定最小日期为当前日期 */
			max : laydate.now(), //设定最大日期为当前日期
			istime : true,
			istoday : false,
			choose : function(datas) {
				end.min = datas; //开始日选好后，重置结束日的最小日期
				end.start = datas //将结束日的初始值设定为开始日
			}
		};
		var end = {
			elem : '#end',
			format : 'YYYY-MM-DD hh：mm：ss',
			min : '1099-06-16',
			max : laydate.now(),
			istime : true,
			istoday : false,
			choose : function(datas) {
				start.max = datas; //结束日选好后，充值开始日的最大日期
			}
		};
		laydate(start);
		laydate(end);
		//自定义日期格式
		laydate({
			elem : '#test1',
			format : 'YYYY年MM月DD日',
			festival : true, //显示节日
			choose : function(datas) { //选择日期完毕的回调
				alert('得到：' + datas);
			}
		});
		//日期范围限定在昨天到明天
		laydate({
			elem : '#hello3',
			min : laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
			max : laydate.now(+1)
		//+1代表明天，+2代表后天，以此类推
		});
	</script>
</body>

<script type="text/javascript">
	 function fileNext(){		 	
		    //获得表单
			var form =document.getElementById("fileForm");			
			//设置地址
			form.action="fileShow.action?currentPage=${(fileCon.currentPage+1)<=fileCon.totalPage?fileCon.currentPage+1:fileCon.totalPage}";		
			//提交表单
			form.submit();
			
	 }	 
	 function fileLast(){
		 var form =document.getElementById("fileForm");
			//设置地址
		 form.action="fileShow.action?currentPage=${(fileCon.currentPage-1)>0?fileCon.currentPage-1:1}";
			//提交表单
		 form.submit();
	 }
</script>

</html>