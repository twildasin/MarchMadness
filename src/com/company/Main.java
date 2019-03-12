package com.company;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        //region declaring stuff

        // Scans a file with every march madness game
        Scanner scanIn = new Scanner(new File("accounts.txt"));

        //Skips line with titles in it
        scanIn.nextLine();

        // I don't need to explain this...
        scanIn.useDelimiter(",");

        //Used to store each line of the text file
        // (store each GAME)
        ArrayList<Team> roster = new ArrayList<>();

        //Used to store team averages
        // (store each TEAM)
        ArrayList<Team> tour = new ArrayList<>();


        //endregion



        // Adds every of test file to a position iun the Team array
        while(scanIn.hasNext())
        {
            // One of the constructors takes a string and will parse all the data into the correct state variables
            roster.add(new Team(scanIn.nextLine()));
        }


        //Used to sort text file (if we need to add data and use again)
        //Collections.sort(roster);


        //region Condense game stats to team stats


        // Temporary array list stores collection of one team's stats (objects) to get condensed to one object
        ArrayList<Team> grp = new ArrayList<>();

        // Stores current team's ID
        int tm = -1;
        //First time finding a new team ID
        boolean firstTime = true;
        //Stores temporarily a team to add to temporary array list
        Team selectTeam;
        for(int i = 0; i < roster.size(); i++)
        {
            selectTeam = roster.get(i);
            //If same team ID, just add that to temp array list
            if(selectTeam.fir[2] == tm)
            {
                //Cholonk
                grp.add(selectTeam);
            }
            //If new team ID, finalize the array list (send it to a method) and clear it and prepare for new team's data
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
        // Adds the combined team's averages to one final array list
        tour.add(new Team((grp)));

        System.out.println(tour);

        //endregion


        //region Print out positions in array list

        /*

        StringBuffer otp2 = new StringBuffer();

        Team tp;
        otp2.append("0,");
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

            if(i != tour.size()-1)
                otp2.append("\n" + (i +1) + ",");
        }


        System.out.println(otp2.toString());

        */

        //endregion





        StringBuffer gui = new StringBuffer();
        FileWriter fw3 = new FileWriter("NameTeam.txt");
        PrintWriter pw3 = new PrintWriter(fw3);
        Scanner poop = new Scanner(new File("SheetData.txt"));

        gui.append(poop.nextLine());

        while(poop.hasNext())
        {
            gui.append("\n,");
            gui.append(poop.nextLine());
        }






        //System.out.println(Match.Game(tour.get(326), tour.get(286), 1));
        System.out.println(Match.Game(tour.get(326), tour.get(4), 1)); //Nova v AL (easy win)
        //System.out.println(Match.Game(tour.get(286), tour.get(326), 1));
        System.out.println(Match.Game(tour.get(326), tour.get(327), 1)); //Nova v VA (close game)

    fw3.close();
    pw3.close();

    }
}
