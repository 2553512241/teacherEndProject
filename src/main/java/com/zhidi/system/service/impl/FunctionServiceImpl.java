package com.zhidi.system.service.impl;

import com.zhidi.system.dao.FunctionDao;
import com.zhidi.system.entity.Dict;
import com.zhidi.system.entity.Function;

import com.zhidi.system.service.FunctionService;
import com.zhidi.system.vo.FuncVo;

import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    protected FunctionDao functionDao;

    @Override
    public List<Function> getFunctionsByRoleId(String roleId) {
        return functionDao.getFunctionsByRoleId(roleId);
    }

    @Override
    public void saveFunction(Function function) {
        functionDao.save(function);
    }

    @Override
    public void updateFunction(Function function) {
        functionDao.update(function);
    }

    @Override
    public FuncVo getFunctionVoById(String id) {
       Function function = functionDao.get(id);
       FuncVo functionVo = FuncVo.fromRole(function);
        return functionVo;
    }

    @Override
    public void deleteFuction(String[] ids) {
        if (ids != null && ids.length > 0){
            for (int i = 0;i < ids.length;i++){
                functionDao.delete(ids[i]);
            }
        }
    }

    @Override
    public Pager getFunctionByPage(Integer pageNumber, Integer pageSize) {
        List<Function> functions = functionDao.getFunctionByPage(pageNumber,pageSize);
        List<FuncVo> funcVos = new ArrayList<FuncVo>();
        if (functions != null && !functions.isEmpty()){
            for (Function function : functions){
                FuncVo funcVo = FuncVo.fromRole(function);
                funcVos.add(funcVo);
            }
        }

        Integer totalRows = functionDao.count();
        Pager pager = new Pager();
        pager.setTotalRows(totalRows);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setList(funcVos);
        pager.setTotalPage(pager.getTotalPage());

        return pager;
    }

    @Override
    public List<Function> getAll() {
        return functionDao.getAll();
    }
}
