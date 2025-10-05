package clientPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) throws Exception
	{    
		 System.out.println("Je suis un client pas encore connecté...");
		 Socket socket = new Socket("localhost", 1234);
		 System.out.println("je suis connecté");
		 Scanner s = new Scanner(System.in);
		 System.out.println("donner un entier ");
		 int x= s.nextInt();
	     OutputStream os= socket.getOutputStream();
	     os.write(x);
	     InputStream is=socket.getInputStream();
	     int p=is.read();
	     System.out.println("le produit avec 5 est "+p);
	     socket.close();
	     		
	}

}
