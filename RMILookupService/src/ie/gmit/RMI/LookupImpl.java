package ie.gmit.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LookupImpl extends UnicastRemoteObject implements Lookup{
	private static final long serialVersionUID = 1L;

	protected LookupImpl() throws RemoteException {
		super();
	}

	@Override
	public String lookup(String s) throws RemoteException {
		
		return null;
	}
	
	

}
