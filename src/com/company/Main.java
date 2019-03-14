package com.company;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int n = 300;
        double eeee = Math.pow((1 + (1/n)), n);
        System.out.println(Math.exp(1));

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

        //System.out.println(tour);

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


        //region Input position in bracket

        Team [] aDiv = new Team [16];
        Team [] bDiv = new Team [16];
        Team [] cDiv = new Team [16];
        Team [] dDiv = new Team [16];

        Team [] aDiv2 = new Team [8];
        Team [] bDiv2 = new Team [8];
        Team [] cDiv2 = new Team [8];
        Team [] dDiv2 = new Team [8];

        Team [] aDiv3 = new Team [4];
        Team [] bDiv3 = new Team [4];
        Team [] cDiv3 = new Team [4];
        Team [] dDiv3 = new Team [4];

        Team [] aDiv4 = new Team [2];
        Team [] bDiv4 = new Team [2];
        Team [] cDiv4 = new Team [2];
        Team [] dDiv4 = new Team [2];

        for(int i = 0; i < 16; i++)
        {
            aDiv[i] = null;
            bDiv[i] = null;
            cDiv[i] = null;
            dDiv[i] = null;
        }


        Scanner  findpos = new Scanner(new File("NameTeam.txt"));
        String tempLine;
        Scanner scanLine;
        String sortThis;
        int scanTeamID;
        Team scanTeam = null;
        findpos.nextLine();


        while(findpos.hasNext())
        {
            tempLine = findpos.nextLine();

            if(!(tempLine.substring(0,1)).equals(","))
            {
                scanLine = new Scanner(tempLine);
                scanLine.useDelimiter(",");
                sortThis = scanLine.next();
                scanTeamID = Integer.parseInt(scanLine.next());
                int rankNum = Integer.parseInt(sortThis.substring(1,sortThis.length())) - 1;

                for(int i = 0; i < tour.size(); i++)
                {
                    scanTeam = tour.get(i);
                    if(scanTeam.fir[2] == scanTeamID)
                        break;
                    else if (i == tour.size() - 1)
                        throw new IOException("Okay so we did something wrong...");
                }

                scanTeam.teamName = scanLine.next();


                if(sortThis.substring(0,1).equalsIgnoreCase("a"))
                {
                    aDiv[rankNum] = scanTeam;
                }
                else if(sortThis.substring(0,1).equalsIgnoreCase("b"))
                {
                    bDiv[rankNum] = scanTeam;
                }
                else if(sortThis.substring(0,1).equalsIgnoreCase("c"))
                {
                    cDiv[rankNum] = scanTeam;
                }
                else if(sortThis.substring(0,1).equalsIgnoreCase("d"))
                {
                    dDiv[rankNum] = scanTeam;
                }
            }
        }



        //For testing purposes only (print array)
        for(Team x : aDiv)
        {
            try
            {
                System.out.println(x.teamName + "\t" + x.fir[2]);
            }
            catch (NullPointerException e)
            {
                System.out.println("Null\t0");
            }
        }

        //endregion

        //region Cholonk
        /*
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMWNXKKXNWMMMMMMMWNNNNNWMMMMMWNNNNNWMMMMMMMMWNXKKXNWMMMMMMMMWNNNNWWMMMMMMMMMMMMMMMMWNXXKXNWMMMMMMMMWWNNNNWMMMMMMWNNNNWMMMWNNNNWWMMMMWWNNNNNNWMMM
        MMMMMXkl;'.....,cxXMMMMk,''',kMMMMMx'''';OMMMMW0d:,.....';cxXMMMMWd'''':0MMMMMMMMMMMMMNkl;'.....,:o0WMMMM0:''''cKMMMMXl''''xWMNo''''cKMMW0c''''';xNMMM
        MMMNx'            .xNMMd     dMMMMWl    .xMMMKc.            .dNMMN:    .OMMMMMMMMMMMNx'            .:0WMMO.     'kWMMK,    lWMN:    '0MXo.    .:OWMMMM
        MMWd.    'dOOkc.   'OWMd     dMMMMWl    .xMM0,    .ckOOx;     lNMN:    .OMMMMMMMMMMWd.    ,dOOkl.    'OMMO.      .oXMK,    lWMN:    'kx'     ;kNMMMMMM
        MMK,    ,KMMMMW0dk0KNMMd     .;;;;;.    .xMWl    .dWMMMMN:    .kMN:    .OMMMMMMMMMM0'    ;KMMMMMk.    cNMO.        ;0K,    lWMN:    ..     .oNMMMMMMMM
        MMO.    cWMMMMMMMMMMMMMd                .xMN:    '0MMMMMMd    .dMN:    .OMMMMMMMMMMx.    lWMMMMMK,    ;XMO.    '.   .l'    lWMN:            ,0WMMMMMMM
        MM0'    :NMMMMMKxk0XWMMd     'ccccc.    .xMNc    .kMMMMMWl    .xMN:    .OMMMMMMMMMMk.    cNMMMMM0'    :XMO.   .dO,         lWMN:       '.    .kWMMMMMM
        MMNl    .oXWWNk,  .'dWMd     dMMMMWl    .xMMk.    ;ONWWXd.    ;KMN:    .dKKKKKKKKXWX:    .oXWWN0:    .dWMO.   .xMXc.       lWMN:     ,kNO.    .oNMMMMM
        MMMXc     .,,'.    ;0MMd     dMMMMWl    .xMMWx.    .',,.     ;0MMN:     .........:KMK:     .,;'.    .oNMMO.   .xMMNx.      lWMN:    .OMMWO'     cXMMMM
        MMMMNk:.        .,dXMMMd    .dMMMMWo    .xMMMWKo,.        .;xNMMMNc              ,KMMNk:.        .'l0WMMMO.   .xMMMW0;     lWMN:    '0MMMMO'     ;0MMM
        MMMMMMWX0kddddxkKWMMMMMXkkkkkXMMMMMKkkkkOXMMMMMMNKOxddddkOXWMMMMMWKxxkkxxxkkxkkkx0WMMMMWX0kxdddxk0NMMMMMMNOkkkOXMMMMMNOkkkkKMMW0kkkkONMMMMMKkxxxkkKMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM
        */
        //endregion


        int rep = 15;
        for(int i = 0; i < 8; i++)
        {
            aDiv2[i] = Match.Game(aDiv[i], aDiv[rep], 1);
            //bDiv2[i] = Match.Game(bDiv[i], bDiv[rep], 1);
            //cDiv2[i] = Match.Game(cDiv[i], cDiv[rep], 1);
            //dDiv2[i] = Match.Game(dDiv[i], dDiv[rep], 1);
            rep--;
        }

        rep = 7;
        for(int i = 0; i < 4; i++)
        {
            aDiv3[i] = Match.Game(aDiv2[i], aDiv2[rep], 1);
            //bDiv3[i] = Match.Game(bDiv2[i], bDiv2[rep], 1);
            //cDiv3[i] = Match.Game(cDiv2[i], cDiv2[rep], 1);
            //dDiv3[i] = Match.Game(dDiv2[i], dDiv2[rep], 1);
            rep--;
        }

        rep = 3;
        for(int i = 0; i < 2; i++)
        {
            aDiv4[i] = Match.Game(aDiv3[2*i], aDiv3[(2*i) +1], 1);
            //bDiv4[i] = Match.Game(bDiv3[2*i], bDiv3[(2*i) +1], 1);
            //cDiv4[i] = Match.Game(cDiv3[2*i], cDiv3[(2*i) +1], 1);
            //dDiv4[i] = Match.Game(dDiv3[2*i], dDiv3[(2*i) +1], 1);
            rep--;
        }




        //System.out.println(Match.Game(tour.get(326), tour.get(286), 1));
        //System.out.println(Match.Game(tour.get(326), tour.get(4), 1)); //Nova v AL (easy win)
        //System.out.println(Match.Game(tour.get(286), tour.get(326), 1));
        //System.out.println(Match.Game(tour.get(326), tour.get(327), 1)); //Nova v VA (close game)
        System.out.println(Match.Game(aDiv[0], aDiv[1], 1)); //Entity 0 and 1 of aDivision (aDiv) array

    }
}
