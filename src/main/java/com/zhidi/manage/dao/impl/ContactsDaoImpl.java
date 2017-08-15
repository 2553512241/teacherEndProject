package com.zhidi.manage.dao.impl;

import com.zhidi.base.action.BaseAction;
import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.ContactsDao;
import com.zhidi.manage.entity.Contacts;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
@Repository
public class ContactsDaoImpl extends BaseDaoImpl<Contacts, String> implements ContactsDao {

    @Override
    public List<Contacts> getAll() {
        return super.getAll();
    }
}
