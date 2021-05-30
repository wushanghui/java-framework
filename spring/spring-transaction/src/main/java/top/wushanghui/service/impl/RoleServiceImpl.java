package top.wushanghui.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wushanghui.dao.RoleDao;
import top.wushanghui.entity.Role;
import top.wushanghui.service.RoleService;

/**
 * @author jue
 * @date 2020/8/15 22:52
 * @describe
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public int update(Role role) {
        return roleDao.update(role);
    }

    @Override
    public Role query(String roleCode) {
        return roleDao.query(roleCode);
    }
}
