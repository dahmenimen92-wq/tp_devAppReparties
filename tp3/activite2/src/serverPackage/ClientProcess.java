package serverPackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import objet.Formule;

public class ClientProcess extends Thread
{   Socket s;
	int count;
	public ClientProcess(Socket s,int count)
	{
		this.s=s;
		this.count=count;
	}
	public void run()
	{
		System.out.println("client n"+count+" depuis "+s.getRemoteSocketAddress());
		PrintWriter out;
		try 
		{
			//pour afficher dans cmd
			out = new PrintWriter(s.getOutputStream(),true);
			out.println("client n"+count+" depuis "+s.getRemoteSocketAddress());
			
			//envoie numero d'ordre au client
			OutputStream os=s.getOutputStream();
			PrintWriter pw=new PrintWriter(os,true);
			pw.println("numero d'ordre de connextion "+count);
			
			//recuperer l'objet 
			InputStream is=s.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			Formule f=(Formule)ois.readObject();
	        int x=f.getPremier();
	        int z=f.getDeuxieme();
	        String op=f.getOp();
	        System.out.println("formule= "+x+" "+op+" "+z);
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
			synchronized (Server.lock) 
            {
                Server.totalOperations++;
                System.out.println("Nombre total d’opérations traitées : " + Server.totalOperations);
            }
			//envoie du resultat
	        pw.println(resultat);
	        s.close();
		} 
		catch (IOException e) 
		{     e.printStackTrace(); } 
		catch (ClassNotFoundException e) 
		{    e.printStackTrace();  }	
		
	}

}


