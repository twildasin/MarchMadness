package com.company;

import java.io.*;
import java.util.*;

public class Match {

    public static void Game (int t1, int t2) throws IOException
    {
        Scanner scanIn = new Scanner(new File("sheet.txt"));
        scanIn.useDelimiter(",");

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


            find.next();
            find.next();
            teamID1 = Integer.parseInt(find.next());
            find.next();
            teamID2 = Integer.parseInt(find.next());

            if((teamID1 == t1 && teamID2 == t2) || (teamID1 == t2 && teamID2 == t1))
            {
                System.out.println(temp);
                found = true;
            }



        }

    }
}
