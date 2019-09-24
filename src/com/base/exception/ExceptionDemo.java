package com.base.exception;

public class ExceptionDemo {

	private static String[] arg = null;
	/**
	 *@Description:
	 *@param args
	 *@return void
	 * @throws Throwable 
	 * @throws Exception 
	 */
	public static void main(String[] args)  {
		
		try{
			fingException();
			//System.out.println("The Val is: " + arg[1]);
		}catch(Exception e){
			e.printStackTrace();
			//System.out.println("The Exception is: " + e.printStackTrace());
		}finally{
			
		} 

	}
	
	public static void fingException() throws Exception {
		
			arg = new String[1];
			arg[1]="bb";
			//throw new Exception("hello");
		
		
		
	}

}
