package cn.cultivator.bbs.util;

import java.security.MessageDigest;
import java.util.Random;


public final class WebUtil {
	public static String encodeByMd5(String password) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] results = md.digest(password.getBytes());
		String passwordMD5 = byteArrayToString(results);
		return passwordMD5;
	}

	private static String byteArrayToString(byte[] results) {
		StringBuffer sb = new StringBuffer();
		for(byte b : results){
			String hexString = byteToString(b);
			sb.append(hexString);
		}
		return sb.toString();
	}

	private static String byteToString(byte b) {
		int n = b;
		if(n<0){
			n=n+256;
		}
		int d1 = n/16;
		int d2 = n%16;
		return hex[d1]+hex[d2];
	}
	private final static String hex[] = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	public static String getRandom(){
		Random r = new Random();
		int random = r.nextInt(9000)+1000;
		return random+"";
	}
}
