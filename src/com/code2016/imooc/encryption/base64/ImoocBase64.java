package com.code2016.imooc.encryption.base64;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


/**
 * @Description: Base64加密算法
 * @author wutp 2016年10月3日
 * @version 1.0
 */
public class ImoocBase64 {

	private static String src = "imooc security base64"; 
	
	public static void main(String[] args) {
//		jdkBase64();
//		commonsCodesBase64();
		bouncyCastleBase64();

	}
	
	/**
	 * @Description:sun.misc
	 * @auther: wutp 2016年10月3日
	 * @return void
	 */
	public static void jdkBase64(){
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode: " + encode);
			
			BASE64Decoder decoder = new BASE64Decoder();
			System.out.println("decoder: " + new String(decoder.decodeBuffer(encode)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description:org.apache.commons.codec.binary
	 * @auther: wutp 2016年10月3日
	 * @return void
	 */
	public static void commonsCodecBase64(){
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());;
		System.out.println("encode: " + new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decoder: " + new String(decodeBytes));
	}
	
	/**
	 * @Description:org.apache.commons.codec.binary
	 * @auther: wutp 2016年10月3日
	 * @return void
	 */
	public static void bouncyCastleBase64(){
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode: " + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decoder: " + new String(decodeBytes));
	}
	
	
}