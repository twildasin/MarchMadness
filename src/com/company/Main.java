package com.company;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanIn = new Scanner(new File("accounts.txt"));

        scanIn.nextLine();
        scanIn.useDelimiter(",");

        ArrayList<Team> roster = new ArrayList<>();
        ArrayList<Team> tour = new ArrayList<>();
        //String [] grp;





        ///*
        FileWriter fw = new FileWriter("sheet.txt"); //page 142 in Blue Pelican
        PrintWriter pw = new PrintWriter(fw);
        StringBuffer otp = new StringBuffer();

        FileWriter fw2 = new FileWriter("Averages.txt"); //page 142 in Blue Pelican
        PrintWriter pw2 = new PrintWriter(fw);
        StringBuffer otp2 = new StringBuffer();




        while(scanIn.hasNext())
        {
            roster.add(new Team(scanIn.nextLine()));

        }



        Collections.sort(roster);
        //System.out.println(roster);



        ArrayList<Team> grp = new ArrayList<>();

        //Match.Game(1155, 1243);

        int tm = -1;
        boolean firstTime = true;
        Team selectTeam;
        for(int i = 0; i < roster.size(); i++)
        {
            selectTeam = roster.get(i);
            if(selectTeam.fir[2] == tm)
            {
                //Cholonk
                grp.add(selectTeam);
            }
            else
            {
                if(!firstTime)
                {
                    tour.add(new Team(grp));
                }
                tm = selectTeam.fir[2];
                grp.clear();
                grp.add(selectTeam);
            }
            firstTime = false;
        }
        tour.add(new Team((grp)));

        System.out.println(tour);
        //System.out.println(tour.size());

        //System.out.println();


        ///*
        //String temp;
        Team tp;
        for(int i = 0; i < tour.size(); i++)
        {
            tp = tour.get(i);

            for(int k = 0; k < 6; k++)
            {
                otp2.append(Integer.toString(tp.fir[k]));
                otp2.append(",");
            }

            otp2.append(tp.str);
            otp2.append(",");

            for(int k = 0; k < 27; k++)
            {
                otp2.append(Integer.toString(tp.sec[k]));
                otp2.append(",");
            }

            otp2.append("\n" + (i +1) + "\t");
        }


        pw2.print(otp2.toString());
        System.out.println(otp2.toString());

        fw2.close();
        pw2.close();
        //*/
        //*/


        //System.out.println(Match.Game(tour.get(326), tour.get(286), 1));
        //System.out.println(Match.Game(tour.get(326), tour.get(4), 1));
        System.out.println(Match.Game(tour.get(286), tour.get(326), 1));



    }
}
