package com.zhidi.system.vo;

import com.zhidi.system.entity.Function;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;

import java.util.Date;

/**
 * Created by Administrator on 2017/7/26.
 */
public class FuncVo {

    private String id;
    private String updateById;
    private String updateByName;
    private String createById;
    private String createByName;
    private Function function;
    private String createtime;
    private String funccode;
    private String funcname;
    private String funcnote;
    private Integer functype;
    private String funcurl;
    private String iconclass;
    private String iconurl;
    private Integer sortnum;
    private Integer status;
    private String updatetime;
    private String rolesId;
    private String rolesName;
    private String functionsIds;
    private String functionsNames;
    private String functionId;
    private String functionName;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

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

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getFunccode() {
        return funccode;
    }

    public void setFunccode(String funccode) {
        this.funccode = funccode;
    }

    public String getFuncname() {
        return funcname;
    }

    public void setFuncname(String funcname) {
        this.funcname = funcname;
    }

    public String getFuncnote() {
        return funcnote;
    }

    public void setFuncnote(String funcnote) {
        this.funcnote = funcnote;
    }

    public Integer getFunctype() {
        return functype;
    }

    public void setFunctype(Integer functype) {
        this.functype = functype;
    }

    public String getFuncurl() {
        return funcurl;
    }

    public void setFuncurl(String funcurl) {
        this.funcurl = funcurl;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
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

    public String getRolesId() {
        return rolesId;
    }

    public void setRolesId(String rolesId) {
        this.rolesId = rolesId;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getFunctionsIds() {
        return functionsIds;
    }

    public void setFunctionsIds(String functionsIds) {
        this.functionsIds = functionsIds;
    }

    public String getFunctionsNames() {
        return functionsNames;
    }

    public void setFunctionsNames(String functionsNames) {
        this.functionsNames = functionsNames;
    }

    /**
     * 把Function对象的属性封装到vo中
     * @param function
     * @return
     */
    public static FuncVo fromRole(Function function) {
        if (function != null) {
            FuncVo funcVo = new FuncVo();
            funcVo.setId(function.getId());
            if (function.getUserByUpdateby() != null) {
                funcVo.setUpdateById(function.getUserByUpdateby().getId());
                funcVo.setUpdateByName(function.getUserByUpdateby().getUsername());
            }
            if (function.getUserByCreateby() != null) {
                funcVo.setCreateById(function.getUserByCreateby().getId());
                funcVo.setCreateByName(function.getUserByCreateby().getUsername());
            }

            funcVo.setCreatetime(DateUtil.formatDate(function.getCreatetime(), "yyyy-MM-dd HH:mm:ss"));
            funcVo.setSortnum(function.getSortnum());
            funcVo.setStatus(function.getStatus());
            funcVo.setUpdatetime(DateUtil.formatDate(function.getUpdatetime(), "yyyy-MM-dd HH:mm:ss"));
            funcVo.setFunction(function.getFunction());
            funcVo.setFunccode(function.getFunccode());
            funcVo.setFuncname(function.getFuncname());
            funcVo.setFuncnote(function.getFuncnote());
            funcVo.setFunctype(function.getFunctype());
            funcVo.setFuncurl(function.getFuncurl());
            funcVo.setIconclass(function.getIconclass());
            funcVo.setIconurl(function.getIconurl());

            StringBuffer sbName = new StringBuffer();
            StringBuffer sbIds = new StringBuffer();
            StringBuffer sbfName = new StringBuffer();
            StringBuffer sbfIds = new StringBuffer();
            StringBuffer sbffName = new StringBuffer();
            StringBuffer sbffIds = new StringBuffer();
            if (function.getFunctions() != null) {
                for (Function function1 : function.getFunctions()) {
                    sbName.append(function1.getFuncname());
                    sbName.append(",");
                    sbIds.append(function1.getId());
                    sbIds.append(",");
                }
            }
            if (sbName.length() > 0) {
                sbName.deleteCharAt(sbName.length() - 1 );
                sbIds.deleteCharAt(sbIds.length() - 1);
            }
            funcVo.setFunctionsIds(sbIds.toString());
            funcVo.setFunctionsNames(sbName.toString());

            if (function.getRoles() != null) {
                for (Role role : function.getRoles()) {
                    sbfName.append(role.getRolename());
                    sbfName.append(",");
                    sbfIds.append(role.getId());
                    sbfIds.append(",");
                }
            }
            if (sbfName.length() > 0) {
                sbfName.deleteCharAt(sbName.length() - 1 );
                sbfIds.deleteCharAt(sbIds.length() - 1);
            }
            funcVo.setRolesName(sbfIds.toString());
            funcVo.setRolesId(sbfName.toString());

            if (function.getFunction() != null){
                funcVo.setFunctionId(function.getFunction().getId());
                funcVo.setFunctionName(function.getFunction().getFuncname());
            }
            return funcVo;
        }
        return null;
    }
}
