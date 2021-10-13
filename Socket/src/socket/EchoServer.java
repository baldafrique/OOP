package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(4444);
		System.out.println("Server start");
		while (true) {
			Socket socket = serverSocket.accept();
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = in.readLine();
			System.out.println("Server : " + str + " got a message");
			out.println(str);
			out.flush();
			break;
		}
		System.out.println("Server shut down");
		serverSocket.close();
	}

}
