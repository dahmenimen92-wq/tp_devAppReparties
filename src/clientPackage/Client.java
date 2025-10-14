package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception
	{    
		 System.out.println("Je suis un client pas encore connecté...");
		 InetAddress serveurIP = InetAddress.getLocalHost();
		 InetSocketAddress serveurAddress = new InetSocketAddress(serveurIP, 1234);
		 Socket socket = new Socket();
		 socket.connect(serveurAddress);
		 System.out.println("je suis connecté");
		 
		 Scanner s = new Scanner(System.in);
		 System.out.println("donner le premiere nombre");
		 int x= s.nextInt();
		 System.out.println("donner l'operation");
		 String y = s.next();
		 System.out.println("donner le 2eme nombre");
		 int z= s.nextInt();
		 if (!y.equals("+") && !y.equals("*") && !y.equals("-") && !y.equals("/"))
			 System.out.println("operateur invalide");
		 
		 OutputStream os=socket.getOutputStream();
		 PrintWriter pw=new PrintWriter(os,true);
		 pw.println(x);
		 pw.println(y);
		 pw.println(z);
          
		 InputStream is=socket.getInputStream(); 
		 InputStreamReader isr=new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);
		 double resultat = Double.parseDouble(br.readLine());
		 System.out.println("resultat= "+resultat);
	     socket.close();
	     s.close();	
	}
}
