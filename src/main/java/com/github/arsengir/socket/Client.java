package com.github.arsengir.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String LOCALHOST = "netology.homework";

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(LOCALHOST, Server.SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            Scanner scanner = new Scanner(System.in);
            String resp;
            while (!(resp= in.readLine()).isEmpty()){
                System.out.println(resp);
                if (resp.endsWith(":")) {
                    out.println(scanner.nextLine());
                }
            }
        }
    }
}
