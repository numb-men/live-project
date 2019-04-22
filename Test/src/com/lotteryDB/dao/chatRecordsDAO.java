package com.lotteryDB.dao;

import com.lotteryDB.domain.ChatRecord;
import com.lotteryDB.domain.User;

import java.util.List;

public interface chatRecordsDAO {
    void addChatRecord(ChatRecord bean);

    List<User> getEligibleUsers(String beginTime, String endTime, int type,int type2);
}
