package com.lotteryDB.dao;

import com.lotteryDB.domain.ChatRecord;
import com.lotteryDB.domain.User;
import com.lotteryDB.until.DBUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class chatRecordsDAOImpl implements chatRecordsDAO {
    //新增消息记录
    public void addChatRecord(ChatRecord bean) {
        String sql = "insert into chatrecord values(null ,? ,? ,? ,? ,? ,? )";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, bean.getDate());
            ps.setString(2, bean.getName());
            ps.setString(3, bean.getQqNumber());
            ps.setInt(4, bean.getKey_changeGroup());
            ps.setInt(5, bean.getKey_redPackets());
            ps.setInt(6, bean.getKey_iLoveSEP());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //通过发言开始和结束时间段以及参加的关键字筛选出符合条件的所有用户
    public List<User> getEligibleUsers(String beginTime, String endTime, int type) {
        String key = "";
        List<User> list = new LinkedList<User>();
        String sql="";
        if (type == 1) {
            sql = "select distinct chatrecord.qqNumber,chatrecord.name,userinfo.chatTotalRecords from chatrecord left join userinfo on chatrecord.qqNumber=userinfo.qqNumber where date between ? and ? and key_changeGroup=1;";
        } else if (type == 2) {
            sql = "select distinct chatrecord.qqNumber,chatrecord.name,userinfo.chatTotalRecords from chatrecord left join userinfo on chatrecord.qqNumber=userinfo.qqNumber where date between ? and ? and key_redPackets=1;";
        } else if (type == 3) {
            sql = "select distinct chatrecord.qqNumber,chatrecord.name,userinfo.chatTotalRecords from chatrecord left join userinfo on chatrecord.qqNumber=userinfo.qqNumber where date between ? and ? and key_iLoveSEP=1;";
        }
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, beginTime);
            ps.setString(2, endTime);
            ResultSet rs = ps.executeQuery();
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

}
