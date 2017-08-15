<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>添加角色</title>

    <meta name="pragma" content="no-cache">
    <meta name="cache-control" content="no-cache">
    <meta name="content-type" content="text/html;charset=UTF-8">
    <meta name="expires" content="0">
    <%@ include file="../../script.html" %>

</head>

<body style="width:100%;max-width:600px;padding:30px 60px;">
<section class="info-section">
    <form id="form" method="post">
        <table>
            <tr>
                <td class="text-title">角色名称：</td>
                <td class="text-content">
                    <%--<input type="text" name="roleVo.id">--%>
                    <input type="text" name="roleVo.rolename"
                           class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[3,10]'">
                </td>
            </tr>
            <tr>
                <td class="text-title">排序编号：</td>
                <td class="text-content">
                    <input type="text" name="roleVo.sortnum"
                           class="easyui-textbox theme-textbox-radius" data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="text-title">角色状态：</td>
                <td class="text-content">
                    <select name="roleVo.status" class="easyui-combobox theme-textbox-radius">
                        <option value="1" ${roleVo.status==1?"selected":"" }>正常</option>
                        <option value="0" ${roleVo.status==0?"selected":"" }>禁用</option>
                        <option value="2" ${roleVo.status==2?"selected":"" }>已删除</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td class="text-title">描述信息：</td>
                <td class="text-content">
                    <textarea class="theme-textbox-radius" rows="5"  cols="20" name="roleVo.rolenote"></textarea></td>
            </tr>
            <tr>
                <td class="text-title">创建者：</td>
                <td class="text-content" >
                    <input type="text" name="username" value="${user.username}" disabled
                           class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[3,10]'">
                </td>
            </tr>
            <tr>
                <td class="text-title">创建时间：</td>
                <td class="text-content" >
                    <input type="text" name="createtime" value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"
                           class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[3,10]'">
                </td>
            </tr>


            <tr style="display: none;">
                <td colspan="2">
                    <input type="hidden" name="roleVo.functionIds">
                    <input type="hidden" name="roleVo.createById" >
                    <input type="hidden" name="roleVo.createtime" >
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;margin-top: 10px;">
                    <a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a>
                    <a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
                </td>
            </tr>
        </table>
    </form>
</section>
<script type="text/javascript">
    $(function() {
        //重置按钮
        $("#resetBtn").on("click",function(event){
            $("#form").form("reset");
        });


    });


    //为保存按钮添加事件
    $("#saveBtn").bind("click",function(event){
        $.post("system/role/saveRole.action",$("#form").serialize(),function(result){
            if(result.success){
                $.messager.alert("提示",result.msg)
            }else {
                $.messager.alert("提示","保存失败")
            }
        },"json");
    });

</script>
</body>
</html>

