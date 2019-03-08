package com.code2017.rpc.rmi.server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hello extends UnicastRemoteObject implements HelloInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	/**
	 * 必须定义构造方法，即使是默认构造方法，也必须把它明确地写出来，因为它必须抛出出RemoteException异常
	 */
	public Hello(String msg) throws RemoteException {
		message = msg;
	}

	/**
	 * 远程接口方法的实现
	 */
	public String say() throws RemoteException {
		System.out.println("Called by HelloClient");
		return message;
	}

}
