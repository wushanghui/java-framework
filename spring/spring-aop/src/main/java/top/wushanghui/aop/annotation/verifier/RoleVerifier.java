package top.wushanghui.aop.annotation.verifier;

import top.wushanghui.aop.annotation.pojo.Role;

/**
 * @author jue
 * @date 2020/8/13 22:43
 * @describe
 */
public interface RoleVerifier {

    public boolean verify(Role role);
}
