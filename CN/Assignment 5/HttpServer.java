/********************************************************
 *Author: Lalitha Bhogaraju
 *Description: The program analyzes the Http packets sent by the browser.
 *             The HttpServer will deliver a simple HTML web page with an Embedded image in it.
 *               
 *********************************************************/


import java.net.*;
import java.util.*;
import java.io.*;

public class HttpServer {

        // Port number that server listens to
        private static int DEST_PORT ;

        
        public static void main(String[] args) {

                String Two = null;
                String CRLF = "\r\n";
                FileInputStream file = null;
                int count = 0;
                // To do  Auto-generated method stub
                if (args.length != 1) 
                {
                        System.out.println("Port Number Missing. Provide the valid Port Number(between 5900 to 5999) ");
                        System.exit(0);
                }
                try
                {
                        DEST_PORT = Integer.parseInt(args[0]);
                        // Create a server socket
                        ServerSocket svrSocket = new ServerSocket(DEST_PORT);

                        while (true)
                         {
                                // Accept client request
                                Socket clientSocket = svrSocket.accept();

                                InetAddress clientIP = clientSocket.getInetAddress();
                                System.out.println("Connected to " + clientIP.toString());

                               /*Reads text from a character-input stream, buffering characters 
                                 so as to provide for the efficient reading of characters, arrays, and lines.*/
                                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                                /*An InputStreamReader is a bridge from byte streams to character streams:
                                 It reads bytes and decodes them into characters using a specified charset. 
                                 The charset that it uses may be specified by name or may be given explicitly.*/

                                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                                // read the bytes from the input stream
                                String str = in.readLine();
                                /*
                                 * String Tokenizer:breaks down the string into number of tokens.
                                 */

                                if (str != null) 
                                {

                                        System.out.println("HTTP Request from client: " + str);
                                        System.out.println();
                                        StringTokenizer st = new StringTokenizer(str, " / ");
                                        while (st.hasMoreTokens())
                                        {
                                                String One = st.nextToken();
                                                Two = st.nextToken();
                                                String Three = st.nextToken();
                                                String Four = st.nextToken();



                                        }

                                        try
                                        {
                                                System.out.println("filename:"+ Two);
                                                file = new FileInputStream(Two);
                                                count++;

                                        } 
                                        catch (Exception FileNotFoundException)
                                        {

                                                count = 0;
                                        }
                                        if (count != 0)
                                        {
                                                String statusLine = "HTTP/1.1 200 OK" + CRLF;
                                                String contentType = "Content-type: " + contentType(Two) + CRLF;
                                                out.writeBytes(statusLine);
                                                out.writeBytes(contentType);
                                                out.writeBytes(CRLF);
                                                byte[] outones = new byte[1000];
                                                int bytesout;
                                                while ((bytesout = file.read(outones)) != -1) 
                                                {
                                                        out.write(outones, 0, bytesout);
                                                }

                                        }
                                        else 
                                        {
                                                String statusLine = "HTTP/1.1 404 Not Found" + CRLF;
                                                String contentType = "Content-type: " + contentType(Two) + CRLF;
                                                String entitybody = "<HTML>"
                                                                     + "<HEAD><TITLE>Not Found</TITLE></HEAD>"
                                                                     + "<BODY>Not Found</BODY></HTML>";
                                                out.writeBytes(statusLine);
                                                out.writeBytes(contentType);
                                                out.writeBytes(CRLF);
                                                out.writeBytes(entitybody);
                                                out.flush();

                                        }

                                }

                                // close streams. Client will close local socket
                                in.close();
                                out.close();
                        }

                } 
                catch (Exception e) 
                {
                        e.printStackTrace();
                }
        }

        private static String contentType(String filename) {
                if (filename.endsWith("html") || filename.endsWith("html")) {
                        return ("text/html");
                } else if (filename.endsWith("gif")) {
                        return ("image/gif");
                } else if (filename.endsWith("jpg") || filename.endsWith("jpeg")) {
                        return ("image/jpeg");
                } else if (filename.endsWith(".txt")) {
                        return "text/plain";
                } else
                        return ("application/octet-stream");
        }
}
