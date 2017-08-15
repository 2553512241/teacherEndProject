package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Customer;

import java.util.List;

/**
 * Created by 段俊 on 2017/7/31.
 */
public interface CustomerDao extends BaseDao<Customer,String> {

    List<Customer> getCustomerByPager(Integer pageNumber, Integer pageSize, String name, String address, String industry);

    @Override
    List<Customer> getAll();
}
