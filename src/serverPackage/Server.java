package serverPackage;
import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) throws Exception
	{
		InetAddress ip = InetAddress.getByName("192.168.1.14");
		InetSocketAddress socketAddress = new InetSocketAddress(ip,1234);
		ServerSocket socketServeur = new ServerSocket();
		socketServeur.bind(socketAddress);
		System.out.println("Je suis un serveur en attente la connexion d'un client "); 
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		int x = Integer.parseInt(br.readLine());
        int operation = Integer.parseInt(br.readLine());
        double resultat = 0;
        switch (operation) {
        case 1: 
            resultat = x + 5;
            break;
        case 2: 
            resultat = x - 5;
            break;
        case 3: 
            resultat = x * 5;
            break;
        case 4: 
            resultat = (double) x / 5;
            break;
        default:
            System.out.println("Option invalide");
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(resultat + "\n");
        bw.flush();
        br.close();
        bw.close();
		socketServeur.close();
	}

}
