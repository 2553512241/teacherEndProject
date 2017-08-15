package com.zhidi.system.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface UserDao extends BaseDao<User, String> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    /**
     * 根据pageNumber和pageSize分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<User> getUserListByPage(Integer pageNumber, Integer pageSize);

    /**
     * 查询所有的负责人
     * @return
     */
    public List<User> getAll();
}
