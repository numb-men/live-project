package com.lotteryDB.domain;

public class User {

    private String name;

    private String qqNumber;


    private int chatTotalRecords;

    public void setName(String name) {
        this.name = name;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public void setChatTotalRecords(int chatTotalRecords) {
        this.chatTotalRecords = chatTotalRecords;
    }

    public String getName() {
        return name;
    }

    public String getQQNumber() {
        return qqNumber;
    }

    public int getChatTotalRecords() {
        return chatTotalRecords;
    }
}
