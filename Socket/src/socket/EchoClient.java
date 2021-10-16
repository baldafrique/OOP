package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 4444);
		// create socket
		// parameter are IP and port number
		
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// 소켓 통신에서 사용할 입출력 스트림 생성
		
		out.println("hello echo");
		out.flush();
		
		String str = in.readLine();
		// 서버로부터 전송된 데이터를 소켓을 통해 한 줄 읽음
		
		System.out.println("Client : " + str + " got a message");
		socket.close();
	}

}
