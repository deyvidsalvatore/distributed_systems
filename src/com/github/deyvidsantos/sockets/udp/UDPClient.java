package com.github.deyvidsantos.sockets.udp;

import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        byte[] sendData = new byte[1024];
        InetAddress ipAddress = InetAddress.getByName("localhost");
        while (true){
            String sentence = JOptionPane.showInputDialog("Digite: ");
            sendData = sentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sentence.length(), ipAddress, 5000);
            clientSocket.send(sendPacket);
            if (sentence.equals("fim")) break;
        }
        clientSocket.close();

    }

}
