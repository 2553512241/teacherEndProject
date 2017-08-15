package com.zhidi.manage.service;

import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;

import java.util.List;

/**
 * Created by �ο� on 2017/7/26.
 */
public interface DepartmentService {

    /**
     * ����pageNumber��pageSize��ҳ��ѯ
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getDepartmentByPager(Integer pageNumber, Integer pageSize);

}
