package com.zhidi.manage.service.impl;


import com.zhidi.manage.dao.BusinessDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.service.BusinessService;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    protected BusinessDao businessDao;
    /**
     * 实现的分页方法
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public Pager getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer searchBy, String searchText) {
        //获取商业信息
        List<Business> businessList = businessDao.getBusinessListByPage(pageNumber, pageSize, searchBy, searchText);
        List<BusinessVO> businessVOList = new ArrayList<BusinessVO>();
        if(businessList != null && businessList.size() > 0) {
            for (Business business: businessList) {
                BusinessVO businessVO = BusinessVO.fromBusiness(business);
                businessVOList.add(businessVO);
            }
        }
        //获取总数
        Integer count = businessDao.count();
        Pager pager = new Pager();
        pager.setList(businessVOList);
        pager.setPageNumber(pageNumber);
        pager.setTotalRows(count);
        pager.setPageSize(pageSize);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public BusinessVO get(String id) {
        Business business = businessDao.get(id);
        BusinessVO businessVO = new BusinessVO();
        return businessVO.fromBusiness(business);
    }

    @Override
    public List<Business> getAll() {
        return  businessDao.getAll();
    }

    @Override
    public void update(Business entity) {
        businessDao.update(entity);
    }

    @Override
    public void save(Business entity) {
        businessDao.save(entity);
    }

    @Override
    public void delete(String id) {
        businessDao.delete(id);
    }


}
