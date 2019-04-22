package com.lotteryDB.until;

import java.sql.*;

public class DBUtil {
    static String ip = "134.175.16.143";
    static int port = 3306;
    static String database = "lottery";
    static String encoding = "UTF-8";
    static String loginName = "schoolhelp6!";
    static String password = "Zgdr@Very6!";
//    ip:134.175.16.143
//    port:3306
//    user:schoolhelp6!
//    password:Zgdr@Very6!
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }

    /* 关闭连接的方法 */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (stmt != null)
                stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
