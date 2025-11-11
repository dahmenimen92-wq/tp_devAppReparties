package service;

import java.util.ArrayList;
import java.util.List;

import corbaBanque.*;
public class BanqueImpl extends BanquePOA
{
	private List<Compte> comptes=new ArrayList<>();
	
	public void creerCompte (corbaBanque.Compte cpte)
	{
		 comptes.add(cpte);
		 System.out.println("Compte créé : " + cpte.code + " - Solde : " + cpte.solde);
	}
	public void verser (float mt, int code)
	{
		for (Compte c:comptes)
		{
			if (c.code==code)
			{
				c.solde+=mt;
				System.out.println("Versement de " + mt + " sur le compte " + code);     
			    return;
			}
		}
		System.out.println("Compte introuvable");
	}
	 public void retirer (float mt, int code)
	{
		 for (Compte c:comptes)
			{
				if (c.code==code)
				{
					c.solde-=mt;
					System.out.println("retirer de " + mt + " sur le compte " + code);     
				    return;
				}
			}
			System.out.println("Compte introuvable");
	}
	public corbaBanque.Compte getCompte (int code)
	{
		for(corbaBanque.Compte c:comptes)
		{
			if (c.code==code)
				return c;
		}
		return null;
		 
	}
	public corbaBanque.Compte[] getComptes ()
	{
		return comptes.toArray(new Compte[0]);
		  
	}
	public double conversion (float mt)
	{
		double taux=3.2;
		return mt*taux;
		
	}
}
