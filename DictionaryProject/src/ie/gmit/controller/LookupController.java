package ie.gmit.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ie.gmit.model.LookupModel;

public class LookupController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private String word;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
		
		word = request.getParameter("word");

		if ((word != null && !word.isEmpty())) {

			LookupModel service = new LookupModel();
			
			String description = service.lookup(word);
			
			messages.put("description", description);
			
			if(description != null && !description.isEmpty()) {
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
				dispatcher.forward(request, response);
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
				dispatcher.forward(request, response);
			}
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.html");
			dispatcher.forward(request, response);
		}
		
	}

}
