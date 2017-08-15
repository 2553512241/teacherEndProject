package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.UserDao;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User getUserByName(String username) {
        Query query = getSession().createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */

    @Override
    public List<User> getUserListByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from User u left join fetch u.roles left join fetch u.userByUpdateby left join fetch u.userByCreateby order by u.sortnum";
        return this.getListByPage(pageNumber, pageSize, hql, new String[] {});
    }

    @Override
    public List<User> getAll() {
        return super.getAll();
    }
}
