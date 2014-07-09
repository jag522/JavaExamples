package com.jag.net;
import java.io.*;
import java.net.*;

/**
 * A simple network client that establishes a network connection to a specified
 * port on a specified host, sends an optional message across the connection,
 * reads the response from the server, and exits.  A suitable client for simple
 * network services like the daytime or finger.
 **/
public class Connect {
    public static void main(String[  ] args) {
        try {  // Handle exceptions below
            // Get our command-line arguments
            String hostname = args[0];
            int port = Integer.parseInt(args[1]);
            String message = "";
            if (args.length > 2) 
                for(int i = 2; i < args.length; i++) message += args[i] + " ";
            
            // Create a Socket connected to the specified host and port.
            Socket s = new Socket(hostname, port);

            // Get the socket output stream and wrap a PrintWriter around it
            PrintWriter out = new PrintWriter(s.getOutputStream( ));

            // Send the specified message through the socket to the server.
            out.print(message + "\r\n");
            out.flush( );  // Send it now.
            
            // Get an input stream from the socket and wrap a BufferedReader
            // around it, so we can read lines of text from the server.
            BufferedReader in =
                new BufferedReader(new InputStreamReader(s.getInputStream( )));

            // Before we start reading the server's response, tell the socket
            // that we don't want to wait more than 3 seconds
            s.setSoTimeout(3000);

            // Now read lines from the server until the server closes the
            // connection (and we get a null return indicating EOF) or until
            // the server is silent for 3 seconds.
            try {
                String line;                          
                while((line = in.readLine( )) != null) // If we get a line
                    System.out.println(line);         // print it out.
            }
            catch(SocketTimeoutException e) {
                // We end up here if readLine( ) times out.
                System.err.println("Timeout; no response from server.");
            }
            
            out.close( );  // Close the output stream
            in.close( );   // Close the input stream
            s.close( );    // Close the socket
        }
        catch(IOException e) {  // Handle IO and network exceptions here
            System.err.println(e);
        }
        catch(NumberFormatException e) {  // Bad port number
            System.err.println("You must specify the port as a number");
        }
        catch(ArrayIndexOutOfBoundsException e) {  // wrong # of args
            System.err.println("Usage: Connect <hostname> <port> message...");
        }
    }
}
