package org.smart4j.framework.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    //数据库配置
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/demo";
    public static final String username = "root";
    public static final String password = "root";

    //定义一个数据库连接
    public static Connection conn = null;

    //定义一个用于放置数据库连接的局部线程变量（使每个线程都拥有自己的连接）
    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    //获取连接
    public static Connection getConnection() {
        Connection conn = connContainer.get();
        try{
            if(conn==null){
                Class.forName(driver);
                conn = DriverManager.getConnection(url,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();;
        } finally {
            connContainer.set(conn);
        }
        return conn;
    }

    //关闭连接
    public static void closeConnection() {
        Connection conn = connContainer.get();
        try{
            if(conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            connContainer.remove();
        }
    }

}
