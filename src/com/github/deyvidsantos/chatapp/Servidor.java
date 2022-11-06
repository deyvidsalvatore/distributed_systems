package com.github.deyvidsantos.chatapp;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        String entrada;

        System.out.println("Cliente iniciado...");
        ServerSocket socketServidor = new ServerSocket(5000);
        Socket socketCliente = socketServidor.accept();
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
        EscutaThread escuta = new EscutaThread(in);
        escuta.start();

        while(true) {
            entrada = JOptionPane.showInputDialog(null, "Mensagem para o cliente", "Servidor",
                    JOptionPane.INFORMATION_MESSAGE);
            out.println(entrada);
            System.out.println("Servidor: " + entrada);
        }

    }
}
