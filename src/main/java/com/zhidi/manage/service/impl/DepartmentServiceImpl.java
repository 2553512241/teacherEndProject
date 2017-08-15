package com.zhidi.manage.service.impl;

import com.zhidi.manage.dao.DepartmentDao;
import com.zhidi.manage.entity.Department;
import com.zhidi.manage.service.DepartmentService;
import com.zhidi.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 段俊 on 2017/7/26.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public Pager getDepartmentByPager(Integer pageNumber, Integer pageSize) {
        //查询部门表信息
        List<Department> departments = departmentDao.getDepartmentByPager(pageNumber, pageSize);
        //查询数据总条数
        Integer totalRows = departmentDao.count();
        Pager pager = new Pager();
        pager.setList(departments);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }
}
