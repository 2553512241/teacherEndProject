package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.BusinessDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Repository
public class BusinessDaoImpl extends BaseDaoImpl<Business, String> implements BusinessDao {
    /**
     * 实现Dao层里的方法
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @Override
    public List<Business> getBusinessListByPage(Integer pageNumber, Integer pageSize, Integer searchBy, String searchText) {
        String hql = null;
        if (searchText == null || searchBy == 1) {
            hql = "from Business";
        }
        if(searchText != null) {
            if (searchBy == 2) {
                hql = "from Business b where b.customer.name like '%"+searchText+"%'";
            }
            if (searchBy == 3) {
                hql = "from Business b where b.name like '%"+searchText+"%'";
            }
            if (searchBy == 4) {
                hql = "from Business b where b.origin like '%"+searchText+"%'";
            }
            if (searchBy == 5) {
                hql = "from Business b where b.nextstep like '%"+searchText+"%'";
            }
        }
        return this.getListByPage(pageNumber, pageSize, hql, new Object[]{});
    }

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Override
    public Business get(String id) {
        return super.get(id);
    }

    @Override
    public List<Business> getAll() {
        return super.getAll();
    }

    /**
     * 保存的方法
     * @param entity
     */
    @Override
    public void save(Business entity) {
        super.save(entity);
    }

    /**
     * 更新的方法
     * @param entity
     */
    @Override
    public void update(Business entity) {
        super.update(entity);
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }
}
