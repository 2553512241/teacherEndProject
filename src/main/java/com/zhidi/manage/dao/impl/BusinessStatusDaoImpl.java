package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.BusinessStatusDao;
import com.zhidi.manage.entity.BusinessStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
@Repository
public class BusinessStatusDaoImpl extends BaseDaoImpl<BusinessStatus, String> implements BusinessStatusDao {
    @Override
    public List<BusinessStatus> getAll() {
        return super.getAll();
    }
}
