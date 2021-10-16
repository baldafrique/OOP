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
		// create server socket
		// parameter is port number
		
		System.out.println("Server start");
		while (true) {
			Socket socket = serverSocket.accept();
			// 클라이언트의 연결 요청 수락 및 클라이언트와 통신할 통신 소켓 반환
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			// 소켓 통신에 사용할 출력 스트림
			// socket.getOutputStream()은 소켓에 바이트 단위로 쓰는 스트림 반환
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// socket.getInputStream()은 소켓에서 바이트 단위로 읽는 스트림 반환
			
			String str = in.readLine();
			// read one line through socket
			
			System.out.println("Server : " + str + " got a message");
			out.println(str);
			// 소켓에 읽은 내용을 다시 씀
			
			out.flush();
			break;
		}
		System.out.println("Server shut down");
		serverSocket.close();
	}

}
