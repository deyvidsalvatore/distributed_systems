package com.github.deyvidsantos.threads;

public class ThreadPrincipal {
    public static void main(String[] args) {
        ThreadParalelo a = new ThreadParalelo("#Paralelo");
        a.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ":"+"&Principal&");
        }
    }
}
