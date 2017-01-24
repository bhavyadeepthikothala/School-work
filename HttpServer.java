/*************************************************************************************************************
 * Author: Harshini Bollineni
 * Date: 10/11/2016
 * Description: HttpServer opens a TCP socket at a user specified port to listen to the HTTP GET request.
 ************************************************************************************************************/



import java.io.*;
import java.net.*;

public class HttpServer {

	//Port number that server listens to
	private static int  port;
	static String var;
	public static void main(String[] args) 
	{
		
		if(args.length == 0)
		{
			System.out.println(" Port number is missing " + " \n ");
			System.exit(0);
			
		}
		else
		{
			var=args[0];
			port = Integer.parseInt(var);
		
		try
		{
			
			ServerSocket serversocket = new ServerSocket(port);
			
			while(true)
			{
				//Accept client request, this returns a local Socket to communicate with the client
			
				System.out.println(" Waiting for client....... ");
				Socket client = serversocket.accept();
			
				
				//Get the input and output streams of the socket

				 /*******************************************
				 * Prints objects to a text-output stream.  
				 *******************************************/

				 PrintWriter outstrm = new PrintWriter(client.getOutputStream(), true);
				
				 /************************************************
				 * Reads text from a character input stream
				 ************************************************/
				
				 InputStreamReader inpstrm = new InputStreamReader(client.getInputStream());
				 BufferedReader bfrrdr = new BufferedReader(inpstrm);
				
		
				   String  output = bfrrdr.readLine();
				   
				    //to split and write output
				   
			         	 String[] splitHeader = output.split(" ");
			         	 
				          int i=0;
				          
				          while(i < splitHeader.length)
				          {
				        	  System.out.println(" Request Type: " + splitHeader[i]+"\n\n" );
				        	  i++;
					          System.out.println(" URL Requested: " + splitHeader[i]+"\n\n");
					          i++;
					          System.out.println(" HTTP version: " + splitHeader[i]+"\n\n" );
					          i++;
				          }
				          
			             System.out.println(" \n ");
			    
			            i=0;
				 
			            String Header  = bfrrdr.readLine();
			            
			            while( true )
				          {
							  i++;
							  if(Header.length()>0)
							  {
				        	      System.out.println(" HEADER LINE "+i+" : "+Header);
							  }
							  
							  Header  = bfrrdr.readLine();
							  
							  if( Header == null)
							  {
								  break;
							  }
				        	 
				          }
	
										       
		             //to print the output in the browser
		             outstrm.println("\n\n");
		             
		             outstrm.println("\t\t"+"the port number that the server is listening to:"+port+"\n\n");
		             outstrm.println("\t\t"+"the Request type, URL Requested and the HTTP Version are:"+output);
		
		
			
				// to close streams Client will close local sockets
				bfrrdr.close();    //to close the input stream reader
				outstrm.close();   //closing the output stream reader
				
			}
		}
		        // To catch exception that is thrown in the try block
		catch (Exception e)
		{
			//To print the exception details 
			e.printStackTrace();
		}
	}
 }
}
