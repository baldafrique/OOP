package singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
	
	Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		System.out.println("A client connected");
		IBanking banking = ServerBanking.getInstance();
		
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String depositCommand = reader.readLine();
			String[] commandAndParam = depositCommand.split(":");
			
			int balance = 0;
			if (commandAndParam[0].equals("deposit")) {
				balance = banking.deposit(Integer.parseInt(commandAndParam[1]));
			} else if (commandAndParam[0].equals("withdraw")) {
				balance = banking.withdraw(Integer.parseInt(commandAndParam[1]));
			}
			
			pw.println("balance:" + balance);
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
