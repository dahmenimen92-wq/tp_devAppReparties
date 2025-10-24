package clientPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException 
	{
		 InetAddress serverIP = InetAddress.getLocalHost();
		 InetSocketAddress add=new InetSocketAddress(serverIP,1234);
		 Socket s=new Socket();
		 s.connect(add);
		 InputStream is=s.getInputStream(); 
		 InputStreamReader isr=new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);
		 System.out.println(br.readLine());
	}

}
