package com.github.deyvidsantos.chatapp;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws IOException {
        String entrada = "";

        System.out.println("Cliente iniciado...");
        Socket socket = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();

        while(true) {
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o servidor", "Cliente",
                    JOptionPane.INFORMATION_MESSAGE);
            out.println(entrada);
            System.out.println("Cliente: " + entrada);
        }

    }
}
