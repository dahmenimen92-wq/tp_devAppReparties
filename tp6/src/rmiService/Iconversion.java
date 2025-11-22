package rmiService;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Iconversion extends Remote
{
	double convertirMontant(double mt) throws RemoteException;
}
