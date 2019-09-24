package com.concurrent.query;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Description: BlockingQueue:
 * LinkedBlockingQueue 没有上限,链表
 * ArrayBlockingQueue 在构造时需要指定容量， 并可以选择是否需要公平性
 * PriorityBlockingQueue 带优先级的 队列
 * DelayQueue 存放Delayed 元素的无界阻塞队列
 * @author wutp 2017年1月5日
 * @version 1.0
 */
public class BlockingQueueTest {  
	
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
        System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src): ");  
        String directory = in.nextLine();  
        System.out.print("Enter keyword (e.g. volatile): ");  
        String keyword = in.nextLine();  
  
        final int FILE_QUEUE_SIZE = 10;// 阻塞队列大小  
        final int SEARCH_THREADS = 100;// 关键字搜索线程个数  
  
        // 基于ArrayBlockingQueue的阻塞队列  
        BlockingQueue<File> queue = new ArrayBlockingQueue<File>(  
                FILE_QUEUE_SIZE);  
  
        //只启动一个线程来搜索目录  
        FileEnumerationTask enumerator = new FileEnumerationTask(queue,  
                new File(directory));  
        new Thread(enumerator).start();  
          
        //启动100个线程用来在文件中搜索指定的关键字  
        for (int i = 1; i <= SEARCH_THREADS; i++)  
            new Thread(new SearchTask(queue, keyword)).start();  
    }  
}  
