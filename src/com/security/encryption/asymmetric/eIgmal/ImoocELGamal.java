package com.security.encryption.asymmetric.eIgmal;

import java.security.AlgorithmParameterGenerator;  
import java.security.AlgorithmParameters;  
import java.security.Key;  
import java.security.KeyFactory;  
import java.security.KeyPair;  
import java.security.KeyPairGenerator;  
import java.security.PrivateKey;  
import java.security.PublicKey;  
import java.security.SecureRandom;  
import java.security.Security;  
import java.security.interfaces.RSAPrivateKey;  
import java.security.interfaces.RSAPublicKey;  
import java.security.spec.PKCS8EncodedKeySpec;  
import java.security.spec.X509EncodedKeySpec;  
import java.util.HashMap;  
import java.util.Map;  
import javax.crypto.Cipher;  
import javax.crypto.interfaces.DHPrivateKey;  
import javax.crypto.interfaces.DHPublicKey;  
import javax.crypto.spec.DHParameterSpec;  
import org.apache.commons.codec.binary.Base64;  
import org.bouncycastle.jce.provider.BouncyCastleProvider;  
/**
 * @Description: ELGamal
 * @author wutp 2016年10月3日
 * @version 1.0
 */
public class ImoocELGamal {
	
	private static String src = "imooc security rsa";

	public static void main(String[] args) {
		bcELGamal();
	}
	
	public static void bcELGamal(){
		
		
		//1、初始化密钥
		try {
			/**
			 * //公钥加密，私钥解密
			 */			
			Security.addProvider(new BouncyCastleProvider());						
			AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ElGamal");
			//初始化参数生成器 
			algorithmParameterGenerator.init(256);
			//生成算法参数  
			AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
			//构建参数材料 
			DHParameterSpec dhParameterSpec = (DHParameterSpec)algorithmParameters.getParameterSpec(DHParameterSpec.class);
			//实例化密钥生成器  
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ElGamal");
			//初始化密钥对生成器  
			keyPairGenerator.initialize(dhParameterSpec, new SecureRandom());
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			//甲方公钥 
			PublicKey eIGamalPublicKey = keyPair.getPublic();
			//甲方私钥 
			PrivateKey eIGamalPrivateKey = keyPair.getPrivate();
			System.out.println("Public Key: " + Base64.encodeBase64String(eIGamalPublicKey.getEncoded()));
			System.out.println("private Key: " + Base64.encodeBase64String(eIGamalPrivateKey.getEncoded()));
			
			//实例化密钥工厂
			KeyFactory keyFactory = KeyFactory.getInstance("ElGamal");
			//初始化公钥  
	        //密钥材料转换 
			X509EncodedKeySpec x509EncodedKeySpec =new X509EncodedKeySpec(eIGamalPublicKey.getEncoded());
			PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
			Cipher cipher = Cipher.getInstance("ElGamal");
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			byte[] result = cipher.doFinal(src.getBytes());
			System.out.println("公钥加密、私钥解密-加密: " + Base64.encodeBase64String(result));
			
			//取得私钥  
			PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(eIGamalPrivateKey.getEncoded());
			keyFactory =KeyFactory.getInstance("ElGamal");
			//生成私钥 
			PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
			//数据解密 
			cipher = Cipher.getInstance("ElGamal");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			result = cipher.doFinal(result);
			System.out.println("公钥加密、私钥解密-解密: " + new String(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
