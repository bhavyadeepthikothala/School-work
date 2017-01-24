/*Author : HARSHINI BOLLINENI
Date : 09/14/2016
Program: PING client program to calculate the min, max and avg delays
*/
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class PingClient {

	public static void main(String[] args) throws Exception {
		long[] pingDelay = new long[10];
		long totalDelay = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the ServerName and PortNumber(again) in the format : [hostAddress:port]");
		String input = scanner.next();
		String[] arguments = input.split(":");
		String serverName = arguments[0];
		int portNumber = Integer.parseInt(arguments[1]);
		System.out.println("ServerName : " + serverName);
		System.out.println("PortNumber : " + portNumber);
		try {
			DatagramSocket Client = new DatagramSocket();
			InetAddress IPAddress = InetAddress.getByName(serverName);
			int requestNumber = 0;
			while(requestNumber<10) {
				long sendingTime = System.currentTimeMillis();
				String inputMessage = "Ping "+ requestNumber + " " + sendingTime + "\n";
				DatagramPacket requestPacket = new DatagramPacket(inputMessage.getBytes(), inputMessage.length(), IPAddress, portNumber);
				Client.send(requestPacket);
				try {
					DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
					Client.setSoTimeout(1000);
					Client.receive(responsePacket);
					long delay = System.currentTimeMillis() - sendingTime;
					totalDelay += delay;
					pingDelay[requestNumber] = delay;
					String replyMessageData = new String(responsePacket.getData(), 0, responsePacket.getLength());
					System.out.println("Received text " + replyMessageData + " from Server");
					System.out.println("Time Taken for packet : " + delay + "ms");
				} catch (Exception e) {
					System.out.println("Packet have been lost");
				}
				requestNumber++;
			}
			//Calculating the Minimum, Maximum, Average Delays.
			calculateTimeDelays(pingDelay, totalDelay);
			Client.close();
			scanner.close();
		} catch (Exception e) {
			System.out.println("Connection TimeOut");
		}
	}

	private static void calculateTimeDelays(long[] finishedTime, long totalTime) {
		long minimumDelay=0;
		long maximumDelay=0;
		for (int i=0; i <finishedTime.length; i++) {
			
			if(maximumDelay < finishedTime[i]) {
				maximumDelay = finishedTime[i];
			}
		}
		minimumDelay = maximumDelay;
		for (int i=0; i <finishedTime.length; i++) {
			if(finishedTime[i] <= 0) {
				continue;
			}
			if(minimumDelay > finishedTime[i]) {
				minimumDelay = finishedTime[i];
			}
		}
		System.out.println("The Minimum delay : " + minimumDelay + "ms");
		System.out.println("The Maximum delay : " + maximumDelay + "ms");
		System.out.println("The Average delay : " + (totalTime/10) + "ms");
	}
}