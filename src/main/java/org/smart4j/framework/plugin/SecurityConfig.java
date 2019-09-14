package org.smart4j.framework.plugin;

import org.smart4j.framework.util.ReflectionUtil;

/**
 * 从配置文件中获取相关属性
 */
public final class SecurityConfig {

    public static String getRealms() {
        return SecurityConstant.REALMS;
    }

    public static SmartSecurity getSmartSecurity() {
        String className = SecurityConstant.SMART_SECURITY;
        return (SmartSecurity) ReflectionUtil.newInstance(className);
    }

    public static String getJdbcAuthcQuery() {
        return SecurityConstant.JDBC_AUTHC_QUERY;
    }

    public static String getJdbcRolesQuery() {
        return SecurityConstant.JDBC_ROLES_QUERY;
    }

    public static String getJdbcPermissionsQuery() {
        return SecurityConstant.JDBC_PERMISSIONS_QUERY;
    }

    public static boolean isCacheable() {
        return false;
    }

}
