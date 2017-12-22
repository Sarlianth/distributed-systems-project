package ie.gmit.sw.RMI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
/**
*This is a class implementing the remote interface
*It implements all the functionallity for the remote methods
**/
public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService{
	//The serialization runtime associates with each serializable class a version number, 
	//called a serialVersionUID, which is used during deserialization to verify that the sender and receiver of a serialized object 
	//have loaded classes for that object that are compatible with respect to serialization. 
	private static final long serialVersionUID = 1L;
	
	//Declaring class variables
    private String line = "";
    private String cvsSplitBy = ",";
    //HashMap will be used to store records from the CSV file
    private HashMap<String,String> map = new HashMap<String, String>();
    
    // Method to read the CSV file into the HashMap
    public void read() {
    
    	try {
    		//Create BufferedReader to read the file
    		BufferedReader reader = new BufferedReader(new FileReader("file.csv"));
    		//Loop until end of file
            while ((line = reader.readLine()) != null) {

                //Use comma as separator
                String[] args = line.split(cvsSplitBy);
                
                //Insert data into a map, keep keys in uppercase for easier comparison later
                map.put(args[0].toUpperCase(), line.toString());
            }
            //Close the BufferedReader after reading the file fully
        	reader.close();
		} catch (IOException e) {
			//Inform user that the file could not be found/opened
			System.out.println("There was a problem with reading the CSV file.\nPlease make sure that file.csv is in the same directory as the JAR file..");
		}
    }
    
    //Constructor
	protected DictionaryServiceImpl() throws RemoteException {
		super();
		//Read the file once service is run
		read();
	}

	//Method to looup the word in the dictionary
	@Override
	public String lookup(String s) throws RemoteException {
		//If dictionary contains the word (key) then get its definition (value), and return to user
		if(map.containsKey("\"" + s.toUpperCase() + "\"")) {
			//return s + " - " + map.get("\"" + s + "\"");
			try {
				//Simulate latency by waiting 1000ms
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Build the result string - value of given key from HashMap
			String res = map.get("\"" + s.toUpperCase() + "\"");
			//Delete " from the word - each key is surrounded by " in the HashMap
			res = res.replace("\"", " ");
			//Return result to user
			return res;
		}
		//If the word has not been found in the dictionary - HashMap
		else {
			try {
				//Simulate latency by waiting 1000ms
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//Return result to user
			return "Sorry, "+s+" was not found in dictionary";
		}
	}

	@Override
	public String add(String key, String desc) throws RemoteException {
		
		try {
			//Simulate latency by waiting 1000ms
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Check if dictionary contains the word (key)
		if(map.containsKey("\"" + key.toUpperCase() + "\"")) {
			//Do not allow user to add a word that already exists in dictionary
			return "Definition for " + key + " already exists in the dictionary..";
		}
		//If dictionary does not contain the word
		else {
			//Add a new Key/Value pair into a HashMap
			map.put("\"" + key.toUpperCase() + "\"", upper(key) + ", " + desc);
			try {
				//Add record to CSV file too, so we can can read it again with the word saved in it..
				addToCSV(key, desc);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//Return result to user - notify of successfull adding
			return "Successfully added " + key + " to the dictionary. Thank you.";
		}

	}
	
	//Method to format a word in an appropiate manner for dictionary - start with capital letter and keep all the other letters in lowercase 
	public String upper(String s) {
		//Bring all characters to lowercase
		s.toLowerCase();
		//Create a char array from a string
		char[] temp = s.toCharArray();
		//first character in a string to uppercase
		temp[0] = Character.toUpperCase(temp[0]);
		//Create a new string from updated char array
		String out = new String(temp);
		//Return formatted word
		return out;
	}
	
	//Method to add record to CSV file
	public void addToCSV(String key, String desc) throws IOException {
		//Create an instance of FileWriter, 
		//The true param in the constructor means we want to append to the file 
		//(add to the end and keep the current records in..)
		FileWriter pw = new FileWriter("file.csv",true); 
		
		//Add the word itself (key)
		pw.append("\"" + upper(key) + "\"");
		//Seperate the value with a comma
        pw.append(",");
        //Skip next column
        pw.append(" ");
        //Seperate the value with a comma
        pw.append(",");
        //Add the description of a word (value)
        pw.append(desc);
        //New line
        pw.append("\n");
		
        //flush the buffer, and close the file writer
        pw.flush();
        pw.close();
	}
	
	//Method to generate a CSV file from a HashMap
	//This is useful when deleting/updating a record from a dictionary (HashMap)
	public void mapToCSV(HashMap<String, String> m) {
		//Create a new instance of a FileWriter and save to file.csv
		try (Writer writer = new FileWriter("file.csv")) {
			  //For each HashMap entry do the following:
			  for (HashMap.Entry<String, String> entry : map.entrySet()) {
				//Add the value and go to the next line
			    writer.append(entry.getValue())
			          .append("\n");
			  }
			} catch (IOException ex) {
			  ex.printStackTrace(System.err);
			}
	}

	//Method to delete an entry from a HashMap
	@Override
	public String delete(String key) throws RemoteException {
		try {
			//Simulate latency by waiting 1000ms
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Check if dictionary contains the word (key)
		//Eventhough every word should be in uppercase, we want to check for all possible variations..
		if(map.containsKey("\"" + key + "\"") || map.containsKey("\"" + key.toUpperCase() + "\"") || map.containsKey("\"" + upper(key) + "\"")) {
			//If the word has been found in the HashMap, simply remove it..
			if(map.containsKey("\"" + key + "\"")) {
				map.remove("\"" + key + "\"");
			}
			//If the word has been found in the HashMap, simply remove it..
			else if(map.containsKey("\"" + key.toUpperCase() + "\"")) {
				map.remove("\"" + key.toUpperCase() + "\"");
			}
			//If the word has been found in the HashMap, simply remove it..
			else if(map.containsKey("\"" + upper(key) + "\"")) {
				map.remove("\"" + upper(key) + "\"");
			}
			
			//Export the updated HashMap to a CSV file
			mapToCSV(map);
			//Inform user that file has been successfully deleted 
			return key + " has been successfully deleted from dictionary..";
		}
		//If the word (key) has not been found, do nothing, just inform user
		else {
			//Return to user to inform word doesn't exist..
			return key + " doesn't exist in the dictionary..";
		}
	}

	//Method to modify a word in a dictionry
	@Override
	public String modify(String key, String desc) throws RemoteException {
		//Check if dictionary contains the word (key)
		//Eventhough every word should be in uppercase, we want to check for all possible variations..
		if(map.containsKey("\"" + key + "\"") || map.containsKey("\"" + key.toUpperCase() + "\"") || map.containsKey("\"" + upper(key) + "\"")) {
			//If the word (key) has been found in the HashMap, simply change it's description (value) it..
			if(map.containsKey("\"" + key + "\"")) {
				map.replace("\"" + key + "\"", upper(key) + ", " + desc);
			}
			//If the word (key) has been found in the HashMap, simply change it's description (value) it..
			else if(map.containsKey("\"" + key.toUpperCase() + "\"")) {
				map.replace("\"" + key.toUpperCase() + "\"", upper(key) + ", " + desc);
			}
			//If the word (key) has been found in the HashMap, simply change it's description (value) it..
			else if(map.containsKey("\"" + upper(key) + "\"")) {
				map.replace("\"" + upper(key) + "\"", upper(key) + ", " + desc);
			}

			//Export the updated HashMap to a CSV file
			mapToCSV(map);
			//Notify user that the word has been updated
			return key + " has been successfully updated..";
		}
		//If the word (key) has not been found, do nothing, just inform user
		else{
			//Return to user to inform word doesn't exist..
			return "Sorry, " + key + " has not been found in dictionary..\nYou can add it using the menu above..";
		}
	}
}
