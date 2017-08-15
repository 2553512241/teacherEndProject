package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface ContractDao extends BaseDao<Contract, String>{

    /**
     * 分页查询商业信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    List<Contract> getContractListByPage(Integer pageNumber, Integer pageSize, Integer contractOne, Integer contractTwo, String contractThree);

    @Override
    Contract get(String id);

    @Override
    void save(Contract entity);

    @Override
    void delete(String id);

    @Override
    void update(Contract entity);
}
