package corbaServer;

import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import javax.naming.Context;
import javax.naming.InitialContext;


import service.BanqueImpl;

public class BanqueServer 
{   
    public static void main(String[]args)
    {
    	try {
    		ORB orb = ORB.init(args, null);
    		POA poa =POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
    		poa.the_POAManager().activate();
    		Context ctx = new InitialContext();
    		BanqueImpl od = new BanqueImpl();
    		ctx.rebind("BK", poa.servant_to_reference(od));
    		orb.run();
    		}
    	catch (Exception e) {e.printStackTrace();}
    }
}

