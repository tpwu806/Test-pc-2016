package com.code2016.imooc.securite.symmetric.aes;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @Description: AES
 * @author wutp 2016年10月3日
 * @version 1.0
 */
public class ImoocAES {

	private static String src = "imooc security aes";
	
	public static void main(String[] args) {
		jdkAES();
		bcAES();
	}
	
	public static void jdkAES(){
		try {
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.getProvider();
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			Key key = new SecretKeySpec(byteKey,"AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk aes encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("jdk aes decrypt: " + new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void bcAES(){
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES","BC");
			keyGenerator.getProvider();
			keyGenerator.init(128);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			Key key = new SecretKeySpec(byteKey,"AES");
			
			//加密
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc aes encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, key);
			result = cipher.doFinal(result);
			System.out.println("bc aes decrypt: " + new String(result));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
