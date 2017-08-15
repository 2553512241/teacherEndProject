package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.BusinessStatus;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4.
 */
public interface BusinessStatusDao extends BaseDao<BusinessStatus, String> {
    @Override
    List<BusinessStatus> getAll();
}
