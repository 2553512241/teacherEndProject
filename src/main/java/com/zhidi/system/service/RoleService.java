package com.zhidi.system.service;


import com.zhidi.system.entity.Role;
import com.zhidi.system.vo.RoleVo;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface RoleService {
    /**
     * 提供角色的分页查询方法
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getRoleListByPage(Integer pageNumber, Integer pageSize);

    void deleteRole(String[] id);

    void saveRole(Role role);

    RoleVo getRoleById(String id);


    public void updateRole(Role role);


}
