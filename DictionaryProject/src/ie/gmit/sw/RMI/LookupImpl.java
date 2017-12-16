package ie.gmit.sw.RMI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class LookupImpl extends UnicastRemoteObject implements Lookup{
	private static final long serialVersionUID = 1L;
	
	//String csvFile = "dictionary.csv";
    String line = "";
    String cvsSplitBy = ",";
    HashMap<String,String> map = new HashMap<String, String>();
    
    public void read() {
    
    	try {
			BufferedReader reader = new BufferedReader(new FileReader("file.csv"));
            while ((line = reader.readLine()) != null) {

                // use comma as separator
                String[] description = line.split(cvsSplitBy);

                map.put(description[0], description[2]);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	protected LookupImpl() throws RemoteException {
		super();
		read();
		//System.out.println(map.values());
		//System.out.println(map.containsKey("A"));
	}

	@Override
	public String lookup(String s) throws RemoteException {
		
		if(map.containsKey(s)) {
			return map.get(s);
		}
		else {
			return "Sorry, not found";
		}
	}
	
}
