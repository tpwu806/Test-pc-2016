package com.code2016.imooc.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class UDPClient {
	public static void main(String[] args) throws IOException {
		/*
		 * ��������˷�������
		 */
		//1.����������ĵ�ַ���˿ںš�����
		InetAddress address=InetAddress.getByName("localhost");
		int port=8800;
		byte[] data="�û�����admin;���룺123".getBytes();
		//2.�������ݱ����������͵�������Ϣ
		DatagramPacket packet=new DatagramPacket(data, data.length, address, port);
		//3.����DatagramSocket����
		DatagramSocket socket=new DatagramSocket();
		//4.��������˷������ݱ�
		socket.send(packet);
		
		/*
		 * ���շ���������Ӧ������
		 */
		//1.�������ݱ������ڽ��շ���������Ӧ������
		byte[] data2=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(data2, data2.length);
		//2.���շ�������Ӧ������
		socket.receive(packet2);
		//3.��ȡ����
		String reply=new String(data2, 0, packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��"+reply);
		//4.�ر���Դ
		socket.close();
	}
}
