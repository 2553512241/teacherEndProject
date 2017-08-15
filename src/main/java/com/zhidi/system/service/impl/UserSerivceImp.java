package com.zhidi.system.service.impl;

import com.zhidi.system.dao.UserDao;
import com.zhidi.system.entity.User;
import com.zhidi.system.service.UserSerivce;
import com.zhidi.system.vo.UserVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Service
public class UserSerivceImp implements UserSerivce {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public Pager getUserListByPage(Integer pageNumber, Integer pageSize) {
        //查询用户列表
        List<User> userList = userDao.getUserListByPage(pageNumber, pageSize);
        List<UserVO> userVOList = new ArrayList<UserVO>();
        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
               UserVO userVO = UserVO.fromUser(user);
               userVOList.add(userVO);
            }
        }
        //查询数据总数
        Integer totalRows = userDao.count();
        Pager pager = new Pager();
        pager.setList(userVOList);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public List<UserVO> getAll() {
        List<User> userList = userDao.getAll();
        List<UserVO> userVOList = new ArrayList<UserVO>();
        if (userList != null && !userList.isEmpty()) {
            for (User user : userList) {
                UserVO userVO = UserVO.fromUser(user);
                userVOList.add(userVO);
            }
        }
       return userVOList;
    }

}
