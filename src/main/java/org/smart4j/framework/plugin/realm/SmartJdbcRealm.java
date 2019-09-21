package org.smart4j.framework.plugin.realm;

import org.apache.shiro.authc.credential.Md5CredentialsMatcher;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.framework.plugin.security.SecurityConfig;

/**
 * 基于Smart的JDBC Realm(需要提供相关smart.plugin.security.jdbc.*配置项)
 */
public class SmartJdbcRealm extends JdbcRealm {

    public SmartJdbcRealm() {
        super.setDataSource(DatabaseHelper.getDataSource());
        super.setAuthenticationQuery(SecurityConfig.getJdbcAuthcQuery());
        super.setUserRolesQuery(SecurityConfig.getJdbcRolesQuery());
        super.setPermissionsQuery(SecurityConfig.getJdbcPermissionsQuery());
        super.setPermissionsLookupEnabled(true);
        //使用MD5加密算法
        super.setCredentialsMatcher(new Md5CredentialsMatcher());
    }

}
