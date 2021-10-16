package remoteProxy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9090);
		ServerBanking banking = new ServerBanking();
		System.out.println("Waiting for client");
		
		while (true) {

			Socket socket = server.accept();
			System.out.println("A client connected");
			
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
			
		}
		
	}

}
