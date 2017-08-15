package com.zhidi.system.service;

import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.Function;
import com.zhidi.system.vo.FuncVo;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface FunctionService {

    /**
     * 提供角色的分页查询方法
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getFunctionByPage(Integer pageNumber, Integer pageSize);

    /**
     * 获取所有权限
     * @return
     */

    List<Function> getAll();



    /**
     * 获取角色的权限
     * @param roleId
     * @return
     */
    List<Function> getFunctionsByRoleId(String roleId);

    FuncVo getFunctionVoById(String id);

    void saveFunction(Function function);

    void updateFunction(Function function);

    void deleteFuction(String[] ids);



}
