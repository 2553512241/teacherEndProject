package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Employee;
import com.zhidi.manage.entity.Position;

import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
public interface PositionDao  extends BaseDao<Position,String>{
    /**
     * 根据pageNumber 和PageSize 分页查询
     * @param PageNumber
     * @param PageSize
     * @return
     */
    List<Position> getEmployeeListByPage(Integer PageNumber, Integer PageSize, String name);

    @Override
    void delete(String positionid);

    @Override
    void update(Position position);
}
