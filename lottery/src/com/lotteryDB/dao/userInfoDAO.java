package com.lotteryDB.dao;

import com.lotteryDB.domain.User;

import java.util.List;

public interface userInfoDAO {
    int getTotal();

    void addUser(User bean);

    List<User> getAll();

    int getChatCountByQQNumber(String qqNumber);

    void addOne(String qqNumber);
}
