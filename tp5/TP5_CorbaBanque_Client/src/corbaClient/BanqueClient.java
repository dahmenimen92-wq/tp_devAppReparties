package corbaClient;

import corbaBanque.Banque;
import corbaBanque.BanqueHelper;
import corbaBanque.Compte;
import javax.naming.Context;
import javax.naming.InitialContext;

public class BanqueClient 
{
	public static void main(String[] args) 
	{
		try 
		{
			Context ctx = new InitialContext();
			Object ref = ctx.lookup("BK");
			Banque stub=BanqueHelper.narrow((org.omg.CORBA.Object)ref);
			System.out.println("Conversion "+stub.conversion(600));
			Compte c1=new Compte(1,2000);
			Compte c2 = new Compte(2, 1500);
			stub.creerCompte(c1);
			stub.creerCompte(c2);
            System.out.println("Compte créé avec code=" + c1.code);
            System.out.println("Compte créé avec code=" + c2.code);
            stub.verser(500, 1);
            stub.retirer(300, 2);
            Compte c = stub.getCompte(1);
            if (c != null)
                System.out.println("Compte récupéré : code=" + c.code + " solde=" + c.solde);
            Compte[] tousComptes = stub.getComptes();
            System.out.println("Tous les comptes :");
            for (Compte compte : tousComptes) 
            {
                System.out.println("Compte code=" + compte.code + ", solde=" + compte.solde);
            }

	    }
		 catch (Exception e) { e.printStackTrace(); }
	 }
}

