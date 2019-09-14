package org.smart4j.framework.plugin.realm;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.smart4j.framework.helper.DatabaseHelper;

/**
 * 基于Smart的JDBC Realm(需要提供相关smart.plugin.security.jdbc.*配置项)
 */
public class SmartJdbcRealm extends JdbcRealm {

    public SmartJdbcRealm(){
        super.setDataSource(DatabaseHelper.getDataSource());
    }

}
