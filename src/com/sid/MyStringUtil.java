package com.sid;
import java.security.MessageDigest;

public class MyStringUtil {
	public static String applySHA256(String input) {
		try
		{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(input.getBytes("UTF-8"));
		StringBuffer hexString = new StringBuffer();
		for(int i=0;i<hash.length;i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
		}
		catch(Exception e) {
			System.out.println("Exception at applySHA256"+e.toString());
			return e.toString();
		}
	}
}
