import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {
	private static DatagramSocket socket;
	private static int port = 8888;
	public static void main(String[] args) {
		byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
		try {
			InetAddress addr = InetAddress.getByName("192.168.137.1");
			socket = new DatagramSocket(port, addr);
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length, addr, port);
			String s = "Hello World";
			sendData = s.getBytes();
			System.out.println(sendData.toString());
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, addr, port);
			socket.send(sendPacket);
			String sr;
			do {
				sr = new String(receivePacket.getData());
				System.out.println(sr);
			} while(!sr.equals("1"));
			System.out.println("Client is connected");
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
