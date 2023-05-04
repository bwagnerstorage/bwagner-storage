package org.bwagner;

import java.util.*; 

/*
    This class stores up to four Players to form a workout group.
*/

public class Group 
{
    private Player[] group;
    private int maxGroupSize;
    private int numPlayers;
    
    //constructor
    public Group(int groupSize)
    {
        maxGroupSize = groupSize;
        group = new Player[maxGroupSize];
        numPlayers = 0;
    }
    
    /*
        Adds a player to the group
    */
    public void addPlayer(Player player)
    {
        if(numPlayers < maxGroupSize)
        {
            group[numPlayers] = player;
            numPlayers++;
        }
    }
    
    /*
        @return the number of players in this group
    */
    public int getGroupSize()
    {
        return numPlayers;
    }
    
    public Player[] getGroup()
    {
        return group;
    }
    
}
