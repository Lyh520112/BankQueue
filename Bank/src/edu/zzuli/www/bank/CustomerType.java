package edu.zzuli.www.bank;

public enum CustomerType {

	COMMOE,EXPRESS,VIP;
	public String toString()
	{
		switch(this) {
		case COMMOE:
			return "��ͨ";
		case EXPRESS:
			return "����";
		case VIP:
			return name();
		}
		return null;
	}
}
