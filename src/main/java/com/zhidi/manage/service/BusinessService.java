package com.zhidi.manage.service;


import com.zhidi.manage.dao.BusinessDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * Created by Administrator on 2017/7/26.
 */
public interface BusinessService {

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer searchBy, String searchText);

    /**
     * 通过id查询修改数据
     * @param id
     * @return
     */
    BusinessVO get(String id);


    List<Business> getAll();

    void update(Business entity);

    void save(Business entity);

    void delete(String id);




}
