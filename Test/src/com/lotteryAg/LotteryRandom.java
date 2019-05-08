package com.lotteryAg;
import java.util.*;
//import org.omg.CORBA.PUBLIC_MEMBER;

public  class LotteryRandom{
	public static ArrayList<Integer> getDiffNO(int giftnum,int peoplenum){
		int cout=0;

		ArrayList<Integer> list = new ArrayList();
     /*如果奖品数大于参与人数，则返回全部参与人数的序列*/
		if(giftnum>=peoplenum){
			for(int i=0;i<peoplenum;i++){
				list.add(i);
			}
			return list;
		}
        while( cout<giftnum){
        	Date now = new Date();
			long nowtime =now.getTime();//获取系统至今通过的毫秒数
		    Random r=new Random();
		    int  ran1=r.nextInt(1000);//使用random（）生成随机数
		    long sum=ran1+nowtime;
		    int lucknum=(int) (sum%(peoplenum));
        	if(!list.contains(lucknum)){//判断产生的随机数是否在序列中
        		list.add(lucknum);
        		cout++;
        	} 	
        }	
    	return list;
	}

			public static void main(String[] args){
			/*LinkedList x=LotteryRandom.getDiffNO(4, 11);
        	for ( int i = 0; i < x.size(); i++){
        		 System.out.println(x.get(i));
        		} */
	}

	
}
