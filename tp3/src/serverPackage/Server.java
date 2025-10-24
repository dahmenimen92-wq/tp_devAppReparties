package serverPackage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;


public class Server
{
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
				OutputStream os=s.getOutputStream();
				PrintWriter pw=new PrintWriter(os,true);
				pw.println("numero d'ordre de connextion "+count);
			}
		} 
    	catch (IOException e) 
    	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    		
    }
   
    
    

}
