package ie.gmit.sw.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
/**
*This is a remote interface for RMI service
*It declares remote methods that are later implemented in a seperate class
**/
public interface DictionaryService extends Remote{
	
	// Method to lookup a word in dictionary
	public String lookup(String s) throws RemoteException;
	
	// Method to add a word to a dictionary
	public String add(String key, String desc) throws RemoteException;
	
	// Method to delete a word from a dictionary
	public String delete(String key) throws RemoteException;
	
	// Method to modify a word in a dictionary
	public String modify(String key, String desc) throws RemoteException;

}
