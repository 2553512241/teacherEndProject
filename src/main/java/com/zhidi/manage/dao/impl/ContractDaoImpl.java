package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.ContractDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.entity.Contract;
import org.springframework.stereotype.Repository;
import sun.swing.SwingUtilities2;

import java.util.List;

/**
 * Created by Administrator on 2017/8/1.
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract, String> implements ContractDao {
    @Override
    public List<Contract> getContractListByPage(Integer pageNumber, Integer pageSize, Integer contractOne, Integer contractTwo, String contractThree) {
        StringBuffer hql =  new StringBuffer( "from Contract c left join fetch c.business b left join fetch c.createUser left join " + "fetch c.ownerUser left join fetch c.deleteUser left join fetch b.customer");
        if (contractOne != null && contractTwo != null && contractThree != null) {
            if(contractOne == 2 && contractTwo ==1) {
                hql.append(" where b.customer.name like '%");
                hql.append(contractThree);
                hql.append("%'");
            }
            if(contractOne==2 && contractTwo ==2) {
                hql.append("where b.customer.name = ");
                hql.append(contractThree);
            }
            if(contractOne ==3 && contractTwo == 1) {
                hql.append(" where b.businessContacts.name like '%"+contractThree+"%'");
            }
            if(contractOne ==3 && contractTwo==2) {
                //where businessConnectionName='contractThree';
                hql.append(" where b.businessContacts.name ='"+ contractThree +"'");
            }
            if(contractOne==4 && contractTwo==1) {
                hql.append(" where c.ownerUser.username like '%"+contractThree+"%'");
            }
            if(contractOne==4 && contractTwo==2) {
                hql.append(" where c.ownerUser.username = '"+ contractThree +"'");
            }
            return this.getListByPage(pageNumber,pageSize,new String(hql),new String[]{});
        }
        return this.getListByPage(pageNumber,pageSize,new String(hql),new String[]{});
    }

    @Override
    public Contract get(String id) {
        return super.get(id);
    }

    @Override
    public void save(Contract entity) {
        super.save(entity);
    }

    @Override
    public void delete(String id) {
        super.delete(id);
    }

    @Override
    public void update(Contract entity) {
        super.update(entity);
    }
}
