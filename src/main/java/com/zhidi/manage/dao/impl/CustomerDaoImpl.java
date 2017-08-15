package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.CustomerDao;
import com.zhidi.manage.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 段俊 on 2017/7/31.
 */
@Repository
public class CustomerDaoImpl extends BaseDaoImpl<Customer,String> implements CustomerDao {

    @Override
    public List<Customer> getCustomerByPager(Integer pageNumber, Integer pageSize, String name, String address, String industry) {
        String hql = "from Customer";
        if (name != null) {
            hql = "from Customer c where c.name like '%" + name + "%'";
        }
        if (address != null) {
            hql = "from Customer c where c.address like '%" + address + "%'";
        }
        if (industry != null) {
            hql = "from Customer c where c.industry like '%" + industry + "%'";
        }
        return this.getListByPage(pageNumber, pageSize, hql, new String[] {});
    }

    @Override
    public List<Customer> getAll() {
        return super.getAll();
    }
}
