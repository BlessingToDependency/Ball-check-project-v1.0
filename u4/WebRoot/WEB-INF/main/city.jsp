<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'testui.jsp' starting page</title>


	</head>

	<body> 
	
		1、显示属性：<s:property value="Sproperty"/>---${Sproperty}<br/>
		
		2、显示对像属性：<s:property value="customer.cname"/> --- ${customer.cname}<br/>
		3.1   <s:property value="cities[1].code"/><br/>
		3、显示集合或数组某元素值：<s:property value="customer.travelCities[1]"/><br/>
		
		4、显示map：<s:property value="map.shanhai"/><br/>
		
		<%-- 
		
		
		5、显示执行表达式计算：<s:property value="customer.cname!=null"/><br/>
		6、显示执行方法：<s:property value="customer.cname.length()"/><br/>
		7、显示不访问action创建临时集合：<s:property value="{1,2,3}"/><br/>
		8、显示不访问action创建临时map：<s:property value="#{'bj':'北京','sh':'上海'}"/><br/>
		9、输出栈顶内容：<s:property /><br/>
		10、输出context对像：<s:property  value="#xwork.NullHandler.createNullObjects"/><br/><br/><br/><br/>
		
		演示s:iterator<br/>
		<s:iterator var="s" value="customer.travelCities" status="st"> 
			<s:property value="#st.index"/>:<s:property value="s"/><br/>
		</s:iterator>
		
		<s:iterator begin="1" end="5" step="1" var="k">
			<s:property value="#k"/><br/>
		</s:iterator>
		-----------------<br/>
		context对像：<s:property value="#k"/><br/>
		--------------<br/>
		<s:property /><br/> --%>
	
		<%-- 1.表单标签 --%>
	<%-- 	<s:form action="#" method="post"  theme="simple">
			<!--此处略去其他标签...-->
			<!-- 
            .1多选框标签
             1）根据OGNL（list属性值）创建的Map生成一组checkbox，其中Map的key
                生成checkbox的value值，Map的value生成checkbox的label值。
             2）根据OGNL（name属性值->customer.travelCities）取值来与生成checkbox的
                value比较，若与哪个checkbox的value值一致，则将其勾选。
        -->
			<br/><br/><s:checkboxlist list="cities" name="customer.travelCities" listKey="code"
				listValue="name"></s:checkboxlist>
			<br/><s:checkboxlist name="travelCities"  list="#{'01':'北京', '02':'上海', '03':'广州', '04':'深圳'}"/>
			<!-- 
            .单选框标签
             1）根据OGNL（list属性值）创建的Map生成一组radio，其中Map的key
                生成radio的value值，Map的value生成radio的label值。
             2）根据OGNL（name属性值->customer.travelCities[0]）取值来与生成radio的
                value比较，若与哪个radio的value值一致，则将其勾选。
        -->	
			<br/><br/><s:radio list="cities" name="customer.travelCities[0]" listKey="code"	listValue="name"></s:radio>
			<br/><s:radio name="sex" list="#{'M':'男', 'F':'女'}"/>
 			<!-- 
            .下拉框标签
             1）根据OGNL（list属性值）创建的Map生成一组select，其中Map的key
                生成select的value值，Map的value生成select的label值。
             2）根据OGNL（name属性值->customer.travelCities[0]）取值来与生成select的
                value比较，若与哪个select的value值一致，则将其勾选。
        -->	
			<br/><br/><s:select list="cities" name="customer.travelCities[0]" listKey="code"	listValue="name"/>
			<s:select name="home"  list="#{'01':'北京', '02':'上海', '03':'广州', '04':'深圳' }"/>
			
			

			<br/>提交按钮：<s:submit value="保存" />
			<br/>文本框：<s:textfield name="OGNL" />
			<br/>密码框：<s:password name="OGNL" />
			<br/>多行文本框 ：<s:textarea name="OGNL" />
			
			
			
		</s:form>

<s:debug>测试</s:debug> --%>

	</body>
</html>
