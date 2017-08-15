package com.zhidi.manage.service.impl;

import com.zhidi.manage.dao.ContractDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import com.zhidi.manage.service.ContractService;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.manage.vo.ContractVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Service
public class ContractServiceImpl implements ContractService{

    @Autowired
    protected ContractDao contractDao;

    /**
     * 实现分页的方法
     * @param pageNumber
     * @param pageSize
     * @param
     * @return
     */
    @Override
    public Pager getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer contractOne, Integer contractTwo, String contractThree) {
        List<Contract> contractList = contractDao.getContractListByPage(pageNumber, pageSize, contractOne, contractTwo, contractThree);
        List<ContractVO> contractVOList = new ArrayList<ContractVO>();
        if(contractList != null && contractList.size() > 0) {
            for (Contract contract: contractList) {
                ContractVO contractVO = ContractVO.formContract(contract);
                contractVOList.add(contractVO);
            }
        }
        //获取总数
        Integer count = contractDao.count();
        Pager pager = new Pager();
        pager.setList(contractVOList);
        pager.setPageNumber(pageNumber);
        pager.setTotalRows(count);
        pager.setPageSize(pageSize);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public ContractVO get(String id) {
        Contract contract = contractDao.get(id);
        return   ContractVO.formContract(contract);
    }

    @Override
    public void save(Contract entity) {
        contractDao.save(entity);
    }

    @Override
    public void delete(String id) {
        contractDao.delete(id);
    }

    @Override
    public void update(Contract entity) {
        contractDao.update(entity);
    }
}
