package ie.gmit.sw.model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import ie.gmit.sw.RMI.DictionaryService;

public class DictionaryModel {
	
	// Final variable PORT on which the RMI service works
	private final int PORT = 1099;
	// Final variable SERVICE_URL containing the rmi registry
	private final String SERVICE_URL = "rmi://localhost:"+PORT+"/lookup";
	
	//Model representation of lookup method
	public String lookup(String s) {
			
		try {
			// Create a remote object (stub)
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			// call the remote method
			return lookup.lookup(s);
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
	
	//Model representation of add method
	public String add(String key, String desc) {
		try {
			// Create a remote object (stub)
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			// call the remote method
			return lookup.add(key, desc);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
	
	//Model representation of delete method
	public String delete(String key) {
		try {
			// Create a remote object (stub)
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			// call the remote method
			return lookup.delete(key);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
	
	//Model representation of modify method
	public String modify(String key, String desc) {
		try {
			// Create a remote object (stub)
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			
			// call the remote method
			return lookup.modify(key,desc);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Oops.. Something went wrong..";
	}
}
