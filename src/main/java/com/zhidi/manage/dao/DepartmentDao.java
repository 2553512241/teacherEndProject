package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Department;

import java.util.List;

/**
 * Created by 段俊 on 2017/7/26.
 */
public interface DepartmentDao extends BaseDao<Department, String> {

    /**
     * 根据pageNumber和pageSize分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Department> getDepartmentByPager(Integer pageNumber, Integer pageSize);
}
