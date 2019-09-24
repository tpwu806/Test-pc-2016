package com.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//import com.alibaba.fastjson.JSON;

public class UrlTest {
	
	static Proxy proxy;
	static String proxyAddress = "proxy1.bj.petrochina";
	static int proxyPort = 8080;
	
	public static void main(String[] args){
		Map<String, Object> map = request("http://www.easybots.cn/api/holiday.php?m=201301");
		Iterator<Entry<String, Object>> Iterator = map.entrySet().iterator();
		System.out.println(Iterator.toString());
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> request(String httpUrl) {
		Map<String, Object> map = null;
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();

		try {
			URL url = new URL(httpUrl);
			// 创建一个代理服务器对象
			proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
					proxyAddress, proxyPort));
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection(proxy);
			connection.setRequestMethod("GET");
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			//map = (Map<String, Object>) JSON.parse(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
