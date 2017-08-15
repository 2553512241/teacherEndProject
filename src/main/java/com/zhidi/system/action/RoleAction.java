package com.zhidi.system.action;

import com.zhidi.base.action.BaseAction;
import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.system.vo.RoleVo;
import com.zhidi.util.Pager;
import com.zhidi.util.ResultData;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@ParentPackage("struts-default")
@Namespace("/system/role")
public class RoleAction extends BaseAction{

    private String roleId;

    private RoleVo roleVo;

    private Role role;

    private String roleIds;

    private String functionIds;

    public String getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public RoleVo getRoleVo() {
        return roleVo;
    }

    public void setRoleVo(RoleVo roleVo) {
        this.roleVo = roleVo;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * 跳转到角色列表页
     * @return
     */
    @Action(value = "list",results = {
            @Result(name = SUCCESS,location = "list.jsp")
    })
    public String list(){
        return SUCCESS;
    }

    /**
     * 角色分页查询的ajax请求
     */
    @Action(value = "findRoleByPager")
    public void findRoleByPager() throws IOException {
        Pager pager = roleService.getRoleListByPage(page,rows);
        resultData = ResultData.buildSuccessResult("角色列表查询成功",pager);
        printJSONObject(resultData);
    }

    /**
     * 跳转到分配权限页面
     * @return
     */
    @Action(value = "assignFunction",results = {
            @Result(location = "assign.jsp")
    })
    public String toAssignFunction() {
        roleVo = roleService.getRoleById(roleId);
        return SUCCESS;
    }

  /*  @Action(value = "assignSaveFunction")
    public void assignSaveFunction() throws IOException {
        String[] ids = null;
        if (functionIds != null && functionIds.length() > 0){
            ids = functionIds.split(",");
        }
        roleService.assignFuntionToRole(roleId,ids);
        resultData = ResultData.buildSuccessResult("分配权限保存成功");
        printJSONObject(resultData);
    }*/

    /**
     * 跳转到新增角色页面
     * @return
     */
    @Action(value = "addRole",results = {
            @Result(location = "add.jsp")
    })
    public String addRole(){
        return SUCCESS;
    }

    /**
     * 新增角色方法
     * @throws IOException
     */
    @Action("saveRole")
    public void saveAddRole() throws IOException {
        User user = (User) getSession().getAttribute("user");
        role.setUserByCreateby(user);
        roleService.saveRole(role);
        resultData = ResultData.buildSuccessResult("保存成功");
        printJSONObject(resultData);
    }

    /**
     * 跳转到修改角色页面
     * @return
     */
    @Action(value = "editRole",results = {
            @Result(location = "edit.jsp")
    })
    public String editRole() throws IOException {
        roleVo = roleService.getRoleById(roleId);
        return SUCCESS;
    }


     /**
     * 更新角色方法
     * @throws ParseException
     * @throws IOException
     */

    @Action(value = "updateRole")
    public void updateRole() throws ParseException, IOException {
        User user = (User) getSession().getAttribute("user");
        Role role = Role.fromRoleVo(roleVo, user);
        roleService.updateRole(role);
        resultData = ResultData.buildSuccessResult("修改角色成功");
        printJSONObject(resultData);
    }


    /**
     * 删除角色
     * @throws IOException
     */
    @Action(value = "removeRole")
    public void deleteRole() throws IOException {
        String[] ids = null;
        if (roleIds != null && !roleIds.isEmpty()){
            ids = roleIds.split(",");
        }
        roleService.deleteRole(ids);
        resultData = ResultData.buildSuccessResult("删除成功");
        printJSONObject(resultData);
    }

}