/*****************************************
 * Author: Lalitha Bhogaraju
 * Description: HttpServer that opens a TCP socket at a user specified port to listen to HTTP GET requests.
 */



import java.io.*;
import java.net.*;

public class HttpServer {

	//Port number that server listens to
	private static int  port;
	static String var;
	public static void main(String[] args) 
	{
		
		if(args.length!=1)
		{
			System.out.println("Port number missing"+ "\n"+"enter the port number");
		}
		else
		{
			var=args[0];
			port = Integer.parseInt(var);
		try
		{
			
			ServerSocket serversocket = new ServerSocket(port);
			System.out.println("\n\n"+"the port number to which the server is listening to is:"+ port+"\n");
			
			while(true)
			{
				//Accept client request, this returns a local Socket
				//to communicate with the client
				System.out.println("Waiting for client to run the web browser");
				Socket clntsckt = serversocket.accept();
			
				
				//Get the input and output streams of the socket

				/**********************************************
				 * Prints formatted representations of objects to a text-output stream.  
				 **************************************************/

				 PrintWriter outstrm = new PrintWriter(clntsckt.getOutputStream(), true);
				
				 /***************************************************
				 * Reads text from a character-input stream***********/
				
				 InputStreamReader isr = new InputStreamReader(clntsckt.getInputStream());
				 BufferedReader instrm = new BufferedReader(isr);
				
		
				   String  outputstring = instrm.readLine();
				   
				    //to split and write output
				   
			         	 String[] splited = outputstring.split(" ");
			         	 
				          int i=0;
				          while(i<splited.length)
				          {
				        	  System.out.println("Request Type:" + splited[i]+"\n\n" );
				        	  i++;
					          System.out.println("URL Requested:" + splited[i]+"\n\n");
					          i++;
					          System.out.println("HTTP version:" + splited[i]+"\n\n" );
					          i++;
				          }
				          
			             System.out.println("\n");
			    
			            i=0;
				 
			            String Header;
						
			            while((Header  = instrm.readLine()) != null)
				          {
							  i++;
							  if(Header.length()>0)
							  {
				        	      System.out.println("HEADER "+i+":"+Header);
							  }
				        	 
				          }
	
										       
		             //to print the output in the browser
		             outstrm.println("\n\n");
		             
		             outstrm.println("\t\t"+"the port number that the server is listening to is:"+port+"\n\n");
		             outstrm.println("\t\t"+"the Request type, URL Requested and the HTTP Version are:"+outputstring);
		
		
			
				//to close streams Client will close local sockets
				instrm.close();//closing the input stream reader
				outstrm.close();//closing the output stream reader
				
			}
		}
		// catch any exception that is thrown in the try block
		catch (Exception e)
		{
			//print the entire exception details 
			e.printStackTrace();
		}
	}
 }
}
