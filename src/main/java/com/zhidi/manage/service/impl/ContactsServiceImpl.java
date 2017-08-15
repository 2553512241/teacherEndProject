package com.zhidi.manage.service.impl;

import com.zhidi.manage.dao.ContactsDao;
import com.zhidi.manage.entity.Contacts;
import com.zhidi.manage.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5.
 */
@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsDao contactsDao;

    @Override
    public List<Contacts> getAll() {
        return contactsDao.getAll();
    }
}
