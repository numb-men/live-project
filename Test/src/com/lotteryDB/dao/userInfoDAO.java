package com.lotteryDB.dao;

import com.lotteryDB.domain.User;

import java.util.List;

public interface userInfoDAO {
    int getTotal();

    void addUser(User bean);

    //List<User> getAll();

    int getTotalChatCountByQQNumber(String qqNumber);

    int getNormalChatCountByQQNumber(String qqNumber);

    boolean isUserExistByQQNumber(String qqNumber);

    void addOneTotal(String qqNumber);

    void addOneNormalChat(String qqNumber);
}
