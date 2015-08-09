package server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// server-side
public class Server{

	public static void main(String[] args) throws Exception{
		System.out.println("Server is running...");
		try{
			ServerSocket Ssocket = new ServerSocket(7000);
			while(true){
				Socket socket = Ssocket.accept();
				DataInputStream dIn = new DataInputStream(socket.getInputStream());

				int length = dIn.readInt();                    // read length of incoming message
				if(length>0) {
					byte[] message = new byte[length];
					dIn.readFully(message, 0, message.length); // read the message
				}
				System.out.println("Receive data from port: 7000");

				DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
				outToClient.writeUTF("Testing Testing");
				outToClient.flush();
				outToClient.close();
				dIn.close();
				System.out.println("Sent to client");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
