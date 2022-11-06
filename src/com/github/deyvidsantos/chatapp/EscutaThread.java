package com.github.deyvidsantos.chatapp;

import java.io.BufferedReader;
import java.io.IOException;

public class EscutaThread extends Thread{
    BufferedReader in;
    public EscutaThread(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        String entrada;
        try {
            while ((entrada = in.readLine()) != null){ System.out.println("Recebi "+ entrada); }
        } catch (IOException ignored){}
    }
}
