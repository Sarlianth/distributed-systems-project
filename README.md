# An Asynchronous RMI Dictionary Service
#### *Distributed Systems Module - Lecturer: Patrick Mannion - 4th Year Software Development*

## Overview
- You are required to use the Servlet/JSP and Java RMI frameworks to develop a remote, asynchronous dictionary lookup service. A JSP page should provide users with the ability to specify a string which will be checked against the dictionary. The HTML form information should be dispatched to a servlet that adds the client request to an in-queue and then returns a job ID to the web client. The web client should poll the web server periodically (every 10 seconds) and query if the request has been processed. Client requests in the inQueue should
be periodically removed and processed (every 10 seconds).
- The processing of a client request will require a RMI method invocation to a remote object which implements an interface called DictionaryService. The remote object which implements DictionaryService should check if the string received exists in the dictionary, and return the dictionary definition of the string if it does exist in the dictionary, or “String not found” if it does not exist in the dictionary. Once the result of the dictionary lookup has been computed by the remote object, the returned response should be added to the outQueue on the Tomcat server and returned to the original web client when they next poll the server.
- The point of this exercise is to give you some “hands-on” experience programming an asynchronous remote software service. Asynchronous communication is an important topic in distributed computing, as it provides a degree of scalability if the number of potential requests is unknown or may vary significantly.

## How to clone this repository
1. In the Clone with HTTPs section, copy the clone URL for the repository.
2. Open Git Bash.
3. Change the current working directory to the location where you want the cloned directory to be made.
4. Type `git clone`, and then paste the URL you copied in Step 2.
5. Press Enter. Your local clone will be created.

## How to run the application
To run the application you should follow the following steps: 
1. Clone this repository [see above]
2. Note 3 important files: **file.csv** - **job-server.war** - **dictionary-service.jar**
3. Make sure you have **file.csv** and **dictionary-service.jar** in **the same directory** - otherwise you will not allow the RMI server to load the dictionary file
4. Open command line prompt and `cd` into the directory where you have all the files listed above
5. Run the following command to start the RMI server - `java –cp ./dictionary-service.jar ie.gmit.sw.RMI.Server`
6. Once the server is running, open Eclipse [Java EE Perspective] and **import** the **job-server.war** file
7. Make sure to change Target runtime to **Apache Tomcat 8.5** [This is the one I have used while developing the application]
8. Once you imported the .WAR file just click **Run As..** [Run on Server]
9. Eclipse will automatically open the homepage for you once successfully deployed, but you can use your favourite browser and access the web app using the following URL - `http://localhost:8080/job-server/`
