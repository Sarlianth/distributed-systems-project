package ie.gmit.sw.RMI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
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
                String[] args = line.split(cvsSplitBy);
                
                map.put(args[0].toUpperCase(), line.toString());
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
	protected DictionaryServiceImpl() throws RemoteException {
		super();
		read();
	}

	@Override
	public String lookup(String s) throws RemoteException {
		
		if(map.containsKey("\"" + s.toUpperCase() + "\"")) {
			//return s + " - " + map.get("\"" + s + "\"");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String res = map.get("\"" + s.toUpperCase() + "\"");
			res = res.replace("\"", " ");
			return res;
		}
		else {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Sorry, "+s+" was not found in dictionary";
		}
	}
	
}
