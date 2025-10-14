package serverPackage;
import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) throws Exception
	{
		InetAddress ip = InetAddress.getLocalHost();
		InetSocketAddress socketAddress = new InetSocketAddress(ip,1234);
		ServerSocket socketServeur = new ServerSocket();
		socketServeur.bind(socketAddress);
		System.out.println("Je suis un serveur en attente la connexion d'un client "); 
		Socket socket = socketServeur.accept();
		System.out.println("un client est connecté");
		
		InputStream is=socket.getInputStream(); 
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		int x = Integer.parseInt(br.readLine());
		String op=br.readLine();
		int z=Integer.parseInt(br.readLine());
		System.out.println("Formule reçue : " + x + " " + op + " " + z);
		
		double resultat = 0;
		switch (op)
		{
		case "+":
			resultat=x+z;
			break;
		case "-":
			resultat=x-z;
			break;
		case "*":
			resultat=x*z;
			break;
		case "/":
			resultat=(double)x/z;
			break;
		default:
            System.out.println("Opérateur invalide");
		}
		OutputStream os=socket.getOutputStream(); 
		PrintWriter pw=new PrintWriter(os,true);
        pw.println(resultat);
        br.close();
        socket.close();
		
	}
}


