package singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class BankingStub implements IBanking {

	@Override
	public Integer deposit(Integer money) throws UnknownHostException, IOException {
		return call("deposit", money);
	}

	@Override
	public Integer withdraw(Integer money) throws UnknownHostException, IOException {
		return call("withdraw", money);
	}
	
	Integer call(String command, Integer money) throws UnknownHostException, IOException  {
		Socket client = new Socket("localhost", 9090);
		
		System.out.println("Trying to connect to server");

		PrintWriter pw = new PrintWriter(client.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		pw.println(command + ":" + money);
		pw.flush();
		
		String returnValue = reader.readLine(); // balance: 100, 200, 300
		String[] propertyAndValue = returnValue.split(":");
		
		client.close();
		
		return Integer.parseInt(propertyAndValue[1]);
	}

}
