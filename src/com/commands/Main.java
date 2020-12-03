package com.commands;

public class Main {

    public static void main(String[] args) {
        WriteFileDetails wfd = new WriteFileDetails("HelpValue","14-02-2000","Guja","ErroText");
        wfd.saveDetails();
        CommandsServer server = new CommandsServer();
        CommandsClient client = new CommandsClient();
        server.start();
        client.start();
    }

}
