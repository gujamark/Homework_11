package com.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDetails {
    String help;
    String date;
    String name;
    String error;
    String separator = "----";
    public WriteFileDetails(String help, String date, String name, String error) {
        this.help = help;
        this.date = date;
        this.name = name;
        this.error = error;
    }

    public void saveDetails() {

        try {
            FileWriter fw = new FileWriter("info.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("help" + separator + this.help + "\n");
            bw.write("date" + separator + this.date + "\n");
            bw.write("name" + separator + this.name + "\n");
            bw.write("error" + separator + this.error);
            bw.flush();
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
