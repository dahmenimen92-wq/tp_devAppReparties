package clientPackage;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws Exception
	{    
		 System.out.println("Je suis un client pas encore connecté...");
		 Socket socket = new Socket("localhost", 1234);
	     System.out.println("je suis connecté");
	     socket.close();
	     		

	}

}
