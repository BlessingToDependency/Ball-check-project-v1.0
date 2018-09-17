<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
	<head></head>
	<body style="color: red; font-size: 30px">
		<table width="200px" align="center">
		
			<s:iterator value="depts" var="d">
				<tr>
					<td><s:property value="#d.deptno"/></td>
					<td><s:property value="#d.dname"/></td>
					<td><s:property value="#d.loc"/></td>
				</tr>
			</s:iterator>


		</table>
		<hr />
		<s:debug>debug</s:debug>




	</body>

</html>