package com.company;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class Match {

    //scans to find if two teams have competed before and will return (team 1 wins - team 2 wins). Returns 0 if equal win/loss or not games played.
    public static int findGame (int t1, int t2) throws IOException
    {
        // Makes a new Scanner from the txt file of teams (unsorted)
        Scanner scanIn = new Scanner(new File("sheet.txt"));
        scanIn.useDelimiter(",");

        //Used to keep track of wins
        int t1t = 0;
        int t2t = 0;

        int teamID1;
        int teamID2;

        String temp;
        Scanner find;
        scanIn.nextLine();
        boolean found = false;
        while(scanIn.hasNext())
        {
            temp = scanIn.nextLine();
            find = new Scanner(temp);
            find.useDelimiter(",");
            //System.out.println(find.next());
            //System.out.println(find.toString());


            // Skips first two data points
            find.next();
            find.next();
            teamID1 = Integer.parseInt(find.next());
            find.next();
            teamID2 = Integer.parseInt(find.next());

            // If team 2 wins
            if(teamID1 == t2 && teamID2 == t1)
            {
                t2t++;
            }

            // If team 1 wins
            if(teamID1 == t1 && teamID2 == t2)
            {
                t1t++;
            }



        }

        return t1t - t2t;

    }

    // Big method that compares different data points to return which team would be most likely to win the game
    public static String Game (Team t1, Team t2, int round) throws IOException
    {
        int t1t = 0;
        int t2t = 0;

        // Keeps track of which team has won previous games
        int winning;

        // Calls method above to see which team has won previous games
        winning = Match.findGame(t1.fir[2], t2.fir[2]);

        if(winning > 0) // If team 1 one
        {
            t1t++;
        }

        else if (winning < 0) // If team 2 won
        {
            t2t++;
        }

        double mt1 = 0;
        double mt2 = 0;

        for(int i = 1; i < 14; i++)
        {

            if(i == 10 || i == 13) // Where smaller number is better
            {
                mt2 = t1.sec[i];
                mt1 = t2.sec[i];

                double com = mt1 + mt2;

                mt1 = mt1/com;
                mt2 = mt2/com;

                mt1 = mt1 * 100;
                mt2 = mt2 * 100;

                switch (i)
                {
                    case 0:
                        mt1 = mt1 * 10;
                        mt2 = mt2 * 10;
                        break;
                    case 1:
                        mt1 = mt1 * 10;
                        mt2 = mt2 * 10;
                        break;

                }

            }
            else // Where larger is better
            {
                if()
                mt1 = t1.sec[i];
                mt2 = t2.sec[i];



                double com = mt1 + mt2;

                mt1 = mt1/com;
                mt2 = mt2/com;

                mt1 = mt1 * 100;
                mt2 = mt2 * 100;

                switch (i)
                {
                    case 0:
                        mt1 = mt1 * 10;
                        mt2 = mt2 * 10;
                        break;
                    case 1:
                        mt1 = mt1 * 10;
                        mt2 = mt2 * 10;
                        break;

                }

            }















        }
    }
}
