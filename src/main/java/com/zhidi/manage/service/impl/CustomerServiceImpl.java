package com.zhidi.manage.service.impl;

import com.zhidi.manage.dao.CustomerDao;
import com.zhidi.manage.entity.Customer;
import com.zhidi.manage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    protected CustomerDao customerDao;

    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }
}
