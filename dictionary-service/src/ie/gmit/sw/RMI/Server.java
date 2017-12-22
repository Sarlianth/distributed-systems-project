package ie.gmit.sw.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
*This is a server containing main method that will run the RMI service
**/
public class Server {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		// Final variable PORT on which the RMI service will work
		final int PORT = 1099;
		
		// Defining Object
		DictionaryService lookup = new DictionaryServiceImpl();
		
		// Creating RMI Registry with Port
		LocateRegistry.createRegistry(PORT);
		
		// Binding the Object
		Naming.rebind("lookup", lookup);

		// Notify user
		System.out.println("Dictionary service is ready.");
	}

}