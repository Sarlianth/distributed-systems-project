package ie.gmit.model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ie.gmit.RMI.Lookup;

public class LookupModel {

	private final int PORT = 1099;
	private final String SERVICE_URL = "rmi://localhost:"+PORT+"/lookup";
	
	
	public String lookup(String s) {
			
			try {
				
				Lookup lookup = (Lookup) Naming.lookup(SERVICE_URL);
				
				return lookup.lookup(s);
				
				
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			return "String not found in dictionary.";
		}
	
}
