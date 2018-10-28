import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws Exception {

		DatagramSocket datagramSocket = new DatagramSocket();
		
		System.out.println("Enter the number to be sent to Server");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		
		System.out.println("Data sent to Server: " + number);
		
		byte byteMessage [] = (number+"").toString().trim().getBytes();		
		InetAddress address = InetAddress.getLocalHost();
		int port = 9999;
		
		DatagramPacket sendPacket = new DatagramPacket(byteMessage, byteMessage.length, address, port);
		datagramSocket.send(sendPacket);
		
		byte [] receivedByte = new byte[1024];
		DatagramPacket response = new DatagramPacket(receivedByte, receivedByte.length);
		datagramSocket.receive(response);
		
		String receivedData = new String(receivedByte, 0, receivedByte.length);
		System.out.println("Below response is received from Server\nThe square is: " + receivedData);
		
		datagramSocket.close();
		scanner.close();
	}

}
