package rmiServer;

import java.rmi.Naming;
import rmiService.ConversionImpl;

import java.rmi.registry.LocateRegistry;
public class ConversionServer 
{
	public static void main(String[] args) 
	{
		 try 
		 {
		 LocateRegistry.createRegistry(2001);
		 ConversionImpl obj = new ConversionImpl();
		 Naming.rebind("rmi://localhost:2001/ConversionService", obj);
		 System.out.println("Serveur RMI ");
		 } 
		 catch (Exception e) 
		 {  e.printStackTrace();  }

	}
}	
	
