package com.lotteryDB.domain;

public class ChatRecord {
    private String date;
    private String name;
    private String qqNumber;
    private int key_changeGroup;
    private int key_redPackets;
    private int key_iLoveSEP;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQqNumber() {
        return qqNumber;
    }

    public void setQqNumber(String qqNumber) {
        this.qqNumber = qqNumber;
    }

    public int getKey_changeGroup() {
        return key_changeGroup;
    }

    public void setKey_changeGroup(int key_changeGroup) {
        this.key_changeGroup = key_changeGroup;
    }

    public int getKey_redPackets() {
        return key_redPackets;
    }

    public void setKey_redPackets(int key_redPackets) {
        this.key_redPackets = key_redPackets;
    }

    public int getKey_iLoveSEP() {
        return key_iLoveSEP;
    }

    public void setKey_iLoveSEP(int key_iLoveSEP) {
        this.key_iLoveSEP = key_iLoveSEP;
    }

}
