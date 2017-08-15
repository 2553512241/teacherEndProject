package com.zhidi.system.service.impl;

import com.zhidi.system.dao.RoleDao;
import com.zhidi.system.entity.Role;
import com.zhidi.system.service.RoleService;
import com.zhidi.system.vo.RoleVo;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/26.
 */
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    protected RoleDao roleDao;

    @Override
    public Pager getRoleListByPage(Integer pageNumber, Integer pageSize) {
       List<Role> roles = roleDao.getRoleByPage(pageNumber,pageSize);
       List<RoleVo> roleVos = new ArrayList<RoleVo>();
       if (roles != null && !roles.isEmpty()){
           for (Role role : roles){
               RoleVo roleVo = RoleVo.fromRole(role);
               roleVos.add(roleVo);
           }
       }

       Integer totalRows = roleDao.count();
       Pager pager = new Pager();
       pager.setTotalRows(totalRows);
       pager.setPageNumber(pageNumber);
       pager.setPageSize(pageSize);
       pager.setList(roleVos);
       pager.setTotalPage(pager.getTotalPage());

        return pager;
    }


    @Override
    public void deleteRole(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                roleDao.delete(ids[i]);
            }
        }
    }

    @Override
    public void saveRole(Role role) {
        roleDao.save(role);
    }

    @Override
    public RoleVo getRoleById(String id) {
        Role role = roleDao.get(id);
        RoleVo roleVo = new RoleVo();
        return roleVo.fromRole(role);
    }

    @Override
    public void updateRole(Role role) {
        roleDao.update(role);
    }
}
