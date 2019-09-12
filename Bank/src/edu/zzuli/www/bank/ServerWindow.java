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
				String windowName = "��" + windowId + "��" + type + "����";
				System.out.println(windowName+"���ڻ�ȡ����");
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
					System.out.println(windowName + "Ϊ�ڼ���" + number + "��" + type + "�ͻ���ɷ��񣬺�ʱ" +costTime/1000 + "��");
				}else {
					System.out.println(windowName+"û��ȡ���κ�����,����Ϣ1�����");
					try {
						Thread.sleep(1000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
	
			private void expressService() {
				String windowName = "��" + windowId + "��" + type + "����";
				System.out.println(windowName+"���ڻ�ȡ����");
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
					System.out.println(windowName + "Ϊ�ڼ���" + number + "��" + type + "�ͻ���ɷ��񣬺�ʱ" +costTime/1000 + "��");
				}else {
					System.out.println(windowName + "û��ȡ���κ�����");
					commonService();
					
				}
			}
			
			private void vipService() {
				String windowName = "��" + windowId + "��" + type + "����";
				System.out.println(windowName+"���ڻ�ȡ����");
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
					System.out.println(windowName + "Ϊ�ڼ���" + number + "��" + type + "�ͻ���ɷ��񣬺�ʱ" +costTime/1000 + "��");
				}else {
					System.out.println(windowName + "û��ȡ������");
					commonService();
					
				}
			}
}
