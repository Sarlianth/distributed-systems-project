package ie.gmit.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Lookup extends Remote{
	
	public String lookup(String s) throws RemoteException;

}
