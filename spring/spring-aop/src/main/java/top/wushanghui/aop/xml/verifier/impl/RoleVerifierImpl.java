package top.wushanghui.aop.xml.verifier.impl;

import top.wushanghui.aop.xml.pojo.Role;
import top.wushanghui.aop.xml.verifier.RoleVerifier;

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
