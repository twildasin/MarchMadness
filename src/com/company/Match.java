package com.company;
import java.io.*;
import java.util.*;

public class Match {

    //scans to find if two teams have competed before and will return (team 1 wins - team 2 wins). Returns 0 if equal win/loss or not games played.
    public static int findGame (int t1, int t2) throws IOException
    {
        // Makes a new Scanner from the txt file of teams (unsorted)
        Scanner scanIn = new Scanner(new File("sheet.txt"));
        scanIn.useDelimiter(",");

        //Used to keep track of wins for each team
        int t1t = 0;
        int t2t = 0;

        //Stores each team's IDs
        int teamID1;
        int teamID2;

        String temp;
        Scanner find;
        scanIn.nextLine();
        boolean found = false;
        while(scanIn.hasNext())
        {
            //Sets a line to be tested equal to a String
            temp = scanIn.nextLine();

            //Creates a scanner from that line/String
            find = new Scanner(temp);

            //Duh...
            find.useDelimiter(",");

            // Skips first three data points
            find.next();
            find.next();
            find.next();

            // sets ID equal to the position in the scanner where the first ID SHOULD be
            teamID1 = Integer.parseInt(find.next());

            //Skips un-needed data point
            find.next();

            // sets ID equal to the position in the scanner where the second ID SHOULD be
            teamID2 = Integer.parseInt(find.next());

            // If team 2 wins
            if(teamID1 == t2 && teamID2 == t1)
                t2t++;

            // If team 1 wins
            if(teamID1 == t1 && teamID2 == t2)
                t1t++;

        }

        //Return how many more games team 1 has win (can be 0 or negative if team 2 won same amount or more)
        return t1t - t2t;

    }

    // Big method that compares different data points to return which team would be most likely to win the game
    public static Team Game (Team t1, Team t2, int round) throws IOException
    {
        //region Analyze stats

        //Final variables used to determine which team wins (values added based on multiple data points)
        int t1t = 0;
        int t2t = 0;

        //Under Construction
        //region Find previous games played

        /*

        // Keeps track of which team has won previous games
        int winning = 0;

        // Calls method above to see which team has won previous games
        winning = Match.findGame(t1.fir[2], t2.fir[2]);



        // If team 1 beat team 2 before, give them some points
        if(winning > 0)
            t1t++;

        // If team 2 beat team 1 before, give them some points
        else if (winning < 0)
            t2t++;

        */

        //endregion


        double mt1 = 0;
        double mt2 = 0;

        //Goes through every data point we are using
        for(int i = 1; i < 14; i++)
        {
            // Where smaller number is better
            if(i == 10 || i == 13)
            {

                //Switch teams values (since smaller is better)
                mt2 = t1.sec[i];
                mt1 = t2.sec[i];


                //region Fancy math crap to give team points based on how better that data point is from the other team
                double com = mt1 + mt2;

                mt1 = mt1/com;
                mt2 = mt2/com;

                mt1 = mt1 * 100;
                mt2 = mt2 * 100;

                //endregion

            }

            // Where  is better (aka always)
            else
            {
                if(i == 1 || i == 3 || i ==5)
                {
                    mt1 = (double) t1.sec[i] / t1.sec[i + 1];
                    mt2 = (double) t2.sec[i] / t2.sec[i + 1];

                    //region More fancy math crap to give team points based on how better that data point is from the other team

                    double com = mt1 + mt2;

                    mt1 = mt1 / com;
                    mt2 = mt2 / com;

                    mt1 = mt1 * 100;
                    mt2 = mt2 * 100;

                    i++;

                    //endregion
                }

                else
                {
                    mt1 = t1.sec[i];
                    mt2 = t2.sec[i];

                    //region Even more fancy math crap to give team points based on how better that data point is from the other team

                    double com = mt1 + mt2;

                    mt1 = mt1 / com;
                    mt2 = mt2 / com;

                    mt1 = mt1 * 100;
                    mt2 = mt2 * 100;

                    //endregion
                }


            }

            //region Weigh by data point

            //Different data points are weighed more strongly than others

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

            //endregion


        }

        //endregion

        ///*
        //Soooooooooooooooo... the data from last years HUGE upset (UMBC) skewed the entire data so this skews it back
        //If we were to get all math-y with this, we should actually use the MEDIAN of the data, not the MEAN
        //...Buts that's above my pay grade so yeah these 8 lines are easier than changing our entire averaging algorithm
        if(t1.fir[2] == 1452)
        {
            t1t = t1t - 70;
        }
        else if(t2.fir[2] == 1452)
        {
            t2t = t2t - 70;
        }

        if(t1.fir[2] == 1437)
        {
            t1t = t1t + 25;
        }
        else if(t2.fir[2] == 1437)
        {
            t2t = t2t + 25;
        }
        //*/

        ///*
        if(round == 1)
        {
            t1t = t1t - (t1.seed * 5);
            t2t = t2t - (t2.seed * 5);
        }
        else if (round == 2)
        {
            t1t = t1t - (t1.seed * 5);
            t2t = t2t - (t2.seed * 5);
        }
        else if (round == 3)
        {
            t1t = t1t - (t1.seed * 5);
            t2t = t2t - (t2.seed * 5);
        }
        else if (round == 4)
        {
            t1t = t1t - (t1.seed * 5);
            t2t = t2t - (t2.seed * 5);
        }
        //*/



        //region Upset

        int upset;
        int difference = Math.abs(t1t - t2t);
        Random ran = new Random();


        //region Version 2.0

        /*
        upset = ran.nextInt(difference);

        // Gives a chance for upset using difference between two teams (ex 2 in ____ chance of winning --> blank being difference between two teams)
        if(upset >= 0 && upset < 6)
        {
            System.out.println("\n\nUpset");
            if(t1t > t2t)
            {
                t2t = t2t + difference + 1;
            }
            else if(t2t > t1t)
            {
                t1t = t1t + difference +1;
            }
        }
        */
        //endregion

        //region Version 3.0

        if(difference < 10)
        {
            upset = ran.nextInt(2); // 50 %
        }
        else if(difference < 25)
        {
            upset = ran.nextInt(4); // 25 %
        }
        else if(difference < 50)
        {
            upset = ran.nextInt(10); // 10 %
        }
        else if(difference < 100)
        {
            upset = ran.nextInt(20); // 5 %
        }
        else
        {
            upset = ran.nextInt(50); // 2 %
        }

        if(upset == 0)
        {
            System.out.println("----------Upset----------");
            if(t1t > t2t)
            {
                t2t = t2t + difference + 1;
            }
            else if(t2t > t1t)
            {
                t1t = t1t + difference +1;
            }
        }

        //endregion

        //region Version 1.0
        /*


        int upset1;
        int boundary;
        int boundary2;
        int difference = Math.abs(t1t = t2t);
        Random ran = new Random();

        boundary = ran.nextInt(100);
        boundary2 = ran.nextInt(100);

        if (boundary < boundary2)
        {

        }


        if(boundary < 2) // 2%
        {

        }
        else if(boundary < 10) // 8%
        {

        }
        else if(boundary < 25) // 15%
        {

        }
        else if(boundary < 50) // 25%
        {

        }
        else if(boundary < 100) // 50%
        {

        }

        if(boundary2 < 2) // 2%
        {

        }
        else if(boundary2 < 10) // 8%
        {

        }
        else if(boundary2 < 25) // 15%
        {

        }
        else if(boundary2 < 50) // 25%
        {

        }
        else if(boundary2 < 100) // 50%
        {

        }


        */

        //endregion


        //endregion

        //System.out.println("\nTeam 1: " + t1t);
        //System.out.println("Team 2: " + t2t + "\n");

        if(t1t > t2t)
        {
            System.out.println(t1.teamName + " beat " + t2.teamName);
            return t1;
            //return t1.teamName + " Wins!";
        }
        else
        {
            System.out.println(t2.teamName + " beat " + t1.teamName);
            return t2;
            //return t2.teamName + " Wins!";
        }

        //return "Team 1: " + t1t + "\tTeam 2: " + t2t;
    }
}
