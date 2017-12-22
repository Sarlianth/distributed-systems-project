This WebApp allows you to lookup a definition of a word that exists in the dictionary. The dictionary contains 34231 unique words. I have found the CSV file containing the words and definition online, however I unfortunately did not save the source link and couldn't find the link to it later on. I have added extra functionallity to the application such as; adding, deleting or modifying entries in the dictionary. The file is read into a HashMap, I have decided to use HashMap over TreeMap, because the order of the keys doesn't really matter in this case - and HashMap is more efficient in general. I have also added a bit of Bootstrap to make the WebApp look better.

Please make sure to have the dictionary-service.jar file in the same folder with file.csv, otherwise it will not work properly!!

As the homepage is loaded, you can see a search box and a button in the middle of the screen, and a navbar at the top. I have added the search functionallity into the navbar for quick searches. When testing the application you can use the word "Kerosene" as an example. 


To run the application you should follow the following steps:

1. Clone this repository [see above]
2. Note 3 important files: file.csv - job-server.war - dictionary-service.jar
3. Make sure you have file.csv and dictionary-service.jar in the same directory - otherwise you will not allow the RMI server to load the dictionary file
4. Open command line prompt and cd into the directory where you have all the files listed above
5. Run the following command to start the RMI server - java –cp ./dictionary-service.jar ie.gmit.sw.RMI.Server
6. Once the server is running, open Eclipse [Java EE Perspective] and import the job-server.war file
7. Make sure to change Target runtime to Apache Tomcat 8.5 [This is the one I have used while developing the application]
8. Once you imported the .WAR file just click Run As.. [Run on Server]
9. Eclipse will automatically open the homepage for you once successfully deployed, but you can use your favourite browser and access the web app using the following URL - http://localhost:8080/job-server/

If you wish to have a look at the code, please see https://github.com/Sarlianth/distributed-systems-project