import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

	public static void main(String[] args) throws Exception{
		
		DatagramSocket serverSocket = new DatagramSocket(9999);
		
		System.out.println("Server is up and running");
		
		byte [] receivedByte = new byte[1024];
		DatagramPacket receivedPacket = new DatagramPacket(receivedByte, receivedByte.length);
		serverSocket.receive(receivedPacket);
		
		String receivedData = new String(receivedByte, 0, receivedByte.length);
		System.out.println("Packet received from Client: " + receivedData);
		
		int number = Integer.parseInt(receivedData.trim());
		
		byte[] square = ((number*number) + "").toString().trim().getBytes();
		
		InetAddress serverAddress = InetAddress.getLocalHost();
		DatagramPacket sendPacket = new DatagramPacket(square, square.length, serverAddress, receivedPacket.getPort());
		serverSocket.send(sendPacket);
		
		System.out.println("Square has been sent to Client");
		
	}

}
