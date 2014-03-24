/****
 * Socket Programming Demonstration:	TextTranslator.java
 * 		
 * 		@author 	Hazel lobos
 * 		@MRU		201529006
 * 		@Professor	Mingwei Gong
 * 		@Class		COMP-3533 Network Infrastructure
 * 
 * */

import java.io.*;
import java.net.*;


public class TCPClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{	
		
		String sentence;
		String modifiedSentence;
				
		//Input stream
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		//Create clientSocket and connect to server
		Socket clientSocket = new Socket("www.mtroyal.ca", 6789);
		
		//Grab input back from server
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		//Create input stream attached to socket, read line in from USER
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
		
		sentence = inFromUser.readLine();
		
		//send a sentence to the server
		outToServer.writeBytes(sentence + '\n');
		
		//read line back from server
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("From Server: " + modifiedSentence);
		
		//close socket
		clientSocket.close();
				
	}

}
