package serverPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientProcess extends Thread
{
        Socket s;
        int count;
    	public ClientProcess(Socket s,int count)
    	{
    		this.s=s;
    		this.count=count;
    	}
    	public void run()
    	{
    		System.out.println("client n"+count+" depuis "+s.getRemoteSocketAddress());
    		
    		//pour afficher dans cmd
			PrintWriter out;
			try {
				out = new PrintWriter(s.getOutputStream(),true);
				out.println("client n"+count+" depuis "+s.getRemoteSocketAddress());
			} catch (IOException e) {
				e.printStackTrace();
			}	
    	}
    	
    	
	}

