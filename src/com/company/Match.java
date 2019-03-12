package com.company;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

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
        int winning = 0;

        // Calls method above to see which team has won previous games
        //winning = Match.findGame(t1.fir[2], t2.fir[2]);

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


            }
            else // Where larger is better (aka always)
            {
                if(i == 1 || i == 3 || i ==5)
                {
                    mt1 = (double) t1.sec[i] / t1.sec[i + 1];
                    mt2 = (double) t2.sec[i] / t2.sec[i + 1];


                    double com = mt1 + mt2;

                    mt1 = mt1 / com;
                    mt2 = mt2 / com;

                    mt1 = mt1 * 100;
                    mt2 = mt2 * 100;

                    i++;
                }

                else
                {
                    mt1 = t1.sec[i];
                    mt2 = t2.sec[i];


                    double com = mt1 + mt2;

                    mt1 = mt1 / com;
                    mt2 = mt2 / com;

                    mt1 = mt1 * 100;
                    mt2 = mt2 * 100;
                }





            }

            if(i == 1)
            {
                t1t = t1t + ( (int) mt1 * 10);
                t2t = t2t + ( (int) mt2 * 10);
            }
            else if(i == 3 || i == 5)
            {
                t1t = t1t + ( (int) mt1 * 7);
                t2t = t2t + ( (int) mt2 * 7);
            }
            else if(i == 7)
            {
                t1t = t1t + ( (int) mt1 * 6);
                t2t = t2t + ( (int) mt2 * 6);
            }
            else if(i == 10)
            {
                t1t = t1t + ( (int) mt1 * 4);
                t2t = t2t + ( (int) mt2 * 4);
            }
            else if(i == 13)
            {
                t1t = t1t + ( (int) mt1 * 2);
                t2t = t2t + ( (int) mt2 * 2);
            }
            else if(i == 8 || i == 9 || i == 11|| i == 12)
            {
                t1t = t1t + ( (int) mt1);
                t2t = t2t + ( (int) mt2);
            }














        }

        return "Team 1: " + t1t + "\tTeam 2: " + t2t;
    }
}
