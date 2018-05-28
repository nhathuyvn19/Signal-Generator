import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class Server {
	private static int port = 8888;
	private static ServerSocket server;
	private static PrintWriter pw;
	private static BufferedReader bf;
	private static InetAddress addr;
	
	public static void main(String[] args) {
		
		try {
			addr = InetAddress.getByName(null);
			server = new ServerSocket(port, 1, addr);
			System.out.println("Server start at port " + port);
			Socket socketObject = server.accept();
			pw = new PrintWriter(new OutputStreamWriter(socketObject.getOutputStream(), StandardCharsets.UTF_8), true);
			bf = new BufferedReader(new InputStreamReader(socketObject.getInputStream(), StandardCharsets.UTF_8));
			pw.println("Hello World");
			while (!bf.readLine().equals("1"));
			System.out.println("Client is connected");
			pw.close();
			bf.close();
			socketObject.close();
			server.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
das
}
