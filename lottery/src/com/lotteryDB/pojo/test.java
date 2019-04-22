package com.lotteryDB.pojo;

import com.lotteryDB.dao.chatRecordsDAOImpl;
import com.lotteryDB.domain.User;
import com.lotteryDB.dao.userInfoDAOImpl;

import java.util.List;

public class test {
    public static void get() {
        userInfoDAOImpl userDaoImpl = new userInfoDAOImpl();
        int qqNum = 100;
        int num = userDaoImpl.getTotal();
        System.out.println(num);//.getCustomerName());
    }

    public static void add(User user) {
        userInfoDAOImpl userDaoImpl = new userInfoDAOImpl();
        userDaoImpl.addUser(user);
    }

    public static void getall() {
    }

    //调用并获得符合抽奖条件的用户列表list（时间以及抽奖类型）
    public static void pickEligibleUsers() {
        chatRecordsDAOImpl chd = new chatRecordsDAOImpl();
        List<User> list = chd.getEligibleUsers("2022-08-19 16:45:49", "2022-11-25 10:43:49", 1);

        for (User user : list) {
            System.out.println(user.getChatTotalRecords() + " " + user.getName() + " " + user.getChatTotalRecords());
        }
    }

    public static void getNormal(){
        userInfoDAOImpl userDaoImpl = new userInfoDAOImpl();
        System.out.println(userDaoImpl.getNormalChatCountByQQNumber("1259125431"));
    }

    public static void main(String[] args) {
        getNormal();
    }
}
