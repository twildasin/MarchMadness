package com.company;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanIn = new Scanner(new File("sheet.txt"));

        scanIn.nextLine();
        scanIn.useDelimiter(",");

        ArrayList<Team> roster = new ArrayList<>();










        FileWriter fw = new FileWriter("accounts.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);
        StringBuffer otp = new StringBuffer();


///*
        //int it = 0;
        while(scanIn.hasNext())
        {
            //roster.add(new Team(Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), scanIn.next(), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next()), Integer.parseInt(scanIn.next())));
            roster.add(new Team(scanIn.nextLine()));
            //it++;
            //System.out.println(it);
        }



        Collections.sort(roster);
        System.out.println(roster);

//*/


/*
        while (scanIn.hasNext())
        {
            otp.append("\n" + scanIn.nextLine() + ",----,");
        }


        pw.print(otp);
*/


        String temp;
        Team tp;
        for(int i = 0; i < roster.size(); i++)
        {
            tp = roster.get(i);

            for(int k = 0; k < 6; k++)
            {
                otp.append(Integer.toString(tp.fir[k]));
                otp.append(",");
            }

            otp.append(tp.str);
            otp.append(",");

            for(int k = 0; k < 27; k++)
            {
                otp.append(Integer.toString(tp.sec[k]));
                otp.append(",");
            }

            otp.append("\n");
        }


        pw.print(otp.toString());
        //System.out.println(otp.toString());


        fw.close();
        pw.close();

    }
}
