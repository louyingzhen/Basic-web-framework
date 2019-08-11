package org.smart4j.framework.service;

import org.smart4j.framework.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductServiceImpl implements ProductService {

    private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";

    public static final String INSERT_LOG_SQL = "insert into log(created,description) values(?,?)";

    @Override
    public void updateProductPrice(Long productId, int price) {
        try {
            //获取连接
            Connection conn = DBUtil.getConnection();
            //关闭自动提交事务(开启事务)
            conn.setAutoCommit(false);

            //执行操作
            updateProduct(conn, UPDATE_PRODUCT_SQL, productId, price);

            //更新产品，插入日志
            insertLog(conn, INSERT_LOG_SQL, "Create product.");
            //提交事务
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DBUtil.closeConnection();
        }

    }

    private void updateProduct(Connection conn, String updateProductSQL, long productId, int productPrice) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(updateProductSQL);
        pstmt.setInt(1, productPrice);
        pstmt.setLong(2, productId);
        int rows = pstmt.executeUpdate();
        if (rows != 0) {
            System.out.println("Update product success!");
        }
    }

    private void insertLog(Connection conn, String insertLogSQL, String logDescription) throws Exception {
        PreparedStatement pstmt = conn.prepareStatement(insertLogSQL);
        pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        pstmt.setString(2, logDescription);
        int rows = pstmt.executeUpdate();
        if (rows != 0) {
            System.out.println("Insert log success!");
        }
    }
}
