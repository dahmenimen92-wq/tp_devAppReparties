package rmiClient;
import java.rmi.Naming;
import rmiService.Iconversion;
public class ConversionClient 
{
	 public static void main(String[] args) 
	 {
		 try 
		 {
			 
		 Iconversion banque = (Iconversion)Naming.lookup("rmi://localhost:2001/ConversionService");
		 
		 double result = banque.convertirMontant(500);
		 System.out.println("Résultat de la conversion : " + result);
		 }
		 catch (Exception e) 
		 {
		 e.printStackTrace();
	 }
    }
}


		 
	
