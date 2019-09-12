package edu.zzuli.www.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainClass {

	public static void main(String[] args) {
		
		for(int i = 1;i<=5;i++) {
			ServerWindow commonwindow = new ServerWindow();
			commonwindow.setWindowId(i);
			commonwindow.start();
		}
		ServerWindow ecpresswindow = new ServerWindow();
		ecpresswindow.setType(CustomerType.EXPRESS);
		ecpresswindow.start();
		
		ServerWindow vipwindow = new ServerWindow();
		vipwindow.setType(CustomerType.VIP);
		vipwindow.start();
		
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				
				new Runnable() {
					public void run() {
						Integer number = NumberMachine.getInstance().getCommonManager().generateNetManage();
						System.out.println(number + "号普通客户等待服务！");
					}
				},
				0,
				Constants.COMMON_CUSTOMER_INTERVAL_TIME,
				TimeUnit.SECONDS
			);
		
Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				
				new Runnable() {
					public void run() {
						Integer number = NumberMachine.getInstance().getExpressManager().generateNetManage();
						System.out.println(number + "号快速客户等待服务！");
					}
				},
				0,
				Constants.COMMON_CUSTOMER_INTERVAL_TIME*2,
				TimeUnit.SECONDS
			);
Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
				
				new Runnable() {
					public void run() {
						Integer number = NumberMachine.getInstance().getVipManager().generateNetManage();
						System.out.println(number + "号VIP客户等待服务！");
					}
				},
				0,
				Constants.COMMON_CUSTOMER_INTERVAL_TIME*6,
				TimeUnit.SECONDS
			);
	}
}
