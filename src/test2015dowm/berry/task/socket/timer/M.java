package test2015dowm.berry.task.socket.timer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 开启一个任务
 * */
public class M {
	public static void main(String[] args) {
		Timer timer = new Timer();		
		timer.schedule(new MyTask(), 1000 ,5000);
	}
}

/**
 * 控制线程的任务
 * */
class MyTask extends TimerTask {	
	MyThread mt;
	static Socket socket;
	public MyTask(){
		startThread();
	}
	
	/**
	 * 开启线程
	 * */
	public void startThread(){
		String IP="localhost"; 
		int PORT = 6789;
		try {
			
			socket = new Socket(IP, PORT);
			mt=new MyThread(socket);
			mt.setStatus(true);
			mt.start();
		}catch(Exception e){
            e.printStackTrace();
		}
		
	}
	
	/**
	 * 关闭线程
	 * */
	public void stopThread(){
		mt.setStatus(false);
	}
	
	@Override
	public void run() {
		
		System.out.println("********");
		IfWoke iw=new IfWoke();
		if(iw.isCmdstatus()){			
			if(!mt.isStatus()){
				startThread();
			}												
		}else if(!iw.isCmdstatus()){	
			if(mt.isStatus()){
				stopThread();
			}			
		}
	}	

}

/**
 * 模拟从数据库中获得结果
 * */
class IfWoke{
	
	private boolean cmdstatus=true;//指令状态,ture开启 false关闭
	
	public boolean isCmdstatus() {
		return cmdstatus;
	}
	public void setCmdstatus(boolean cmdstatus) {
		this.cmdstatus = cmdstatus;
	}
}

/**
 * socket线程
 * */
class MyThread extends Thread{
	private volatile boolean status;//设备状态,ture;正在运行  false：已经关闭	
	private Socket socket;
	
    public MyThread(Socket socket){
        this.socket=socket;
    }
	public  boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void run() {
		BufferedReader receive = null;
		PrintWriter send = null;
		String tem = null;
		String cmd="GET";
		
		try{
			receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    send = new PrintWriter(socket.getOutputStream());
		    
		    while(status){  
		        send.println(cmd);  
                send.flush();
		    	tem = receive.readLine();  
                if(tem.equals("END")){  
                    break;  
                }                 
                System.out.println("Client Socket Message:"+tem);  
                Thread.sleep(50);  
                  
            }
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
                System.out.println("关闭连接:"+socket.getInetAddress()+":"+socket.getPort());
                if(socket!=null){
                	receive.close();
                	send.close();
                	socket.close();
                }               	
            }catch(IOException e){
                e.printStackTrace();
                System.out.println(e);
            }
		}
					
	}
	
}
