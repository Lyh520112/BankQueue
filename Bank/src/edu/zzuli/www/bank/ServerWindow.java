package edu.zzuli.www.bank;

import java.util.Random;
import java.util.concurrent.Executors;

public class ServerWindow {

	private CustomerType type = CustomerType.COMMOE;
	private int windowId = 1;
	public void setType(CustomerType type) {
		this.type = type;
	}

	public void setWindowId(int windowId) {
		this.windowId = windowId;
	}

	
	public void start() {
		Executors.newSingleThreadExecutor().execute(new Runnable() {
			public void run() {
				while(true) {
					switch(type) {
					case COMMOE:
						commonService();
						break;
					case EXPRESS:
						commonService();
						break;
					case VIP:
						commonService();
						break;
					}
				}
			}
		});
		}

			private void commonService() {
				String windowName = "第" + windowId + "号" + type + "窗口";
				System.out.println(windowName+"正在获取任务");
				Integer number = NumberMachine.getInstance().getCommonManager().fetchServerNumber();
				if(number !=null) {
					long beginTime = System.currentTimeMillis();
					int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					long serverTime = new Random().nextInt(maxRand) + 1 +Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(serverTime);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第几个" + number + "个" + type + "客户完成服务，耗时" +costTime/1000 + "秒");
				}else {
					System.out.println(windowName+"没有取到任何任务,先休息1秒钟嘛！");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	
			private void expressService() {
				String windowName = "第" + windowId + "号" + type + "窗口";
				System.out.println(windowName+"正在获取任务");
				Integer number = NumberMachine.getInstance().getExpressManager().fetchServerNumber();
				if(number !=null) {
					long beginTime = System.currentTimeMillis();
					//int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					//long serverTime = new Random().nextInt(maxRand) + 1 + Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(Constants.MIN_SERVICE_TIME);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第几个" + number + "个" + type + "客户完成服务，耗时" +costTime/1000 + "秒");
				}else {
					System.out.println(windowName + "没有取到任何任务");
					commonService();
					
				}
			}
			
			private void vipService() {
				String windowName = "第" + windowId + "号" + type + "窗口";
				System.out.println(windowName+"正在获取任务");
				Integer number = NumberMachine.getInstance().getVipManager().fetchServerNumber();
				if(number !=null) {
					long beginTime = System.currentTimeMillis();
					int maxRand = Constants.MAX_SERVICE_TIME - Constants.MIN_SERVICE_TIME;
					long serverTime = new Random().nextInt(maxRand) + 1 +Constants.MIN_SERVICE_TIME;
					try {
						Thread.sleep(serverTime);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					long costTime = System.currentTimeMillis() - beginTime;
					System.out.println(windowName + "为第几个" + number + "个" + type + "客户完成服务，耗时" +costTime/1000 + "秒");
				}else {
					System.out.println(windowName + "没有取到任务");
					commonService();
					
				}
			}
}
