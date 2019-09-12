package edu.zzuli.www.bank;

public enum CustomerType {

	COMMOE,EXPRESS,VIP;
	public String toString()
	{
		switch(this) {
		case COMMOE:
			return "ÆÕÍ¨";
		case EXPRESS:
			return "¿ìËÙ";
		case VIP:
			return name();
		}
		return null;
	}
}
