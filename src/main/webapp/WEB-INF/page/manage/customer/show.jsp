<%--
  Created by IntelliJ IDEA.
  User: 段俊
  Date: 2017/7/31
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <%@ include file="/WEB-INF/page/system/script.html" %>
</head>
<style>
    *{
        margin-left: 10px;
        padding: 3px;
    }
    .tip{

        height:30px;
        text-align: right;
        background-color: #F5F5F5;
    }
</style>
<body>
<table>
    <tr>
        <td colspan="4">客户基本信息</td>
    </tr>
    <tr>
        <td class="tip">客户名：</td>
        <td><input class="easyui-textbox" value="${customerVO.name }" data-options="readonly:true"></td>
        <td class="tip">客户来源：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.orgin }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">地址：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.address }" data-options="readonly:true"></td>
        <td class="tip">邮编：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.zipCode }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">行业：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.industry }" data-options="readonly:true"></td>
        <td class="tip">盈利额：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.annualRevenue }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">公司性质：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.ownerShip }" data-options="readonly:true"></td>
        <td class="tip">评分：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.rating }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">客户负责人：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.owner }" data-options="readonly:true"></td>
        <td></td>
        <td></td>
    </tr>

    <tr>
        <td colspan="4">主要联系人</td>
    </tr>
    <tr>
        <td class="tip">姓名：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contacts }"  data-options="readonly:true" ></td>
        <td class="tip">性别：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.sex }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">部门：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.department }" data-options="readonly:true"></td>
        <td class="tip">职位：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.post }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">称呼：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.saltName }" data-options="readonly:true"></td>
        <td class="tip">电话：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.mobile }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">QQ：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.qq }" data-options="readonly:true"></td>
        <td class="tip">Email：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.email }" data-options="readonly:true"></td>
    </tr>
    <tr>
        <td class="tip">地址：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactAddress }" data-options="readonly:true"></td>
        <td class="tip">邮编：</td>
        <td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactZipcode }" data-options="readonly:true"></td>
    </tr>

    <tr>
        <td class="tip">描述：</td>
        <td colspan="3">
            <textarea data-options="multiline:true" style="width:579px;height:60px;" class="easyui-textbox" value="value:${customerVO.descriptionContact }" data-options="readonly:true"></textarea>
        </td>
    </tr>

    <tr>
        <td colspan="4">系统信息</td>
    </tr>
    <tr>
        <td class="tip">创建人：</td>
        <td><input class="easyui-textbox validatebox-readonly" value="${customerVO.createUser }" data-options="readonly:true"></td>
        <td class="tip">创建时间：</td>
        <td><input class="easyui-textbox validatebox-readonly" value="${customerVO.createTime }" data-options="readonly:true"></td>
    </tr>
</table>
</body>
</html>
