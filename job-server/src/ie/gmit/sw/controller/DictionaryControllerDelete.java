package ie.gmit.sw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.sw.model.DictionaryModel;

//Controller for the servlet delete.jsp
public class DictionaryControllerDelete extends HttpServlet {
	//The serialization runtime associates with each serializable class a version number, 
	//called a serialVersionUID, which is used during deserialization to verify that the sender and receiver of a serialized object 
	//have loaded classes for that object that are compatible with respect to serialization. 
	private static final long serialVersionUID = 1L;
	//Private variables..
	private String key;
	
	//Handling POST request from a servlet
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Create a HashMap messages to send data to a servlet
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
		
        //Get params from a servlet (form)
		key = request.getParameter("word");

		//If params not empty do the following..
		if ((key != null && !key.isEmpty())) {

			//Create a service from the model to use RMI remote methods..
			DictionaryModel service = new DictionaryModel();
			
			//Create a new String, and call delete method sending the data from a form as a param..
			String description = service.delete(key);
			
			//Send the result of called method back to servlet and display it to user
			messages.put("description", description);
			RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
			dispatcher.forward(request, response);

			// If the data from forms on servlet was empty display error message..
		} else {
			
			messages.put("description", "Oops.. Something went wrong..");
			RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
