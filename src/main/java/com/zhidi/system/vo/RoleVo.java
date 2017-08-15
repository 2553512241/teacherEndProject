package com.zhidi.system.vo;

import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;

import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class RoleVo {
    private String id;
    private String updateById;
    private String updateByName;
    private String createById;
    private String createByName;
    private String createtime;
    private String rolename;
    private String rolenote;
    private Integer sortnum;
    private Integer status;
    private String updatetime;

    private String functionIds;
    private String functionNames;
    private String userIds;
    private String userNames;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdateById() {
        return updateById;
    }

    public void setUpdateById(String updateById) {
        this.updateById = updateById;
    }

    public String getUpdateByName() {
        return updateByName;
    }

    public void setUpdateByName(String updateByName) {
        this.updateByName = updateByName;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRolenote() {
        return rolenote;
    }

    public void setRolenote(String rolenote) {
        this.rolenote = rolenote;
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }

    public String getFunctionNames() {
        return functionNames;
    }

    public void setFunctionNames(String functionNames) {
        this.functionNames = functionNames;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }

    /**
     * 把Role对象的属性封装到vo中
     * @param role
     * @return
     */
    public static RoleVo fromRole(Role role) {
        if (role != null) {
            RoleVo roleVo = new RoleVo();
            roleVo.setId(role.getId());
            if (role.getUserByUpdateby() != null) {
                roleVo.setUpdateById(role.getUserByUpdateby().getId());
                roleVo.setUpdateByName(role.getUserByUpdateby().getUsername());
            }
            if (role.getUserByCreateby() != null) {
                roleVo.setCreateById(role.getUserByCreateby().getId());
                roleVo.setCreateByName(role.getUserByCreateby().getUsername());
            }

            roleVo.setCreatetime(DateUtil.formatDate(role.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            roleVo.setRolename(role.getRolename());
            roleVo.setRolenote(role.getRolenote());
            roleVo.setSortnum(role.getSortnum());
            roleVo.setStatus(role.getStatus());
            roleVo.setUpdatetime(DateUtil.formatDate(role.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));

            //创建两个StringBuffer来拼接
            StringBuffer sbName = new StringBuffer();
            StringBuffer sbIds = new StringBuffer();
            if (role.getFunctions() != null) {
                for (Function function : role.getFunctions()) {
                    sbName.append(function.getFuncname());
                    sbName.append(",");
                    sbIds.append(function.getId());
                    sbIds.append(",");
                }
            }
            if (sbName.length() > 0) {
                sbName.deleteCharAt(sbName.length() - 1 );
                sbIds.deleteCharAt(sbIds.length() - 1);
            }
            roleVo.setFunctionIds(sbIds.toString());
            roleVo.setFunctionNames(sbName.toString());

//            StringBuffer sbffName = new StringBuffer();
//            StringBuffer sbffIds = new StringBuffer();
//            if (role.getUsers() != null){
//                for (User user : role.getUsers()){
//                    sbffName.append(user.);
//                    sbffName.append(",");
//                    sbffIds.append(user.getId());
//                    sbffIds.append(",");
//                }
//            }
//            if (sbffName.length() > 0) {
//                sbffName.deleteCharAt(sbName.length() - 1 );
//                sbffIds.deleteCharAt(sbIds.length() - 1);
//            }
//            roleVo.setUserIds(sbffIds.toString());
//            roleVo.setUserNames(sbffName.toString());
            return roleVo;
        }
        return null;
    }


}
