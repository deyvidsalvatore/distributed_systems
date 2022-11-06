package com.github.deyvidsantos.sockets.tcp;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String serverInput = "";
        String userInput = "";

        Socket socket = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        while (!userInput.equals("fim")){
            out.println(userInput);
            serverInput = in.readLine();
            userInput = JOptionPane.showInputDialog("Chegou: " + serverInput + "\nDigite para enviar: ");
        }

        out.close();
        in.close();
        socket.close();

    }
}
