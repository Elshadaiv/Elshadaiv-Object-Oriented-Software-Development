import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebsitePinger {

	public static void main (String[] args) {
		
		websitePing("Google.com", 10);
	} // this pings the website google.com and the number of times it pings which is 10

		 
		 //execute the method above allowing it to ping google.com 10 times
	public static void websitePing (String websitePing, int noPing)
		 {
		try { // creating the process builder, number of pings and the website pings
				ProcessBuilder processbuilder = new ProcessBuilder("cmd.exe", "/c", "ping", "-n", Integer.toString(noPing), websitePing);
			
				Process process = processbuilder.start();
					// start the process builder
		
			 	BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		          //using buffered reader  to create input stream reader to read content 
			 		String line;
			 		//initilzing line as a string
		            while ((line = reader.readLine()) != null) //prints out the line unless its null 
		            {
		                System.out.println(line);
		            } // print each line of the output
		            
		  } catch (IOException e) 
			 	{
		            e.printStackTrace();
		        }// exception handling

}
}


