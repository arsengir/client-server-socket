package com.github.arsengir.socket;

import java.io.*;
import java.net.Socket;

public class Client {

    public static final String LOCALHOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(LOCALHOST, Server.SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            out.println("Client");
            String resp = in.readLine();
            System.out.println(resp);
        }
    }
}
