package edu.zzuli.www.bank;

import java.util.ArrayList;
import java.util.List;

public class NumberManager {

	private int lastNumber = 1;
	private List<Integer> queueNumber = new ArrayList<Integer>();
	
	public synchronized Integer generateNetManage() {
		queueNumber.add(lastNumber);
		return lastNumber++;
	}
	
	public synchronized Integer fetchServerNumber() {
		Integer number =null;
		if(queueNumber.size()>0) {
			return queueNumber.remove(0);
		}
		return number;
	}
}
