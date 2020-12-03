package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {
    Socket socket;
    ObjectOutputStream objectOutput;
    String text;
    ObjectInputStream objectInput;
    String ip;

    public void run() {
        System.out.println(Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your IP Address: ");
        ip = sc.nextLine();

        try {
            socket = new Socket(InetAddress.getByName("localhost"),8080);
            objectOutput = new ObjectOutputStream(socket.getOutputStream());
            while (true){
                text = sc.nextLine();
                objectOutput.writeObject(ip + "-> " + text);
                objectInput = new ObjectInputStream(socket.getInputStream());
                System.out.println("Server->" + objectInput.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
