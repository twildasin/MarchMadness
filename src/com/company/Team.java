package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Team implements Comparable
{


    //Store each data point in a line of the text file
    int [] fir = new int[6];
    String str;
    int [] sec = new int[28];




    //First constructor
    public Team (String line)
    {   //Accepts one String (line in text file) and makes it into one object
        Scanner sf = new Scanner(line);
        sf.useDelimiter(",");

        //First 6 data points to first int array
        for (int i = 0; i < 6; i++)
        {
            fir[i] = Integer.parseInt(sf.next());
        }

        //String to string
        str = sf.next();

        //Last ints to a different int array
        for (int i = 0; i < 27; i++)
        {
            sec[i] = Integer.parseInt(sf.next());
        }
    }

    //Second constructor (overloading)
    public Team (ArrayList<Team> temp)
    {    //Accepts an array list of the same team and will find their averages and combine them into one object

        int year;
        double weigh = 0;

        for(int j = 1; j < 6; j++)
        {
            int tot = 0;
            Team mytemp = null;
            for (int i = 0; i < temp.size(); i++)
            {
                mytemp = temp.get(i);


                //region Weigh by year
                year = mytemp.fir[0];
                if(j != 2)
                {
                    //Gives more recent years a stronger influence on the predicted winner
                    switch (year) {
                        case 2010:
                            weigh = 0.01;
                            break;
                        case 2011:
                            weigh = 0.02;
                            break;
                        case 2012:
                            weigh = 0.03;
                            break;
                        case 2013:
                            weigh = 0.04;
                            break;
                        case 2014:
                            weigh = 0.05;
                            break;
                        case 2015:
                            weigh = 0.10;
                            break;
                        case 2016:
                            weigh = 0.15;
                            break;
                        case 2017:
                            weigh = 0.20;
                            break;
                        case 2018:
                            weigh = 0.40;
                            break;


                    }
                }

                //endregion yea

                //*/
                if(j != 2)
                {
                    tot = tot + (int) (((double) mytemp.fir[j] * weigh) * 100);
                }
                else
                {
                    tot = tot + mytemp.fir[j];
                }
            }
            tot = tot / temp.size();
            fir[j] = tot;
        }

        str = "n";

        for(int j = 0; j < 27; j++)
        {
            int tot = 0;
            Team mytemp;
            for (int i = 0; i < temp.size(); i++)
            {
                mytemp = temp.get(i);




                year = mytemp.fir[0];
                switch (year)
                {
                    case 2010:
                        weigh = 0.01;
                        break;
                    case 2011:
                        weigh = 0.02;
                        break;
                    case 2012:
                        weigh = 0.03;
                        break;
                    case 2013:
                        weigh = 0.04;
                        break;
                    case 2014:
                        weigh = 0.05;
                        break;
                    case 2015:
                        weigh = 0.10;
                        break;
                    case 2016:
                        weigh = 0.15;
                        break;
                    case 2017:
                        weigh = 0.20;
                        break;
                    case 2018:
                        weigh = 0.40;
                        break;

                }

                tot = tot + (int) (((double) mytemp.sec[j] * weigh) * 100);
            }
            tot = tot / temp.size();
            sec[j] = tot;
        }
    }

    @Override
    public int compareTo(Object otherObject)
    {
        Team myTeam = (Team) otherObject;
        int retValue;
        if (fir[2] < myTeam.fir[2])
        {
            retValue = -1;
        } else {
            if (fir[2] > myTeam.fir[2])
            {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }

    @Override
    public String toString()
    {
        return Integer.toString(this.fir[1]);
    }

    public String printAvg()
    {
        return Integer.toString(this.fir[1]);
    }

}
