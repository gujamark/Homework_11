package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread{
    Socket socket;
    ObjectInputStream objectInput;
    String text;
    ObjectOutputStream objectOutput;

    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            socket = serverSocket.accept();
            objectInput = new ObjectInputStream(socket.getInputStream());
            while (true) {
                text = (String) objectInput.readObject();
                System.out.println(text);
                objectOutput = new ObjectOutputStream(socket.getOutputStream());
                Scanner sc = new Scanner(System.in);
                objectOutput.writeObject(sc.nextLine());
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
