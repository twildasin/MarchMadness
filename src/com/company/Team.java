package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Team implements Comparable
{



    int [] fir = new int[6];
    String str;
    int [] sec = new int[28];




    public Team (String line)
    {
        Scanner sf = new Scanner(line);
        sf.useDelimiter(",");

        for (int i = 0; i < 6; i++)
        {
            fir[i] = Integer.parseInt(sf.next());
        }

        str = sf.next();

        for (int i = 0; i < 27; i++)
        {
            sec[i] = Integer.parseInt(sf.next());
        }
    }

    public Team (ArrayList<Team> temp)
    {
        int tot = 0;
        Team mytemp;
        for(int i = 0; i < temp.size(); i++)
        {
            mytemp = temp.get(i);
            tot = tot + mytemp.fir[1];
        }
        tot = tot / temp.size();
        fir[1] = tot;
    }

    @Override
    public int compareTo(Object otherObject)
    {
        Team myTeam = (Team) otherObject;
        int retValue;
        if (fir[2] < myTeam.fir[2]) {
            retValue = -1;
        } else {
            if (fir[2] > myTeam.fir[2]) {
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
