package serverPackage;

import java.io.*;
import java.net.*;

public class Server 
{   
	public static int totalOperations = 0;
	public static final Object lock = new Object();
	public static void main(String[] args)
   {
		int count=0;
		try 
		{
			ServerSocket ss=new ServerSocket(1234);
			while(true)
			{
				Socket s=ss.accept();
				count++;
				new ClientProcess(s,count).start();
			}
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}


	

}
