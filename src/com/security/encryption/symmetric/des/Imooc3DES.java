package com.security.encryption.symmetric.des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @Description: 3DES(DESede)
 * @author wutp 2016年10月3日
 * @version 1.0
 */
public class Imooc3DES {

	private static String src = "imooc security des";
	public static void main(String[] args) {
		jdk3DES();
		bc3DES();

	}
	//jdk 3des encrypt: [C@28864e92
	//jdk 3des decrypt: imooc security des
	private static void jdk3DES(){
		try {
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
			keyGenerator.getProvider();
			//keyGenerator.init(168);
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
			SecretKeyFactory  factory = SecretKeyFactory.getInstance("DESede");
			SecretKey convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");//name+工作模式+填充方式
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk 3des encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk 3des decrypt: " + new String(result));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}
	
	private static void bc3DES(){
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede","BC");
			keyGenerator.getProvider();
			//keyGenerator.init(168);
			keyGenerator.init(new SecureRandom());
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
			SecretKeyFactory  factory = SecretKeyFactory.getInstance("DESede");
			SecretKey convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc 3des encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("bc 3des decrypt: " + new String(result));
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
	}

}
