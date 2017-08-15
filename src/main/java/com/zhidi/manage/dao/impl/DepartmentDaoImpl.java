package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.DepartmentDao;
import com.zhidi.manage.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ¶Î¿¡ on 2017/7/26.
 */
@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department,String> implements DepartmentDao {

    @Override
    public List<Department> getDepartmentByPager(Integer pageNumber, Integer pageSize) {
        String hql = "from Department";
        return this.getListByPage(pageNumber, pageSize, hql, new Object[] {} );
    }
}
