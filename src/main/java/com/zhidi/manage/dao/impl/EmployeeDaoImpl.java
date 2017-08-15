package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.EmployeeDao;
import com.zhidi.manage.entity.Employee;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee,String> implements EmployeeDao{


    @Override
    public List<Employee> getEmployeeListByPage(Integer PageNumber, Integer PageSize,String name) {
        String hql = null;
        if(name==null){
             hql = "from Employee";
        }else {
             hql = "from Employee e where e.name like '%"+name+"%'";
        }
        return this.getListByPage(PageNumber,PageSize,hql, new String[]{});
    }

}
