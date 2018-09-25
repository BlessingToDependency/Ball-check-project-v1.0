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
    <title>��˾�б�</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="shortcut icon" href="<%=path%>/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="<%=path%>/css/font.css">
    <link rel="stylesheet" href="<%=path%>/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=path%>/js/xadmin.js"></script>
    <!-- ��IE8/9֧��ý���ѯ���Ӷ�����դ�� -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
     <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	//�����˾��չʾ��Ϣ
    <script type="text/javascript">
	function info(id){
	$.ajax({
		url:"<%=path %>userAdminAction/userInfo.action",
		data:"staffId="+id,
		dataType:"json",
		type:"POST",
		success : function(str){
			$("#name").val(str.staffName);
			$("#age").val(str.age);
			$("#sex").val(str.sex);
			$("#phone").val(str.phone);
			$("#idNum").val(str.idNum);
		}
	});
};
</script>
<script type="text/javascript">
    $(document).ready(function(){
       //������ӵ�ʱ�����
      $("#linkToCart").click(function(){
 
          //�õ�input��ֵ
          var pages = $("#pages").val();
 
          //����linkToCart��href��ֵ
          $("#linkToCart").attr("href","<%=path %>userAdminAction/userAdmin.action?pages="+pages+"");
      });
    });
</script>
<script type="text/javascript">
function checkUser(){
	document.getElementById("formid").submit();
}
	</script>
  </head>
  
  <body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">��ҳ</a>
        <a href="">��ʾ</a>
        <a>
          <cite>����Ԫ��</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="ˢ��">
        <i class="layui-icon" style="line-height:30px">?</i></a>
    </div>
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" id="formid" action="<%=path %>userAdminAction/userAdmin.action">
          <input class="layui-input" placeholder="��ʼ��" name="statTime" id="start">
          <input class="layui-input" placeholder="��ֹ��" name="stopTime" id="end">
          <input type="text" name="staffName"  placeholder="�������û���" autocomplete="off" class="layui-input">
          <input type="text" name="phone"  placeholder="�������ֻ���" autocomplete="off" class="layui-input">
          <input type="text" name="staffName"  placeholder="�����������" autocomplete="off" class="layui-input">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach" onclick = "checkUser();"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        <button class="layui-btn" onclick="x_admin_show('����û�','./admin-add.html')"><i class="layui-icon">�b</i>���</button>
      </xblock>
       <table class="layui-table">
        <thead>
          <tr>
            <th>
              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
            </th>
            <th>ID</th>
            <th>����</th>
            <th>�ֻ���</th>
            <th>���ʱ��</th>
            <th>�����</th>
            <th>��˾</th>
            <th>����</th>
        </thead>
        <tbody>
        <c:forEach items="${userList}" var="staffBean">
          <tr>
            <td>
              <div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>
            </td>
          	<input type="hidden" id="hidden" name="hidden" value="${staffBean.staffId}"/>
            <td>${staffBean.staffId}</td>
            <td><a data-toggle="modal" data-target="#myModal" onclick="info(${staffBean.staffId})">${staffBean.staffName}</a></td>
            <td>${staffBean.phone}</td>
            <td>${staffBean.perguirelaBean.partYear}</td>
             <td>${staffBean.staffId}${staffBean.perguirelaBean.partYear}${staffBean.companyId}${staffBean.perguirelaBean.batchNum}</td>
             <td>${staffBean.userBean.company}</td>
            <td class="td-status">
              
              <a title="�༭"  onclick="x_admin_show('�༭','admin-edit.html')" href="javascript:;">
                <i class="layui-icon">&#xe642;</i>
              </a>
              <a title="ɾ��" onclick="member_del(this,'Ҫɾ����id')" href="javascript:;">
                <i class="layui-icon">&#xe640;</i>
              </a>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <div class="page">
        <div>
      ��ǰ����  ${pages } ҳ/ �� ${pageCountAll} ҳ
          <a class="num" href="<%=path %>userAdminAction/userAdmin.action?pages=1">��ҳ</a>
          <a class="prev" href="<%=path %>${(pages-1)>0?pages-1:1}">��һҳ</a>
          <a class="next" href="<%=path %>userAdminAction/userAdmin.action?pages=${(pages+1)<=pageCountAll?pages+1:pageCountAll}">��һҳ</a>
          <a class="num" href="<%=path %>userAdminAction/userAdmin.action?pages=${pageCountAll}">ĩҳ</a>
          <input type="text" id="pages" name="code" style="width:50px;height:40px;" autocomplete="off"/>
           <a class="num" id="linkToCart" href="">��ת</a>
        </div>
      </div>

    </div>
    <!-- ģ̬��Modal�� -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel" >
            �����Ա��Ϣ       
                </h4>
            </div>
            
            <div class="modal-body">
                 ������<input type="text" id="name">
            </div>
            <div class="modal-body">
                �Ա�<input type="text" id="sex">
            </div>
            
            <div class="modal-body">
                ���䣺<input type="text" id="age">
            </div>
            <div class="modal-body">
                �绰��<input type="text" id="phone">
            </div>
            <div class="modal-body">
                ���֤�ţ�<input type="text" id="idNum">
            </div>
           
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">�ر�
                </button>
                <button type="button" class="btn btn-primary">
                    �ύ����
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<script>
      layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //ִ��һ��laydateʵ��
        laydate.render({
          elem: '#start' //ָ��Ԫ��
        });

        //ִ��һ��laydateʵ��
        laydate.render({
          elem: '#end' //ָ��Ԫ��
        });
      });
 </script>
</body>

</html>