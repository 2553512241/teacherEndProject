<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">

<title>编辑权限</title>

<meta name="pragma" content="no-cache">
<meta name="cache-control" content="no-cache">
<meta name="expires" content="0">
<%@include file="../script.html"%>
</head>
<style type="text/css">
.myselect{
	height:30px;
}
</style>

<body style="width:100%;max-width:100%;padding:10px 30px;">
<div>

</div>

<form id="form" method="post">
<strong>主要信息</strong>
	<section class="info-section">
			<table id="tb">
				<tr>
					<td class="text-title">负责人</td>
					<td class="text-content">
						<input type="hidden" name="businessVO.businessId" value="${businessVO.businessId}">
						<input type="hidden" name="businessVO.createtimeBusiness" value="${businessVO.createtimeBusiness}">
						<input type="hidden" name="businessVO.createById" value="${businessVO.createById }">

						<select class="myselect" name="businessVO.updateById">
							<option value="-1">请选择负责人</option>
							<c:forEach items="${userVOs}" var="u">
								<option value="${u.id}" <c:if test="${u.id eq businessVO.updateById}">selected</c:if>>${u.username}</option>
							</c:forEach>
						</select>

					</td>
					<td class="text-title">客户</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.customerId">
							<option value="-1">请选择客户</option>
							<c:forEach items="${customers}" var="c">
								<option value="${c.customerid}" <c:if test="${businessVO.customerId eq c.customerid}">selected</c:if>>${c.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机金额</td>
					<td class="text-content">
						<input type="text" name="businessVO.salesprice" value="${businessVO.salesprice}"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
					<td class="text-title">商机名</td>
					<td class="text-content">
						<input type="text"  name="businessVO.businessName" value="${businessVO.businessName}"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">联系人</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.contactsId">
							<option>请选择</option>
							<c:forEach items="${contactss}" var="c">
								<option value="${c.contactsid}" <c:if test="${c.contactsid eq businessVO.contactsId}">selected</c:if >        >${c.name}</option>
							</c:forEach>
						</select>
							<a href="manage/contacts/add.action" class="text-title" style="color:blue;">新建</a>
					</td>

				</tr>
				<tr>
					<td class="text-title" >合同签订地址</td>
					<td class="text-content" colspan="3">
						<input type="text" style="width:550px;" name="businessVO.contractaddress" value="${businessVO.contractaddress }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">商机类型</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.type">
							<option value="-1">请选择</option>
							<c:forEach items="${list}" var="b">
								<option value="${b.type}" <c:if test="${businessVO.businessId eq b.businessid}"> selected</c:if >       >${b.type}</option>
							</c:forEach>
						</select>
					</td>
					<td class="text-title">状态</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.businessStatusId">
							<option>请选择</option>
							<c:forEach items="${businessStatuses}" var="stau">
								<option value="${stau.statusid}" <c:if test="${stau.statusid eq businessVO.businessStatusId}" >selected</c:if >              >${stau.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机来源</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.businessOrgnin">
							<option>请选择</option>
							<c:forEach items="${list}" var="s">
								<option value="${s.origin}" <c:if test="${businessVO.businessId eq s.businessid}">selected</c:if>   >${s.origin}</option>
							</c:forEach>
						</select>
					</td>
					<td class="text-title">赢单率</td>
					<td class="text-content">
						<input type="text" name="businessVO.gainrate" value="${businessVO.gainrate }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">预定成交价</td>
					<td class="text-content">
						<input type="text" name="businessVO.estimateprice" value="${businessVO.estimateprice }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
					<td class="text-title">下次联系时间</td>
					<td class="text-content">
						<input class="easyui-datetimebox" name="businessVO.nextsteptime" value="${businessVO.nextsteptime }"
	  					  data-options="required:false,showSeconds:false" style="width:150px">
					</td>
				</tr>
				<tr>
					<td class="text-title">下次联系内容</td>
					<td class="text-content">
						<input type="text" name="businessVO.nextstep" value="${businessVO.nextstep }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				</table>

	</section>
	<strong>附加信息</strong>
	<section class="info-section">
			<table>
				<tr>
					<td class="text-title">备注</td>
					<td class="text-content">
						<textarea name="businessVO.description" rows="5" style="width:80%;">${businessVO.description}</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary" style="margin-left:-70px;">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger" style="margin-left:30px;">重置</a>
					</td>
				</tr>
				</table>
	</section>
	</form>
   <script src="static/jquery/jquery.min.js"></script>
	<script type="text/javascript">
   $(function(){



})





   //保存按钮
   $("#saveBtn").on("click",function(event){
       $.post("manage/business/update.action",$("#form").serialize(),function(result){
           if(result.success){
              alert("修改成功")
			   parent.closeTopWindow()
           }else {
               $.messager.alert("提示","更新失败",function () {
                   parent.closeTopWindow()
               })

           }
       },"json")
   })





	</script>
</body>
</html>
				