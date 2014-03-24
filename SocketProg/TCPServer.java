/**
 * 		@author Hazel Lobos
 *
 */
import java.io.*;
import java.net.*;

public class TCPServer  {
	
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		
		String clientSentence;
		String capitalizedSentence;
		
		//create welcoming socket at port 6789
		@SuppressWarnings("resource")
		ServerSocket welcomeSocket = new ServerSocket(6789);
		
		//always will loop back to wait for a client connection
		while (true) 
		{
						
			//wait on welcoming socket accept() method for client contact, create new socket on return
			Socket connectionSocket = welcomeSocket.accept();
			
			//create input stream attached to socket
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			//create output stream attached to socket
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			//read in line from socket
			clientSentence = inFromClient.readLine();
			
			capitalizedSentence = clientSentence.toUpperCase()  + '\n';
			
			//write out line to socket
			outToClient.writeBytes(capitalizedSentence);
		}
		
	}
	
}

