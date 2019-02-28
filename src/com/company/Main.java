package com.company;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanIn = new Scanner(new File("sheet.txt"));

        scanIn.nextLine();

        FileWriter fw = new FileWriter("output.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);



        for(int i = 0; i < 29233; i++)
        {
            scanIn.nextLine();
        }



        //ArrayList<String> myTxt = new ArrayList<String>();

        StringBuffer myTxt = new StringBuffer();

        while (scanIn.hasNext())
        {
            myTxt.append("\n");
            myTxt.append(scanIn.nextLine());
        }




        //System.out.println(myTxt);
        pw.println(myTxt);

        fw.close();
        pw.close();



    }
}
