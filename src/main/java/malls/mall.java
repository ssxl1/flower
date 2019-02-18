package malls;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mall {
	
	public static  double usermoney;
	public static   String name ;
	public static   int status=1;
	public static   boolean flag =true;
	public static void main(String[] args) {
		//创建Scanner对象
        //System.in表示标准化输出，也就是键盘输出
		System.out.println("请输入顾客姓名");
        Scanner sc = new Scanner(System.in);
        name = sc.next();
        System.out.println("请输入余额");
        Scanner moneys = new Scanner(System.in);
        usermoney=Double.parseDouble(moneys.next());
        showuserInfo();
        //利用nextXXX()方法输出内容
    	
        while (flag) {
        	System.out.println("请输入酒名");
        	 Scanner sk = new Scanner(System.in);
            String winename = sk.nextLine();
            if(winename!=null&&!winename.equals("")) {
	           	 System.out.println("请输入购买数量,退酒用负数表示");
	           	 Scanner num = new Scanner(System.in);
                int nums=Integer.parseInt(num.next());
							status=1;
						 	System.out.println("请输入酒水单价");
					        Scanner winePrice = new Scanner(System.in);
					       double winePrices=Double.parseDouble(winePrice.next());
						if(nums>0) {
								double price=winePrices*nums;
								usermoney-=price;
							 showuserInfo();
						}else {
							double price=Math.abs(nums)*winePrices;
							usermoney+=price;
							 showuserInfo();
						}
						
            	
            }else {
            	flag=false;
            	System.out.println("您已经退出酒水商店了");
            }
           
        }

	}
	public static void showuserInfo() {
		if(usermoney>0) {
    		System.out.println(name+"您好您的余额为￥"+Math.abs(usermoney));
    	}else {
    		System.out.println(name+"您好您的欠额为-￥"+Math.abs(usermoney));
    	}
	}
		
}
