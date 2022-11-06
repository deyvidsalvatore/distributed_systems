package com.github.deyvidsantos.sockets.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        String entrada = "";

        System.out.println("Servidor iniciado...");
        ServerSocket socketServidor = new ServerSocket(5000);
        Socket socketCliente = socketServidor.accept();
        PrintWriter out = new PrintWriter(socketCliente.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));

        while((entrada = in.readLine()) != null){
            System.out.println("Recebido: " + entrada);
            out.println(entrada);

            if(entrada.equals("fim")) break;
        }
        out.close();
        socketServidor.close();
        socketCliente.close();
    }
}
