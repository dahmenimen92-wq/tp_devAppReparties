package clientPackage;

import java.io.*;
import java.net.*;

import java.util.Scanner;

import objet.Formule;

public class Client 
{   public static void main(String[] args) throws UnknownHostException, IOException 
	{
		 InetAddress serverIP = InetAddress.getLocalHost();
		 InetSocketAddress add=new InetSocketAddress(serverIP,1234);
		 Socket s=new Socket();
		 s.connect(add);
		 InputStream is=s.getInputStream(); 
		 InputStreamReader isr=new InputStreamReader(is);
		 BufferedReader br = new BufferedReader(isr);
		 System.out.println(br.readLine());
		 
		 OutputStream os=s.getOutputStream();
		 ObjectOutputStream oos=new ObjectOutputStream(os);
		 oos.flush();
         System.out.println(br.readLine());
		 Scanner sc = new Scanner(System.in);
		 System.out.println("donner le premiere nombre");
		 int x= sc.nextInt();
		 System.out.println("donner l'operation");
		 String y = sc.next();
		 System.out.println("donner le 2eme nombre");
		 int z= sc.nextInt();
		 if (!y.equals("+") && !y.equals("*") && !y.equals("-") && !y.equals("/"))
			 System.out.println("operateur invalide");
		 Formule f=new Formule(x,y,z);
		 oos.writeObject(f);
         System.out.println("Résultat : " + br.readLine());
         oos.close();
         br.close();
         s.close();
         sc.close();
	}


}
