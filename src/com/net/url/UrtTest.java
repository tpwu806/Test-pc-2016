package com.net.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class UrtTest {

	public static void main(String[] args) throws Exception{
		URL url = new URL("http://localhost:8080/ServletDemo/ServletDemo1");
//		URL url = new URL("http://www.baidu.com");
		Proxy proxy;
		HttpURLConnection connection;
		if(url.toString().contains("localhost")){
			connection = (HttpURLConnection) url.openConnection();
		} else {
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
					"proxy5.bj.petrochina", 8080));
			connection = (HttpURLConnection) url.openConnection(proxy);
		}
		
//		String result = get(connection);
		String result = post(connection);
		System.out.println("result:"+result);
	}
	
	static String get(HttpURLConnection connection) throws Exception{
		connection.setRequestMethod("GET");
//		connection.connect();
		InputStream is = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		String strRead = null;
		StringBuffer sbf = new StringBuffer();
		while ((strRead = reader.readLine()) != null) {
			sbf.append(strRead);
			sbf.append("\r\n");
		}
		reader.close();
		String result = sbf.toString();
		return result;
	}
	
	static String post(HttpURLConnection connection) throws Exception{
		connection.setRequestMethod("POST");
//		connection.connect();
		connection.setConnectTimeout(10000);//连接的超时时间  
		connection.setReadTimeout(5000);//读数据的超时时间  
		connection.setDoOutput(true);//必须设置此方法  允许输出  
		connection.setDoInput(true);   //需要输入
		connection.setUseCaches(false);  //不允许缓存
		
		PrintWriter writer = new PrintWriter(connection.getOutputStream());
		writer.write("Hello");
		writer.flush();
		writer.close();
		int code = connection.getResponseCode();
		if (code == 200) {
			InputStream inputStream = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String liner;
			StringBuffer buffer = new StringBuffer();
			while ((liner = reader.readLine()) != null) {
				buffer.append(liner);
			}
			String result = buffer.toString();
			return result;
		}
		return null;
	}
	
}
