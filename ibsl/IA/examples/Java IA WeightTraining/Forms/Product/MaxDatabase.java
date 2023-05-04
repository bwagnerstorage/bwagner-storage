package org.bwagner;

import java.util.*;
import java.io.*;

/*
  This class maintains a list of Player’s. It also provides methods for
  manipulating this list.

*/

public class MaxDatabase implements Serializable
{
    // constants
    public static String FILENAME = "weightTraining.dat";  // data file name
    public static String BACKUP = "weightTraining.bak";  // backup file name
    
    // instance variables
    private ArrayList<Player> players;  // database of Players
    
    // constructor  
    public MaxDatabase()
    {
        players = new ArrayList<>();
        readFile();
    }
    
    /* 
        This method reads the data file if it exists and loads the data into the
        database. If the data file does not exist it creates it.
    */
    public void readFile()
    {
        FileInputStream fileID;
        ObjectInputStream inFile;

        try
        {
            // Create a stream for reading in objects
            fileID = new FileInputStream(FILENAME);
            inFile  = new ObjectInputStream(fileID);

            // Read all the objects and put them in the ArrayList
            players = (ArrayList <Player>) inFile.readObject();
            
            makeBackupFile();  // make backup

            // Close the stream
            inFile.close();
        }
        catch(FileNotFoundException e) // Data file does not exist; create it
        { 
            FileOutputStream newFileID;
            ObjectOutputStream outFile;

            try
            {
                // Create the output stream
                newFileID = new FileOutputStream(FILENAME);
                // create new data file
                outFile   = new ObjectOutputStream(newFileID);

                // Close the file
                outFile.close();
                
                return;   // exit method now;
            }
            catch (IOException ex) // can't create data file
            {
                System.out.println("Error creating data file: " + ex.getMessage());
            }
        }
        catch(IOException exception) // a general IO error possibly corrupt file
        {
            System.out.println("Error reading data file: " + exception.getMessage());
        }
        catch(ClassNotFoundException e)  // needed because of cast above
        {
            System.out.println("Error trying to open file: " + e.getMessage());
        }
    }
    
    /* 
       This method save the database to the data file.
    */
    public void saveFile()
    {
        FileOutputStream fileID;
        ObjectOutputStream outFile;

        try
        {
            // Create the output stream
            fileID = new FileOutputStream(FILENAME);
            outFile   = new ObjectOutputStream(fileID);

            // Write the ArrayList to the file
            outFile.writeObject(players);

            // Close the file
            outFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing to data file: " + e.getMessage());
        }
    }
    
    /* This method saves the current data in the data file to a backup file before
       the data from the data file is loaded into the database.
    */
    public void makeBackupFile()
    {
        FileOutputStream fileID;
        ObjectOutputStream outFile;

        try
        {
            // Create the output stream
            fileID = new FileOutputStream(BACKUP);
            outFile   = new ObjectOutputStream(fileID);

            // Write the ArrayList to the file
            outFile.writeObject(players);

            // Close the file
            outFile.close();
        }
        catch (IOException e)
        {
            System.out.println("Error writing to backup file: " + e.getMessage());
        }
        
    }
    
    /*
        @return the number of players in database
    */
    public int getSize()
    {
        return players.size();
    }
    
    /*
        Adds a Player to database
        @param player the player to be added
    */
    public void addPlayer(Player player)
    {
        players.add(player);
    }
    
    /* Deletes a Player from database 
       @param player the player to be removed
    */
    public void deletePlayer(Player player)
    {
        players.remove(player);
    }
    
    /*
       Deletes every player in the database and clears data file.
    */
    public void clearDatabase()
    {
        players = new ArrayList<>();  // clear ArrayList            
        
        // clear data file
        FileOutputStream newFileID;
        ObjectOutputStream outFile;
        try
        {
            // Create the output stream
            newFileID = new FileOutputStream(FILENAME);
            // create new data file
            outFile   = new ObjectOutputStream(newFileID);

            // Close the file
            outFile.close();
        }
        catch (IOException ex) // can't create data file
        {
            System.out.println("Error deleting data file: " + ex.getMessage());
        }
        
    }
    
    /*
        An accessor method for the list of players
        @ return a reference to the ArrayList players 
    */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    /*
       Performs a linear search for a player in the database
       @param name the player's name
       @return the Player found or null if player not found
    */
    public Player searchByName(String name)
    {
        // linear search algorithm
        for(Player player : players)
        {
            if(player.getName().equals(name))
            {
                return player;
            }
        }
        
        return null;  // player not in list
    }
    
    /* 
       @return an Arraylist that is a copy of the database that is
               sorted using the selection sort algorithm in
               alphabetical order by player name
    */
    public ArrayList <Player> sortPlayersByName()
    {
        // create new list and copy player's data into it
        ArrayList <Player> list = copyList(players);
        
        // selection sort algorithm
        
        int i, j;
        int min;
        Player temp;

        for (i = 0; i < list.size()-1; i++)
        {
           min = i;
           for (j = i+1; j < list.size(); j++)
           {
              if (list.get(j).getName().compareTo(list.get(min).getName()) < 0)
                 min = j;
           }
           // swap
           temp = list.get(i);
           list.set(i, list.get(min));
           list.set(min, temp);
         }
        
        return list;
    }
    
    /* 
       @return an Arraylist that is a copy of the database that is
               sorted using the selection sort algorithm in
               numerical order by player bench max
    */
    public ArrayList <Player> sortPlayersByBenchMax()
    {
        // create new list and copy player's data into it
        ArrayList <Player> list = copyList(players);
        
        // selection sort algorithm
        
        int i, j;
        int max;
        Player temp;

        for (i = 0; i < list.size()-1; i++) // advance through list one player at a time
        {
           max = i;
           for (j = i+1; j < list.size(); j++)  // find largest player max in list
           {
              if (list.get(j).getBenchMax() > list.get(max).getBenchMax())
                 max = j;
           }
           // swap largest max with current max
           temp = list.get(i);
           list.set(i, list.get(max));
           list.set(max, temp);
         }
        return list;  // return sorted list
    }
    
    /* 
        return an ArrayList that is a copy of the database
    */
    public ArrayList<Player> copyList(ArrayList<Player> list)
    {
        ArrayList <Player> temp = new ArrayList<>();  
        for(Player player: list)
        {
            temp.add(player);
        }
        return temp;
    }
    
    /*
       @return an ArrayList of Groups organize in groups according
          by player bench max
    */
    public ArrayList<Group> createGroups(int groupSize)
    {
        ArrayList <Player> list = sortPlayersByBenchMax();
        ArrayList <Group> groups = new ArrayList<>();
        
        Group group = new Group(groupSize);
        for(int i = 0; i < list.size(); i++)
        {
            group.addPlayer(list.get(i));
            if(i != 0 && i % groupSize == 0)   // add group every groupSize players
            {
                groups.add(group);
                group = new Group(groupSize);
                group.addPlayer(list.get(i));
            }    
        }
        // if you still have players left create a group smaller than groupsize
        if(groups.size() * groupSize < list.size())
        {
            int num = list.size() - groups.size() * groupSize;
            group = new Group(groupSize);
            for(int i = 0, j = num-1; i < num; i++, j--)
            {
                group.addPlayer(list.get(list.size() - j - 1));
            }
            groups.add(group);
        }
        return groups;
    }
}
