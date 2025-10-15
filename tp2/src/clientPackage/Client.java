package clientPackage;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import objet.Formule;

public class Client 
{   
    public static void main(String[] args) throws UnknownHostException, IOException 
    {
		Socket s=new Socket("localhost",1234);
		OutputStream os=s.getOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(os);
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
		//recevoir la resultat
		InputStream is=s.getInputStream(); 
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		double resultat = Double.parseDouble(br.readLine());
		System.out.println("resultat= "+resultat);	
		sc.close();
		s.close();

	}

}
