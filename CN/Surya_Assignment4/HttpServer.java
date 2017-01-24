import java.util.*;
import java.io.*;
import java.net.*;

public class HttpServer 
{
	private static ServerSocket Server;
	
	public static void main(String[] args) throws IOException
	{
		int port = 0;
		
		if(args.length == 0)
		{
			System.out.println(" Missing Port Number ");
		}
		else
		{
			try
			{
				port = Integer.parseInt(args[0]);
			}
			catch(Exception e)
			{
				System.out.println(" Port Number should be a Integer");
			}
		}
		Server = new ServerSocket(port);
		System.out.println("Listening to the port: " + port);
		System.out.println("Waiting for client to open a browser window........... ");
		
		while(true)
		{
			try
			{
				Socket s = Server.accept();
				new ClientHandler(s);
			}
			catch(Exception E)
			{
				System.out.println("Socket Exception: " + "\n" + E);
			}
		}
	}
}

class ClientHandler extends Thread
{
	private Socket Skt;
	public int headercount = 0;
	
	public ClientHandler(Socket S)
	{
		Skt = S;
		start();
	}
	
	public void run()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new InputStreamReader(Skt.getInputStream()));
			PrintWriter out = new PrintWriter(Skt.getOutputStream(),true);
			// read contents line by line
			String line = reader.readLine();
			// splitting the first line of the request
			StringTokenizer token = new StringTokenizer(line);
			
			while (!line.isEmpty()) 
			{
				// check for more tokens and print the request line
				if (token.hasMoreElements()&& token.nextToken().equalsIgnoreCase("GET")) 
				{
					out.println("Reqyest Type : GET");
					out.println("URL requested: " + token.nextToken());
					out.println("HTTP version: " + token.nextToken());
				} 
				else 
				{
					headercount++;
					//print the header lines
					out.println("Header Line " + headercount + ":" + line);
				}
				line = reader.readLine();
			}
			// closing the  output stream
			out.close();
			return;

		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}