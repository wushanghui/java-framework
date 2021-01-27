package top.wushanghui.entity;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author jue
 * @date 2020/8/15 22:44
 * @describe
 */
public class Role {

    private String roleCode;
    private String roleName;
    private Integer version;

    public Role(String roleCode, String roleName, Integer version) {
        this.roleCode = roleCode;
        this.roleName = roleName;
        this.version = version;
    }

    public Role() {}

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleCode='" + roleCode + '\'' +
                ", roleName='" + roleName + '\'' +
                ", version=" + version +
                '}';
    }
}
