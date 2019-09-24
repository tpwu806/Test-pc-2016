package com.concurrent.book.concurrent.practice.demo2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * 总消息队列管理
 **
 * @author tengfei.fangtf
 */
public class MsgQueueManager implements IMsgQueue {
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(MsgQueueManager.class);
	/**
	 * 消息总队列
	 */
	public final BlockingQueue<Message> messageQueue;

	private MsgQueueManager() {
		messageQueue = new LinkedTransferQueue<Message>();
	}

	public void put(Message msg) {
		try {
			messageQueue.put(msg);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public Message take() {
		try {
			return messageQueue.take();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		return null;
	}

	/**
	 * 分发消息，负责把消息从大队列塞到小队列里
	 **
	 * @author tengfei.fangtf
	 */
	static class DispatchMessageTask implements Runnable {
		@Override
		public void run() {
			BlockingQueue<Message> subQueue;
			for (;;) {// 如果没有数据，则阻塞在这里
				Message msg = MsgQueueFactory.getMessageQueue().take();
				// 如果为空，则表示没有Session机器连接上来，
				// 需要等待，直到有Session机器连接上来
				while ((subQueue = getInstance().getSubQueue()) == null) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				} // 把消息放到小队列里
				try {
					subQueue.put(msg);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
	}

	public static MsgQueueFactory getInstance() {
		// TODO Auto-generated method stub
		return new MsgQueueFactory();
	}
}
