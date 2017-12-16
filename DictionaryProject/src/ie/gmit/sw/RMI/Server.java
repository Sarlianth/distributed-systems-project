package ie.gmit.sw.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		final int PORT = 1099;
		
		Lookup lookup = new LookupImpl();
		
		LocateRegistry.createRegistry(PORT);
		
		Naming.rebind("lookup", lookup);

		System.out.println("Lookup service is ready.");
	}

}
