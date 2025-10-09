package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception
	{    
		 System.out.println("Je suis un client pas encore connecté...");
		 InetAddress serveurIP = InetAddress.getByName("192.168.1.14");
		 InetSocketAddress serveurAddress = new InetSocketAddress(serveurIP, 1234);
		 Socket socket = new Socket();
		 socket.connect(serveurAddress);
		 System.out.println("je suis connecté");
		 
		 Scanner s = new Scanner(System.in);
		 System.out.println("donner un nombre");
		 int x= s.nextInt();
		 System.out.println("choisir un service de calcul :");
		 System.out.println("1. addition");
		 System.out.println("2. soustraction");
		 System.out.println("3. multiplication");
		 System.out.println("4. division");
		 int o= s.nextInt();
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		 bw.write(x + "\n");
	     bw.write(o + "\n");
	     bw.flush();
	     
	     BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	     String resultat = br.readLine();
	     System.out.println("Résultat : " + resultat);
	     br.close();
	     bw.close();
	     socket.close();
	     s.close();	
	}
}
