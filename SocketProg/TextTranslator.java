import java.io.*;

public class TextTranslator {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader stream = new InputStreamReader(System.in);
		BufferedReader ubr = new BufferedReader(stream);						 //userInput Reader
		BufferedReader cbr;
		String userInput = "";
	
		System.out.println("\t\t\t||===== Text Speak Translator =====||");
		System.out.println("\n\t\t To stop entering new messages please type: exit");
		
		int exit = 1;
		
		while(exit != 0) 
		{
			System.out.print("\nEnter Your Message: ");
			userInput = ubr.readLine();
			
			//check if user wants to exit
			if (userInput.trim().equals("exit")) 
			{		
				exit = 0;
			}
			else
			{
				System.out.println("\nYour Original Message: " + userInput);
				
				//Read in the codebook.txt
				String line;
				
				//Turn userInput to uppercase and compare words to the codebook
				userInput = userInput.toUpperCase();
				
				//creates new reader for codebook.txt
				cbr = new BufferedReader(new FileReader("codebook.txt"));
				
				//While will exit as soon as a line is found to be empty (the end of the codebook file)
				while((line = cbr.readLine()) !=  null)
				{
					//Delimit first word from line and the following sentence (translation)
					String arr[] = line.split("\\s+", 2);
					String firstWord = arr[0];
					String theRest = arr[1];
						
					userInput = userInput.replaceAll(("\\b"+firstWord+"\\b"), theRest);
				}
				
				//Translated Message:
					
				System.out.println("Your Translation: " + userInput);
			}
			
		}
		
		System.out.println("\n\t\t\t\t||===== End of Program! =====||");
		
	}

}
