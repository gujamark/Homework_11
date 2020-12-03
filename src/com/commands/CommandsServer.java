package com.commands;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class CommandsServer extends Thread{
    Socket socket;
    ObjectInputStream objectInput;
    String text;
    ObjectOutputStream objectOutput;
    HashMap <String, String> fileInfo = new HashMap<String,String>();


    public void run() {
        System.out.println(Thread.currentThread().getName());

        File file = new File("info.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] info = sc.nextLine().split("----");
                fileInfo.put(info[0],info[1]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            socket = serverSocket.accept();
            objectInput = new ObjectInputStream(socket.getInputStream());
            while (true) {
                text = (String) objectInput.readObject();
                objectOutput = new ObjectOutputStream(socket.getOutputStream());
                objectOutput.writeObject(fileInfo.get(text));
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
