package com.github.arsengir.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Write your name:");
        String username = in.readLine();
        out.println("Are you child? (yes/no):");
        if ("yes".equals(in.readLine())) {
            out.println(String.format("Welcome to the kids area, %s! Let's play!", username));
        } else {
            out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
        }
        out.println();
    }
}
