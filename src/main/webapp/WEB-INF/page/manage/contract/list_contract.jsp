<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>合同列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../script.html" %>

  </head>
  
  <body >
  	<div>
  		<select class="easyui-combobox theme-textbox-radius" style="width:120px" id="contractOne">
  			<option value="2">客户</option>
  			<option value="3">联系人</option>
  			<option value="4">负责人</option>
  		</select>
  		<select class="easyui-combobox theme-textbox-radius" style="width:100px" id="contractTwo">
  			<option value="1">包含字段</option>
  			<option value="2">精确查询</option>
  		</select>
  		<span>查询:</span>
		<input id="contract" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
  	</div>
   	<table id="contractList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<a href="javascript:void(0);" onclick="return add('manage/contract/add.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/contract/delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/contract/edit.action')" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	</div>
    </div>
    <script type="text/javascript">


    	//加载用户数据
    	$(function(){
    		$("#contractList").datagrid({
    			url : "manage/contract/findByPage.action",
    			//queryParams:{"positionName":$("#positionName").val()},
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "contractid",
    			rownumbers : true,
    			//singleSelect:true,
    			showHeader:true,//定义是否显示头部
    			columns : [[
    				{field:"contractid",title:"选择合同",checkbox:true},
    				{field:"contractnumber",title:"合同编号"},
    				{field:"businessCustomerName",title:"客户"},
    				{field:"ownerUserName",title:"负责人"},//ownerUserName
    				{field:"businessConnectionName",title:"联系人"},
    				{field:"duetime",title:"签约日期"},
    				{field:"price",title:"合同金额"},
    				{field:"status",title:"状态"},
    				{field:"enddate",title:"结束时间"},
    				{field:"operation",title:"操作",formatter:function(value,row,index){
		  			return "<a href='manage/position/ContractAction_edit.action?ids='"+row.index+">查看</a>"+
		  			"&nbsp;&nbsp<a href='javascript:void(0)' onclick='return modify("+index+")'>编辑</a>";
  				}}
    				
    				
    			]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
                    return {"total":data.data.totalRows,"rows":data.data.list};
    			}
    		
    		})
    	});





		//查找
     		function  doSearch() {
     		    alert('1')
				$("#contractList").datagrid("load", {
					contractOne : $("#contractOne").val(),
					contractTwo : $("#contractTwo").val(),
					contractThree : $("#contract").val(),
				})
			}


        //修改
        var edit = function (url) {
            alert('1')
            var rows = $("#contractList").datagrid("getChecked");
            if (!rows.length) {
                $.messager.alert("警告", "请选择一行要修改的合同");
                return;
            }
            if (rows.length > 1) {
                $.messager.alert("警告", "同时只能对一个商机合同");
                return;
            }

            var contractid = rows[0].contractid;
            parent.openTopWindow({
                url:url+"?contractid="+contractid,
                width:1000,
                height:600,
                title:"修改合同页面",
                issScrolling:true,
                close:function(){
                    $("#contractList").datagrid("reload")
                }

            });
        }



        //添加
        function add(url){
            parent.parent.openTopWindow({
                width:1000,
                height:600,
                title:"添加合同",
                "url": url,
                close:function(){
                    $("#contractList").datagrid("reload");
                }
            });
        }




		//删除
        var del = function (url) {
            var row = $("#contractList").datagrid("getSelected");
            $.messager.confirm("提示", "您确定要删除吗?", function (r) {
                if (r) {
                    $.post(url, {"contractid": row.contractid}, function (result) {
                        if (result.success) {
                            $('#contractList').datagrid("reload");
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
