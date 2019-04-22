package com.lotteryAg;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import com.lotteryDB.until.*;
import java.sql.*;
import com.lotteryDB.dao.*;
import com.lotteryDB.domain.User;
public class DrawLottery {
	/*


	 */


	public static  ArrayList<User> CheckedPeople(String beginTime,String endTime,int type,int giftNum,int type2) throws SQLException {
		//System.out.println(beginTime+" "+endTime+" "+type+" "+giftNum);
		int peopleNum=0;
		ArrayList<Integer> luckyPeople=null;
		ArrayList<User> checkedPeople=null;
		ArrayList<User> userlist =new ArrayList<>();

		chatRecordsDAOImpl chatRecord = new chatRecordsDAOImpl();
		//调用chatRecordsDAOImpl中的getEligibleUsers方法，通过sql查找符合筛选条件的用户
		checkedPeople=(ArrayList<User>) chatRecord.getEligibleUsers(beginTime,endTime,type,type2);//返回符合抽奖规则的用户列表
//		for(User x :checkedPeople ){
//			System.out.println(x.getName());
//		}
		peopleNum=checkedPeople.size();
		luckyPeople=LotteryRandom.getDiffNO(giftNum,peopleNum);//获取获奖人序列号
		//System.out.println(peopleNum);
//       	for(int x :luckyPeople){
//       		System.out.println(x);
//       	}
       for(int x :luckyPeople){
       	userlist.add(checkedPeople.get(x));

	   }
       return userlist;
	}
}
