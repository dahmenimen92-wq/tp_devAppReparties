package serverPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception
	{
		ServerSocket socketServeur = new ServerSocket(1234);
		System.out.println("Je suis un serveur en attente la connexion d'un client "); 
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");
		InputStream is= socket.getInputStream();
		int x=is.read();
		System.out.println("la valeur est "+x);
		int p= x*5;
		OutputStream os=socket.getOutputStream();
		os.write(p);
		socketServeur.close();
	}

}
