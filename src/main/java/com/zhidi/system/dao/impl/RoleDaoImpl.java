package com.zhidi.system.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.system.dao.RoleDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.entity.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lx on 2017/7/24.
 */
@Repository
public class RoleDaoImpl extends BaseDaoImpl<Role, String> implements RoleDao {

    @Override
    public List<Role> getRoleByUer(User user) {
        String hql = "from Role r inner join fetch r.users u where u.id=:userId";
        Query query = getSession().createQuery(hql);
        query.setParameter("userId", user.getId());
        return query.list();
    }

    @Override
    public List<Role> getRoleByPage(Integer pageNumber, Integer pageSize) {
        String hql = "from Role r left join fetch r.functions left join fetch r.userByCreateby left join fetch r.userByUpdateby order by r.sortnum";
        return this.getListByPage(pageNumber, pageSize, hql);
    }
}
