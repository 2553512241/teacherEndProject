package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.system.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface BusinessDao extends BaseDao<Business, String> {

    /**
     * 分页查询商业信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Business> getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer searchBy, String searchText);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    Business get(String id);


    @Override
    List<Business> getAll();

    /**
     * 保存的方法
     * @param entity
     */
    @Override
    void save(Business entity);

    @Override
    void update(Business entity);

    @Override
    void delete(String id);
}
