package serverPackage;
import java.io.*;
import java.net.*;
import objet.Formule;

public class Server 
{
    public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		ServerSocket ss=new ServerSocket(1234);
		Socket s=ss.accept();
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
		//envoie du resultat
		OutputStream os=s.getOutputStream(); 
		PrintWriter pw=new PrintWriter(os,true);
        pw.println(resultat);
        s.close();
    
	}

}
