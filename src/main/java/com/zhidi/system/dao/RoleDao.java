package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface RoleDao extends BaseDao<Role, String> {

    List<Role> getRoleByUer(User user);

    List<Role> getRoleByPage(Integer pageNumber, Integer pageSize);

}
