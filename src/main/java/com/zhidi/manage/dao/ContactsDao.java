package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Contacts;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
public interface ContactsDao extends BaseDao<Contacts, String> {
    @Override
    List<Contacts> getAll();
}
