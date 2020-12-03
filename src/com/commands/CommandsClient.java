package com.commands;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class CommandsClient extends Thread{
    Socket socket;
    ObjectOutputStream objectOutput;
    String text;
    ObjectInputStream objectInput;

    public void run() {
        System.out.println(Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);

        try {
            socket = new Socket(InetAddress.getByName("localhost"),8081);
            objectOutput = new ObjectOutputStream(socket.getOutputStream());
            while (true){
                System.out.print("Enter Command: ");
                text = sc.nextLine();
                objectOutput.writeObject(text);
                objectInput = new ObjectInputStream(socket.getInputStream());
                System.out.println(objectInput.readObject());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
