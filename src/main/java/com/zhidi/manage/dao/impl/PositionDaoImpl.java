package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.PositionDao;
import com.zhidi.manage.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Repository
public class PositionDaoImpl extends BaseDaoImpl<Position,String> implements PositionDao {


    @Override
    public List<Position> getEmployeeListByPage(Integer PageNumber, Integer PageSize, String name) {
        String hql= null;
        if(name==null){
             hql = "from Position";
        }else {
             hql = "from Position p where p.name like '%"+name+"%'";

        }
        return this.getListByPage(PageNumber,PageSize,hql, new String[]{});
    }

}

