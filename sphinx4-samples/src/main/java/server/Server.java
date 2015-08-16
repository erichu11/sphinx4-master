package server;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// server-side
public class Server{

	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = null;

		boolean listeningSocket = true;
		try {
			serverSocket = new ServerSocket(7000);
		} catch (IOException e) {
			System.err.println("Could not listen on port: 7000");
		}
		System.out.println("Server is running...");

		while(listeningSocket){
			Socket clientSocket = serverSocket.accept();
			MiniServer mini = new MiniServer(clientSocket);
			mini.start();
		}
		serverSocket.close();       
	}
}

