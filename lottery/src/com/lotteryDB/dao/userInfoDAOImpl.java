package com.lotteryDB.dao;

import com.lotteryDB.domain.User;
import com.lotteryDB.until.DBUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class userInfoDAOImpl implements userInfoDAO {
    //获取用户信息表中用户总数
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "select count(*) from userinfo";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    //新增用户记录
    public void addUser(User bean) {
        String sql = "insert into userinfo values(? ,? ,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, bean.getQQNumber());
            ps.setString(2, bean.getName());
            ps.setInt(3, bean.getChatTotalRecords());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //获取用户信息表所有用户，存在list中
    public List<User> getAll() {
        List<User> list = new LinkedList<User>();
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement()) {
            String sql = "select * from userinfo";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setQqNumber(rs.getString(1));
                user.setName(rs.getString(2));
                user.setChatTotalRecords(rs.getInt(3));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //通过QQ号获取该用户发布过的消息数量
    public int getChatCountByQQNumber(String qqNumber) {
        User user = new User();
        int chatRecorders = 0;
        String sql = "select * from userinfo where qqNumber like ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, qqNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                chatRecorders = rs.getInt(3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chatRecorders;
    }

    //通过QQ号判断用户是否存在
    public boolean isUserExistByQQNumber(String qqNumber) {
        User user = new User();
        boolean exist = false;
        String sql = "select * from userinfo where qqNumber like ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, qqNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public void addOne(String qqNumber){
        String sql = "update userinfo set chatTotalRecords=chatTotalRecords+1 where qqNumber like ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, qqNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
