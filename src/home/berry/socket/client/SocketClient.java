package home.berry.socket.client;

import java.io.IOException;
import java.net.Socket;

public class SocketClient {
	static Socket socket;
	
	public static void main(String[] args) throws IOException {
		//server = new Socket(InetAddress.getLocalHost(), 6789);
		//server = new Socket("172.16.8.108", 6789);
		//String IP="172.16.8.109";
		String IP="localhost"; 
		int PORT = 6789;
		try {
			
			socket = new Socket(IP, PORT);
			Thread workThread=new Thread(new SocketThread(socket));    //创建线程
            workThread.start();
		}catch(Exception e){
            e.printStackTrace();
		}
	}
	
	
}
