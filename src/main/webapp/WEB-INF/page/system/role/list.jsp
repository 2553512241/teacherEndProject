<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>

  </head>
  
  <body >
   	<table id="roleList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('system/role/addRole.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
        <a href="javascript:void(0);" onclick="return del('system/role/removeRole.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('system/role/editRole.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    	<a href="javascript:void(0);" onclick="return assign('system/role/assignFunction.action')" id="setBtn" class="easyui-linkbutton" data-options="iconCls:'icon-man',plain:true">分配权限</a>
    </div>
    <script type="text/javascript">

        //加载角色数据
        $(function(){
            $("#roleList").datagrid({
                url : "system/role/findRoleByPager.action",
                pagination : true,
                toolbar : "#toolbar",
                fitColumns : true,
                idField : "id",
                rownumbers : true,
                //singleSelect:true,
                columns : [[
                    {field:"id",title:"选择",checkbox:true},
                    {field:"rolename",title:"角色名称",sortable:true,width:10},
                    {field:"rolenote",title:"角色描述",width:15},
                    {field:"createByName",title:"创建者",width:10},
                    {field:"createtime",title:"创建时间",width:15},
                    {field:"updateByName",title:"修改者",width:10},
                    {field:"updatetime",title:"修改时间",width:15},
                    {field:"status",title:"角色状态",formatter:function(value,rowData,index){
                        if(value == 1){
                            return "可用";
                        }else if(value == 0){
                            return "禁用";
                        }else if(value == 2){
                            return "已删除";
                        }else{
                            return "";
                        }
                    }}

                ]],
                loadFilter:function(data){
                    //data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
                    return {"total":data.data.totalRows,"rows":data.data.list};
                }

            });
        })

    	//分配权限按钮事件处理函数
        var assign = function (url) {
            var rows = $("#roleList").datagrid("getChecked");
            if (!rows.length){
                $.messager.alert("警告", "请选择一行要分配的权限");
                return;
            }
            if (rows.length > 1) {
                $.messager.alert("警告", "只能对一个角色分配权限");
                return;
            }
            var roleId = rows[0].id;
            parent.openTopWindow({
                url:url+"?roleId="+roleId,
                width:700,
                height:500,
                title:"分配角色页面",
                isScrolling:true,
                close:function(){
                    $("#roleList").datagrid("reload")
                }
            });
        }


    	//修改按钮事件处理函数
        var edit = function (url) {

            var rows = $("#roleList").datagrid("getChecked");
            if (!rows.length) {
                $.messager.alert("警告", "请选择一行要修改的角色");
                return;
            }
            if (rows.length > 1) {
                $.messager.alert("警告", "同时只能对一个角色修改");
                return;
            }

            var roleId = rows[0].id;
            parent.openTopWindow({
                url:url+"?roleId="+roleId,
                width:700,
                height:400,
                title:"修改角色页面",
                isScrolling:true,
                close:function(){
                    $("#roleList").datagrid("reload")
                }
            });
        }

    	
    	//添加按钮事件处理函数
        var add = function (url) {
            parent.openTopWindow({
                url:url,
                width:700,
                height:400,
                title:"新增角色页面",
                isScrolling:true,
                close:function(){
                    $("#roleList").datagrid("reload")
                }
            });
        }

        //删除按钮事件处理函数
        var del = function (url) {
            var roleIds = new Array();
            var rows = $("#roleList").datagrid("getChecked");
            if (rows) {
                $.each(rows, function (index, obj) {
                    roleIds.push(obj.id);
                })
                //让数组中的元素以逗号分隔
                roleIds.join(",");
            }
            $.messager.confirm("提示", "您确定要删除吗?", function (r) {
                if (r) {
                    $.post(url, {"roleIds": roleIds.toString()}, function (result) {
                        if (result.success) {
                            $('#roleList').datagrid("reload");
                        } else {
                            $.messager.show({
                                title: 'Error',
                                msg: result.msg
                            });
                        }
                    }, "json");
                }
            });

        }

    </script>
  </body>
</html>
