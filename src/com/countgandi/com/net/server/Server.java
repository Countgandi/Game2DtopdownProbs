package com.countgandi.com.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
	
	public static boolean serverRunning = false;
	public static int Port = 26077;
	public DatagramSocket udpSocket;
	public ServerSocket tcpSocket;
	public CopyOnWriteArrayList<ClientConnection> clients = new CopyOnWriteArrayList<ClientConnection>();
	
	public Server() {
		try {
			System.out.println("Starting server on port: " + Port);
			tcpSocket = new ServerSocket(Port);
			udpSocket = new DatagramSocket(Port);
			System.out.println("Server connections established");
		} catch (IOException e) {
			e.printStackTrace();
		}
		serverRunning = true;
		
		acceptClients();
		recieveUdp();
		
	}
	
	private void acceptClients() {
		Server s = this;
		new Thread() {
			@Override
			public void run() {
				while(serverRunning) {
					try {
						clients.add(new ClientConnection(tcpSocket.accept(), s));
					} catch (IOException e) {
						System.err.println("Something happened while waiting that isn't good!");
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	private void recieveUdp() {
		new Thread() {
			@Override
			public void run() {
				DatagramPacket packet = new DatagramPacket(new byte[256], 256);
				while(serverRunning) {
					try {
						udpSocket.receive(packet);
						String data = new String(packet.getData()).trim();
						for(int i = 0; i < clients.size(); i++) {
							if(data.startsWith(clients.get(i).getUsername() + "$")) {
								clients.get(i).recieveUdp(data.substring(clients.get(i).getUsername().length() + 1));
								break;
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	public static void main(String[] args) {
		new Server();
	}

}
