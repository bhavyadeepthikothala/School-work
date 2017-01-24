/********************************************************
* AUTHOR: JASWANTH KAMBHAMPATI
* DATE : 02/16/2015
* DESCRIPTION:The following is a java program that simulates the ping command using the UDP Transport protocol and runs at application layer.
*********************************************************/

import java.io.*;
import java.util.*;
import java.net.*;


public class PingClient
{
	    
	public static void main(String[] args) throws Exception
	{
         int sequence_value;
        long sum=0,minimum_Delay=0,maximum_Delay=0;
		long sending_Time[]=new long[10];
		long receiving_Time[]=new long[10];
	
		long average_delay;
		long time_taken[]=new long[10];
		System.out.println("enter the server name and port number seperated by a colon(:):");
		//Creating a buffered reader to read string from the keyboard and store them in string 'instring' 
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		//Reading string from the keyboard
		String inString = keyboard.readLine();
		System.out.println(inString);
		//The string is divided into server name and port number
		String[] srpo =new String[2];
		srpo = inString.split(":");
		System.out.println("The server name is:" + srpo[0] );
		System.out.println("The port number is:" +srpo[1]);
		//Converting the string value of port number into integer
		int portNumber = Integer.parseInt(srpo[1]);
		//try allows us to check a block of code for errors and the timed out exception 
	 
		try
		{
		
      //UDP connection with the use of socket is created
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress clientAddress = InetAddress.getByName(srpo[0]);
		sequence_value=0;
	    do 
		{
			
		String Data = ("PING " + sequence_value + ":" + System.currentTimeMillis() + " \n");
		//The data information is send to the server 		
		DatagramPacket sendPacket = new DatagramPacket(Data.getBytes(),Data.length(),clientAddress, portNumber);
		//Now the packet is send to the server
		clientSocket.send(sendPacket);
		sending_Time[sequence_value] = System.currentTimeMillis();
		clientSocket.setSoTimeout(1000);
		try
		{
		byte[] buffer = new byte[1024];
		
		//DatagramPacket Object is created  to receive the data from the server
		DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
		clientSocket.receive(receivePacket);
		receiving_Time[sequence_value] = System.currentTimeMillis();
		
		String receiveString = new String(receivePacket.getData(), 0, receivePacket.getLength());
		System.out.println("Received text " + receiveString + " from Server");
		}
		catch(Exception ex)
		{
			System.out.println("packet have been lost");
		}
		 //The time delay between the sending and receiving the packet is calculated
         time_taken[sequence_value] = receiving_Time[sequence_value] - sending_Time[sequence_value];
        if(time_taken[sequence_value] > 0) 
        {
            System.out.print("Time Taken for packet " + sequence_value + ":" + time_taken[sequence_value] + "ms\n");
            System.out.println("");
        
            sum = sum + time_taken[sequence_value];
            sequence_value++;
        }
	}while(sequence_value<10);
        
         int loopcontrol_variable=0;
            while(loopcontrol_variable<10)
            {
               int lpcontrol=loopcontrol_variable+1;
            	while(lpcontrol<10)
            	{
            		if(time_taken[loopcontrol_variable] > time_taken[lpcontrol])
            		{
            			minimum_Delay=time_taken[lpcontrol];
            			time_taken[lpcontrol]=time_taken[loopcontrol_variable];
            			time_taken[loopcontrol_variable]=minimum_Delay;
            		}
                 lpcontrol++;
            	}
             loopcontrol_variable++;
            }
            // The maximum,minimum and average delays are calculated
            int loop_counter=0;
            if(time_taken[0]<0)
            {
            	while(time_taken[loop_counter]<0)
            	{
            		loop_counter++;
            	}
            
            System.out.println("Minimum delay: " + time_taken[loop_counter] + "ms\n");
            }
            else
            	 System.out.println("Minimum delay: " + time_taken[0] + "ms\n");
        
            System.out.println("Maximum delay: " + time_taken[9] + "ms\n");
   
   // System.out.println("Maximum delay: " + maximum_Delay + "ms\n");
    average_delay = sum/10;
    System.out.println("Average delay: " + average_delay + "ms\n");
    
		
		clientSocket.close();
		//catch block 2	
		}
		catch(SocketException SE)
		{
			System.out.println("Connection Timed Out");
		}
		
		catch (Exception e)
		{
		
			System.out.println("Connection Timed Out");
			
		}
	

}
}