package com.zhidi.manage.service;

import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface ContractService {

    /**
     * 分页查询
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Pager getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer contractOne, Integer contractTwo, String contractThree);



    ContractVO get(String id);


    void save(Contract entity);

    void delete(String id);

    void update(Contract entity);
}



