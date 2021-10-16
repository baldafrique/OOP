package singleton;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9090);
		System.out.println("Waiting for client");
		
		while (true) {
			Socket socket = server.accept();
			new ClientHandler(socket).start();
		}
		
	}

}
