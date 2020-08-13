package top.wushanghui.aop.annotation.verifier.impl;

import top.wushanghui.aop.annotation.pojo.Role;
import top.wushanghui.aop.annotation.verifier.RoleVerifier;

/**
 * @author jue
 * @date 2020/8/13 22:43
 * @describe
 */
public class RoleVerifierImpl implements RoleVerifier {
    @Override
    public boolean verify(Role role) {
        return role != null;
    }
}
