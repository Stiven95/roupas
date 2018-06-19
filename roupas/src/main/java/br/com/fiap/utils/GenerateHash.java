package br.com.fiap.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenerateHash {

	public static String generate(String s) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			
			m.update(s.getBytes(), 0, s.length());
			byte[] digest = m.digest();
			
			String hexaDecimal = new BigInteger(1, digest).toString(16);
			
			return hexaDecimal;
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
