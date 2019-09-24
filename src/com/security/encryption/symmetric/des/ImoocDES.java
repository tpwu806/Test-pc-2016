package com.security.encryption.symmetric.des;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 * @Description: DES加密
 * @author wutp 2016年10月3日
 * @version 1.0
 */
public class ImoocDES {
	
	private static String src = "imooc security des";

	public static void main(String[] args) {
		jdkDES();
		bcDES();
	}

	/**
	 * @Description:javax.crypto
	 * @auther: wutp 2016年10月3日
	 * @return void
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeySpecException 
	 */
	public static void jdkDES(){
		try {
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.getProvider();
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			DESKeySpec desKeySpec = new DESKeySpec(byteKey);
			SecretKeyFactory  factory = SecretKeyFactory.getInstance("DES");
			SecretKey convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("jdk des encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("jdk des decrypt: " + new String(result));
			
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
	
	/**
	 * @Description:org.bouncycastle.jce.provider.BouncyCastleProvider
	 * @auther: wutp 2016年10月3日
	 * @return void
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeySpecException 
	 */
	public static void bcDES(){
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			//生成KEY
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
			keyGenerator.getProvider();
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] byteKey = secretKey.getEncoded();
			
			//KEY的转换
			DESKeySpec desKeySpec = new DESKeySpec(byteKey);
			SecretKeyFactory  factory = SecretKeyFactory.getInstance("DES");
			SecretKey convertSecretKey = factory.generateSecret(desKeySpec);
			
			//加密
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("bc des encrypt: " + Hex.encodeHex(result).toString());
			
			//解密
			cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
			result = cipher.doFinal(result);
			System.out.println("bc des decrypt: " + new String(result));
			
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
