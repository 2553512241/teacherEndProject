package com.zhidi.system.service;

import com.zhidi.system.entity.User;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
public interface UserSerivce{

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByName(String username);

    Pager getUserListByPage(Integer pageNumber, Integer pageSize);

    /**
     * 查询所有的负责人
     * @return
     */
    public List<UserVO> getAll();
}
