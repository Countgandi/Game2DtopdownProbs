package com.countgandi.com.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;

public class ClientConnection {

	private Server server;
	private Socket socket;
	private String username = "";

	public ClientConnection(Socket socket, Server server) {
		this.socket = socket;
		this.server = server;

		byte[] bytes = new byte[64];
		try {
			socket.getInputStream().read(bytes);
			username = new String(bytes).trim().split("@")[1];
			System.out.println(username + " has connected.");
			if (username.length() < 2) {
				throw new IOException("The username is not valid and the client is not allowed to connect to the server.");
			}
			sendDataTcp("good");

		} catch (IOException e) {
			e.printStackTrace();
			sendDataTcp("bad ");
			disconnect();
		}

		new Thread() {
			@Override
			public void run() {
				if (!socket.isClosed()) {
					try {
						recieveTcp();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();

	}

	public void recieveTcp() throws IOException {
		byte[] bytes = new byte[1024];
		socket.getInputStream().read(bytes);
	}

	public void recieveUdp(String data) {
		System.out.println("UDP Data: " + data);
	}

	public void sendDataUdp(String data) {
		try {
			server.udpSocket.send(new DatagramPacket(data.getBytes(), data.getBytes().length, socket.getInetAddress(), Server.Port));
		} catch (IOException e) {
			System.err.println("Cannot send UDP data to the client: " + username + " [" + socket.getInetAddress().getHostAddress() + "]");
			e.printStackTrace();
			disconnect();
		}
	}

	public void sendDataTcp(String data) {
		try {
			socket.getOutputStream().write(data.getBytes());
		} catch (IOException e) {
			System.err.println("Cannot send TCP data to the client: " + username + " [" + socket.getInetAddress().getHostAddress() + "]");
			e.printStackTrace();
			disconnect();
		}
	}

	public void disconnect() {
		try {
			socket.getInputStream().close();
			socket.getOutputStream().close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket = null;
		System.out.println(username + " has disconnected.");
		server.clients.remove(this);
	}

	public String getUsername() {
		return username;
	}

}
