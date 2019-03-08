package com.code2017.nio;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerTimeServer implements Runnable{

	private Selector selector;
	
	private ServerSocketChannel servChannel;
	
	private volatile boolean stop;
	
	public MultiplexerTimeServer(int port){
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
