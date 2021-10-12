package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class Server 
{
    public static void main( String[] args ) throws Exception
    {
    	ServerSocket server = new ServerSocket(9090);
    	
    	System.out.println( "Waiting for client" );
    	
    	ServerBanking banking = new ServerBanking();
    	
    	while(true) {
    		Socket socket = server.accept();
        	
        	System.out.println("A client connected");
        	
        	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	PrintWriter pw = new PrintWriter(socket.getOutputStream());
        	
        	String depositCommand = reader.readLine();
        	String[] commandAndParam = depositCommand.split(":");
        	
        	int balance = 0;
        	if ("deposit".equals(commandAndParam[0])) {
        		balance = banking.deposit(Integer.parseInt(commandAndParam[1]));
        	} else if ("withdraw".equals(commandAndParam[0])) {
        		balance = banking.withdraw(Integer.parseInt(commandAndParam[1]));
        	}
        	
        	pw.println("balance:" + balance);
        	pw.flush();
        	
//        	http server
//        	pw.println("HTTP/1.1 200 OK");
//        	pw.println("Date: Wed, 6 Oct 2021 23:22:22 GMT");
//        	pw.println("Content-Type: text/html");
//        	pw.println("Content-Length: 3");
//        	pw.println("");
//        	pw.println("ABC");
//        	pw.flush();
    	}
    	
    	
    }
}
