package com.github.deyvidsantos.sockets.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("Servidor iniciado...");
        byte[] receiveData = new byte[1024];
        DatagramSocket serverSocket = new DatagramSocket(5000);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

        while (true){
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());

            if (sentence.substring(0,3).equals("fim")) break;

            InetAddress ipAddress = receivePacket.getAddress();
            System.out.println("Recebido de "+ ipAddress.getHostAddress()+":"+sentence);
        }

        serverSocket.close();
    }
}
