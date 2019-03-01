package com.company;

import java.util.Comparator;
import java.util.Scanner;

public class Team implements Comparable
{



    int [] fir = new int[6];
    String str;
    int [] sec = new int[28];



/*    public Team (int c1, int c2, int c3, int c4, int c5, int c6, String c8, int c9, int c10, int c11, int c12, int c13, int c14, int c15, int c16, int c17, int c18, int c19, int c20, int c21, int c22, int c23, int c24, int c25, int c26, int c27, int c28, int c29, int c30, int c31, int c32, int c33, int c34, int c35, int c36)
    {

        fir[0] = c1;
        fir[1] = c2;
        fir[2] = c3;
        fir[3] = c4;
        fir[4] = c5;
        fir[5] = c6;
        str = c8;
        sec[0] = c9;
        sec[1] = c10;
        sec[2] = c11;
        sec[3] = c12;
        sec[4] = c13;
        sec[5] = c14;
        sec[6] = c15;
        sec[7] = c16;
        sec[8] = c17;
        sec[9] = c18;
        sec[10] = c19;
        sec[11] = c20;
        sec[12] = c21;
        sec[13] = c22;
        sec[14] = c23;
        sec[15] = c24;
        sec[16] = c25;
        sec[17] = c26;
        sec[18] = c27;
        sec[19] = c28;
        sec[20] = c29;
        sec[21] = c30;
        sec[22] = c31;
        sec[23] = c32;
        sec[24] = c33;
        sec[25] = c34;
        sec[26] = c35;
        sec[27] = c36;



        Scanner sf = new Scanner();





    }*/

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
        return Integer.toString(this.fir[2]);
    }
}
