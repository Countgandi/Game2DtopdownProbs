package com.countgandi.com.net.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.countgandi.com.net.server.Server;

public class Client {

	public static int Port = 26077;
	private boolean clientRunning = false;
	private String username = "";
	private String ipAddress = "localhost";
	private Socket tcpSocket;
	private DatagramSocket udpSocket;

	public Client(String username, String ip) {
		this.username = username;
		this.ipAddress = ip;
		try {
			tcpSocket = new Socket(ipAddress, Port);
			udpSocket = new DatagramSocket();
			udpSocket.connect(tcpSocket.getInetAddress(), Port);
			sendDataTcp("Log@" + this.username);
			byte[] okbytes = new byte["good".getBytes().length];
			tcpSocket.getInputStream().read(okbytes);
			String ok = new String(okbytes).trim();
			if (!ok.equals("good")) {
				disconnect();
			} else {
				System.out.println("Connection to server has been established.");
				clientRunning = true;
			}
		} catch (UnknownHostException e) {
			System.err.println("It doesn't exist bud...");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Well something went wrong.");
			e.printStackTrace();
		}
		new Thread() {
			@Override
			public void run() {
				while (clientRunning) {
					handleDataSending();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (clientRunning) {
					recieveUdp();
				}
			}
		}.start();
		new Thread() {
			@Override
			public void run() {
				while (clientRunning) {
					recieveTcp();
				}
			}
		}.start();
	}

	public void handleDataSending() {
		//Tcp Sending
		
		//Udp Sending
		sendDataUdp("hello friends and fammery");
	}

	public void recieveUdp() {

	}

	public void recieveTcp() {

	}

	private void disconnect() {
		try {
			tcpSocket.getInputStream().close();
			tcpSocket.getOutputStream().close();
			udpSocket.disconnect();
			udpSocket.close();
			tcpSocket.close();

		} catch (IOException e) {
		}
		tcpSocket = null;
		udpSocket = null;
		clientRunning = false;
		System.out.println("Disconnected from server.");
	}

	public void sendDataUdp(String data) {
		try {
			data = username + "$" + data;
			byte[] bytes = new byte[256];
			byte[] ogbytes = data.getBytes();
			for(int i = 0; i < ogbytes.length; i++) {
				bytes[i] = ogbytes[i];
			}
			udpSocket.send(new DatagramPacket(bytes, bytes.length, tcpSocket.getInetAddress(), Server.Port));
		} catch (IOException e) {
			System.err.println("Cannot send UDP data to the Server");
			e.printStackTrace();
			disconnect();
		}
	}

	public void sendDataTcp(String data) {
		try {
			data = username + "$" + data;
			tcpSocket.getOutputStream().write(data.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			disconnect();
		}
	}

	public static void main(String[] args) {
		new Client("Gay", "localhost");
	}

}
