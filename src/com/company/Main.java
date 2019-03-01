package com.company;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanIn = new Scanner(new File("sheet.txt"));

        scanIn.nextLine();
        scanIn.useDelimiter(",");
        ArrayList<Team> roster = new ArrayList<Team>();



/*        while (scanIn.hasNext())
        {

        }*/

        FileWriter fw = new FileWriter("accounts.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);








        fw.close();
        pw.close();

    }
}
