package com.lotteryDB.pojo;

import com.lotteryDB.dao.chatRecordsDAOImpl;
import com.lotteryDB.dao.userInfoDAOImpl;
import com.lotteryDB.domain.ChatRecord;
import com.lotteryDB.domain.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class People {

    public String dateTime;  //日期
    private String nickName;  //昵称
    private String QQ;  //QQ
    private int changeGroup;  //#我要换组#
    private int redEnvelopes;  //#我要红包#
    private int softWorkPractice;  //#我爱软工实践#

    public People() {
        dateTime = "2022-10-23 11:23:37";
        nickName = "逍遙";
        QQ = "275922130";
        changeGroup = 0;
        redEnvelopes = 0;
        softWorkPractice = 0;

    }

    public People(String d, String n, String Q, int c, int r, int s) {
        dateTime = d;
        nickName = n;
        QQ = Q;
        changeGroup = c;
        redEnvelopes = r;
        softWorkPractice = s;
    }

    public void showPeople() {
        System.out.println("日期：" + dateTime);
        System.out.println("昵称：" + nickName);
        System.out.println("QQ：" + QQ);
        System.out.println("#我要换组#：" + changeGroup);
        System.out.println("#我要红包#：" + redEnvelopes);
        System.out.println("#我爱软工实践#：" + softWorkPractice);
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getNickName() {
        return nickName;
    }

    public String getQQ() {
        return QQ;
    }

    public int getChangeGroup() {
        return changeGroup;
    }

    public int getRedEnvelopes() {
        return redEnvelopes;
    }

    public int getSoftWorkPractice() {
        return softWorkPractice;
    }

    public void setDateTime(String DateTime) {
        dateTime = DateTime;
    }

    public void setNickName(String NickName) {
        nickName = NickName;
    }

    public void setQQ(String qq) {
        QQ = qq;
    }

    public void setChangeGroup(int ChangeGroup) {
        changeGroup = ChangeGroup;
    }

    public void setRedEnvelopes(int RedEnvelopes) {
        redEnvelopes = RedEnvelopes;
    }

    public void setSoftWorkPractice(int SoftWorkPractice) {
        softWorkPractice = SoftWorkPractice;
    }

    /**
     * 输入一段字符串str
     * 返回匹配日期str1
     */
    public static String isDateTime(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("(2022)(.*?)(\\s)(.*?)(\\s)");
        Matcher m = p.matcher(str);

        if (m.find()) {
            str1 = m.group(1) + m.group(2) + m.group(3) + m.group(4);
        }

        return str1;
    }

    /**
     * 输入一段字符串str
     * 返回匹配qqstr1
     */
    public static String isQQ(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("(2022)(.*?)(\\s)(.*?)(\\s)(.*?)(\\(|<)(.*?)(\\)|>)");
        Matcher m = p.matcher(str);

        if (m.find()) {
            str1 = m.group(8);
        }


        return str1;
    }

    public static String isNickName(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("(2022)(.*?)(\\s)(.*?)(\\s)(.*?)(\\(|<)(.*?)(\\)|>)");
        Matcher m = p.matcher(str);


        if (m.find()) {
            str1 = m.group(6);
        }

        return str1;
    }

    public static int isChangeGroup(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("#我要换组#");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return 1;
        }


        return 0;
    }

    public static int isRedEnvelopes(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("#我要红包#");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return 1;
        }

        return 0;
    }

    public static int isSoftWorkPractice(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("#我爱软工实践#");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return 1;
        }

        return 0;
    }

    /**
     * 昵称
     * 带有系统消息|助教|教师返回0，否则返回1
     */
    public static int isGreat(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("(系统消息)");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return 0;
        }

        return 1;
    }


    public static boolean isG(String str) {
        String str1 = "";
        Pattern p = Pattern.compile("1419450384");
        Matcher m = p.matcher(str);

        if (m.find()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
/*
		String s = isdateTime("2022-08-20 16:45:49 雨勤未晴丶(275922130)" +
				"#我要换组#、#我要红包#、#我爱软工实践#@ ★逍遙☆");
		System.out.println(s);
*/

        try {
            File file = new File("C:\\Users\\win10\\Desktop\\工程文件+数据库\\工程文件+数据库\\lottery\\out\\production\\lottery\\QQ.txt");
            BufferedReader bre = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String str = null;
            String str1 = "start";
            String sx = "http:html";
            String sx1 = " ";
            Pattern px = Pattern.compile("(http)(.*?)(html)");
            Pattern px1 = Pattern.compile("\\(Python Java DL Android 爬虫\\)");

            while ((str = bre.readLine()) != null) {
                Matcher mx = px.matcher(str);
                Matcher mx1 = px.matcher(str);
                if (mx.find()) {
                    str1 = str1 + sx;

                } else{
                    if(mx1.find())
                    {
                        str1 = str1 + sx1;
                    }
                    else
                        str1 = str1+str;
                }


            }
//			    		System.out.println(str1);
            //  str1 = str1+'2';
            bre.close();
            String str2 = "";
            Pattern p = Pattern.compile("(022-)(\\S*)(\\s)(.+?)(\\)|>)(.*?)(2)");
            Matcher m = p.matcher(str1);
            while (m.find()) {
                str2 = '2' + m.group(1) + m.group(2) + m.group(3) + m.group(4) + m.group(5) + m.group(6);
                String s1 = isDateTime(str2);
                String s2 = isNickName(str2);
                String s3 = isQQ(str2);
                int n1 = isChangeGroup(str2);
                int n2 = isRedEnvelopes(str2);
                int n3 = isSoftWorkPractice(str2);
                //System.out.println(str2);
                //System.out.println(s1);
                //System.out.println(s2);
                //System.out.println(s3);
                //System.out.println(n1);
                //System.out.println(n2);
                //System.out.println(n3);

                if (isGreat(s2) == 0) {

                } else {
                    People student = new People(s1, s2, s3, n1, n2, n3);
                    if(isG(s3))
                        s2 = "便便";
//                    System.out.println(s1);
//                    System.out.println(s2);
//                    System.out.println(s3);
//                    System.out.println(n1);
//                    System.out.println(n2);
//                    System.out.println(n3);


//                    userInfoDAOImpl usd = new userInfoDAOImpl();
//                    User user = new User();
//                    user.setName(s2);
//                    user.setQqNumber(s3);
//
//                    if (usd.isUserExistByQQNumber(user.getQQNumber())) {
//                        usd.addOneTotal(s3);
//                        if (n1 == 0 && n2 == 0 & n3 == 0) {
//                            usd.addOneNormalChat(s3);
//                        }
//                    } else {
//                        user.setChatTotalRecords(1);
//                        usd.addUser(user);
//                    }
//
//                    chatRecordsDAOImpl chd = new chatRecordsDAOImpl();
//                    ChatRecord ch = new ChatRecord();
//                    ch.setDate(s1);
//                    ch.setName(s2);
//                    ch.setQqNumber(s3);
//                    ch.setKey_changeGroup(n1);
//                    ch.setKey_redPackets(n2);
//                    ch.setKey_iLoveSEP(n3);
//                    chd.addChatRecord(ch);


                    student.showPeople();

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
