package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface EmployeeDao extends BaseDao<Employee,String> {

    /**
     * 根据pageNumber 和PageSize 分页查询
     * @param PageNumber
     * @param PageSize
     * @return
     */
   List<Employee> getEmployeeListByPage(Integer PageNumber,Integer PageSize,String name);

    @Override
    void delete(String empid);

    @Override
    void update(Employee employee);
}
