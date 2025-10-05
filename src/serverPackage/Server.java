package serverPackage;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception
	{
		// La première étape : 
		ServerSocket socketServeur = new ServerSocket(1234);
		System.out.println("Je suis un serveur en attente la connexion d'un client "); 
		// La deuxième étape : 
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté"); 
		// La dernière étape : Fermer socket 
		socketServeur.close();
	}

}
