package com.zhidi.manage.service.impl;

import com.zhidi.manage.dao.BusinessStatusDao;
import com.zhidi.manage.entity.BusinessStatus;
import com.zhidi.manage.service.BusinessStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@Service
public class BusinessStatusServiceImpl implements BusinessStatusService {

    @Autowired
    protected BusinessStatusDao businessStatusDao;
    @Override
    public List<BusinessStatus> getAll() {
        return businessStatusDao.getAll();
    }
}
